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
