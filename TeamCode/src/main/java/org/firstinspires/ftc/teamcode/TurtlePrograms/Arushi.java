package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous(name="Arushi", group="Autonomous")

public class Arushi extends LinearOpMode {

    /* Declare OpMode members. */
    HardwarePushbot         robot   = new HardwarePushbot();   // Use a Pushbot's hardware

    //Make yourself some nice base variables right here

    @Override
    public void runOpMode() {

        //Or here
        robot.init(hardwareMap);

        // Send telemetry message to signify robot waiting;
        telemetry.addData("Status", "Guess who seems to be working as of now!!");    //
        telemetry.update();

        // Wait for the game to start (driver presses PLAY)
        waitForStart();

       //Put your nice fancy codies here
       
       robot.rightMotor.setPower(1);
       robot.leftMotor.setPower(1);
       TimeUnit.SECONDS.sleep(2);
       robot.rightMotor.setPower(0);
       robot.leftMotor.setPower(0);
       
    }
}
