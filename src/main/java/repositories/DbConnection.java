package repositories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;

/**
 * Created by Alisa on 5/2/2017.
 */
public class DbConnection {

    private static final String JDBC_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static final String DB_URL = "jdbc:sqlserver://localhost\\SQLEXPRESS:1433;databaseName=Blogs";

    private static final String USER = "alisa";
    private static final String PASSWORD = "alisa12345";

    public static Connection openConnection() throws Exception {

        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            String errorMessage = "JDBC driver could not be found.";
            throw new Exception(errorMessage);
        }

        Connection connection;

        try {
            connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
        } catch (SQLException e) {
            String errorMessage = "Error occurred when connecting to database.";
            throw new Exception(errorMessage);
        }

        return connection;
    }
}
