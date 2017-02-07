package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import java.util.concurrent.TimeUnit;

@Autonomous(name="ballRight", group="Pushbot")

public class ballRight extends LinearOpMode {

    /* Declare OpMode members. */
    HardwarePushbot1 robot = new HardwarePushbot1();   // Use a Pushbot's hardware
    private ElapsedTime runtime = new ElapsedTime();

    double startPositionL = 0;
    double startPositionR = 0;

    int r = 1;
    int l = 1;

    @Override
    public void runOpMode() {

        robot.init(hardwareMap);
        //initialize servo
        robot.collector.setPosition(0.18);

        waitForStart();

        startPositionR = robot.rightMotor.getCurrentPosition();
        while (opModeIsActive() && (robot.rightMotor.getCurrentPosition() > startPositionR - 8850)) {


            robot.rightMotor.setPower(0.9);
            robot.leftMotor.setPower(1);
        }

        robot.rightMotor.setPower(0);
        robot.leftMotor.setPower(0);

        startPositionR = robot.rightMotor.getCurrentPosition();
        while (opModeIsActive() && (robot.rightMotor.getCurrentPosition() > startPositionR - 3000)) {


            robot.rightMotor.setPower(-1);
            robot.leftMotor.setPower(1);
        }

        robot.rightMotor.setPower(0);
        robot.leftMotor.setPower(0);
        robot.autobroom.setPower(-1);
        startPositionR = robot.rightMotor.getCurrentPosition();
        while(opModeIsActive() && (robot.rightMotor.getCurrentPosition() > startPositionR - 17000)){
            robot.rightMotor.setPower(1);
            robot.leftMotor.setPower(1);

        }

        robot.autobroom.setPower(0);
        while(opModeIsActive()){
        robot.autobroom.setPower(1);
        robot.collector.setPosition(0.28);
        robot.rightMotor.setPower(0);
        robot.leftMotor.setPower(0);
            if(!opModeIsActive())
                break;
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            robot.collector.setPosition(0.18);
            robot.autobroom.setPower(-1);
            if(!opModeIsActive())
                break;
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}








