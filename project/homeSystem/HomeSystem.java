// HomeSystem.java
package project.homeSystem;

import java.util.ArrayList;
import java.util.List;

import project.devices.DeviceSound;
import project.devices.SmartDevice;

public class HomeSystem {

    private List<SmartDevice> devices;

    public HomeSystem() {
        devices = new ArrayList<>();
    }

    public void addDevice(SmartDevice device) {
        devices.add(device);
    }

    public SmartDevice findDevice(String name) throws ErrorNotFound {
        for (SmartDevice device : devices) {
            if (device.getName().equalsIgnoreCase(name)) {
                return device;
            }
        }

        throw new ErrorNotFound("Device not found: " + name);
    }

    public void displayAllDevices() {
        for (SmartDevice device : devices) {
            device.deviceName();
            device.deviceBattery();
            System.out.println("Status: " + (device.isOn() ? "ON" : "OFF"));
            System.out.println();
        }
    }

    public void checkDevicesOn() {
        boolean foundOnDevice = false;

        for (SmartDevice device : devices) {
            if (device.isOn()) {
                System.out.println(device.getName() + " is ON");
                foundOnDevice = true;
            }
        }

        if (!foundOnDevice) {
            System.out.println("No devices are currently ON.");
        }
    }

    public void executeSecurityProtocol() {
        for (SmartDevice device : devices) {
            if (device.isOn()) {
                device.toggleDevice();
            }

            if (device instanceof DeviceSound) {
                DeviceSound soundDevice = (DeviceSound) device;
                soundDevice.setVolume(DeviceSound.MIN_VOL);
            }
        }

        System.out.println("Security protocol executed.");
    }

    public void setDeviceVolume(String name, int volume)
            throws ErrorNotFound, ErrorNoSupport {
        SmartDevice device = findDevice(name);

        if (!(device instanceof DeviceSound)) {
            throw new ErrorNoSupport(device.getName() + " does not support sound controls.");
        }

        DeviceSound soundDevice = (DeviceSound) device;
        soundDevice.setVolume(volume);
        System.out.println(device.getName() + " volume set to " + soundDevice.getVolume());
    }
}