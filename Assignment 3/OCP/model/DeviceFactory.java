package model;
public abstract class DeviceFactory {
    public Device create() {
        Device device = createDevice();
        return device;
    }
    public abstract Device createDevice();
}
