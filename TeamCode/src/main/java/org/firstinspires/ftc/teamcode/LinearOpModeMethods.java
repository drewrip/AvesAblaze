package org.firstinspires.ftc.teamcode.TeamCode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

import java.lang.Math;
import java.util.ArrayList;

/**
 * Created by Sycamore2 on 9/28/2017.
 */

@Autonomous(name="LinearOpModeMethods", group="None")
@Disabled

public class LinearOpModeMethods extends LinearOpMode {
    HardwarePushbot1 robot = new HardwarePushbot1();
    @Override
    public void runOpMode(){

    }
    public double drive(double degrees, double velocity, boolean isTurning, int w){
        double rad = Math.toRadians(degrees);
        double arc;
        if(isTurning){
            arc = rad;
            rad = 0;
        }
        else{
            arc = 0;
        }
        double d = 9+(9*Math.sqrt(3));
        double w0 = Math.sin(rad) - Math.cos(rad) + d;
        double w1 = Math.sin(rad) + Math.cos(rad) - d;
        double w2 = Math.sin(rad) - Math.cos(rad) - d;
        double w3 = Math.sin(rad) + Math.cos(rad) + d;
        switch(w){
            case 0: return w0;
            case 1: return w1;
            case 2: return w2;
            case 3: return w3;
            default: return 0;
        }
    }


}
