package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    // set up a database connection
        private static final String url = "jdbc:mysql://localhost:3306/example_schema";
        private static final String username = "root";
        private static final String password = "1234567890D";
        private static final String driver = "com.mysql.cj.jdbc.Driver";

        public static Connection getConnection () {
            Connection connection = null;
            try {
                Class.forName(driver);
                connection = DriverManager.getConnection(url, username, password);
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            return connection;
        }
}
