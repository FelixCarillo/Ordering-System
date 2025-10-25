public class Eyeglass {
    private int id;
    private String name;
    private String material;
    private double price;
    private String frameShape;
    private String color;

    //constructor
    public Eyeglass(int id, String name, String material, double price, String frameShape, String color) {
        this.id = id;
        this.name = name;
        this.material = material;
        this.price = price;
        this.frameShape = frameShape;
        this.color = color;
    }

    // Getters
    public int getId() {
        return id;
    }
    public String getName(){
        return name;
    }
    public String getMaterial(){
        return material;
    }
    public double getPrice(){
        return price;
    }
    public String getFrameType(){
        return frameShape;
    }
    public String getColor(){
        return color;
    }

    // Setters
}