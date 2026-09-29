package com.mycompany.ConsoleApplication;

import java.util.Scanner;

public class ConsoleSalesReport {

    public static void main(String[] args) {

        // Step 1: Create Scanner for user input
        Scanner input = new Scanner(System.in);

        // Step 2: List of console devices
        String[] consoles = {"PS5", "XBOX", "SWITCH"};

        // Step 3: Ask how many stores will be entered
        System.out.println("----- CONSOLE DEVICE SALES -----");
        System.out.print("How many stores do you want to enter? ");
        int numberOfStores = input.nextInt();
        input.nextLine(); // clear the leftover Enter key

        // Step 4: Create arrays to store the data
        String[] storeNames = new String[numberOfStores];   // store names
        int[] consoleChoice = new int[numberOfStores];      // console index (0-3)
        int[] salesAmount = new int[numberOfStores];        // sales number

        // Step 5: Loop to get each store's info
        for (int i = 0; i < numberOfStores; i++) {

            System.out.println();
            System.out.println("----- Store " + (i + 1) + " -----");

            // 5a. Ask for store name
            System.out.print("Enter store name: ");
            storeNames[i] = input.nextLine();

            // 5b. Show the console menu
            System.out.println("Select a console device:");
            for (int j = 0; j < consoles.length; j++) {
                System.out.println("  " + (j + 1) + ". " + consoles[j]);
            }

            // 5c. Ask user to choose a console (1-4)
            System.out.print("Enter your choice (1-" + consoles.length + "): ");
            int choice = input.nextInt();

            // 5d. Validate the choice
            while (choice < 1 || choice > consoles.length) {
                System.out.print("Invalid choice. Please enter 1-" + consoles.length + ": ");
                choice = input.nextInt();
            }

            // 5e. Save choice as index (subtract 1)
            consoleChoice[i] = choice - 1;

            // 5f. Ask for total sales
            System.out.print("Enter total number of sales: ");
            salesAmount[i] = input.nextInt();
            input.nextLine(); // clear the leftover Enter key
        }

        // Step 6: Print all the entered records
        System.out.println();
        System.out.println("----- ALL STORE SALES -----");
        System.out.println("Store\t\tConsole\t\tSales");

        for (int i = 0; i < numberOfStores; i++) {
            System.out.println(storeNames[i] + "\t\t"
                    + consoles[consoleChoice[i]] + "\t\t"
                    + salesAmount[i]);
        }

        // Step 7: Calculate total sales per console
        int[] consoleTotal = new int[consoles.length];

        for (int i = 0; i < numberOfStores; i++) {
            int consoleIndex = consoleChoice[i];
            consoleTotal[consoleIndex] = consoleTotal[consoleIndex] + salesAmount[i];
        }

        // Step 8: Print total sales per console
        System.out.println();
        System.out.println("----- TOTAL SALES PER CONSOLE -----");
        for (int j = 0; j < consoles.length; j++) {
            System.out.println(consoles[j] + " = " + consoleTotal[j]);
        }

        // Step 9: Calculate and print grand total
        int grandTotal = 0;
        for (int j = 0; j < consoles.length; j++) {
            grandTotal = grandTotal + consoleTotal[j];
        }

        System.out.println();
        System.out.println("Grand total sales = " + grandTotal);

        // Step 10: Close Scanner
        input.close();
    }
}
