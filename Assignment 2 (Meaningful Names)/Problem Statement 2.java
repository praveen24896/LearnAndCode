import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Product {
    private String name;
    private double price;
    private int quantity;

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

class InventoryManager {
    private List<Product> productList;

    public InventoryManager() {
        this.productList = new ArrayList<>();
    }

    public void addProduct(Product product) {
        productList.add(product);
    }

    public List<Product> getInventory() {
        return productList;
    }
}

public class InventoryManagementSystem {
    public static void main(String[] args) {
        InventoryManager inventoryManager = new InventoryManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nInventory Management System");
            System.out.println("1. Add Product");
            System.out.println("2. Display Inventory");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int userChoice = scanner.nextInt();

            switch (userChoice) {
                case 1:
                    System.out.print("Enter product name: ");
                    String productName = scanner.next();
                    System.out.print("Enter product price: ");
                    double productPrice = scanner.nextDouble();
                    System.out.print("Enter product quantity: ");
                    int productQuantity = scanner.nextInt();

                    Product newProduct = new Product(productName, productPrice, productQuantity);
                    inventoryManager.addProduct(newProduct);

                    System.out.println("Product added successfully!");
                    break;

                case 2:
                    System.out.println("\nCurrent Inventory:");
                    List<Product> inventoryList = inventoryManager.getInventory();
                    for (Product product : inventoryList) {
                        System.out.println("Name: " + product.getName() +
                                ", Price: $" + product.getPrice() +
                                ", Quantity: " + product.getQuantity());
                    }
                    break;

                case 3:
                    System.out.println("Exiting program. Goodbye!");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}
