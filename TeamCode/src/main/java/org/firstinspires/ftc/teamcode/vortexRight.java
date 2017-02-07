package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;
import java.util.concurrent.TimeUnit;
@Autonomous(name="vortexRight", group="Pushbot")

public class vortexRight extends LinearOpMode {

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
        //initialize servo- 0.18 (other position is 0.28)
        robot.collector.setPosition(0.18);
        //Wait for the drivers to press the start button to start the program
        waitForStart();
        //set autobroom to suck in balls
        robot.autobroom.setPower(-1);
        //set starting encoders position to their current positiion
        startPositionR = robot.rightMotor.getCurrentPosition();
        //move robot forward
        while (opModeIsActive() && (robot.rightMotor.getCurrentPosition() > startPositionR - 8600)) {


            robot.rightMotor.setPower(0.9);
            robot.leftMotor.setPower(1);
        }
        //after while loop is completed, stop robot
        robot.rightMotor.setPower(0);
        robot.leftMotor.setPower(0);
        //set encoders to current position and turn robot right
        startPositionR = robot.rightMotor.getCurrentPosition();
        while (opModeIsActive() && (robot.rightMotor.getCurrentPosition() > startPositionR - 4100)) {


            robot.rightMotor.setPower(-1);
            robot.leftMotor.setPower(1);
        }

        robot.rightMotor.setPower(0);
        robot.leftMotor.setPower(0);
        //robot move forward into corner vortex
        startPositionR = robot.rightMotor.getCurrentPosition();
        while(opModeIsActive() && (robot.rightMotor.getCurrentPosition() > startPositionR - 13000)){
            robot.rightMotor.setPower(1);
            robot.leftMotor.setPower(1);

        }
        //the following code shoots the ball by setting the autobroom to shoot balls while the collector moves to the desired position
        robot.autobroom.setPower(0);
        while(opModeIsActive()){
        robot.autobroom.setPower(1);
        robot.collector.setPosition(0.28);
        robot.rightMotor.setPower(0);
        robot.leftMotor.setPower(0);
            //repeat the previous code until the 30 seconds have expired in case the ball does not go into the vortex the first time
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
            //wait two seconds
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    }








