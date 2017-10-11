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

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name = "MotorTest", group = "Autonomous")

public class MotorTest extends LinearOpMode {

    /* Declare OpMode members. */
    HardwarePushbot2 robot = new HardwarePushbot2();   // Use a Pushbot's hardware

    //Make yourself some nice base variables right here
    double motorPower=0.1;


    @Override
    public void runOpMode() {

        //Or here
        robot.init(hardwareMap);

        /*ArrayList<DcMotor> motors = new ArrayList<DcMotor>();
        motors.add(robot.leftFront);
        motors.add(robot.rightFront);
        motors.add(robot.leftBack);
        motors.add(robot.rightBack);*/

        // Send telemetry message to signify robot waiting;
        telemetry.addData("Status", "Guess who seems to be working as of now!!");    //
        telemetry.update();

        // Wait for the game to start (driver presses PLAY)
        waitForStart();
        while (opModeIsActive()) {
            if (gamepad1.dpad_up) {
                motorPower += 0.05;
                try {
                    Thread.sleep(700);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if (gamepad1.dpad_down) {
                motorPower -= 0.05;
                try {
                    Thread.sleep(700);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if (gamepad1.a){
                robot.right.setPower(motorPower);
                robot.left.setPower(motorPower);
            }
            if (gamepad1.b){
                robot.right.setPower(0);
                robot.left.setPower(0);
            }
            if (gamepad1.x){
                robot.right.setPower(motorPower*-1);
                robot.left.setPower(motorPower*-1);
            }
            robot.right.setPower(gamepad1.right_stick_y*motorPower);
            robot.left.setPower(gamepad1.left_stick_y*motorPower);

        }
        //Put your nice fancy codies here
    }
}