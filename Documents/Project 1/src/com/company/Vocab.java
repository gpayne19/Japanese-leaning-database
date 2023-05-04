package com.company;
import java.sql.*;
import java.util.Scanner;

import static com.company.DBConnection.connect;

public class Vocab {
    static Connection connection = connect();
    static ResultSet resultSet;
    private static Scanner scan = new Scanner(System.in);

    public static void printVocab () throws SQLException {
        Statement statement = connection.createStatement();
        resultSet = statement.executeQuery("select * from vocab");
        int n = 1;
        while (resultSet.next()) {
            System.out.print("Column: " + resultSet.getString("columnNum") + "\nJapanese: ");
            System.out.println(resultSet.getString("j_word"));
            System.out.print("Romaji: ");
            System.out.println(resultSet.getString("romaji"));
            System.out.print("Meaning: ");
            System.out.println(resultSet.getString("meaning") + "\n");
            n++;
        }
        resultSet.close();
        System.out.println("Total vocab recorded: "+ (n-1) + "\n");
    }

        public static void addVocab () throws SQLException {
            String j_word, romaji, meaning;

            System.out.print("Enter the word in japanese: ");
            j_word = scan.nextLine();
            System.out.print("Enter the word in romaji: ");
            romaji = scan.nextLine();
            System.out.print("Enter the meaning: ");
            meaning = scan.nextLine();

            Statement statement = connection.createStatement();
            String insert = "INSERT INTO vocab(j_word, romaji, meaning) "
                    + "VALUES('" + j_word + "'" + "," + "'" + romaji + "'" + "," + "'" + meaning + "')";
            try {
                statement.executeUpdate(insert);
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }

        public static void removeVocab () throws SQLException {
            int columnNum;
            System.out.print("Enter the column number for the vocab you wish to delete.: ");
            columnNum = scan.nextInt();
            Statement statement = connection.createStatement();
            String deletion = "DELETE FROM vocab WHERE columnNum = " + columnNum;
            try {
                statement.executeUpdate(deletion);
                System.out.print("Column number " + columnNum + " has been deleted.");
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }

        public static void updateTable () throws SQLException {
            try {
                System.out.print("Which column number would you like to update? ");
                int columnNum = scan.nextInt();
                scan.nextLine();
                String j_word, romaji, meaning;
                System.out.print("Enter the word in japanese: ");
                j_word = scan.nextLine();
                System.out.print("Enter the word in romaji: ");
                romaji = scan.nextLine();
                System.out.print("Enter the meaning: ");
                meaning = scan.nextLine();
                String update = "UPDATE vocab" +
                        " SET j_word = '" + j_word + "', romaji = '" + romaji + "', meaning = '" + meaning +"'" +
                        "WHERE columnNum = "+ columnNum;
                Statement statement = connection.createStatement();
                statement.executeUpdate(update);
            }
            catch (SQLException e) {
                e.printStackTrace();
                System.out.println("That column doest not exist. Please enter a number of an existing column.");
            }
        }

}
