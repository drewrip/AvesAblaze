# Aves Ablaze API
### Assigning a motor to the robot
#### Before using a motor it must be assigned
 1. Enter the Hardware file (HardwarePushbot)
 1. Use the set method to add your motor
 1. The name in quotes must be identical to the name of the motor in the configuration
``` java
motor0= setMotor("motor0");
```
### Assigning a Servo or imu to the robot 
#### Before using any hardware it must be assigned
 1. Enter the Hardware file (HardwarePushbot)
 1. Use the set method to add your object
 1. The name in quotes must be identical to the name of the object in the configuration
 ```java
 servo0=setServo("servo0");
 imu=setIMU("imu");
 ```
 ### Assigning another object to the robot
 #### Before using any hardware it must be assigned
 1. Enter the Hardware file (HardwarePushbot
 1. Use the set method to add your object
 1. The name in quotes must be identical to the name of the object in the configuration
 ```java
 ModernRoboticsColor color=(ModernRoboticsColor) easySet(ModernRoboticsColor.class, "color");
 ```
