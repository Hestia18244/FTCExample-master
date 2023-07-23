package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

// This is an example of how to use encoders
// Encoders are a way to treat motors like servos
// Its a bit more precise than regular power
// We use encoders to send motors a certain DISTANCE rather than a certain TIME
public class encoderExample extends LinearOpMode {

    // Declare our motors here
    DcMotor frontRight;
    DcMotor frontLeft;
    DcMotor backLeft;
    DcMotor backRight;

    public void runOpMode(){

        // Hardware map our motors
        frontRight = hardwareMap.dcMotor.get("frontRight");
        frontLeft = hardwareMap.dcMotor.get("frontLeft");
        backLeft = hardwareMap.dcMotor.get("backLeft");
        backRight = hardwareMap.dcMotor.get("backRight");





        // on startup we execute the code below this
        waitForStart();

        // This sets our encoder value to zero
        // Everytime we make the motors use encoders, start with this, otherwise it becomes very confusing
        frontLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        // This sets our target position on the motor
        // In this case, we are making the motor move 537 "ticks", which is roughly one full revolution of our motor
        // encoder ticks can be negative, which reverses the direction
        // Lets assume for the purpose of this example that this code makes our robot move forward
        frontLeft.setTargetPosition(537);
        frontRight.setTargetPosition(-537);
        backRight.setTargetPosition(537);
        backLeft.setTargetPosition(537);

        // We still need to set power to our motors to determine how fast we're going to move 537 ticks
        frontLeft.setPower(.5);
        frontRight.setPower(.5);
        backLeft.setPower(.5);
        backRight.setPower(.5);

        // Calling this sets our motors to run toward the target position
        frontRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        // This while loop is needed to block the code from moving on to whatever code we may have after setting the target position
        // isBusy() returns whether the motor is moving
        // This while loop basically says while the motors are moving, don't move on to anything else or do anything else
        while (frontRight.isBusy() && frontLeft.isBusy() && backLeft.isBusy() && backRight.isBusy()){

        }

        // If we want to add a delay after moving our motors, we can still do so using sleep
        sleep(321);


        // Lets assume we're trying to replicate the code from above
        // We want to move 537 ticks forward, so we set our forward parameter to 537 and the other directions to zero
        // We set the power to the same as before (.5)
        encoderMovement(537, 0, 0, .5, 321);


    }

    // Thats a lot of code, so lets turn this into a function so it becomes one line
    // We need these parameters to determine whether or not we are going forward, strafing, or rotating
    public void encoderMovement(int forward, int strafe, int rotate, double power, int ms){

        // This is still needed from earlier
        frontLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        // We have entered three parameters into our position, but really we are going to set all but one of them to zero
        frontLeft.setTargetPosition(forward + strafe + rotate);
        frontRight.setTargetPosition(-forward + strafe + rotate);
        backRight.setTargetPosition(forward - strafe + rotate);
        backLeft.setTargetPosition(forward + strafe - rotate);

        // setting the power to whatever we input into the function
        frontLeft.setPower(power);
        frontRight.setPower(power);
        backLeft.setPower(power);
        backRight.setPower(power);

        while (frontRight.isBusy() && frontLeft.isBusy() && backLeft.isBusy() && backRight.isBusy()){

        }

        // we add a delay based off of our ms parameter
        sleep(ms);
    }

}
