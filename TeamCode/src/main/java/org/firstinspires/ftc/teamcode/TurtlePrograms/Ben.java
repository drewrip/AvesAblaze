package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

@Autonomous(name="Autonumous_Template", group="Autonomous")

public class Autonomous_Template extends LinearOpMode {

    /* Declare OpMode members. */
    HardwarePushbot1         robot   = new HardwarePushbot1();   // Use a Pushbot's hardware

    //Make yourself some nice base variables right here

    @Override
    public void runOpMode() {

        //Or here
        robot.init(hardwareMap);

        // Send telemetry message to signify robot waiting;
        telemetry.addData("Status", "Guess who seems to be working as of now!!");    //
        telemetry.update();

        
        waitForStart();
        robot.rightMotor.setDirection(DcMotor.Direction.FORWARD);
        robot.leftMotor.setDirection(DcMotor.Direction.FORWARD);
        robot.rightMotor.setPower(1);
        robot.leftMotor.setPower(1);
        sleep(1000);
           robot.rightMotor.setPower(0);
        robot.leftMotor.setPower(0);
        
        

       //Put your nice fancy codies here
    }
}
