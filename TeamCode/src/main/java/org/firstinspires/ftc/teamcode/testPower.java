package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import java.util.concurrent.TimeUnit;

@Autonomous(name="testPower", group="Pushbot")

public class testPower extends LinearOpMode {

    /* Declare OpMode members. */
    HardwarePushbot1 robot = new HardwarePushbot1();   // Use a Pushbot's hardware
    private ElapsedTime runtime = new ElapsedTime();

    double r = 1;
    double l = .2;

    double startPositionL = 0;
    double startPositionR = 0;


    @Override
    public void runOpMode() {

        robot.init(hardwareMap);
        //initialize servo


        waitForStart();

        while (opModeIsActive()) {
            robot.rightMotor.setPower(r);
            robot.leftMotor.setPower(l);

        }


    }
}







