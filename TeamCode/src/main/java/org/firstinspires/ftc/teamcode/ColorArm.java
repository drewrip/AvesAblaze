package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous(name="ColorArm", group="Autonomous")

public class Autonomous_Template extends LinearOpMode {

    /* Declare OpMode members. */
    HardwarePushbot         robot   = new HardwarePushbot1();   // Use a Pushbot's hardware
    int mrFullColor=3;
    int revFullColor=125;
    int xArmStorage=0.37;
    int zArmStorage=0;
    @Override
    public void runOpMode() {

        robot.init(hardwareMap);
        robot.xArm.setPosition(xArmStorage);
        robot.zArm.setPosition(zArmStorage);
        // Send telemetry message to signify robot waiting;
        telemetry.addData("Status", "Guess who seems to be working as of now!!");    //
        telemetry.update();

        // Wait for the game to start (driver presses PLAY)
        waitForStart();
        telemetry.addData("red", "jewelIdentifier.red());
        telemetry.addData("blue", "jewelIdentifier.blue());
        telemetry.update();
        robot.zArm.setPosition(0.9);
        if(robot.jewelIdentifier.red()>mrFullColor)
           robot.xArm.setPosition(robot.xArm.getPosition()+0.5);
        else
           robot.xArm.setPosition(robot.xArm.getPosition()-0.5);
        try {
           TimeUnit.SECONDS.sleep(0.3);
       } catch (InterruptedException e) {
           e.printStackTrace();
       }   
        robot.xArm.setPosition(xArmStorage);
        robot.zArm.setPosition(zArmStorage);        
       while(opModeIsActive()){
        telemetry.addData("red", "jewelIdentifier.red());
        telemetry.addData("blue", "jewelIdentifier.blue());
        telemetry.update();       
    }
}
