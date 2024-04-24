public class Product {
    private final int id;
    private String name;
    private double price;
    private int quantity;

    public Product(int id, String name, double price, int quantity) {
        validateNonNegative(price, "Price must be non-negative.");
        validateNonNegative(quantity, "Quantity must be non-negative.");
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    private void validateNonNegative(double value, String errorMessage) {
        if (value < 0) {
            throw new IllegalArgumentException(errorMessage);
        }
    }

    public int getId() {
        return id;
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

    public void setPrice(double price) {
        validateNonNegative(price, "Price must be non-negative.");
        this.price = price;
    }

    public void setQuantity(int quantity) {
        validateNonNegative(quantity, "Quantity must be non-negative.");
        this.quantity = quantity;
    }

    public void update(String name, double price, int quantity) {
        validateNonNegative(price, "Price must be non-negative.");
        validateNonNegative(quantity, "Quantity must be non-negative.");
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Product [id=" + id + ", name=" + name + ", price=" + price + ", quantity=" + quantity + "]";
    }
}
