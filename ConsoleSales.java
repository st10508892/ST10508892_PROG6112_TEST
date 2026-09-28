package com.mycompany.ConsoleApplication;

import java.util.Scanner;


abstract class Store {

    // Fields (attributes) shared by all stores
    protected String consoleType;   // e.g., PS5, XBOX, SWITCH, PC
    protected String storeName;     // e.g., GameStop
    protected int totalSales;       // number of units sold

    // Abstract method - each subclass MUST provide its own version
    public abstract void showInfo();
}


class GameStore extends Store {

    // --------------------------------------------------------
    // Constructor with 3 parameters
    // --------------------------------------------------------
    public GameStore(String consoleType, String storeName, int totalSales) {
        this.consoleType = consoleType;
        this.storeName = storeName;
        this.totalSales = totalSales;
    }

    // Implementation of the abstract method
    @Override
    public void showInfo() {
        System.out.println("[Game Store] " + storeName
                + " sold " + totalSales + " units of " + consoleType);
    }
}

// ============================================================
// SUBCLASS: OnlineStore
// Also contains a constructor with the same 3 parameters
// ============================================================
class OnlineStore extends Store {

    // --------------------------------------------------------
    // Constructor with 3 parameters
    // --------------------------------------------------------
    public OnlineStore(String consoleType, String storeName, int totalSales) {
        this.consoleType = consoleType;
        this.storeName = storeName;
        this.totalSales = totalSales;
    }

    @Override
    public void showInfo() {
        System.out.println("[Online Store] " + storeName
                + " sold " + totalSales + " units of " + consoleType);
    }
}

// ============================================================
// MAIN CLASS: ConsoleSalesReport
// ============================================================
public class ConsoleSales {

    public static void main(String[] args) {

 
        Scanner input = new Scanner(System.in);

       
        String[] consoles = {"PS5", "XBOX", "SWITCH", "PC"};

        
        System.out.println("----- CONSOLE DEVICE SALES -----");
        System.out.print("How many stores do you want to enter? ");
        int numberOfStores = input.nextInt();
        input.nextLine(); // clear leftover Enter key

        
        Store[] stores = new Store[numberOfStores];

        
        for (int i = 0; i < numberOfStores; i++) {

            System.out.println();
            System.out.println("----- Store " + (i + 1) + " -----");

            
            System.out.print("Enter store name: ");
            String name = input.nextLine();

            
            System.out.println("Select a console device:");
            for (int j = 0; j < consoles.length; j++) {
                System.out.println("  " + (j + 1) + ". " + consoles[j]);
            }

            
            System.out.print("Enter your choice (1-" + consoles.length + "): ");
            int choice = input.nextInt();

            while (choice < 1 || choice > consoles.length) {
                System.out.print("Invalid choice. Please enter 1-" + consoles.length + ": ");
                choice = input.nextInt();
            }

            String consoleType = consoles[choice - 1];

            
            System.out.print("Enter total number of sales: ");
            int sales = input.nextInt();
            input.nextLine(); // clear leftover Enter key

           
            System.out.println("What type of store is it?");
            System.out.println("  1. Game Store");
            System.out.println("  2. Online Store");
            System.out.print("Enter your choice (1-2): ");
            int storeType = input.nextInt();
            input.nextLine();

           
            if (storeType == 2) {
                stores[i] = new OnlineStore(consoleType, name, sales);
            } else {
                stores[i] = new GameStore(consoleType, name, sales);
            }
        }

       
        System.out.println();
        System.out.println("----- ALL STORE SALES -----");
        System.out.println("Store\t\tConsole\t\tSales");

        for (int i = 0; i < numberOfStores; i++) {
            System.out.println(stores[i].storeName + "\t\t"
                    + stores[i].consoleType + "\t\t"
                    + stores[i].totalSales);
        }

        //  Calculate total sales per console
        int[] consoleTotal = new int[consoles.length];

        for (int i = 0; i < numberOfStores; i++) {
            for (int j = 0; j < consoles.length; j++) {
                if (stores[i].consoleType.equals(consoles[j])) {
                    consoleTotal[j] = consoleTotal[j] + stores[i].totalSales;
                }
            }
        }

        //  Print total sales per console
        System.out.println();
        System.out.println("----- TOTAL SALES PER CONSOLE -----");
        for (int j = 0; j < consoles.length; j++) {
            System.out.println(consoles[j] + " = " + consoleTotal[j]);
        }

        //  Grand total
        int grandTotal = 0;
        for (int j = 0; j < consoles.length; j++) {
            grandTotal = grandTotal + consoleTotal[j];
        }
        System.out.println();
        System.out.println("Grand total sales = " + grandTotal);

       
        System.out.println();
        System.out.println("----- STORE DETAILS -----");
        for (int i = 0; i < numberOfStores; i++) {
            stores[i].showInfo();
        }

        input.close();
    }
}