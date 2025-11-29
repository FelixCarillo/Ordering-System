
import java.util.*;

public class Orderingsystem {

    // Method to clear the console screen
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //Initialize variables
        String items = "";
        double totalCost = 0.0;

        boolean addOnAvailable = false;


        // Integers for choices
        int dashboardChoice = 0;
        String eyeglassChoice = "";
        String contactLensChoice = "";
        String accessoriesChoice = "";

        // Booleans for loops
        boolean exitAppChoice = true;
        boolean exitDashboardChoice;

        // Customer details
        String customerName = "";
        int customerAge = 0;

        // Initialize eyeglasses
        Eyeglass[] eyeglasses = Inventory.getEyeglasses();
        int IDS[] = new int[eyeglasses.length];
        String Names[] = new String[eyeglasses.length];
        double Prices[] = new double[eyeglasses.length];
        String Materials[] = new String[eyeglasses.length];
        String FrameShapes[] = new String[eyeglasses.length];
        String Colors[] = new String[eyeglasses.length];

        //Initialize addOns
        AddOn[] AddOns = Inventory.getAddOns();
        int AddOnIDs[] = new int[AddOns.length];
        String AddOnNames[] = new String[AddOns.length];
        double AddOnPrices[] = new double[AddOns.length];

        //Initialize Contacts
        Contacts[] contacts = Inventory.getContacts();
        int ContactLensID[] = new int[contacts.length];
        String ContactLensName[] = new String[contacts.length];
        String ContactLensDisposal[] = new String[contacts.length];
        double ContactLensPrices[] = new double[contacts.length];

