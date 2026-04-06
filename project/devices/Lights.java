// Lights.java
package project.devices;

public class Lights extends SmartDevice {

    private int brightness;

    public Lights(String name, int battery, int brightness) {
        super(name, battery);
        this.brightness = brightness;
    }

    @Override
    public void deviceName() {
        System.out.println("Lights: " + getName());
    }

    @Override
    public void deviceBattery() {
        if (isBatteryLow()) {
            System.out.println(getName() + " battery is low.");
        } else {
            System.out.println(getName() + " battery level is normal.");
        }
    }

    public void setBrightness(int brightness) {
        if (brightness < 0) {
            this.brightness = 0;
        } else if (brightness > 100) {
            this.brightness = 100;
        } else {
            this.brightness = brightness;
        }
    }

    public int getBrightness() {
        return brightness;
    }
}