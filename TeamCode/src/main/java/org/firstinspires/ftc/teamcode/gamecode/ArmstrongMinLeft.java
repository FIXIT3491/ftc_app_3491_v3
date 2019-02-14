package org.firstinspires.ftc.teamcode.gamecode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.opmodesupport.AutoOpMode;
import org.firstinspires.ftc.teamcode.robots.Armstrong;

@Autonomous
public class ArmstrongMinLeft extends AutoOpMode {

    @Override

    public void runOp() throws InterruptedException {
        //init phase
        Armstrong armstrong = new Armstrong();
        armstrong.markUp();
        telemetry.addData("Status", "Initialized");
        waitForStart();
        //this is after the driver presses play
        armstrong.lifterUp();
        armstrong.collectServoLeftSlow();
        armstrong.collectServoRightSlow();
        sleep(10790);
        armstrong.lifterStop();
        armstrong.collectServoLeftStop();
        armstrong.collectServoRightStop();

        armstrong.unlatch();
        armstrong.armup();
        sleep(250);
        armstrong.armstop();


        armstrong.forwardDistance(300,0.5);
        armstrong.LeftSample();
        armstrong.forwardDistance(100, 0.5);
        armstrong.LeftWingStore();
        armstrong.forwardDistance(200, 0.5);

        armstrong.markDown();
        sleep(1000);
        telemetry.addData("Status", "WallDown");
    }
}

