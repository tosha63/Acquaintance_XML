package ru.shtanko.xml.db;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.shtanko.xml.util.PropertyLoader;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import static ru.shtanko.xml.util.Constant.*;

public class WorkDB {

    private static final Logger logger = LoggerFactory.getLogger(WorkDB.class);

    private static final PropertyLoader propertyLoader = new PropertyLoader(RESOURCES);

    public static void insertDB(int number) {
        try (Connection connection = getConnection()){
            Statement statement = connection.createStatement();
            for (int i = 1; i < number; i++) {
                String insert = String.format(SQL_INSERT, "" + i, "name " + i, "code " + i, "username " + i, "guid " + i);
                statement.addBatch(insert);
            }
            statement.executeBatch();
            logger.info("INSERT successful " + getDateTime());
        } catch (SQLException | IOException e) {
            logger.info("ERROR INSERT: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws IOException, SQLException{
        return DriverManager.getConnection(propertyLoader.getConnectionURL(),
                propertyLoader.getUser(),
                propertyLoader.getPassword());
    }


}
