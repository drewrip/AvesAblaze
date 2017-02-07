package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;


import java.util.concurrent.TimeUnit;

@TeleOp(name="ablazeTeleOp", group="TeleOp")

public class ablazeTeleOp extends OpMode {

    /* Declare OpMode members. */
    HardwarePushbot1 robot = new HardwarePushbot1();   // Use a Pushbot's hardware
    private ElapsedTime runtime = new ElapsedTime();

    double r = 1;
    double l = 1;

    double startPositionL = 0;
    double startPositionR = 0;

    double left;    //Defining variables
    double right;

    @Override
    public void init(){
        robot.init(hardwareMap);
    }



    public void loop() {

        telemetry.addData("Loop", "Running");


            //initialize


            if(gamepad2.left_bumper){   //making left bumper move servo back
                robot.collector.setPosition(0.18);
            }
            if(gamepad2.right_bumper){  //making right bumper move servo forward
                robot.collector.setPosition(0.28);
            }
            if(gamepad1.left_bumper){   //making left bumper move servo back
                robot.collector.setPosition(0.18);
            }
            if(gamepad1.right_bumper) { //Making right bumper move servo forward
                robot.collector.setPosition(0.28);
            }
            if (gamepad2.x)  {  //makes "x" turn autobroom clockwise
                robot.autobroom.setPower(-1);}

            if (gamepad1.x) {   //makes "x" turn autobroom clockwise
                robot.autobroom.setPower(-1);
            }
            if (gamepad2.a)  {  //makes "a" turn autobroom counter clockwise
                robot.autobroom.setPower(1);
            }

            if (gamepad1.a) {   //makes "a" turn autobroom counter clockwise
                robot.autobroom.setPower(1);
            }
            if (gamepad2.b)  {  //makes "b" turn off autobroom
                robot.autobroom.setPower(0);
            }

            if (gamepad1.b) {   //makes "b" turn off autobroom
                robot.autobroom.setPower(0);
            }

            if (gamepad2.y) {   //makes "y" shoot ball
                robot.collector.setPosition(0.28);
                robot.autobroom.setPower(1);
            }
            if (gamepad1.y) {   //makes "y" shoot ball
                robot.collector.setPosition(0.28);
                robot.autobroom.setPower(1);
            }

            left = -gamepad1.left_stick_y; //reset power values
            right = -gamepad1.right_stick_y;

            robot.rightMotor.setPower(right);   //sets power
            robot.leftMotor.setPower(left);


        }
    }
