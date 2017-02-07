package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.Range;

@TeleOp(name="Drive Tank Multi-Thread", group="Exercises")
//@Disabled
public class ablazeTeleOpTest2 extends LinearOpMode
{
    DcMotor leftMotor, rightMotor;
    double   leftY, rightY;


    // called when init button is  pressed.
    @Override
    public void runOpMode() throws InterruptedException
    {
        leftMotor = hardwareMap.dcMotor.get("left_motor");
        rightMotor = hardwareMap.dcMotor.get("right_motor");
        rightMotor.setDirection(DcMotor.Direction.REVERSE);

        // create an instance of the DriveThread.

        Thread  driveThread = new DriveThread();

        telemetry.addData("Mode", "waiting");
        telemetry.update();

        // wait for start button.



        waitForStart();



        // start the driving thread.

        driveThread.start();

        // continue with main thread.


            while (opModeIsActive())
            {
                telemetry.addData("Mode", "running");
                telemetry.addData("Run Time", this.getRuntime());
                telemetry.addData("Buttons", "x1=" + gamepad1.x);
                telemetry.addData("sticks", "  left=" + leftY + "  right=" + rightY);
                telemetry.update();

                idle();
            }



        // stop the driving thread.

        driveThread.interrupt();


    }

    private class DriveThread extends Thread
    {
        public DriveThread()
        {
            this.setName("DriveThread");


        }

        // called when tread.start is called. thread stays in loop to do what it does until exit is
        // signaled by main code calling thread.interrupt.
        @Override
        public void run()
        {



                while (!isInterrupted())
                {
                    // we record the Y values in the main class to make showing them in telemetry
                    // easier.

                    leftY = gamepad1.left_stick_y;
                    rightY = gamepad1.right_stick_y;

                    leftMotor.setPower(Range.clip(leftY, -1.0, 1.0));
                    rightMotor.setPower(Range.clip(rightY, -1.0, 1.0));

                    idle();
                }

            // interrupted means time to shutdown. note we can stop by detecting isInterrupted = true
            // or by the interrupted exception thrown from the sleep function.

        }
    }
}