# Motors and Servos


  ## DC Motor:


   ```java
   import com.qualcomm.robotcore.hardware.DcMotor;
   ```
   
   #### Initialization: ####
   
   ```java
   motor = hwMap.dcMotor.get("motor_name");
   ```
   
   #### Set the motor direction: ####
   
   ```java
   // Set motor direction to forward
   robot.motor.setDirection(DcMotor.Direction.FORWARD);

   // Set motor direction to reverse
   robot.motor.setDirection(DcMotor.Direction.REVERSE);
   ```
   
   #### Set the power of the motor: ####
   
   ```java
   // Set the power of the motor
   // Power = 1 for forward & -1 for backward
   
   robot.motor.setPower(int power);
   ```
   
   #### Set motor encoder option: ####
   
   ```java
   // To run with encode swap with RUN_WITH_ENCODER
   robot.motor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
   ```
   
   
 ## Servo:
   
   
   #### Initialization: ####
   
   ```java
   robot.servo = hwMap.dcMotor.get("servo_name");
   ```
   
   #### Set the position of the servo: ####
  
   ```java
   // Position 0.00 - 1.00
   robot.servo.setPosition(double position);
   ```
