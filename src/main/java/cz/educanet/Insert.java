package cz.educanet;
import java.util.Scanner;
import java.sql.*;
public class Insert {
    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/luxor", "root",""
        );
        Scanner sc = new Scanner(System.in);

        System.out.println("Add title");
        String title = sc.nextLine();
        System.out.println("Add author");
        String author = sc.nextLine();
        System.out.println("Add glossary");
        String glossary = sc.nextLine();
        System.out.println("Add price");
        int price = sc.nextInt();

        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO book VALUES(NULL, ?, ?, ?, ?)");
        preparedStatement.setString(1, title);
        preparedStatement.setString(2, author);
        preparedStatement.setString(3, glossary);
        preparedStatement.setInt(4, price);
        preparedStatement.executeUpdate();
        connection.close();
    }
}
