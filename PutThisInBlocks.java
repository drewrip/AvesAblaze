while (OpModeIsActive()){
  robot.leftMotor.power()=gamepad1.left_stick_y;
  robot.rightMotor.power()=gamepad2.right_stick_y;
  if(gamepad1.a){
    robot.intake.power()=1;
  }
  if(gamepad1.b){
    robot.intake.power()=0;
  }
  if(gamepad1.x){
    robot.intake.power()=-1;
  }
  if(gamepad1.right_bumper){
    robot.collector.setPosition(0.18)
  }
  if(gamepad1.left_bumper){
    robot.collector.setPosition(0.27)
  }
}