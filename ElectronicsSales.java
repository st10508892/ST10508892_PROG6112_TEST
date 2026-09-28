package com.mycompany.ConsoleApplication;

import java.util.Scanner;

public class ElectronicsSales {

    public static void main(String[] args) {

        // Step 1: Create Scanner to read numbers typed by the user
        Scanner input = new Scanner(System.in);

        //  List of cities
        String[] cities = {"Cape Town", "Port Elizabeth", "Pretoria"};

        //  List of gaming consoles
        String[] consoles = {"PS5", "XBOX", "SWITCH"};

        //  A 2D array to store sales.
        // 3  (cities) and 3 columns (consoles)
        
        int[][] sales = new int[3][3];

        //  Ask the user to type sales for each city and console
        System.out.println("Enter sales for each city and each console:");
        System.out.println();

        for (int i = 0; i < 3; i++) {
            System.out.println("City: " + cities[i]);
            for (int j = 0; j < 3; j++) {
                System.out.print("  " + consoles[j] + " sales: ");
                sales[i][j] = input.nextInt();
            }
            System.out.println();
        }

        
        System.out.println("----- YEARLY SALES REPORT -----");
        System.out.println();

        // Print the header row
        System.out.println("City\t\tPS5\tXBOX\tSWITCH");

        // each city and its sales
        for (int i = 0; i < 3; i++) {
            System.out.print(cities[i] + "\t");
            for (int j = 0; j < 3; j++) {
                System.out.print(sales[i][j] + "\t");
            }
            System.out.println();
        }

        // Step 7: Add up the totals
        int grandTotal = 0;
        int[] cityTotal = new int[3];
        int[] consoleTotal = new int[3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                // Add the sale to the city total (row)
                cityTotal[i] = cityTotal[i] + sales[i][j];

                // Add the sale to the console total (column)
                consoleTotal[j] = consoleTotal[j] + sales[i][j];

                // Add the sale to the grand total
                grandTotal = grandTotal + sales[i][j];
            }
        }

        // Step 8: Show totals per city
        System.out.println();
        System.out.println("----- Total Sales Per City -----");
        for (int i = 0; i < 3; i++) {
            System.out.println(cities[i] + " = " + cityTotal[i]);
        }

        // Step 9: Show totals per console
        System.out.println();
        System.out.println("----- Total Sales Per Console -----");
        for (int j = 0; j < 3; j++) {
            System.out.println(consoles[j] + " = " + consoleTotal[j]);
        }

        // Step 10: Find the console with the most sales
        int mostSold = 0;
        for (int j = 1; j < 3; j++) {
            if (consoleTotal[j] > consoleTotal[mostSold]) {
                mostSold = j;
            }
        }

        // Step 11: Find the city with the most sales
        int bestCity = 0;
        for (int i = 1; i < 3; i++) {
            if (cityTotal[i] > cityTotal[bestCity]) {
                bestCity = i;
            }
        }

        // Step 12: Show the final results
        System.out.println();
        System.out.println("----- RESULTS -----");
        System.out.println("Most sold console : " + consoles[mostSold]
                + " with " + consoleTotal[mostSold] + " units");
        System.out.println("Best city         : " + cities[bestCity]
                + " with " + cityTotal[bestCity] + " units");
        System.out.println("Grand total sales : " + grandTotal + " units");

        // Step 13: Close the Scanner
        input.close();
    }
}