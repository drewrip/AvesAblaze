package org.firstinspires.ftc.teamcode.teamcode;

        import android.app.Activity;
        import android.graphics.Color;
        import android.view.View;

        import com.qualcomm.robotcore.hardware.DcMotor;
        import com.qualcomm.robotcore.hardware.HardwareMap;
        import com.qualcomm.robotcore.hardware.Servo;
        import com.qualcomm.robotcore.util.ElapsedTime;
        import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
        import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
        import com.qualcomm.robotcore.hardware.ColorSensor;
        import com.qualcomm.robotcore.hardware.DcMotor;
        import com.qualcomm.robotcore.hardware.DcMotorSimple;
        import static com.qualcomm.robotcore.hardware.DcMotor.RunMode.RUN_USING_ENCODER;
        import static com.qualcomm.robotcore.hardware.DcMotor.RunMode.RUN_WITHOUT_ENCODER;

public class HardwarePushbot1
{
    /* Public OpMode members. */
    public DcMotor  leftFront  = null;
    public DcMotor  rightFront  = null;
    public DcMotor  leftBack  = null;
    public DcMotor  rightBack  = null;
    public Arm color;
    public ColorSensor jewelIdentifier=null;


    public static final double MID_SERVO       =  0.5 ;

    /* local OpMode members. */
    HardwareMap hwMap =  null;
    private ElapsedTime period  = new ElapsedTime();

    /* Initialize standard Hardware interfaces */
    public void init(HardwareMap ahwMap) {
        // Save reference to Hardware map
        hwMap = ahwMap;

        // Define and Initialize Motors
        leftFront   = hwMap.dcMotor.get("leftFront");
        rightFront  = hwMap.dcMotor.get("rightFront");
        leftBack   = hwMap.dcMotor.get("leftBack");
        rightBack  = hwMap.dcMotor.get("rightBack");

        leftBack.setDirection(DcMotor.Direction.FORWARD); // Set to REVERSE if using AndyMark motors
        rightBack.setDirection(DcMotor.Direction.REVERSE);// Set to FORWARD if using AndyMark motors
        leftFront.setDirection(DcMotor.Direction.FORWARD); // Set to REVERSE if using AndyMark motors
        rightFront.setDirection(DcMotor.Direction.REVERSE);// Set to FORWARD if using AndyMark motors

        rightBack.setPower(0);
        rightFront.setPower(0);
        leftFront.setPower(0);
        leftBack.setPower(0);
        // Set all motors to run without encoders.
        // May want to use RUN_USING_ENCODERS if encoders are installed.

        leftFront.setMode(RUN_USING_ENCODER);
        rightFront.setMode(RUN_USING_ENCODER);
        rightBack.setMode(RUN_USING_ENCODER);
        leftBack.setMode(RUN_USING_ENCODER);
        // Define and initialize ALL installed servos.

        color=new Arm(hwMap.servo.get("xrotation"),hwMap.servo.get("zrotation"));

        //Define and initialize ALL installed sensors
        jewelIdentifier= hwMap.colorSensor.get("color1");
    }

    /***
     *
     * waitForTick implements a periodic delay. However, this acts like a metronome with a regular
     * periodic tick.  This is used to compensate for varying processing times for each cycle.
     * The function looks at the elapsed cycle time, and sleeps for the remaining time interval.
     *
     * @param periodMs  Length of wait cycle in mSec.
     */
    public void waitForTick(long periodMs) {

        long  remaining = periodMs - (long)period.milliseconds();

        // sleep for the remaining portion of the regular cycle period.
        if (remaining > 0) {
            try {
                Thread.sleep(remaining);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        // Reset the cycle clock for the next pass.
        period.reset();
    }
}