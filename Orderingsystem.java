import java.util.*;

public class Orderingsystem {
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    // Initialize eyeglasses
    Eyeglass[] eyeglasses = Inventory.getEyeglasses();

    int IDS[] = new int[eyeglasses.length];
    String Names[] = new String[eyeglasses.length];
    double Prices[] = new double[eyeglasses.length];
    String Materials[] = new String[eyeglasses.length];
    String FrameShapes[] = new String[eyeglasses.length];
    String Colors[] = new String[eyeglasses.length];

    // Test display of eyeglasses
    System.out.println("Available Eyeglasses:");
    for (int i = 0; i < eyeglasses.length; i++){
      IDS[i] = eyeglasses[i].getId();
      Names[i] = eyeglasses[i].getName();
      Prices[i] = eyeglasses[i].getPrice();
      Materials[i] = eyeglasses[i].getMaterial();
      FrameShapes[i] = eyeglasses[i].getFrameType();
      Colors[i] = eyeglasses[i].getColor();

      System.out.println(eyeglasses[i].getName());
      System.out.println(IDS[i]);
      System.out.println(Names[i]);
      System.out.println(Prices[i]);
      System.out.println(Materials[i]);
      System.out.println(FrameShapes[i]);
      System.out.println(Colors[i]);
      System.out.println("-----------------------");
    }
  }
}
