import java.io.FileWriter;
import java.io.IOException;

public class SaveArea {
     public void saveAreaToFile(double area, String fileName) {
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write("Area: " + area);
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }
}
