package org.firstinspires.ftc.teamcode.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by Sycamore2 on 10/11/2017.
 */

public class DriveTrain {
    DcMotor lb;
    DcMotor lf;
    DcMotor rb;
    DcMotor rf;

    DriveTrain(DcMotor leftBack, DcMotor leftFront, DcMotor rightFront, DcMotor rightBack){
        lb=leftBack;
        rb=rightBack;
        lf=leftFront;
        rf=rightFront;
    }
    
    public void drive(double angle, double speed){
        double rad = (angle/180)*Math.PI;
        double wheelSpeeds[] = new double[4];
        double sinRad = Math.sin(rad);
        double cosRad = Math.cos(rad);
        wheelSpeeds[0] = (speed * sinRad) + ;
        wheelSpeeds[1] = speed * cosRad;
        wheelSpeeds[2] = speed * -cosDir;
        wheelSpeeds[3] = speed * -sinDir;
        
        lb.setPower(wheelSpeeds[0]);
        lf.setPower(wheelSpeeds[1]);
        rb.setPower(wheelSpeeds[2]);
        rf.setPower(wheelSpeeds[3]);
        
    }
}
