import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * <pre>
 *  Program Java Co. Menu Lab Project: Main.java
 *  <body>
 *  <br> The Main.java class is the main point of interaction with the user,
 *  taking input and displaying output based on actions performed from the input. </br>
 *         <br> This is the driver class that provides a place to write and execute code that
 *   tests the functionality of other classes in the program. </br>
 * </body>
 *  CS160L-1001 SUMMER2023
 *  6/28/2023
 *  @author Genesis Anne Villar
 *  </pre>
 */

public class Main {
    private static Map<String, Integer> inventory = new TreeMap<String, Integer>();
    private static List<CoffeeOrder> orders = new ArrayList<CoffeeOrder>();

    private static String logFile = "OrderLog.txt";
    private static String inventoryFile = "Inventory.txt";

    /**
     * Private helper method utilized in main.
     *          Builds a coffee order based on user input.
     *
     * @return The CoffeeOrder object representing the built order.
     */
    private static CoffeeOrder buildOrder() {
        CoffeeOrder order = new CoffeeOrder();
        Scanner scan = new Scanner(System.in);
        Images gui = new Images();
        gui.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        gui.pack();

        String decoratorChoice_start;
        do {
            int typeChoice;
            boolean validTypeChoice = false;        /* flag to ask user to re-input valid drink type */
            gui.updateImagesDrinkTypes();
            gui.pack();
            gui.setVisible(true);
            do {

                System.out.println("Select what type of drink you'd like to build in your order:\n1.) JavaCo's Famous Black Coffee\n2.) An Espresso");
                typeChoice = scan.nextInt();
                scan.nextLine();
                if (typeChoice == 1 || typeChoice == 2) {
                    validTypeChoice = true;
                } else {
                    System.out.println("You have inputted an invalid choice. Please try again.");
                }
            }
            while (!validTypeChoice);

            Coffee orderedCoffee = null;

            switch (typeChoice) {
                case 1:
                    orderedCoffee = new BlackCoffee();
                    gui.closeGUI();
                    break;
                case 2:
                    orderedCoffee = new Espresso();
                    gui.closeGUI();
                    break;
            }

            do {
                System.out.println("Would you like to add any additional decorations to your drink? (Y/N)");
                decoratorChoice_start = scan.nextLine();
                if (decoratorChoice_start.equalsIgnoreCase("Y")) {
                    boolean validDecoratorChoice_menu = false;  /* flag to ask user to re-input for Decorator Menu */

                    while (!validDecoratorChoice_menu) { /* only continues when validDecoratorChoice_menu == true */
                        gui.updateImagesDecorator();
                        gui.pack();
                        gui.setVisible(true);
                        System.out.println("What decorator items would you like to add?\nPlease select:\n1.) With Hot Water\n2.) With Milk\n3.) With Sugar\n4.) With Whipped Cream\n5.) With Flavor");
                        int decoratorChoiceMenu = scan.nextInt();
                        scan.nextLine();

                        switch (decoratorChoiceMenu) {
                            case 1:
                                orderedCoffee = new WithHotWater(orderedCoffee);      /* With hot water */
                                validDecoratorChoice_menu = true;
                                gui.closeGUI();
                                break;
                            case 2:
                                orderedCoffee = new WithMilk(orderedCoffee);             /* With milk */
                                validDecoratorChoice_menu = true;
                                gui.closeGUI();
                                break;
                            case 3:
                                orderedCoffee = new WithSugar(orderedCoffee);         /* With sugar */
                                validDecoratorChoice_menu = true;
                                gui.closeGUI();
                                break;
                            case 4:
                                orderedCoffee = new WithWhippedCream(orderedCoffee);       /* With whipped cream */
                                validDecoratorChoice_menu = true;
                                gui.closeGUI();
                                break;
                            case 5:
                                gui.updateImagesFlavor();
                                gui.pack();
                                gui.setVisible(true);
                                System.out.println("What flavor would you like to add?\n1.) Vanilla.\n2.) Mocha\n3.) Caramel");
                                int decoratorChoiceMenu_flavor = scan.nextInt();
                                scan.nextLine();

                                WithFlavor.Syrup flavor = null;

                                switch (decoratorChoiceMenu_flavor) {
                                    case 1:
                                        flavor = WithFlavor.Syrup.VANILLA;      /* Drink type with flavor syrup VANILLA */
                                        validDecoratorChoice_menu = true;
                                        gui.closeGUI();
                                        break;
                                    case 2:
                                        flavor = WithFlavor.Syrup.MOCHA;        /* Drink type with flavor syrup MOCHA */
                                        validDecoratorChoice_menu = true;
                                        gui.closeGUI();
                                        break;
                                    case 3:
                                        flavor = WithFlavor.Syrup.CARAMEL;       /* Drink type with flavor syrup CARAMEL */
                                        validDecoratorChoice_menu = true;
                                        gui.closeGUI();
                                        break;
                                    default:
                                        System.out.println("INVALID FLAVOR CHOICE");
                                }
                                if (validDecoratorChoice_menu) {
                                    orderedCoffee = new WithFlavor(orderedCoffee, flavor);
                                }
                                break;
                            default:
                                System.out.println("INVALID DECORATOR CHOICE");     /* validDecorator_menu is false so repeat */
                        }
                    }
                } else if (!decoratorChoice_start.equalsIgnoreCase("N")) {          /* an input that is neither N or n has been inputted and forced to repeat */
                    System.out.println("Invalid input. Please enter 'Y' or 'N'.");
                }


            }
            while (decoratorChoice_start.equalsIgnoreCase("Y"));        /* False Y/n --> N or n was inputted so No coffee decorations */

            if (isInInventory(orderedCoffee.getIngredients())) {
                // Update inventory
                List<String> ingredients = orderedCoffee.getIngredients();
                for (String ingredient : ingredients) {
                    inventory.put(ingredient, inventory.get(ingredient) - 1);
                }

                order.addCoffee(orderedCoffee);
                System.out.println("Your ordered drink has been added. Would you like to order another? (Y/N)");
            } else {
                System.out.println("Sorry, the requested coffee cannot be added to the order. It is out of stock.");
            }

            decoratorChoice_start = scan.nextLine();
        } while (decoratorChoice_start.equalsIgnoreCase("Y"));            /* False --> Y/y  --> no more coffees to add to order */
        return order;
    }

