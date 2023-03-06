package com.stuypulse.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import com.stuypulse.robot.constants.Ports;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drivetrain extends SubsystemBase{

    CANSparkMax[] leftMotors;
    CANSparkMax[] rightMotors;


    public Drivetrain() {
        leftMotors = new CANSparkMax[3];
        rightMotors = new CANSparkMax[3];

        leftMotors = new CANSparkMax[] {
            new CANSparkMax(Ports.Drivetrain.LEFT_TOP, MotorType.kBrushless),
            new CANSparkMax(Ports.Drivetrain.LEFT_MIDDLE, MotorType.kBrushless),
            new CANSparkMax(Ports.Drivetrain.LEFT_BOTTOM, MotorType.kBrushless),
        };
        rightMotors = new CANSparkMax[] {
            new CANSparkMax(Ports.Drivetrain.RIGHT_TOP, MotorType.kBrushless),
            new CANSparkMax(Ports.Drivetrain.RIGHT_MIDDLE, MotorType.kBrushless),
            new CANSparkMax(Ports.Drivetrain.RIGHT_BOTTOM, MotorType.kBrushless),
        };
    }

    public void drive(double left, double right) {
        for (CANSparkMax motor : leftMotors) {
            motor.set(left);
        }
        for (CANSparkMax motor : rightMotors) {
            motor.set(right);
        }
    }

    @Override
	public void periodic() {
		SmartDashboard.putNumber("Left Velocity", leftMotors[0].get());
		SmartDashboard.putNumber("Right Velocity", rightMotors[0].get());
	}
}
