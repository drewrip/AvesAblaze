package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;


@Autonomous(name="Autonumous_Template", group="Autonomous")

public class david extends LinearOpMode {
    
    /* Declare OpMode members. */    HardwarePushbot         robot   = new HardwarePushbot();   // Use a Pushbot's hardware
   
   //Make yourself some nice base variables right here
   
   @Override    public void runOpMode() {

        //Or here      
        robot.init(hardwareMap);
     
        // Send telemetry message to signify robot waiting;        telemetry.addData("Status", "Guess who seems to be working as of now!!");    //        telemetry.update();
        
        // Wait for the game to start (driver presses PLAY)        waitForStart();
       
        robot.rightMotor.setPower(-0.5);
        robot.leftmotor.setPower(.5);
        
