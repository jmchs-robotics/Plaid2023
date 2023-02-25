package frc.robot.subsystems;


import frc.robot.commands.*;
import edu.wpi.first.math.filter.SlewRateLimiter;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import frc.robot.Constants;

public class Drivetrain extends SubsystemBase {

    private WPI_TalonFX right1;
    private WPI_TalonFX right2;
    private MotorControllerGroup rightMotorGroup;
    private WPI_TalonFX left1;
    private WPI_TalonFX left2;
    private MotorControllerGroup leftMotorGroup;
    private DifferentialDrive drive;

    public Drivetrain() {
        right1 = new WPI_TalonFX(Constants.DrivetrainMotors.rightID1);
         addChild("right1",right1);
         right1.setInverted(false);

        right2 = new WPI_TalonFX(Constants.DrivetrainMotors.rightID2);
         addChild("right2",right2);
         right2.setInverted(false);

        rightMotorGroup = new MotorControllerGroup(right1, right2);
         addChild("Right Motor Group", rightMotorGroup);


        left1 = new WPI_TalonFX(Constants.DrivetrainMotors.leftID1);
         addChild("left1",left1);
         left1.setInverted(true);

        left2 = new WPI_TalonFX(Constants.DrivetrainMotors.leftID2);
         addChild("left2",left2);
         left2.setInverted(true);

        leftMotorGroup = new MotorControllerGroup(left1, left2);
         addChild("Left Motor Group", leftMotorGroup);

        drive = new DifferentialDrive(leftMotorGroup, rightMotorGroup);
        //drive.setSafetyEnabled(true);
        //drive.setExpiration(0.01);
        drive.setMaxOutput(1.0);
    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run

    }

    @Override
    public void simulationPeriodic() {
        // This method will be called once per scheduler run when in simulation

    }

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    
    public void setRightMotors(double speed) {
        rightMotorGroup.set(speed);
    }

    public void setLeftMotors(double speed) {
        leftMotorGroup.set(speed);
    }

    public void setBothMotors(double speed) {
        setRightMotors(speed);
        setLeftMotors(speed);
    }

    public void stopMotors() {
        leftMotorGroup.stopMotor();
        rightMotorGroup.stopMotor();
    }

    /**
     * @param forward Speed of robot going forward
     * @param rotation Speed of robot's rotation
     */
    public void arcadeDrive(double forward, double rotation) {
        drive.arcadeDrive(forward, rotation);
    }

    /**
     * @param leftVal Speed of Plaid's left wheels
     * @param rightVal Speed of Plaid's right wheels
     */
    public void tankDrive(double leftVal, double rightVal) {
        leftMotorGroup.set(leftVal);
        rightMotorGroup.set(rightVal);
    }

    public void setBrakesOn() {
        left1.setNeutralMode(NeutralMode.Brake);
        left2.setNeutralMode(NeutralMode.Brake);
        right1.setNeutralMode(NeutralMode.Brake);
        right2.setNeutralMode(NeutralMode.Brake);
    }

    public void setBrakesOff() {
        left1.setNeutralMode(NeutralMode.Coast);
        left2.setNeutralMode(NeutralMode.Coast);
        right1.setNeutralMode(NeutralMode.Coast);
        right2.setNeutralMode(NeutralMode.Coast);
    }
}

