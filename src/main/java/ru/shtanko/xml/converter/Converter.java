package ru.shtanko.xml.converter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import ru.shtanko.xml.db.WorkDB;
import ru.shtanko.xml.entity.Article;
import ru.shtanko.xml.entity.ArticleList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static ru.shtanko.xml.util.Constant.*;

public class Converter {

    private final static Logger logger = LoggerFactory.getLogger(Converter.class);

    public static void convertToXml() {
        List<Article> resultList = new ArrayList<>();

        try (Connection connection = WorkDB.getConnection()){
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_SELECT);
            while (resultSet.next()) {
                resultList.add(new Article(resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5)));
            }

            ArticleList articleList = new ArticleList(resultList);

            try {
                StringWriter writer = new StringWriter();
                JAXBContext context = JAXBContext.newInstance(ArticleList.class);
                Marshaller marshaller = context.createMarshaller();
                marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
                marshaller.marshal(articleList, writer);
                Files.write(Paths.get(RESULT_TASK_ONE), writer.toString().getBytes());
            } catch (JAXBException e) {
                logger.info("Error JAXB: " + getDateTime() + " " + e.getMessage());
                e.printStackTrace();
            }
            logger.info("Converting POJO successful " + getDateTime());
        } catch (SQLException | IOException e) {
            logger.info("ERROR converting: " + getDateTime() + " " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void transformXml() {
        try {
            TransformerFactory factory = TransformerFactory.newInstance();
            Source transformXsl = new StreamSource(new File(TRANSFORM_XML));
            Transformer transformer = factory.newTransformer(transformXsl);
            Source xml = new StreamSource(new File(RESULT_TASK_ONE));
            transformer.transform(xml, new StreamResult(new File(RESULT_TASK_TWO)));
            logger.info("Transformation XML with XSLT successful " + getDateTime());
        } catch (TransformerException e) {
            logger.info("ERROR transformation XML with XSLT: " + getDateTime() + " " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void convertToCsv() {
        File transformXsl = new File(TRANSFORM_CSV);
        File xmlSource = new File(RESULT_TASK_TWO);

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(xmlSource);

            StreamSource streamSource = new StreamSource(transformXsl);
            Transformer transformer = TransformerFactory.newInstance()
                    .newTransformer(streamSource);
            Source source = new DOMSource(document);
            transformer.transform(source, new StreamResult(new File(RESULT_TASK_THREE)));
            logger.info("Transformation XML to CSV successful " + getDateTime());
        } catch (ParserConfigurationException | SAXException | IOException | TransformerException e) {
            logger.info("ERROR transformation XML to CSV: " + getDateTime() + " " + e.getMessage());
            e.printStackTrace();
        }
    }
}
