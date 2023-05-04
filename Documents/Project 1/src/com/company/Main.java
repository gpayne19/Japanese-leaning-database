package com.company;
import java.sql.*;
import java.util.Objects;
import java.util.Scanner;

import static com.company.DBConnection.connect;

public class Main {
    private static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws SQLException {
        System.out.println("Please select a table to access");
        String DBSelection = scan.nextLine();
        if (Objects.equals(DBSelection, "vocab")) {
            int VSelection = 0;
            while (VSelection != 5) {
                System.out.println("1. List current vocab \n2. Add vocab to table\n3. Delete vocab from table\n4. Update vocab in table\n5. Exit program");
                VSelection = scan.nextInt();
                if (VSelection < 0 || VSelection > 5) {
                    System.out.println("Incorrect input. please input a number between 1 and 5.");
                }
                switch (VSelection) {
                    case 1:
                        Vocab.printVocab();
                        break;
                    case 2:
                        Vocab.addVocab();
                        break;
                    case 3:
                        Vocab.removeVocab();
                        break;
                    case 4:
                        Vocab.updateTable();
                        break;
                }
            }
        }
    }
}
