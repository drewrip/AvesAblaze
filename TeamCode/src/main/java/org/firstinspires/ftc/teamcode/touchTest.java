import com.qualcomm.robotcore.hardware.TouchSensor;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
Autonomous(name="Concept: Compass Calibration", group="Concept")
@Disabled
public class ConceptCompassCalibration extends LinearOpMode {

    /* Declare OpMode members. */
    HardwarePushbot     robot   = new HardwarePushbot();   // Use a Pushbot's hardware
    private ElapsedTime runtime = new ElapsedTime();
    
    @Override
    public void runOpMode() {

        /* Initialize the drive system variables.
         * The init() method of the hardware class does all the work here
         */
        robot.init(hardwareMap);

        // get a reference to our Compass Sensor object.
        compass = hardwareMap.compassSensor.get("compass");

        // Send telemetry message to signify robot waiting;
        telemetry.addData("Status", "Ready to call");    //
        telemetry.update();

        // Wait for the game to start (driver presses PLAY)
        waitForStart();

        // Set the compass to calibration mode
        telemetry.addData("Touched", touchSensor.isPressed());
        telemetry.update();
    }
}
