package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

@Autonomous(name="Autonumous_Template", group="Autonomous")

public class Autonomous_Template extends LinearOpMode {

    /* Declare OpMode members. */
    HardwarePushbot         robot   = new HardwarePushbot();   // Use a Pushbot's hardware

    //Make yourself some nice base variables right here
    leftMotor = hwMap.dcMotor.get("leftMotor");
    rightMotor = hwMap.dcMotor.get("rightMotor");
    robot.leftMotor.setDirection(DcMotor.Direction.FORWARD);
    robot.leftMotor.setPower(int power);
    robot.leftMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
    robot.rightMotor.setDirection(DcMotor.Direction.FORWARD);
    robot.rightMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

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
       
       robot.rightMotor.setPower(int power);
       robot.leftMotor.setPower(int power);
       
    }
}
