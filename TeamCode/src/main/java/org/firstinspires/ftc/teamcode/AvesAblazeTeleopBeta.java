/* Copyright (c) 2017 FIRST. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted (subject to the limitations in the disclaimer below) provided that
 * the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice, this list
 * of conditions and the following disclaimer.
 *
 * Redistributions in binary form must reproduce the above copyright notice, this
 * list of conditions and the following disclaimer in the documentation and/or
 * other materials provided with the distribution.
 *
 * Neither the name of FIRST nor the names of its contributors may be used to endorse or
 * promote products derived from this software without specific prior written permission.
 *
 * NO EXPRESS OR IMPLIED LICENSES TO ANY PARTY'S PATENT RIGHTS ARE GRANTED BY THIS
 * LICENSE. THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package org.firstinspires.ftc.teamcode.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.robotcontroller.external.samples.HardwarePushbot;
import org.firstinspires.ftc.robotcore.external.ClassFactory;
import org.firstinspires.ftc.robotcore.external.matrices.OpenGLMatrix;
import org.firstinspires.ftc.robotcore.external.matrices.VectorF;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.AxesOrder;
import org.firstinspires.ftc.robotcore.external.navigation.AxesReference;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;
import org.firstinspires.ftc.robotcore.external.navigation.RelicRecoveryVuMark;
import org.firstinspires.ftc.robotcore.external.navigation.VuMarkInstanceId;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackable;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackableDefaultListener;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackables;


import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

import java.lang.reflect.Array;
import java.util.ArrayList;

@TeleOp(name = "AvesAblazeTeleopBeta", group = "Autonomus")

public class AvesAblazeTeleopBeta extends LinearOpMode {

    /* Declare OpMode members. */
    HardwarePushbot1 robot = new HardwarePushbot1();   // Use a Pushbot's hardware

    //Make yourself some nice base variables right here
    double motorPower=0.1;


    @Override
    public void runOpMode() {

        //Or here
        robot.init(hardwareMap);

        ArrayList<DcMotor> motors = new ArrayList<DcMotor>();
        motors.add(robot.leftFront);
        motors.add(robot.rightFront);
        motors.add(robot.leftBack);
        motors.add(robot.rightBack);

        LinearOpModeMethods methods = new LinearOpModeMethods();

        // Send telemetry message to signify robot waiting;
        telemetry.addData("Status", "Guess who seems to be working as of now!!");    //
        telemetry.update();

        // Wait for the game to start (driver presses PLAY)
        waitForStart();
        double driveX;
        double driveY;
        double turn;
        while (opModeIsActive()) {

            if (gamepad1.left_stick_y == -1) {
                //move forward
                for(int i = 0; i<motors.size(); i++){
                    motors.get(i).setPower(methods.drive(90, motorPower, false, i));
                }
            }

            else if (gamepad1.left_stick_y == 1) {
                //move backward
                for(int i = 0; i<motors.size(); i++){
                    motors.get(i).setPower(methods.drive(270, motorPower, false, i));
                }
            }
            else if (gamepad1.right_stick_x == 1) {
                //turn right
                for(int i = 0; i<motors.size(); i++){
                    motors.get(i).setPower(methods.drive(0, motorPower, true, i));
                }
            }
            else if (gamepad1.right_stick_x == -1) {
                //turn left
                for(int i = 0; i<motors.size(); i++){
                    motors.get(i).setPower(methods.drive(180, motorPower, true, i));
                }
            }
            else if (gamepad1.left_stick_x == 1) {
                //move right
                for(int i = 0; i<motors.size(); i++){
                    motors.get(i).setPower(methods.drive(0, motorPower, false, i));
                }
            }
            else if (gamepad1.left_stick_x == -1) {
                //move left
                for(int i = 0; i<motors.size(); i++){
                    motors.get(i).setPower(methods.drive(180, motorPower, false, i));
                }
            }
            else{
                for(int i = 0; i<motors.size(); i++){
                    motors.get(i).setPower(0);
                }
            }

        }
        //Put your nice fancy codies here
    }
}