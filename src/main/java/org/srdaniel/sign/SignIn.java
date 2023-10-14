package org.srdaniel.sign;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

/**
* @Author DevDaaniel
*/

public class SignIn {
    static String nameIn = " ";
    static String passwordIn = " ";

    private static boolean checkUserCredentials(Connection connection, String username, String password) {
        String query = "SELECT * FROM users WHERE name = ? AND password = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet.next();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        var sqliteDB = "jdbc:sqlite:/home/daniel/IdeaProjects/SignTerminal/src/main/java/org/srdaniel/sign/database.db";
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(sqliteDB);
        } catch (SQLException e) {
            e.printStackTrace();
            return;
        }

        Scanner scan = new Scanner(System.in);

        System.out.println("Welcome! User Sign-in!");
        System.out.println("Insert your name");
        nameIn = scan.nextLine();

        System.out.println("Insert your password, " + nameIn);
        passwordIn = scan.nextLine();

        boolean isUserValid = checkUserCredentials(connection, nameIn, passwordIn);

        if (isUserValid) {
            System.out.println("Welcome, " + nameIn + "! You have successfully signed in.");
        } else {
            System.out.println("Invalid credentials. Sign-in failed.");
        }

        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}