    /**
     * The main method is the entry point of the Java Coffee Co. application.
     *            In the following menu, it allows users to manage inventory, place coffee orders, and write onto the order log.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        int mainMenuChoice = 0;

        System.out.println("Welcome to Java Coffee Co.! \n");
        try (Scanner input = new Scanner(System.in)) {
            readInventory(inventoryFile);       /* Inventory.txt is read before do/while loop so overwrite is correct */
            do {
                printInventory(inventory);
                System.out.println();

                System.out.println("Please select what you would like to do:\n1.) Add an order\n2.) Reload inventory\n3.) Update Inventory\n4.) Update Order Log\n5.) Quit the Application");
                try {
                    mainMenuChoice = input.nextInt();
                    input.nextLine();

                    switch (mainMenuChoice) {

                    /* Utilizes buildOrder() to build a new CoffeeOrder and add it to orders */
                    case 1:
                        CoffeeOrder order = buildOrder();
                        if (order != null) {
                            orders.add(order);      /* adds order to overall order */
                            System.out.println(order.printOrder());
                        }
                        break;

                    /* Calls readInventory(inventoryFile) and store the results in inventory, then print the current inventory for the user */
                    case 2:
                        readInventory(inventoryFile);
                        printInventory(inventory);
                        break;

                    /* Calls writeInventory(inventoryFile). to manually update overwrite Inventory.txt*/
                    case 3:
                        writeInventory(inventoryFile);
                        break;

                    /* Calls writeOrderLog(logFile) to manually update OrderLog.txt  */
                    case 4:
                        writeOrderLog(logFile);
                        break;

                   /* Terminate the user input loop and exit the program.
                    * Before exiting, the inventory should be updated and any remaining orders are to be logged */
                    case 5:
                        System.out.println("Application has been ended. Inventory has been updated and any remaining orders have been logged.");
                        writeInventory(inventoryFile);
                        writeOrderLog(logFile);  /* when closed, all orders created will be written on file */
                        break;
                    default:
                        System.out.println("Invalid option. Please select from the menu provided");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number that corresponds in the menu printed.");
                input.nextLine(); // Clear the input buffer
            }

            } while (mainMenuChoice != 5);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage() + "\n It seems like you entered a input that is not valid.");
        }
    }

    /**
     * Method that reads the inventory from Inventory.txt and populates the inventory map.
     *          Organizes each ingredient and the quantity so that it may be manipulated accordingly by the code.
     *
     * @param filePath the path to the inventory file
     * @return the inventory map
     */
    private static Map<String, Integer> readInventory(String filePath) {
        inventory.clear();      /* clears mapping for each inventory.txt */

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("=");       /* split each line using '=' */

                if (parts.length == 2) {
                    String ingredient = parts[0].trim();            /* extract ingredient name */
                    int quantity = 0;

                    try {
                        quantity = Integer.parseInt(parts[1].trim());       /* extract quantity if valid */
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid quantity found in the inventory file: " + line);
                        continue;
                    }

                    inventory.put(ingredient, quantity);            /* populate inventory map */
                }
            }

            System.out.println("Inventory loaded successfully.");

        } catch (IOException e) {
            System.out.println("Error reading inventory file: " + e.getMessage());
        }
        return inventory;
    }

    /**
     * Writes the inventory map to Inventory.txt, based on the inputs of the user.
     *              Inventory.txt is overwritten per successful order, to ensure most updated inventory.
     *
     * @param filePath the path to the inventory file
     */
    private static void writeInventory(String filePath) {
        System.out.println("Writing inventory log --- ");
        File outFile = new File(filePath);
        String outPath = outFile.getAbsolutePath();


        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outPath, false))) {          /* To overwrite the file instead of appending, the FileWriter constructor is passed as false */
            for (Map.Entry<String, Integer> entry : inventory.entrySet()) {
                String ingredient = entry.getKey();
                int quantity = entry.getValue();

                writer.write(ingredient + "=" + quantity);
                writer.newLine();
            }
            writer.newLine();       /* create new line for each inventory update */
            System.out.println(outPath);
            System.out.println("Complete! --- ");

            inventory.clear();
        } catch (IOException e) {
            System.out.println("Error writing for inventory file. Error: " + e.getMessage());
        }
    }

    /**
     * Reads the order log from the specified file and returns a list of coffee orders.
     *
     * @param filePath the path to the order log file
     * @return the list of coffee orders
     */
    private static List<CoffeeOrder> readOrderLog(String filePath) {

        return null;
    }

    /**
     * Writes the list of coffee orders to the OrderLog.txt file.
     *          The OrderLog.txt file will include the entire history log of orders.
     *
     * @param filePath the path to the order log file
     */
    private static void writeOrderLog(String filePath) {
        System.out.println("Writing order log --- ");
        File outFile = new File(filePath);
        String outPath = outFile.getAbsolutePath();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outPath, true))) {
            for (CoffeeOrder order : orders) {
                writer.write(order.printOrder());
                writer.newLine();
            }

            System.out.println(outPath);

            System.out.println("Complete! --- ");
            orders.clear();

        } catch (IOException exception) {
            System.out.println("Error writing to the order log file: " + exception.getMessage());
        }
    }

    /**
     * Checks if the given ingredients exist in the inventory AND  has a non-zero quantity.
     *          The signature was modified from the original UML Diagram to accept a list of ingredients.
     *
     * @param ingredients the list of ingredients to check
     * @return {@code true} if all ingredients are in the inventory with non-zero quantity, {@code false} otherwise
     */
    private static boolean isInInventory(List<String> ingredients) {
        for (String ingredient : ingredients) {
            if (!inventory.containsKey(ingredient) || inventory.get(ingredient) <= 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Helper method that prints the current inventory, read from inventory map.
     *
     * @param i the inventory map
     */
    private static void printInventory(Map<String, Integer> i) {
        System.out.println("Current Inventory:");
        for (Map.Entry<String, Integer> entry : i.entrySet()) {
            String ingredient = entry.getKey();
            int quantity = entry.getValue();
            System.out.println(ingredient + ": " + quantity);
        }
    }
}
