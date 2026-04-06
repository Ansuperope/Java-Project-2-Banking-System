# Program Overview  [![Java CI](https://github.com/Ansuperope/CS4A-Project/actions/workflows/java.yml/badge.svg)](https://github.com/Ansuperope/CS4A-Project/actions/workflows/java.yml) [![Documentation](https://img.shields.io/badge/Documentation-Doxygen-blue?logo=doxygen)](https://ansuperope.github.io/CS4A-Project/)

[Google Doc, more info](https://docs.google.com/document/d/1XH2-u4-GlvPFJOgVdttuj_rKvTQDU--6MGTGuS_OFKM/edit?usp=sharing)
1. Program will have the following devices (derived classes):
    1. oven
    2. alarm clock
    3. lights

2. All devices (derived classes) will have the following features (inherit from the abstract base class)
    1. non abstract (will all be the same, implementation details included):	
        1. turn on / off device
        2. return if device is on / off
        3. figure out if battery is low
    1. abstract methods (will vary, not have implementation details):
        1. output device name
        2. notify iAf battery low

3. Devices will also have their own specific features:
    1. lights
        1. defined in class
            1. what it does 
        2. redefine abstract methods
            1. output device name
            2. notify if battery low
    oven
        define in class
           What it does
        redefine abs methods
            output
            notify if battery low
    alarm clock
        Define in class
            what it does
        redefine abs methods
            output device name
            Notify if battery low

Each device that makes noise should have the following features (interface, relationship inheritance):
features (methods)
turn on / off sound
control the device volume
devices (derived classes) that will have these feature
alarm clock
oven

A manager (manager class) will be used to do the following commands on all the devices (relationship: association, unidirectional):
check which devices are on
execute a security protocol

The manager will also call protocols if certain criteria are met (exception classes, relationship dependencies):
device not found
unsupported operations