package database;

import java.sql.*;

public class ConnectionDB {

    public static void main(String[] args) {

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            Connection connection = DriverManager
                    .getConnection("jdbc:postgresql://s-msk-t-ver-db1:5432/testdb", "trainee", "123456");
            Statement stmt = connection.createStatement();

            ResultSet rs = stmt.executeQuery("select * from person");
            while (rs.next()) {
                System.out.println(rs.getString("person_code"));
                System.out.println(rs.getString("first_name"));
                System.out.println(rs.getString("last_name"));
            }

            rs.close();
            stmt.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
