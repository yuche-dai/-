package djt.db;


import java.sql.*;

public class MyDatabase {

    public static Connection getConnection() {

        String url = "jdbc:sqlserver://localhost:1433;databaseName=CretaceousParkDB";
        String user = "sa";
        String pwd = "123456";
        Connection connection = null;

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(url, user, pwd);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return connection;
    }

    public static void close( ResultSet rs,PreparedStatement ps,Connection connection
    ) {


        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }

        try {
            if (ps != null) {
                ps.close();
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }


        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }

    }

}
