# Color Sensor

  ### Import the color sensor class:
  
  ```java
  import com.qualcomm.robotcore.hardware.ColorSensor;
  ```
  
  ### Initialize a color sensor object:
  
  ```java
  colorSensor = hardwareMap.colorSensor.get("sensor_color");
  ```
  
  #### Enable LED
  ```java
  colorSensor.enableLed(boolean);
  ```
  
  #### Get Colors
  ```java
  
  //Returns the alpha value
  colorSensor.alpha();
  
  //Returns the red value
  colorSensor.red();
  
  //Returns the green value
  colorSensor.green();
  
  //Returns the blue value
  colorSensor.blue();
  ```

# Range Sensor
  
  ### Import the range sensor class and other dependencies:
  
  ```java
  import com.qualcomm.hardware.modernrobotics.ModernRoboticsI2cRangeSensor;
  import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
  ```
  
  ### Initialize the range sensor object:
  
  ```java
  ModernRoboticsI2cRangeSensor rangeSensor;
  ```
  
  #### Get raw optical data:
  
  ```java
  rangeSensor.rawUltrasonic();
  ```
  
  #### Get the distance in CM:
  
  ```java
  rangeSensor.getDistance(DistanceUnit.CM);
  ```
  