        while (exitAppChoice) {
            clearScreen();
            // Display welcome message
            System.out.println("Welcome to the ESY Optical Ordering System!");

            // Get customer details if empty
            if (customerName.isEmpty()) {
                System.out.print("Please enter your name: ");
                customerName = sc.nextLine();
            }
            if (customerAge == 0) {
                System.out.print("Please enter your age: ");
                customerAge = sc.nextInt();
            }

            //Display Dashboard
            System.out.println("Please select a category to browse:");
            System.out.println("[1]Eyeglasses [2]Contact Lenses [3]Accessories");
            System.out.print("Enter your choice[1-3]: ");
            exitDashboardChoice = true;
            dashboardChoice = sc.nextInt();

            while (exitDashboardChoice) {
                clearScreen();
                // Process eyeglass choices
                switch (dashboardChoice) {
                    case 1:
                        System.out.println("Available Eyeglasses:");
                        for (int i = 0, j = 1; i < eyeglasses.length; i++, j++) {
                            System.out.printf("[E%-2d] %-30s Php%-8.2f", j, eyeglasses[i].getName(), eyeglasses[i].getPrice());
                            System.out.print("   ");
                            if (j % 3 == 0) {
                                System.out.println();
                            }
                        }
                        if (eyeglasses.length % 3 != 0) {
                            System.out.println();
                        }

                        eyeglassChoice = sc.next();

                        if (eyeglassChoice.startsWith("E") || eyeglassChoice.startsWith("e")) {
                            int eyeglassIndex = Integer.parseInt(eyeglassChoice.substring(1)) - 1;
                            if (eyeglassIndex >= 0 && eyeglassIndex < eyeglasses.length) {
                                Eyeglass selectedEyeglass = eyeglasses[eyeglassIndex];
                                items += selectedEyeglass.getName() + "       - Php" + selectedEyeglass.getPrice() + "\n";
                                totalCost += selectedEyeglass.getPrice();
                                System.out.println("You have selected: " + selectedEyeglass.getName() + " - Php" + selectedEyeglass.getPrice());
                                addOnAvailable = true;
                            } else {
                                System.out.println("Invalid eyeglass selection.");
                            }
                        } else {
                            System.out.println("Invalid input format. Please use the format 'E<number>'.");
                        }

                        break;
                    case 2:
                        if (customerAge < 18) {
                            System.out.println("Note: Contact lenses are not recommended for individuals under 18 years old.");
                            break;
                        }
                        System.out.println("Available Contact Lenses:");
                        for (int i = 0, j = 1; i < contacts.length; i++, j++) {
                            System.out.printf("[C%-2d] %-30s Php%-8.2f", j, contacts[i].getContactLensName(), contacts[i].getContactLensPrices());
                            System.out.print("   ");
                            if (j % 3 == 0) {
                                System.out.println();
                            }
                        }
                        if (contacts.length % 3 != 0) {
                            System.out.println();
                        }

                        contactLensChoice = sc.next();

                        if (contactLensChoice.startsWith("C") || contactLensChoice.startsWith("c")) {
                            int contactLensIndex = Integer.parseInt(contactLensChoice.substring(1)) - 1;
                            if (contactLensIndex >= 0 && contactLensIndex < contacts.length) {
                                Contacts selectedContactLens = contacts[contactLensIndex];
                                items += selectedContactLens.getContactLensName() + "       - Php" + selectedContactLens.getContactLensPrices() + "\n";
                                totalCost += selectedContactLens.getContactLensPrices();
                                System.out.println("You have selected: " + selectedContactLens.getContactLensName() + " - Php" + selectedContactLens.getContactLensPrices());
                            } else {
                                System.out.println("Invalid contact lens selection.");
                            }
                        } else {
                            System.out.println("Invalid input format. Please use the format 'C<number>'.");
                        }
                        break;
                    case 3:
                        System.out.println("Available Accessories:");
                        for (int i = 0, j = 1; i < Inventory.getAccessories().length; i++, j++) {
                            Accessories accessory = Inventory.getAccessories()[i];
                            System.out.printf("[A%-2d] %-30s Php%-8.2f", j, accessory.getName(), accessory.getPrice());
                            System.out.print("   ");
                            if (j % 3 == 0) {
                                System.out.println();
                            }
                        }
                        if (Inventory.getAccessories().length % 3 != 0) {
                            System.out.println();
                        }

                        accessoriesChoice = sc.next();

                        if (accessoriesChoice.startsWith("A") || accessoriesChoice.startsWith("a")) {
                            int accessoriesIndex = Integer.parseInt(accessoriesChoice.substring(1)) - 1;
                            Accessories[] accessories = Inventory.getAccessories();
                            if (accessoriesIndex >= 0 && accessoriesIndex < accessories.length) {
                                Accessories selectedAccessory = accessories[accessoriesIndex];
                                items += selectedAccessory.getName() + " - Php" + selectedAccessory.getPrice() + "\n";
                                totalCost += selectedAccessory.getPrice();
                                System.out.println("You have selected: " + selectedAccessory.getName() + "       - Php" + selectedAccessory.getPrice());
                            } else {
                                System.out.println("Invalid accessory selection.");
                            }
                        } else {
                            System.out.println("Invalid input format. Please use the format 'A<number>'.");
                        }
                        break;
                }

                if (addOnAvailable && dashboardChoice == 1) {
                    // Process add-on choices
                    System.out.println("Would you like to add any add-ons? [Y/N]: ");
                    String addOnChoice = sc.next();
                    if (addOnChoice.equalsIgnoreCase("Y")) {
                        System.out.println("Available Add-Ons:");
                        for (int i = 0, j = 1; i < AddOns.length; i++, j++) {
                            System.out.printf("[D%-2d] %-30s Php%-8.2f", j, AddOns[i].getAddOnNames(), AddOns[i].getAddOnPrices());
                            System.out.print("   ");
                            if (j % 3 == 0) {
                                System.out.println();
                            }
                        }
                        if (AddOns.length % 3 != 0) {
                            System.out.println();
                        }

                        String addOnSelection = sc.next();

                        if (addOnSelection.startsWith("D") || addOnSelection.startsWith("d")) {
                            int addOnIndex = Integer.parseInt(addOnSelection.substring(1)) - 1;
                            if (addOnIndex >= 0 && addOnIndex < AddOns.length) {
                                AddOn selectedAddOn = AddOns[addOnIndex];
                                items += selectedAddOn.getAddOnNames() + " -       Php" + selectedAddOn.getAddOnPrices() + "\n";
                                totalCost += selectedAddOn.getAddOnPrices();
                                System.out.println("You have selected: " + selectedAddOn.getAddOnNames() + " - Php" + selectedAddOn.getAddOnPrices());
                            } else {
                                System.out.println("Invalid add-on selection.");
                            }
                        } else {
                            System.out.println("Invalid input format. Please use the format 'D<number>'.");
                        }
                    }
                }

                // Exit eyeglass choice loop
                System.out.println("Go back to dashboard [X]: ");
                String backChoice = sc.next();
                if (backChoice.equalsIgnoreCase("X")) {
                    exitDashboardChoice = false;
                }

                clearScreen();

                // Exit the application
                System.out.println("Do you want to continue shopping? [Y/N]: ");
                String exitChoice = sc.next();
                if (exitChoice.equalsIgnoreCase("N")) {
                    exitAppChoice = false;
                    sc.close();
                    clearScreen();
                    System.out.println("Thank you for using the ESY Optical Ordering System. Goodbye!");
                }
            }

            // Display order summary
            if (!exitAppChoice && !items.isEmpty()) {
                System.out.println("EYE SEE YOU OPTICAL");
                System.out.printf("Customer Name(%s): %s\n", customerName, customerAge);
                System.out.println("Order Summary:");
                System.out.println("Product Name          |       Price");
                System.out.println(items);
                System.out.printf("Subtotal: Php%.2f\n", totalCost);
                System.out.println("VAT(12%): Php" + String.format("%.2f", (totalCost * 0.12)));
                System.out.printf("Total Amount Due: Php%.2f\n", (totalCost + (totalCost * 0.12)));
                System.out.println("Thank you for your purchase!");
                System.out.println("Take care of your eyes! See you soon!");
            }
        }
    }
}