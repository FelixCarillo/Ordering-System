import java.util.*;

public class Orderingsystem {

  // Method to clear the console screen
  public static void clearScreen() {
    System.out.print("\033[H\033[2J");
    System.out.flush();
  }

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    
    //Initialize variables
    // Integers for choices
    int dashboardChoice = 0;
    int eyeglassChoice = 0;

    // Booleans for loops
    boolean exitAppChoice = true;
    boolean exitDashboardChoice;

    // Customer details
    String customerName = "";
    String customerAge = "";

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
    Contacts[]contacts = Inventory.getContacts();
    int ContactLensID[] = new int[contacts.length];
    String ContactLensName[] = new String[contacts.length];
    String ContactLensDisposal[] = new String[contacts.length];
    double ContactLensPrices[] = new double[contacts.length];

    

    while(exitAppChoice){
      clearScreen();  
      // Display welcome message
      System.out.println("Welcome to the ESY Optical Ordering System!");

      // Get customer details if empty
      if (customerName.isEmpty()) {
        System.out.print("Please enter your name: ");
        customerName = sc.nextLine();
      }
      if (customerAge.isEmpty()) {
        System.out.print("Please enter your age: ");
        customerAge = sc.nextLine();
      }

      //Display Dashboard
      System.out.println("Please select a category to browse:");
      System.out.println("[1]Eyeglasses [2]Contact Lenses [3]Accessories");
      System.out.print("Enter your choice[1-3]: ");
      exitDashboardChoice = true;
      dashboardChoice = sc.nextInt();

      while(exitDashboardChoice){
        clearScreen();
        // Process eyeglass choices
        switch(dashboardChoice){
          case 1:
            System.out.println("Available Eyeglasses:");
            for (int i = 0, j = 1; i < eyeglasses.length; i++, j++) {
              System.out.printf("[%-2d] %-30s Php%-8.2f", j, eyeglasses[i].getName(), eyeglasses[i].getPrice());
              System.out.print("   ");
              if (j % 3 == 0) {
                System.out.println();
              }
            } 
            if (eyeglasses.length % 3 != 0) {
              System.out.println();
            }
            break;
          case 2:
            System.out.println("Available Contact Lenses:");
              for (int i = 0, j = 1; i < contacts.length; i++, j++) {
                System.out.printf("[%-2d] %-30s Php%-8.2f", j, contacts[i].getContactLensName(), contacts[i].getContactLensPrices());
                System.out.print("   ");
                if (j % 3 == 0) {
                  System.out.println();
                }
              } 
              if (contacts.length % 3 != 0) {
                System.out.println();
              }
            break;
            ;
        }

        // Exit eyeglass choice loop
        System.out.println("Go back to dashboard [X]: ");
        String backChoice = sc.next();
        if (backChoice.equalsIgnoreCase("X")) {
            exitDashboardChoice = false;
        }
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
  }
}
