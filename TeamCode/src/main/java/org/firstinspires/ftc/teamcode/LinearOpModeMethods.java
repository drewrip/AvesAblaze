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
    public void stopRobot(){
        robot.leftFront.setPower(0);
        robot.rightFront.setPower(0);
        robot.leftBack.setPower(0);
        robot.rightBack.setPower(0);
    }
    public double w1(double degrees, double velocity, boolean isTurning){
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
        double w1 = Math.sin(rad) - Math.cos(rad) + d;
        return w1;
    }
    public double w2(double degrees, double velocity, boolean isTurning){
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
        double w2 = Math.sin(rad) + Math.cos(rad) - d;
        return w2;
    }
    public double w3(double degrees, double velocity, boolean isTurning){
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
        double w3 = Math.sin(rad) - Math.cos(rad) - d;
        return w3;
    }
    public double w4(double degrees, double velocity, boolean isTurning){
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
        double w4 = Math.sin(rad) + Math.cos(rad) + d;
        return w4;
    }

}
