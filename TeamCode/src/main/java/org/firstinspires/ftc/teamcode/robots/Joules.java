package org.firstinspires.ftc.teamcode.robots;

import android.graphics.Paint;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.RC;
import org.firstinspires.ftc.teamcode.newhardware.FXTCRServo;
import org.firstinspires.ftc.teamcode.newhardware.FXTSensors.FXTAnalogUltrasonicSensor;
import org.firstinspires.ftc.teamcode.newhardware.FXTServo;
import org.firstinspires.ftc.teamcode.newhardware.Motor;
import org.firstinspires.ftc.teamcode.roboticslibrary.TaskHandler;
import org.opencv.photo.CalibrateRobertson;

public class Joules  {
    private Motor FrontRight;
    private Motor FrontLeft;
    private Motor BackRight;
    private Motor BackLeft;
    private String VEER_CHECK_TASK_KEY = "Joules.VEERCHECK";

    //arm servoes
    private FXTCRServo ArmXtnd;
    private FXTCRServo Claw;
    private FXTCRServo Foundation;
    public FXTCRServo Wrist;
    //arm motor
    public Motor ArmMotor;

    //Capstone
    private FXTServo CapLeft;
    private FXTServo CapRight;



    private float GEAR_RATIO = 1/2;

    public Joules(){
        // don't know if we need super();
        //Motors!!
        FrontRight = new Motor("FrontRight");
        FrontLeft = new Motor("FrontLeft");
        BackRight = new Motor("BackRight");
        BackLeft = new Motor("BackLeft");

        ArmXtnd = new FXTCRServo("armExtender");
        ArmMotor = new Motor("arm");
        Wrist = new FXTCRServo("wrist");
        Claw =  new FXTCRServo("claw");
        Foundation = new FXTCRServo("foundation");

        CapLeft = new FXTServo("CapLeft");
        CapRight = new FXTServo("CapRight");

        FrontRight.setMinimumSpeed(0.1);
        FrontLeft.setMinimumSpeed(0.1);
        BackRight.setMinimumSpeed(0.1);
        BackLeft.setMinimumSpeed(0.1);
    }

    //Robot driving
    public void DriveForward(double speed){
        TaskHandler.pauseTask(VEER_CHECK_TASK_KEY);
        FrontLeft.setPower(-speed);
        FrontRight.setPower(speed);
        BackLeft.setPower(-speed);
        BackRight.setPower(speed);
    }
    public void DriveBackward(double speed){
        TaskHandler.pauseTask(VEER_CHECK_TASK_KEY);
        FrontLeft.setPower(speed);
        FrontRight.setPower(-speed);
        BackLeft.setPower(speed);
        BackRight.setPower(-speed);

    }
    public void StrafeLeft(double speed){
        TaskHandler.pauseTask(VEER_CHECK_TASK_KEY);
        FrontLeft.setPower(speed);
        FrontRight.setPower(speed);
        BackLeft.setPower(-speed);
        BackRight.setPower(-speed);
    }
    public void StrafeRight(double speed){
        TaskHandler.pauseTask(VEER_CHECK_TASK_KEY);
        FrontLeft.setPower(-speed);
        FrontRight.setPower(-speed);
        BackLeft.setPower(speed);
        BackRight.setPower(speed);
    }
    public void TurnLeft(double speed){
        TaskHandler.pauseTask(VEER_CHECK_TASK_KEY);
        FrontLeft.setPower(-speed);
        FrontRight.setPower(-speed);
        BackLeft.setPower(-speed);
        BackRight.setPower(-speed);

    }
    public void TurnRight(double speed){
        TaskHandler.pauseTask(VEER_CHECK_TASK_KEY);
        FrontLeft.setPower(speed);
        FrontRight.setPower(speed);
        BackLeft.setPower(speed);
        BackRight.setPower(speed);
    }
    public void Stop(){
        FrontLeft.setPower(0);
        FrontRight.setPower(0);
        BackLeft.setPower(0);
        BackRight.setPower(0);
    }

    //Capstone
    public void CapDown(){
        CapLeft.setPosition(0.1);
        CapRight.setPosition(0.1);
    }
    public void CapUp(){
        CapLeft.setPosition(0.9);
        CapRight.setPosition(0.9);
    }

    //Arm
    public void ArmFor(){
        ArmMotor.setPower(1.5);
    }

    public void ArmBack(){
        ArmMotor.setPower(-1.5);
    }

    public void ArmStop(){
        ArmMotor.setPower(0);
    }

    //Arm Extender
    public void ArmXOut(){
        ArmXtnd.setPower(0.6);
    }
    public void ArmXIn(){
        ArmXtnd.setPower(-0.6);
    }
    public void ArmXStop(){
        ArmXtnd.setPower(0);
    }


    //claw
    public void ClawGrab(){
        Claw.setPower(-0.4);
    }
    public void ClawDrop(){
        Claw.setPower(0.6);
    }

    //foundation
    public void FoundationDrop(){
        Foundation.setZeroPosition(-0.4);
    }
    public void FoundationGrab(){
        Foundation.setZeroPosition(0.6);
    }




}


//I'm so proud :))))). im ur favourite