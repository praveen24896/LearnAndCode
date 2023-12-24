import model.Device;
import model.DeviceFactory;

class SmartphoneFactory extends DeviceFactory {
    @Override
    public Device createDevice() {
        return new Smartphone();
    }
}