package com.stuypulse.robot.commands.drivetrain;

import com.stuypulse.robot.subsystems.Drivetrain;
import com.stuypulse.stuylib.input.Gamepad;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class DrivetrainDrive extends CommandBase{
    private final Gamepad gamepad;
    private final Drivetrain drivetrain;

    public DrivetrainDrive(Gamepad gamepad, Drivetrain drivetrain) {
        this.gamepad = gamepad;
        this.drivetrain = drivetrain;
        addRequirements(drivetrain);
    }

    @Override
    public void execute() {
        drivetrain.drive(gamepad.getLeftY(), gamepad.getRightY());
    }
    
    @Override
    public boolean isFinished() {
        return false;
    }
}
