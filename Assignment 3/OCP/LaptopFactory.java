import model.Device;
import model.DeviceFactory;

class LaptopFactory extends DeviceFactory {
    @Override
    public Device createDevice() {
        return new Laptop();
    }
}