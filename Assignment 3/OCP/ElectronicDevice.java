import model.Device;
import model.DeviceFactory;

public class ElectronicDevice {
    public static void main(String[] args) {
        DeviceFactory smartphoneFactory = new SmartphoneFactory();
        DeviceFactory laptopFactory = new LaptopFactory();

        Device smartphone = smartphoneFactory.createDevice();
        Device laptop = laptopFactory.createDevice();

        smartphone.displayDetails();
        laptop.displayDetails();
    }
}