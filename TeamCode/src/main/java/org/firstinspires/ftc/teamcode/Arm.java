package org.firstinspires.ftc.teamcode.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by Sycamore2 on 10/11/2017.
 */

public class Arm {
    Servo xaxis;
    Servo zaxis;
    Arm(Servo xrotation, Servo zrotation){
        xaxis=xrotation;
        zaxis=zrotation;
    }
}
