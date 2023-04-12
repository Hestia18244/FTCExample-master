// This is an example of how an autonomous mode would be structured
package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.DcMotor;

// @Autonomous makes this appear as an autonomous mode on the driver's hub
// Pay attention to brackets throughout the whole program
@Autonomous (name = "autonLinear")
// LinearOpMode just means that the opmode runs straight through all of the code and doesn't loop
// Autonomous shouldn't loop since all of the code just needs to run once
public class autonLinear extends LinearOpMode {

    // Declaration of Motors and servos is the same
    Servo exampleServo;
    DcMotor exampleMotor;
    DcMotor exampleMotor2;

    // "runOpMode" is the same thing as "init" from teleOp
    // Everything underneath this block of code happens when you press the "init" button on the driver's hub
    public void runOpMode(){

        // Hardware mapping is the same as TeleOp
        exampleServo = hardwareMap.servo.get("exampleServo");
        exampleMotor = hardwareMap.dcMotor.get("exampleMotor");
        exampleMotor2 = hardwareMap.dcMotor.get("exampleMotor2");


        // Reversing motor directions is the same as well
        exampleMotor.setDirection(DcMotor.Direction.REVERSE);

        // This is a built in function that stops the program until the play button is pressed on the drivers hub
        waitForStart();

        // Making motors move is about the same, except that you need to tell the motor how long to move

        // This segment of code sets the power of both motors to full power for 1 second (1000 milliseconds)
        exampleMotor.setPower(1);
        exampleMotor2.setPower(1);
        sleep(1000);


        // Moving servos is the same, but without the if statements

        // After the motors are done moving, the Servo's position will be set to .4
        exampleServo.setPosition(.4);

        // This is very similar to the cpde segment in lines 40-43
        // We can write a function to make it easier to write this code
        exampleMotor.setPower(-1);
        exampleMotor2.setPower(-1);
        sleep(2000);

        // Here are the calls to the function
        // This should execute the same code in lines 40-43 and 53-55, but in less lines

        // The first call sets the motors to full power for 1 second
        exampleFunction(1,1,1000);
        // The second call sets the motors to negative full power (opposite direction) for two seconds
        exampleFunction(-1,-1,2000);


    }
    // Functions are used to stop repeating code
    /*
    This function is named "exampleFunction" and accepts three parameters.
    When you call the function, you have to enter the power to the first motor,
    the second motor, and then the amount of time to run for
    */
    public void exampleFunction(double firstPower, double secondPower, int ms){

        exampleMotor.setPower(firstPower);
        exampleMotor2.setPower(secondPower);
        sleep(ms);

    }
}
