package org.firstinspires.ftc.teamcode;

/**
 * Created by helencho on 10/19/17.
 */

        import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
        import java.util.*;
        import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
        import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by helencho on 8/19/17.
 */

@TeleOp(name="kappa")
public class TankDrive extends LinearOpMode {
    HardwareConfig roboterino = new HardwareConfig();
    @Override
    public void runOpMode() throws InterruptedException{
        roboterino.init(hardwareMap); //giving roboterino hardware map config
        waitForStart(); //when start is pressed opModeIsActive returns true; will return false when stopped

        //left stick controls direction, right stick controls rotation
        while(opModeIsActive()){
            double x = gamepad1.left_stick_x;
            double y = gamepad1.left_stick_y;
            //double r = gamepad1.right_stick_x;
            boolean up = gamepad1.y;
            boolean down = gamepad1.a;
            boolean open = gamepad1.x;
            boolean close = gamepad1.b;

            double frbr = x-y;
            double flbl = -x-y;

            double max = Math.max(Math.abs(frbr), Math.abs(flbl));
            if(max > 1.0){
                frbr /= max;
                flbl /= max;
            }
            if(Math.abs(frbr) < 0.5) frbr = 0;
            if(Math.abs(flbl) < 0.5) flbl = 0;

            while(open){
                //roboterino.armClaw.setPower(0.2);
                roboterino.armMotor.setPower(0);
                roboterino.mBackLeft.setPower(flbl);
                roboterino.mBackRight.setPower(frbr);
                roboterino.mFrontLeft.setPower(flbl);
                roboterino.mFrontRight.setPower(frbr);
                open = gamepad1.x;
            }
            while(close){
                //roboterino.armClaw.setPower(-0.2);
                roboterino.armMotor.setPower(0);
                roboterino.mBackLeft.setPower(flbl);
                roboterino.mBackRight.setPower(frbr);
                roboterino.mFrontLeft.setPower(flbl);
                roboterino.mFrontRight.setPower(frbr);
                close = gamepad1.b;
            }
            while(up){
                roboterino.armMotor.setPower(0.2);
                roboterino.mBackLeft.setPower(flbl);
                roboterino.mBackRight.setPower(frbr);
                roboterino.mFrontLeft.setPower(flbl);
                roboterino.mFrontRight.setPower(frbr);
                up = gamepad1.y;
                telemetry.addData("Up: ", up);
                telemetry.update();
            }
            while(down){
                roboterino.armMotor.setPower(-0.2);
                roboterino.mBackLeft.setPower(flbl);
                roboterino.mBackRight.setPower(frbr);
                roboterino.mFrontLeft.setPower(flbl);
                roboterino.mFrontRight.setPower(frbr);
                down = gamepad1.a;
            }
            //roboterino.armClaw.setPower(0);
            roboterino.armMotor.setPower(0);
            roboterino.mBackLeft.setPower(flbl);
            roboterino.mBackRight.setPower(frbr);
            roboterino.mFrontLeft.setPower(flbl);
            roboterino.mFrontRight.setPower(frbr);

        }
    }
}