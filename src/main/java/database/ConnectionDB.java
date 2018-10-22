//Задание:
//1. Вставить данные в таблицу purchase
//2. Получить данные из таблицы person и вывести их в консоль
//3. Реализовать preparestatment. Параметры для запроса читаются из файла

package database;

import parsingfilepack.TextParser;

import java.sql.*;

public class ConnectionDB {

    public static void main(String[] args) {


        String firstName = TextParser.textparser("C:\\Java_learning\\JavaCource\\parametersDB.txt")
                .iterator().next();
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            Connection connection = DriverManager
                    .getConnection("jdbc:postgresql://s-msk-t-ver-db1:5432/testdb", "trainee", "123456");

            //Получение данных из таблицы person
            Statement stmt = connection.createStatement();

            ResultSet rs = stmt.executeQuery("select * from person");

            while (rs.next()) {
                System.out.println(rs.getString("person_code"));
                System.out.println(rs.getString("first_name"));
                System.out.println(rs.getString("last_name"));
            }

            rs.close();
            stmt.close();

            //Preparestatment
            String SQL = "select * from person where first_name = ?";
            PreparedStatement pstmt = connection.prepareStatement(SQL);
            pstmt.setString(1, firstName);
            ResultSet rs1 = pstmt.executeQuery();
            while (rs1.next()) {
                System.out.println(String.format("%s %s", rs1.getString("first_name"), rs1.getString("last_name")));
            }
            rs1.close();
            pstmt.close();


            //Добавление данных в таблицу purchase
            Statement stmt1 = connection.createStatement();

            stmt1.executeQuery(
                    "INSERT INTO purchase " +
                            "(product_name, salesperson, purchase_date, quantity) " +
                            "VALUES ('Rice', ‘02’, 2018-09-02, 499,00)");

            stmt1.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}