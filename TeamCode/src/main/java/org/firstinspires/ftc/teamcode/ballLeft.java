package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import java.util.concurrent.TimeUnit;

@Autonomous(name="ballLeft", group="Pushbot")

public class ballLeft extends LinearOpMode {

    /* Declare OpMode members. */
    HardwarePushbot1 robot = new HardwarePushbot1();   // Use a Pushbot's hardware
    private ElapsedTime runtime = new ElapsedTime();

    int r = 1;
    int l = 1;

    double startPositionL = 0;
    double startPositionR = 0;
    public static void moveForward(double seconds){
        robot.rightMotor.setPower(1);
        robot.leftMotor.setPower(1);
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        robot.rightMotor.setPower(0);
        robot.leftMotor.setPower(0);
    }
    public static void moveBackwards(double seconds){
        robot.rightMotor.setPower(-1);
        robot.leftMotor.setPower(-1);
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        robot.rightMotor.setPower(0);
        robot.leftMotor.setPower(0);
    }    
    public static void turnRight(double seconds){
        robot.rightMotor.setPower(1);
        robot.leftMotor.setPower(-1);
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        robot.rightMotor.setPower(0);
        robot.leftMotor.setPower(0);
    }    
    public static void moveForward(double seconds){
        robot.rightMotor.setPower(-1);
        robot.leftMotor.setPower(1);
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        robot.rightMotor.setPower(0);
        robot.leftMotor.setPower(0);
    }    
    public static void setPosition(Servo srvo, double position){
        robot.srvo.setPosition(position);
    }
    public static void wait(double seconds){
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void turnMotorClockwise(DcMotor mtr){
        mtr.setPower(1);
    }
    public static void turnMotorCounterClockwise(DcMotor mtr){
        mtr.setPower(-1);
    }
    public static void stopMotor(DcMotor mtr){
        mtr.setPower(0);
    }
    @Override
    public void runOpMode() {
          

        robot.init(hardwareMap);
        //initialize servo
        robot.collector.setPosition(0.18);
        waitForStart();

        startPositionR = robot.rightMotor.getCurrentPosition();
        while (opModeIsActive() && (robot.rightMotor.getCurrentPosition() > startPositionR - 9935)) {

            robot.rightMotor.setPower(1);
            robot.leftMotor.setPower(1);
        }

        robot.rightMotor.setPower(0);
        robot.leftMotor.setPower(0);

        startPositionR = robot.rightMotor.getCurrentPosition();
        while (opModeIsActive() && (robot.rightMotor.getCurrentPosition() < startPositionR + 2900)) {


            robot.rightMotor.setPower(1);
            robot.leftMotor.setPower(-1);
        }

        robot.rightMotor.setPower(0);
        robot.leftMotor.setPower(0);
        robot.autobroom.setPower(-1);

        startPositionR = robot.rightMotor.getCurrentPosition();
        while(opModeIsActive() && (robot.rightMotor.getCurrentPosition() > startPositionR - 18000)) {
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








