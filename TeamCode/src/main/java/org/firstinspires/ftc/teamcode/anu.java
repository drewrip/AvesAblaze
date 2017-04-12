package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import java.util.concurrent.TimeUnit;

@Autonomous(name="Anu", group="Pushbot")

public class Anu extends LinearOpMode {

    /* Declare OpMode members. */
    HardwarePushbot1 robot = new HardwarePushbot1();   // Use a Pushbot's hardware
    private ElapsedTime runtime = new ElapsedTime();
     int r = 1;
    int l = 1;

    double startPositionL = 0;
    double startPositionR = 0;

    @Override
    public void runOpMode() {

        robot.init(hardwareMap);
        waitForStart();
    
    
      while (opModeIsActive() && (robot.rightMotor.getCurrentPosition() > startPositionR - 200)) {

            robot.rightMotor.setPower(1);
            robot.leftMotor.setPower(1);
        }
      while (opModeIsActive() && (robot.rightMotor.getCurrentPosition() < startPositionR + 2400)) {


            robot.rightMotor.setPower(1);
            robot.leftMotor.setPower(-1);
        }
     while (opModeIsActive() && (robot.rightMotor.getCurrentPosition() > startPositionR - 200)) {

            robot.rightMotor.setPower(1);
            robot.leftMotor.setPower(1);
        }
     while (opModeIsActive() && (robot.rightMotor.getCurrentPosition() < startPositionR + 2400)) {


            robot.rightMotor.setPower(1);
            robot.leftMotor.setPower(-1);
        }
     while (opModeIsActive() && (robot.rightMotor.getCurrentPosition() < startPositionR + 200)) {


            robot.rightMotor.setPower(1);
            robot.leftMotor.setPower(1);
        }
        while (opModeIsActive() && (robot.rightMotor.getCurrentPosition() < startPositionR + 2400)) {


            robot.rightMotor.setPower(1);
            robot.leftMotor.setPower(-1);
        }
        while (opModeIsActive() && (robot.rightMotor.getCurrentPosition() < startPositionR + 200)) {


            robot.rightMotor.setPower(1);
            robot.leftMotor.setPower(1);
        }
        }
        }
