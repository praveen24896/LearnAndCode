public class AreaCalculator {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(5.0, 3.0);
        
        double area = calculateRectangleArea(rectangle);

        printArea(area);
    }

    private static double calculateRectangleArea(Rectangle rectangle) {
        return rectangle.getLength() * rectangle.getWidth();
    }

    private static void printArea(double area) {
        System.out.println("Area: " + area);
    }
}