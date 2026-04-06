// SmartDevice.java
package project.devices;

public abstract class SmartDevice {

    public static final int MIN_BATTERY = 0;
    public static final int MAX_BATTERY = 100;
    public static final int LOW_BATTERY = 20;

    private boolean status;
    private String name;
    private int battery;

    public SmartDevice(String name, int battery) {
        this.name = name;
        setBattery(battery);
        this.status = false;
    }

    public boolean toggleDevice() {
        status = !status;
        return status;
    }

    public boolean isOn() {
        return status;
    }

    public boolean isBatteryLow() {
        return battery <= LOW_BATTERY;
    }

    public String getName() {
        return name;
    }

    public int getBattery() {
        return battery;
    }

    public void setBattery(int battery) {
        if (battery < MIN_BATTERY) {
            this.battery = MIN_BATTERY;
        } else if (battery > MAX_BATTERY) {
            this.battery = MAX_BATTERY;
        } else {
            this.battery = battery;
        }
    }

    public abstract void deviceName();

    public abstract void deviceBattery();
}