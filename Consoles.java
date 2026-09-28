package com.mycompany.consoles;

import java.util.Scanner;


abstract class Store {

    // Fields 
    private String consoleType;   // e.g., PS5, XBOX, SWITCH
    private String storeName;     // e.g., GameStop
    private int totalSales;       // number of units sold


    // Constructor - accepts console type, store name, and sales
   
    public Store(String consoleType, String storeName, int totalSales) {
        this.consoleType = consoleType;
        this.storeName = storeName;
        this.totalSales = totalSales;
    }

    
    public String getConsoleType() {
        return consoleType;
    }

    public String getStoreName() {
        return storeName;
    }

    public int getTotalSales() {
        return totalSales;
    }

    
    public void setConsoleType(String consoleType) {
        this.consoleType = consoleType;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public void setTotalSales(int totalSales) {
        this.totalSales = totalSales;
    }

    
    public abstract void showInfo();
}


class GameStore extends Store {

    // Constructor passes the parameters up to the parent class
    public GameStore(String consoleType, String storeName, int totalSales) {
        super(consoleType, storeName, totalSales);
    }

    // Implementation of the abstract method
    @Override
    public void showInfo() {
        System.out.println("[Game Store] " + getStoreName()
                + " sold " + getTotalSales() + " units of " + getConsoleType());
    }
}


class OnlineStore extends Store {

    public OnlineStore(String consoleType, String storeName, int totalSales) {
        super(consoleType, storeName, totalSales);
    }

    @Override
    public void showInfo() {
        System.out.println("[Online Store] " + getStoreName()
                + " sold " + getTotalSales() + " units of " + getConsoleType());
    }
}

// ============================================================
// MAIN CLASS: ConsoleSalesReport
// ============================================================
public class Consoles {

    public static void main(String[] args) {

        
        // List of console devices
        try (Scanner input = new Scanner(System.in)) {
            // List of console devices
            String[] consoles = {"PS5", "XBOX", "SWITCH"};
            
            // how many stores will be entered
            System.out.println("----- CONSOLE DEVICE SALES -----");
            System.out.print("How many stores do you want to enter? ");
            int numberOfStores = input.nextInt();
            input.nextLine(); // clear leftover Enter key
            
            //  Array of Store objects (abstract type!)
            
            Store[] stores = new Store[numberOfStores];
            
            //  Loop to get each store's info
            for (int i = 0; i < numberOfStores; i++) {
                
                System.out.println();
                System.out.println("----- Store " + (i + 1) + " -----");
                
                //  Ask for store name
                System.out.print("Enter store name: ");
                String name = input.nextLine();
                
                //  Show the console menu
                System.out.println("Select a console device:");
                for (int j = 0; j < consoles.length; j++) {
                    System.out.println("  " + (j + 1) + ". " + consoles[j]);
                }
                
                //  Ask user to choose a console
                System.out.print("Enter your choice (1-" + consoles.length + "): ");
                int choice = input.nextInt();
                
                while (choice < 1 || choice > consoles.length) {
                    System.out.print("Invalid choice. Please enter 1-" + consoles.length + ": ");
                    choice = input.nextInt();
                }
                
                String consoleType = consoles[choice - 1];
                
                // Ask for total sales
                System.out.print("Enter total number of sales: ");
                int sales = input.nextInt();
                input.nextLine(); // clear leftover Enter key
                
                //  Ask what kind of store it is
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
            
            // Print all store records
            System.out.println();
            System.out.println("----- ALL STORE SALES -----");
            System.out.println("Store\t\tConsole\t\tSales");
            
            for (int i = 0; i < numberOfStores; i++) {
                System.out.println(stores[i].getStoreName() + "\t\t"
                        + stores[i].getConsoleType() + "\t\t"
                        + stores[i].getTotalSales());
            }
            
            //  Calculate total sales per console
            int[] consoleTotal = new int[consoles.length];
            
            for (int i = 0; i < numberOfStores; i++) {
                // Find the index of the console in the array
                for (int j = 0; j < consoles.length; j++) {
                    if (stores[i].getConsoleType().equals(consoles[j])) {
                        consoleTotal[j] = consoleTotal[j] + stores[i].getTotalSales();
                    }
                }
            }
            
            //  Print total sales per console
            System.out.println();
            System.out.println("----- TOTAL SALES PER CONSOLE -----");
            for (int j = 0; j < consoles.length; j++) {
                System.out.println(consoles[j] + " = " + consoleTotal[j]);
            }
            
            
            int grandTotal = 0;
            for (int j = 0; j < consoles.length; j++) {
                grandTotal = grandTotal + consoleTotal[j];
            }
            System.out.println();
            System.out.println("Grand total sales = " + grandTotal);
            
            // Step 10: Call showInfo() on each store
            
            System.out.println();
            System.out.println("----- STORE DETAILS -----");
            for (int i = 0; i < numberOfStores; i++) {
                stores[i].showInfo();
            }
        }
    }
}