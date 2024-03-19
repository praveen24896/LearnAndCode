public class AreaCalculator {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(5.0, 3.0);
        double area = calculateArea(rectangle);

        SaveArea saveArea = new SaveArea();
        saveArea.saveAreaToFile(area, "area.txt");

        System.out.println("Calculated Area: " + area);
    }

    private static double calculateArea(Rectangle rectangle) {
        return rectangle.getLength() * rectangle.getWidth();
    }
}