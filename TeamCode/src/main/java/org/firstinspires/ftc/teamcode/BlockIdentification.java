package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

/**
 * This OpMode uses the common Pushbot hardware class to define the devices on the robot.
 * All device access is managed through the HardwarePushbot class.
 * The code is structured as a LinearOpMode
 *
 * This particular OpMode executes a POV Game style Teleop for a PushBot
 * In this mode the left stick moves the robot FWD and back, the Right stick turns left and right.
 * It raises and lowers the claw using the Gampad Y and A buttons respectively.
 * It also opens and closes the claws slowly using the left and right Bumper buttons.
 *
 * Use Android Studios to Copy this Class, and Paste it into your team's code folder with a new name.
 * Remove or comment out the @Disabled line to add this opmode to the Driver Station OpMode list
 */
//cameraAPI https://developer.android.com/guide/topics/media/camera.html
//https://developer.android.com/training/camera/photobasics.html
@TeleOp(name="Tele-op Template", group="TeleOp")

public class Tele-op_Template extends LinearOpMode {

    /* Declare OpMode members. */
    HardwarePushbot robot           = new HardwarePushbot1();   // Use a Pushbot's hardware


    @Override
    public void runOpMode() {

        //Maybe make some nice base variables here
        /* Initialize the hardware variables.
         * The init() method of the hardware class does all the work here
         */
        robot.init(hardwareMap);
    if (context.getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA)){
        // this device has a camera
          Camera c = null;
    try {
        c = Camera.open(); // attempt to get a Camera instance
    }
    catch (Exception e){
        // Camera is not available (in use or does not exist)
    }
    return c; // returns null if camera is unavailable
}  
    } else {
        // no camera on this device
        
    }
    
        
        // Send telemetry message to signify robot waiting;
        telemetry.addData("Say", "Hi, I'm not completely broken yet!!");    //
        telemetry.update();

        // Wait for the game to start (driver presses PLAY)
        waitForStart();

        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {

            if(gamepad1.a){
                
                c.super.onPause();
                c.release();
            }
        }
    }
