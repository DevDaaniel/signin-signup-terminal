package org.srdaniel.sign;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

/*
*
* @Author DevDaaniel
*
*/

public class SignUp {
    static String nameUp = " ";
    static String passwordUp = " ";

    private static boolean insertUserCredentials(Connection connection, String username, String password) {
        String query = "INSERT INTO users(name, password) VALUES(?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void main(String[] args) {
        String sqliteDB = "jdbc:sqlite:/home/daniel/IdeaProjects/SignTerminal/src/main/java/org/srdaniel/sign/database.sqlite";
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(sqliteDB);
        } catch (SQLException e) {
            System.out.println("Connection SQLite error");
            e.printStackTrace();
            return;
        }

        Scanner scan = new Scanner(System.in);

        System.out.println("User Sign-Up!");
        System.out.println("Insert your name");
        nameUp = scan.nextLine();

        System.out.println("Insert your password, " + nameUp);
        passwordUp = scan.nextLine();

        boolean insertSuccessful = insertUserCredentials(connection, nameUp, passwordUp);

        if (insertSuccessful) {
            System.out.println("User registered successfully!");
        } else {
            System.out.println("Failed to register user.");
        }
    }
}