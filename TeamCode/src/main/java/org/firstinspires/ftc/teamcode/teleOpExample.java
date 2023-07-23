// Package just means that this is the folder this file is located in
// Don't mess with this
package org.firstinspires.ftc.teamcode;

// import statements allow you to create things like motors in servos
// Without these import statements, it would recognize things like "exampleMotor" as an error
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;


/* @TeleOp makes it so that this opMode appears as a TeleOp mode on the driver's hubs
   "name" is just what the name shows up as on the driver's hub
   Try to keep the name the same as what the name of the file is
   Pay attention to brackets throughout the program
*/
@TeleOp (name = "teleOpExample")
public class teleOpExample extends OpMode {

    // To name a Servo or a motor, just type DcMotor or Servo and then what you want to name the Servo/Motor
    DcMotor exampleMotor;
    DcMotor exampleMotor2;
    Servo exampleServo;


    public void init(){
        // The code within the init statement happens once you press "init" on the driver's hub.
        // This code does not loop as it only needs to be executed once

        // Hardware mapping is when you map the motors and servos to what you named them on the
        // driver's hub. Generally, you should keep what you name them in code and the driver's hub the same
        exampleMotor = hardwareMap.dcMotor.get("exampleMotor");
        exampleMotor2 = hardwareMap.dcMotor.get("exampleMotor2");
        exampleServo = hardwareMap.servo.get("exampleServo");

        // This would also be where you reverse the direction of a motor
        exampleMotor.setDirection(DcMotor.Direction.REVERSE);

        //This bracket closes the init() statement since everything beyond this needs to be looped
    }
    public void loop(){
        // Within the "loop()" method, all of the code within here will constantly loop once you press play

        // To move a motor with a joystick, set its power to the joystick
        // This motor is set to the y axis of gamepad 1's left stick
        // exampleMotor.setPower(gamepad1.left_stick_y);

        // If you have multiple motors and you want to set them both to the same joystick, use a variable
        double forward = gamepad1.left_stick_y;
        double strafe = gamepad1.left_stick_x;

        exampleMotor.setPower(forward + strafe);
        exampleMotor2.setPower(forward + strafe);

        // To move a servo, use an if statement

        // The first if statement sets the servo's position to 1 if "a" is pressed
        if (gamepad1.a){
            exampleServo.setPosition(1);
        }
        if (gamepad1.b){
            exampleServo.setPosition(0);
        }

        // This bracket closes the loop
    }

    // This bracket closes the whole program/class
}
