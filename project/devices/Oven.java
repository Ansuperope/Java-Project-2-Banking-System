// Oven.java
package project.devices;

public class Oven extends SmartDevice implements DeviceSound {

    private String soundToMake;
    private boolean soundStatus;
    private int volume;
    private int temperature;

    public Oven(String name, int battery, int temperature) {
        super(name, battery);
        this.soundToMake = "Beep";
        this.soundStatus = false;
        this.volume = 25;
        this.temperature = temperature;
    }

    @Override // Stuff
    public void deviceName() {
        System.out.println("Oven: " + getName());
    }

    @Override
    public void deviceBattery() {
        if (isBatteryLow()) {
            System.out.println(getName() + " battery is low.");
        } else {
            System.out.println(getName() + " battery level is normal.");
        }
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public int getTemperature() {
        return temperature;
    }

    public String getSoundToMake() {
        return soundToMake;
    }

    @Override
    public boolean toggleSound() {
        soundStatus = !soundStatus;
        return soundStatus;
    }

    @Override
    public void setVolume(int volume) {
        if (volume < MIN_VOL) {
            this.volume = MIN_VOL;
        } else if (volume > MAX_VOL) {
            this.volume = MAX_VOL;
        } else {
            this.volume = volume;
        }
    }

    @Override
    public int getVolume() {
        return volume;
    }
}