package org.firstinspires.ftc.teamcode;


        import com.qualcomm.robotcore.hardware.DcMotor;
        import com.qualcomm.robotcore.hardware.DcMotorSimple;
        import com.qualcomm.robotcore.hardware.HardwareMap;
        import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by helencho on 9/17/17.
 */

public class HardwareConfig {
    DcMotor motorino;


    DcMotor mFrontRight;
    DcMotor mBackRight;
    DcMotor mFrontLeft;
    DcMotor mBackLeft;
    DcMotor armMotor;
    DcMotor armClaw;
    Servo servoClawOne;
    Servo servoClawTwo;

    public void init(HardwareMap hw) { //creating hardware map, setting up hardware map
        mFrontRight = hw.dcMotor.get("frontRight");
        mBackRight = hw.dcMotor.get("backRight");
        mFrontLeft = hw.dcMotor.get("frontLeft");
        mBackLeft = hw.dcMotor.get("backLeft");
        armMotor = hw.dcMotor.get("arm");
        //armClaw = hw.dcMotor.get("claw");
        servoClawOne = hw.servo.get("servoRight");
        servoClawTwo = hw.servo.get("servoLeft");

        mFrontRight.setPower(0.0); //set to stopping
        mBackRight.setPower(0.0);
        mFrontLeft.setPower(0.0);
        mBackLeft.setPower(0.0);

        //need to reverse one side so the robot can move forward
        mFrontRight.setDirection(DcMotorSimple.Direction.REVERSE);
        mBackRight.setDirection(DcMotorSimple.Direction.REVERSE);

    }
}

