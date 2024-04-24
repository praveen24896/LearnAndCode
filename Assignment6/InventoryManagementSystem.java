import java.util.*;

public class InventoryManagementSystem {
    private static final ProductOperations productManager = new ProductManager();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            int choice = getMenuChoice();
            if (!executeChoice(choice)) {
                break;
            }
        }
    }

    private static int getMenuChoice() {
        showMenu();
        System.out.print("Enter your choice: ");
        if (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.next(); 
            return -1; 
        }
        return scanner.nextInt();
    }

    private static boolean executeChoice(int choice) {
        scanner.nextLine(); 
        switch (choice) {
            case 1:
                addProduct();
                return true;
            case 2:
                updateProduct();
                return true;
            case 3:
                deleteProduct();
                return true;
            case 4:
                sellProduct();
                return true;
            case 5:
                viewAllProducts();
                return true;
            case 6:
                System.out.println("Exiting...");
                return false;
            default:
                System.out.println("Invalid choice. Please try again.");
                return true;
        }
    }

    private static void addProduct() {
        try {
            Product product = createProductFromUserInput();
            productManager.addProduct(product);
            System.out.println("Product added successfully.");
        } catch (CustomExceptions.DuplicateProductException | IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static Product createProductFromUserInput() {
        System.out.print("Enter Product ID: ");
        int id = scanner.nextInt();

        System.out.print("Enter Product Name: ");
        scanner.nextLine(); 
        String name = scanner.nextLine();

        System.out.print("Enter Product Price: ");
        double price = scanner.nextDouble();

        System.out.print("Enter Product Quantity: ");
        int quantity = scanner.nextInt();

        return new Product(id, name, price, quantity);
    }

    private static void updateProduct() {
        try {
            System.out.print("Enter Product ID to Update: ");
            int id = scanner.nextInt();
            scanner.nextLine(); 

            System.out.print("Enter New Product Name: ");
            String name = scanner.nextLine();

            System.out.print("Enter New Product Price: ");
            double price = scanner.nextDouble();

            System.out.print("Enter New Product Quantity: ");
            int quantity = scanner.nextInt();

            productManager.updateProduct(id, name, price, quantity);
            System.out.println("Product updated successfully.");
        } catch (CustomExceptions.ProductNotFoundException | IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void deleteProduct() {
        try {
            System.out.print("Enter Product ID to Delete: ");
            int id = scanner.nextInt();

            productManager.deleteProduct(id);
            System.out.println("Product deleted successfully.");
        } catch (CustomExceptions.ProductNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void sellProduct() {
        try {
            System.out.print("Enter Product ID to Sell: ");
            int id = scanner.nextInt();

            System.out.print("Enter Quantity to Sell: ");
            int quantity = scanner.nextInt();

            productManager.sellProduct(id, quantity);
            System.out.println("Product sold successfully.");
        } catch (CustomExceptions.InsufficientQuantityException | CustomExceptions.ProductNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void viewAllProducts() {
        List<Product> products = productManager.getAllProducts();
        if (products.isEmpty()) {
            System.out.println("No products in the inventory.");
        } else {
            products.forEach(System.out::println);
        }
    }

    private static void showMenu() {
        System.out.println("\nInventory Management System");
        System.out.println("1. Add Product");
        System.out.println("2. Update Product");
        System.out.println("3. Delete Product");
        System.out.println("4. Sell Product");
        System.out.println("5. View All Products");
        System.out.println("6. Exit");
    }
}
