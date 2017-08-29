package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.modernrobotics.ModernRoboticsI2cGyro;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gyroscope;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.IntegratingGyroscope;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.AngularVelocity;
import org.firstinspires.ftc.robotcore.external.navigation.AxesOrder;
import org.firstinspires.ftc.robotcore.external.navigation.AxesReference;

@TeleOp(name = "GyroTest", group = "Pushbot")
//@Disabled
public class GyroTest extends LinearOpMode {
    HardwarePushbot1 robot = new HardwarePushbot1();


    /* local OpMode members. */
    private ElapsedTime period  = new ElapsedTime();

    /* Initialize standard Hardware interfaces */


    /***
     *
     * waitForTick implements a periodic delay. However, this acts like a metronome with a regular
     * periodic tick.  This is used to compensate for varying processing times for each cycle.
     * The function looks at the elapsed cycle time, and sleeps for the remaining time interval.
     *
     * @param periodMs  Length of wait cycle in mSec.
     */

    IntegratingGyroscope gyro;
    ModernRoboticsI2cGyro modernRoboticsI2cGyro;

    // A timer helps provide feedback while calibration is taking place
    ElapsedTime timer = new ElapsedTime();

    @Override
    public void runOpMode() {

        boolean lastResetState = false;
        boolean curResetState  = false;

        // Get a reference to a Modern Robotics gyro object. We use several interfaces
        // on this object to illustrate which interfaces support which functionality.
        // If you're only interested int the IntegratingGyroscope interface, the following will suffice.
        // gyro = hardwareMap.get(IntegratingGyroscope.class, "gyro");
        // A similar approach will work for the Gyroscope interface, if that's all you need.
        robot.init(hardwareMap);
        // Start calibrating the gyro. This takes a few seconds and is worth performing
        // during the initialization phase at the start of each opMode.
        robot.gyro.calibrate();

        // Wait until the gyro calibration is complete
        timer.reset();
        while (!isStopRequested() && robot.gyro.isCalibrating())  {
            telemetry.addData("calibrating", "%s", Math.round(timer.seconds())%2==0 ? "|.." : "..|");
            telemetry.update();
            sleep(50);
        }
        telemetry.log().clear(); telemetry.log().add("Gyro Calibrated. Press Start.");
        telemetry.clear(); telemetry.update();

        // Wait for the start button to be pressed
        waitForStart();
        telemetry.log().clear();
        telemetry.log().add("Press A & B to reset heading");

        // Loop until we're asked to stop
        while (opModeIsActive())  {
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
            double left=0;
            double right=0;
            left = -gamepad1.left_stick_y; //reset power values
            right = -gamepad1.right_stick_y;

            robot.rightMotor.setPower(right);   //sets power
            robot.leftMotor.setPower(left);
            // If the A and B buttons are pressed just now, reset Z heading.
            curResetState = (gamepad1.a && gamepad1.b);
            if (curResetState && !lastResetState) {
                robot.gyro.resetZAxisIntegrator();
            }
            lastResetState = curResetState;

            // The raw() methods report the angular rate of change about each of the
            // three axes directly as reported by the underlying sensor IC.
            int rawX = robot.gyro.rawX();
            int rawY = robot.gyro.rawY();
            int rawZ = robot.gyro.rawZ();
            int heading = robot.gyro.getHeading();
            int integratedZ = robot.gyro.getIntegratedZValue();

            // Read dimensionalized data from the gyro. This gyro can report angular velocities
            // about all three axes. Additionally, it internally integrates the Z axis to
            // be able to report an absolute angular Z orientation.
            AngularVelocity rates = robot.gyro.getAngularVelocity(AngleUnit.DEGREES);
            float zAngle = robot.gyro.getAngularOrientation(AxesReference.INTRINSIC, AxesOrder.ZYX, AngleUnit.DEGREES).firstAngle;

            // Read administrative information from the gyro
            int zAxisOffset = robot.gyro.getZAxisOffset();
            int zAxisScalingCoefficient = robot.gyro.getZAxisScalingCoefficient();

            telemetry.addLine()
                    .addData("dx", formatRate(rates.xRotationRate))
                    .addData("dy", formatRate(rates.yRotationRate))
                    .addData("dz", "%s deg/s", formatRate(rates.zRotationRate));
            telemetry.addData("angle", "%s deg", formatFloat(zAngle));
            telemetry.addData("heading", "%3d deg", heading);
            telemetry.addData("integrated Z", "%3d", integratedZ);
            telemetry.addLine()
                    .addData("rawX", formatRaw(rawX))
                    .addData("rawY", formatRaw(rawY))
                    .addData("rawZ", formatRaw(rawZ));
            telemetry.addLine().addData("z offset", zAxisOffset).addData("z coeff", zAxisScalingCoefficient);
            telemetry.update();
        }
    }

    String formatRaw(int rawValue) {
        return String.format("%d", rawValue);
    }

    String formatRate(float rate) {
        return String.format("%.3f", rate);
    }

    String formatFloat(float rate) {
        return String.format("%.3f", rate);
    }

}
