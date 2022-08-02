package ru.shtanko.xml.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Constant {
    private final static String DATE_FORMAT = "dd-MM-yyyy HH:mm:ss";

    public final static String RESOURCES = "resources.properties";
    public final static String SQL_INSERT = "INSERT INTO article(id_art, nam, code, username, guid) VALUES('%s', '%s', '%s', '%s', '%s')";
    public final static String SQL_SELECT = "SELECT id_art, nam, code, username, guid FROM article where row_num < 10000";
    public final static String RESULT_TASK_ONE = "./src/main/resources/results/resultTaskOne.xml";
    public final static String RESULT_TASK_TWO = "./src/main/resources/results/resultTaskTwo.xml";
    public final static String RESULT_TASK_THREE = "./src/main/resources/results/resultTaskThree.csv";
    public final static String TRANSFORM_XML = "./src/main/resources/xsl/transformXml.xsl";
    public final static String TRANSFORM_CSV = "./src/main/resources/xsl/transformXmlToCsv.xsl";

    public static String getDateTime() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern(DATE_FORMAT));
    }
}
