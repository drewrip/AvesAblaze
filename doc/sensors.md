# Color Sensor

  ### Import the color sensor class:
  
  ```java
  import com.qualcomm.robotcore.hardware.ColorSensor;
  ```
  
  ### Initialize a color sensor object:
  
  ```java
  colorSensor = hardwareMap.colorSensor.get("sensor_color");
  ```
  
  #### Enable LED:
  ```java
  colorSensor.enableLed(boolean);
  ```
  
  #### Get Colors:
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
  
  #### Get raw optical data in CM:
  
  ```java
  rangeSensor.cmOptical();
  ```
  
  #### Get raw ultrasonic data:
  
  ```java
  rangeSensor.rawUltrasonic();
  ```
  
  #### Get the distance in CM:
  
  ```java
  rangeSensor.getDistance(DistanceUnit.CM);
  ```

# Gyro Sensor
  
  ### Import the gyro sensor class and dependencies:
  
  ```java
  import com.qualcomm.hardware.modernrobotics.ModernRoboticsI2cGyro;
  import com.qualcomm.robotcore.hardware.Gyroscope;
  import com.qualcomm.robotcore.hardware.IntegratingGyroscope;
  import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
  import org.firstinspires.ftc.robotcore.external.navigation.AngularVelocity;
  import org.firstinspires.ftc.robotcore.external.navigation.AxesOrder;
  import org.firstinspires.ftc.robotcore.external.navigation.AxesReference;
  ```
  
  ### Initialize a gyro sensor objects:
  
  ```java
  IntegratingGyroscope gyro;
  ModernRoboticsI2cGyro modernRoboticsI2cGyro;
  
  // During implementation:
  gyro = (IntegratingGyroscope)hardwareMap.get(ModernRoboticsI2cGyro.class, "gyro");
  ```
  
  #### Calibrate the gyro sensor:
  
  ```java
  modernRoboticsI2cGyro.calibrate();
  ```
