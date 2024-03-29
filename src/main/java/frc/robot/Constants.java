// RobotBuilder Version: 5.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants.  This class should not be used for any other purpose.  All constants should be
 * declared globally (i.e. public static).  Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public class Constants {
   
    public static final class DrivetrainMotors {
        public static final int rightID1 = 3;
        public static final int rightID2 = 5;
        public static final int leftID1 = 2;
        public static final int leftID2 = 4;

        public static final int kEncoderCPR = 2048;
        public static final double kGearRatio = 50/24;
        public static final double kWheelRadiusInches = 3;
        public static final double kWheelCircumference = 2 * Math.PI * kWheelRadiusInches;

        public static final double kP_turn = 0.8;
        public static final double kI_turn = 0;
        public static final double kD_turn = 0;
        public static final double kTurnToleranceDeg = 5;
        public static final double kTurnRateToleranceDegPerS = 10;

        public static final double kP_gyroDriveStraight = 1.3;

        public static final double kP_forward = 0;
        public static final double kI_forward = 0;
        public static final double kD_forward = 0;
    }
    
    public static final class IntakeConstants {

        //Intake Motor IDs
        public static final int intakeM1ID = 6;
        public static final int intakeM2ID = 7;

        //Intake Double Solenoid IDs
        public static final int intakeDS1F = 0;
        public static final int intakeDS1R = 1;
        public static final int intakeDS2F = 2;
        public static final int intakeDS2R = 3;
    }
}