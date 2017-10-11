public class Lift{
  DcMotor[] lifters;
  public Lift(DcMotor[] motors){
    lifters=motors;
  }
  public lift(double power){
    for (i=0; i<lifters.length()-1; i++)
      {
        lifters[i].setPower(1);
      }
  }
}
