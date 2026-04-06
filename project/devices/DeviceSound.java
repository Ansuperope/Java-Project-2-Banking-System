// DeviceSound.java
package project.devices;

public interface DeviceSound {

    int MIN_VOL = 0;
    int MAX_VOL = 100;

    boolean toggleSound();

    void setVolume(int volume);

    int getVolume();
}