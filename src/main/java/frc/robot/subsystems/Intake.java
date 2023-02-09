// RobotBuilder Version: 5.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

// ROBOTBUILDER TYPE: Subsystem.

package frc.robot.subsystems;


import frc.robot.commands.*;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PWM;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import frc.robot.Constants.IntakeConstants;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Counter;

public class Intake extends SubsystemBase {

    //private WPI_TalonFX intakeTalon;
    //private WPI_TalonFX intakeTalon2;
    private CANSparkMax intakeSpark;
    private CANSparkMax intakeSpark2;
    private DoubleSolenoid intakeSolenoid;
    private DoubleSolenoid intakeSolenoid_2;
    private DigitalInput limitSwitch;
    private Counter counter;

    public Intake() {

        //intakeTalon = new WPI_TalonFX(0);
        // addChild("intakeTalon",intakeTalon);
        // intakeTalon.setInverted(false);
        
        //intakeTalon2 = new WPI_TalonFX(1);
        // addChild("intakeTalon2", intakeTalon2);
        // intakeTalon2.setInverted(false);
        
        intakeSpark = new CANSparkMax(IntakeConstants.intakeM1ID, MotorType.kBrushless);
        intakeSpark2 = new CANSparkMax(IntakeConstants.intakeM2ID, MotorType.kBrushless);

        limitSwitch = new DigitalInput(1);
        counter = new Counter(limitSwitch); 
        
        intakeSolenoid = new DoubleSolenoid(0, PneumaticsModuleType.CTREPCM, IntakeConstants.intakeDS1F, IntakeConstants.intakeDS1R);
        addChild("intakeSolenoid", intakeSolenoid);
        
        intakeSolenoid_2 = new DoubleSolenoid(0, PneumaticsModuleType.CTREPCM, IntakeConstants.intakeDS2F, IntakeConstants.intakeDS2R);
        addChild("intakeSolenoid", intakeSolenoid_2);
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

    public void setIntakeSolenoid(Value val){
        intakeSolenoid.set(val);
        intakeSolenoid_2.set(val);
    }

    public void setIntakeMotor(double speed){
        //intakeTalon.set(speed);
        intakeSpark.set(speed);
    }

    public void setIntake2Motor(double speed) {
        //intakeTalon2.set(speed);
        intakeSpark2.set(speed);
    }

    public void setIntakeBoth(double speed) {
        setIntakeMotor(speed);
        setIntake2Motor(speed);
    }

    public void stopIntakeMotors(){
        //intakeTalon.stopMotor();
        //intakeSpark2.stopMotor();
        intakeSpark.stopMotor();
        intakeSpark2.stopMotor();
    }

    public boolean isSwitchTriggered() {
        return counter.get() > 0;
    }

    public void initializeCounter() {
        counter.reset();
    }
}

