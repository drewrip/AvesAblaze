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
 1. Enter the Hardware file (HardwarePushbot)
 1. Use the set method to add your object
 1. The name in quotes must be identical to the name of the object in the configuration
 ```java
 ModernRoboticsColor color=(ModernRoboticsColor) easySet(ModernRoboticsColor.class, "color");
 ```
### Driving the robot
1. Assign the drive motors to the robot under the names motor0 and motor1 
1. Call the drive method (shown below)
1. The number (parameter) is distance in encoder units
``` java
drive(500); //drive 500 encoder units
```
### Turning the robot
1. Assign the drive motors to the robot under the names motor0 and motor1
1. Call the turn method (shown below)
1. The number (parameter) is the degrees that you want the robot to turn
```java
turn(90); //turn 90 degrees
