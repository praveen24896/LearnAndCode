import java.util.List;

interface ProductOperations {
    void addProduct(Product product) throws CustomExceptions.DuplicateProductException;

    void updateProduct(int id, String name, double price, int quantity) throws CustomExceptions.ProductNotFoundException;

    void deleteProduct(int id) throws CustomExceptions.ProductNotFoundException;

    void sellProduct(int id, int quantity) throws CustomExceptions.InsufficientQuantityException, CustomExceptions.ProductNotFoundException;

    List<Product> getAllProducts();
}
