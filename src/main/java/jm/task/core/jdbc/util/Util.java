package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Util {
    // set up a database connection
    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {

        try {
            Configuration configuration = new Configuration();

            configuration.setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
            configuration.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/example_schema");
            configuration.setProperty("hibernate.connection.username", "root");
            configuration.setProperty("hibernate.connection.password", "1234567890D");

            configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");

            configuration.setProperty("hibernate.hbm2ddl.auto", "update");

            configuration.setProperty("hibernate.show_sql", "true");

            configuration.addAnnotatedClass(User.class);

            return configuration.buildSessionFactory();
        } catch (Exception e) {
            throw new RuntimeException("Ошибка при создании Сессии", e);
        }
    }
        public static SessionFactory getSessionFactory(){
            return sessionFactory;
        }
        public static void shutdown(){
            getSessionFactory().close();
    }
}
/*        private static final String url = "jdbc:mysql://localhost:3306/example_schema";
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
        }*/

