import java.util.*;

public class Orderingsystem {
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    
    //Initialize variables
    int dashboardChoice = 0;
    int eyeglassChoice = 0;

    boolean exitAppChoice = true;
    boolean exitDashboardChoice = true;

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
      // Display welcome message
      System.out.println("Welcome to the ESY Optical Ordering System!");

      //Display Dashboard
      System.out.println("Please select a category to browse:");
      System.out.println("[1]Eyeglasses [2]Contact Lenses [3]Accessories");
      System.out.print("Enter your choice[1-3]: ");
      dashboardChoice = sc.nextInt();

      while(exitDashboardChoice){
        // Process eyeglass choices
        switch(dashboardChoice){
          case 1:
            exitDashboardChoice = true;
            System.out.println("Available Eyeglasses:");
            for (int i = 0, j = 1; i < eyeglasses.length; i++, j++) {
              System.out.printf("[%-2d] %-30s Php%-8.2f", j, eyeglasses[i].getName(), eyeglasses[i].getPrice());
              System.out.print("   ");
              if (j % 3 == 0) {
                System.out.println();
              }
            } 
      // Add newline if the last row isn't complete
      if (eyeglasses.length % 3 != 0) {
        System.out.println();
      }
        }

        // Exit eyeglass choice loop
        System.out.println("Do you want to go back to the main menu? [Y/N]: ");
        String backChoice = sc.next();
        if (backChoice.equalsIgnoreCase("Y")) {
            exitDashboardChoice = false;
        }
      }












      // Exit the application
      System.out.println("Do you want to continue shopping? [Y/N]: ");
      String exitChoice = sc.next();
      if (exitChoice.equalsIgnoreCase("N")) {
          exitAppChoice = false;
          System.out.println("Thank you for using the ESY Optical Ordering System. Goodbye!");
      }
    }

























    // // Test display of eyeglasses
    // System.out.println("Available Eyeglasses:");
    // for (int i = 0; i < eyeglasses.length; i++){
    //   IDS[i] = eyeglasses[i].getId();
    //   Names[i] = eyeglasses[i].getName();
    //   Prices[i] = eyeglasses[i].getPrice();
    //   Materials[i] = eyeglasses[i].getMaterial();
    //   FrameShapes[i] = eyeglasses[i].getFrameType();
    //   Colors[i] = eyeglasses[i].getColor();

    //   System.out.println(Names[i]);
    //   System.out.println(IDS[i]);
    //   System.out.println(Names[i]);
    //   System.out.println(Prices[i]);
    //   System.out.println(Materials[i]);
    //   System.out.println(FrameShapes[i]);
    //   System.out.println(Colors[i]);
    //   System.out.println("-----------------------");
    // }
    //Test display for AddOns
    // System.out.println("Available AddOns:");
    // System.out.println(" ");
    // for (int i = 0; i < AddOns.length; i++){
    // 	AddOnIDs[i] =AddOns[i].getAddOnID();
    // 	AddOnNames[i] =AddOns[i].getAddOnNames();
    // 	AddOnPrices[i] =AddOns[i].getAddOnPrices();

    //   System.out.println(AddOnNames[i]);
    //   System.out.println(AddOnIDs[i]);
    //   System.out.println(AddOnNames[i]);
    //   System.out.println(AddOnPrices[i]);
    //   System.out.println("-----------------------");
    // }
     //Test display for Contacts
    // System.out.println("Available Contacts:");
    // System.out.println(" ");
    // for (int i = 0; i < contacts.length; i++){
    // 	ContactLensID[i] =contacts[i].getContactLensID();
    // 	ContactLensName[i] =contacts[i].getContactLensName();
    // 	ContactLensDisposal[i] =contacts[i].getContactLensDisposal();
    // 	ContactLensPrices[i] =contacts[i].getContactLensPrices();

    //   System.out.println(ContactLensName[i]);
    //   System.out.println(ContactLensID[i]);
    //   System.out.println(ContactLensDisposal[i]);
    //   System.out.println(ContactLensPrices[i]);
    //   System.out.println("-----------------------");
    // }
  }
}
