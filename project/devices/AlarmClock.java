// AlarmClock.java
package project.devices;

public class AlarmClock extends SmartDevice implements DeviceSound {

    private String soundToMake;
    private boolean soundStatus;
    private int volume;
    private String time;

    public AlarmClock(String name, int battery, String time) {
        super(name, battery);
        this.soundToMake = "Alarm Tone";
        this.soundStatus = false;
        this.volume = 50;
        this.time = time;
    }

    @Override
    public void deviceName() {
        System.out.println("Alarm Clock: " + getName());
    }

    @Override
    public void deviceBattery() {
        if (isBatteryLow()) {
            System.out.println(getName() + " battery is low.");
        } else {
            System.out.println(getName() + " battery level is normal.");
        }
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTime() {
        return time;
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