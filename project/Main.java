// Main.java
package project;

import project.devices.AlarmClock;
import project.devices.DeviceSound;
import project.devices.Lights;
import project.devices.Oven;
import project.homeSystem.ErrorNoSupport;
import project.homeSystem.ErrorNotFound;
import project.homeSystem.HomeSystem;

public class Main {

    public static void main(String[] args) {
        HomeSystem home = new HomeSystem();

        Oven kitchenOven = new Oven("Kitchen Oven", 18, 375);
        AlarmClock bedroomAlarm = new AlarmClock("Bedroom Alarm", 42, "6:30 AM");
        Lights porchLights = new Lights("Porch Lights", 75, 80);

        kitchenOven.toggleDevice();
        bedroomAlarm.toggleDevice();
        porchLights.toggleDevice();

        home.addDevice(kitchenOven);
        home.addDevice(bedroomAlarm);
        home.addDevice(porchLights);

        System.out.println("=== ALL DEVICES ===");
        home.displayAllDevices();

        System.out.println();
        System.out.println("=== DEVICES THAT ARE ON ===");
        home.checkDevicesOn();

        System.out.println();
        System.out.println("=== INTERFACE IN ACTION ===");
        DeviceSound ovenSound = kitchenOven;
        ovenSound.toggleSound();
        ovenSound.setVolume(55);
        System.out.println("Oven volume: " + ovenSound.getVolume());

        System.out.println();
        System.out.println("=== DEVICE-SPECIFIC FEATURES ===");
        kitchenOven.setTemperature(400);
        System.out.println("Oven temperature: " + kitchenOven.getTemperature());
        bedroomAlarm.setTime("7:00 AM");
        System.out.println("Alarm time: " + bedroomAlarm.getTime());
        porchLights.setBrightness(95);
        System.out.println("Light brightness: " + porchLights.getBrightness());

        System.out.println();
        System.out.println("=== CUSTOM EXCEPTIONS ===");
        try {
            home.setDeviceVolume("Porch Lights", 40);
        } catch (ErrorNotFound | ErrorNoSupport e) {
            System.out.println(e.getMessage());
        }

        try {
            home.setDeviceVolume("Garage Camera", 40);
        } catch (ErrorNotFound | ErrorNoSupport e) {
            System.out.println(e.getMessage());
        }

        System.out.println();
        System.out.println("=== SECURITY PROTOCOL ===");
        home.executeSecurityProtocol();
        home.checkDevicesOn();
    }
}