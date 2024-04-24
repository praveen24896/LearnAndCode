public class CustomExceptions {

    public static class DuplicateProductException extends RuntimeException {
        public DuplicateProductException(String message) {
            super(message);
        }
    }

    public static class ProductNotFoundException extends RuntimeException {
        public ProductNotFoundException(String message) {
            super(message);
        }
    }

    public static class InsufficientQuantityException extends RuntimeException {
        public InsufficientQuantityException(String message) {
            super(message);
        }
    }

    public static class InvalidProductDataException extends RuntimeException {
        public InvalidProductDataException(String message) {
            super(message);
        }
    }
}
