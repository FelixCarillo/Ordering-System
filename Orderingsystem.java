
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
        String itemName = "";
        String itemPrice = "";
        double totalCost = 0.0;

        boolean addOnAvailable = false;

        boolean confirmPurchaseFinal = true;

        boolean eyeCheckService = false;

        double discountAmount = 0.0;

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
        int eyeGrade = 20;
        boolean hasPrescription = false;
        
        //Discount details
        int seniorAge = 60;
        double seniorDiscountRate = 0.10; 
        boolean isSeniorCitizen = false;

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
            System.out.println("\n\t\t\t\t\t\t\tWelcome to the ESY Optical Ordering System!");

            // Get customer details if empty
            if (customerName.isEmpty()) {
                System.out.print("\n\nPlease enter your name:   ");
                customerName = sc.nextLine();
            }
            if (customerAge == 0) {
                System.out.print("Please enter your age:    ");
                customerAge = sc.nextInt();

                if (customerAge >= seniorAge) {
                    isSeniorCitizen = true;
                    System.out.println("\nYou qualify for a senior citizen discount of 10%.");
                }

            }

            // Check for prescription
            if (!hasPrescription && customerAge != 0 && !customerName.isEmpty()) {
                System.out.print("\n\nDo you have a prescription? [Y/N]: ");
                String prescriptionInput = sc.next();
                if (prescriptionInput.equals("Y") || prescriptionInput.equals("y")) {
                    hasPrescription = true;
                    System.out.println("\n\t\t\t\t\t\t  Great! We can assist you with your prescription needs.");
                    System.out.print("\n\nCould you please provide your eye grade? ");
                    eyeGrade = sc.nextInt();
                } else if (prescriptionInput.equals("N") || prescriptionInput.equals("n")) {
                    hasPrescription = false;
                    System.out.print("\nDo you like to get your eyes checked for 1000php? [Y/N]: ");
                    String eyeCheckInput = sc.next();
                    if (eyeCheckInput.equals("Y") || eyeCheckInput.equals("y")) {
                        hasPrescription = true;
                        eyeCheckService = true;
                        itemName += "Eye Checkup Service,";
                        itemPrice += "1000.00,";
                        totalCost += 1000.00;
                        System.out.println("\n\n\t\t\t\t\t\t   Thank you! An eye check will be included in your order.");
                        System.out.print("\n\nCould you please provide your eye grade? ");
                        eyeGrade = sc.nextInt();
                    } else if (eyeCheckInput.equals("N") || eyeCheckInput.equals("n")) {
                        hasPrescription = false;
                        System.out.println("\nNo worries! You can still browse our selection.");
                    }
                } else {
                    System.out.println("Invalid input. Please enter 'Y' for Yes or 'N' for No.");
                }
            }

            // Additional cost for every 100 eye grade
            if (hasPrescription) {
                int additionalCostUnits = eyeGrade / 100;
                double additionalCost = additionalCostUnits * 50.0; // Php50 for every 100 eye grade
                totalCost += additionalCost;
                if (additionalCostUnits > 0) {
                    itemName += "Additional Eye Grade Charge,";
                    itemPrice += String.valueOf(additionalCost) + ",";
                    totalCost += additionalCost;
                }
            }

            clearScreen();

            // Display customer details
            System.out.println("\n\n\t\t\t\t\t\t\t\t\tHello, " + customerName + "!");
            System.out.println("\t\t\t\t\t\t\t\t\t " + customerAge + "yrs old");
            if (hasPrescription) {
                System.out.println("Eye Grade: " + eyeGrade);
            } else {
                System.out.println("No Prescription");
            }
            System.out.println();

            //Display Dashboard
            System.out.println("\nPlease select a category to browse:");
            System.out.println("[1] Eyeglasses [2] Contact Lenses [3] Accessories");
            System.out.print("Enter your choice[1-3]: ");
            

            exitDashboardChoice = true;
            dashboardChoice = sc.nextInt();

            while (exitDashboardChoice) {
                clearScreen();
                // Process eyeglass choices
                switch (dashboardChoice) {
                    case 1:
                        System.out.println("\n\nAvailable Eyeglasses:\n");
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
                                itemName += selectedEyeglass.getName() + ",";
                                itemPrice += String.valueOf(selectedEyeglass.getPrice()) + ",";
                                totalCost += selectedEyeglass.getPrice();
                                System.out.println("\n\n\t\t\t\t\t\t\tYou have selected: " + selectedEyeglass.getName() + " - Php" + selectedEyeglass.getPrice());
                                addOnAvailable = true;
                            } else {
                                System.out.println("\nInvalid eyeglass selection.");
                            }
                        } else {
                            System.out.println("\nInvalid input format. Please use the format 'E<number>'.");
                        }

                        break;
                    case 2:
                        if (customerAge < 18) {
                            System.out.println("\n\n\t\t\t\t\t  Note: Contact lenses are not recommended for individuals under 18 years old.");
                            System.out.println("Press any key to continue...");
                            sc.next();
                            break;
                        }
                        System.out.println("\n\nAvailable Contact Lenses:\n");
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
                                itemName += selectedContactLens.getContactLensName() + ",";
                                itemPrice += String.valueOf(selectedContactLens.getContactLensPrices()) + ",";
                                totalCost += selectedContactLens.getContactLensPrices();
                                System.out.println("\n\n\t\t\t\t\t\t\tYou have selected: " + selectedContactLens.getContactLensName() + " - Php" + selectedContactLens.getContactLensPrices());
                            } else {
                                System.out.println("\nInvalid contact lens selection.");
                            }
                        } else {
                            System.out.println("\nInvalid input format. Please use the format 'C<number>'.");
                        }
                        break;
                    case 3:
                        System.out.println("\n\nAvailable Accessories:\n");
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
                                itemName += selectedAccessory.getName() + ",";
                                itemPrice += String.valueOf(selectedAccessory.getPrice()) + ",";
                                totalCost += selectedAccessory.getPrice();
                                System.out.println("\n\n\t\t\t\t\t\t\tYou have selected: " + selectedAccessory.getName() + "   - Php" + selectedAccessory.getPrice());
                            } else {
                                System.out.println("\nInvalid accessory selection.");
                            }
                        } else {
                            System.out.println("\nInvalid input format. Please use the format 'A<number>'.");
                        }
                        break;

                    default:
                        System.out.println("Thank you for visiting EYE SEE YOU OPTICAL!");
                        break;
                }

                if (addOnAvailable && dashboardChoice == 1) {
                    // Process add-on choices
                    System.out.print("\n\nWould you like to add any add-ons? [Y/N]: ");
                    String addOnChoice = sc.next();
                    if (addOnChoice.equalsIgnoreCase("Y")) {
                        clearScreen();
                        System.out.println("\n\nAvailable Add-Ons:\n");
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
                                itemName += selectedAddOn.getAddOnNames() + ",";
                                itemPrice += String.valueOf(selectedAddOn.getAddOnPrices()) + ",";
                                totalCost += selectedAddOn.getAddOnPrices();
                                System.out.println("\n\n$90s\n\n   You have selected: " + selectedAddOn.getAddOnNames() + " - Php" + selectedAddOn.getAddOnPrices());
                            } else {
                                System.out.println("\nInvalid add-on selection.");
                            }
                        } else {
                            System.out.println("\nInvalid input format. Please use the format 'D<number>'.");
                        }
                    }
                }
                exitDashboardChoice = false;

                clearScreen();

                // Exit the application
                System.out.print("\n\nDo you want to continue shopping? [Y/N]: ");
                String exitChoice = sc.next();
                if (exitChoice.equalsIgnoreCase("N")) {
                    exitAppChoice = false;
                    clearScreen();

                    // Confirm purchase
                    System.out.println("Are you sure with this purchase? [Y/N]: ");
                    String confirmPurchase = sc.next();
                    if (confirmPurchase.equalsIgnoreCase("N")) {
                        itemName = "";
                        itemPrice = "";
                        if (eyeCheckService) {
                            itemName += "Eye Checkup Service,";
                            itemPrice += "1000.00,";
                            totalCost = 1000.00;

                            System.out.println("\nYour cart has been cleared except for the Eye Checkup Service.");
                        } else {
                            totalCost = 0.0;
                            System.out.println("\nYour cart has been cleared.");
                        }
                        confirmPurchaseFinal = false;
                    }
                }
            }

            // Split the item names and prices into arrays
            String[] itemNamesArray = itemName.split(",");
            String[] itemPricesArray = itemPrice.split(",");

            if (isSeniorCitizen) {
                discountAmount = totalCost * seniorDiscountRate;
                totalCost = totalCost - discountAmount;
            }
            
            // Display order summary
            if (confirmPurchaseFinal || (eyeCheckService && confirmPurchaseFinal)) {
                System.out.printf("\n\n%90s\n\n", "EYE SEE YOU OPTICAL");
                System.out.printf("Customer Name(%s): %s\n\n", customerName, customerAge);
                System.out.printf("\n%88s\n\n", "Order Summary:\n");
                System.out.printf("%-50s | %40s%n", "\t\t\t\tProduct Name", "Price");
                System.out.println("\n-------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
                for (int i = 0; i < itemNamesArray.length; i++) {
                    System.out.printf("%-64s | %40sPhp\n", "\t\t" + itemNamesArray[i], itemPricesArray[i]);
                }
                if (isSeniorCitizen) {
                    System.out.printf("\t\tSenior Citizen Discount (10%%):                                 |                                    -Php%.2f\n", discountAmount);
                }
                System.out.println("\n-------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
                System.out.printf("\t\tSubtotal: Php%.2f\n", totalCost);
                System.out.println("\t\tVAT(12%): Php" + String.format("%.2f", (totalCost * 0.12)));
                System.out.printf("\t\tTotal Amount Due: Php%.2f\n\n", (totalCost + (totalCost * 0.12)));
                System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
                System.out.printf("%96s\n", "Thank you for your purchase!");
                System.out.printf("%100s", "Take care of your eyes! See you soon!");

                // Handle Payment
                clearScreen();

                System.out.printf("\n\n%90s\n\n", "EYE SEE YOU OPTICAL");
                System.out.printf("Customer Name(%s): %s\n\n", customerName, customerAge);
                System.out.printf("\n%88s\n\n", "Payment Portal:\n");

                double amountDue = totalCost + (totalCost * 0.12);
                double paymentAmount = 0.0;

                while (paymentAmount < amountDue) {
                    System.out.printf("Total Amount Due: Php%.2f\n", amountDue);
                    System.out.print("Enter payment amount: Php");
                    paymentAmount = sc.nextDouble();

                    if (paymentAmount < amountDue) {
                        System.out.println("\nInsufficient payment. Please enter an amount equal to or greater than the total amount due.\n");
                    }
                }

                // handle change
                if (paymentAmount >= amountDue) {
                    double change = paymentAmount - amountDue;
                    System.out.printf("\nPayment accepted. Your change is: Php%.2f\n", change);
                    System.out.println("\n\n\t\t\t\t\t\t   Thank you for shopping at EYE SEE YOU OPTICAL!\n");
                }

            } if (!exitAppChoice && itemName.isEmpty()) {
                System.out.println("\n\t\t\t\t\t\tNo items were purchased. Thank you for visiting EYE SEE YOU OPTICAL!\n");
            }
        }
    }
}
