import java.util.*;

public class ProductManager implements ProductOperations {
    private final Map<Integer, Product> inventory = new HashMap<>();

    @Override
    public void addProduct(Product product) {
        if (inventory.containsKey(product.getId())) {
            throw new CustomExceptions.DuplicateProductException("Product with ID " + product.getId() + " already exists.");
        }
        inventory.put(product.getId(), product);
    }

    @Override
    public void updateProduct(int id, String name, double price, int quantity) {
        Product product = getProductById(id);
        product.update(name, price, quantity);
    }

    @Override
    public void deleteProduct(int id) {
        inventory.remove(id);
    }

    @Override
    public void sellProduct(int id, int quantity) {
        Product product = getProductById(id);
        if (product.getQuantity() < quantity) {
            throw new CustomExceptions.InsufficientQuantityException("Insufficient quantity for sale.");
        }
        product.setQuantity(product.getQuantity() - quantity);
    }

    private Product getProductById(int id) {
        Product product = inventory.get(id);
        if (product == null) {
            throw new CustomExceptions.ProductNotFoundException("Product with ID " + id + " not found.");
        }
        return product;
    }

    @Override
    public List<Product> getAllProducts() {
        return new ArrayList<>(inventory.values());
    }
}
