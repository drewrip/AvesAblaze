package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous(name="Autonumous_Template", group="Autonomous")

public class Autonomous_Template extends LinearOpMode {

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

       motor = hwMap.dcMotor.get(leftMotor);
       motor = hwMap.dcMotor.get(rightMotor);
       robot.rightMotor.setDirection(DcMotor.Direction.FORWARD);
       robot.leftMotor.setDirection(DcMotor.Direction.FORWARD);
       robot.leftMotor.setPower(1);
       robot.rightMotor.setPower(1);
       while (opModeIsActive() && (robot.rightMotor.getCurrentPosition() < 2000)){
       }
       robot.leftMotor.setPower(0);
       robot.rightMotor.setPower(0);
    }
}
