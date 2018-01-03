package org.robockets.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.robockets.robot.Robot;

/**
 * @author Jake Backer
 */
public class DrivePID extends Command {

	private double gyroSetpoint = 0;

	public DrivePID(double setpoint) {
		requires(Robot.drivetrain);
		gyroSetpoint = setpoint;
	}

	public DrivePID() {
		requires(Robot.drivetrain);
		gyroSetpoint = SmartDashboard.getNumber("GyroSetpoint", 0);
	}

	protected void initialize() {
		Robot.drivetrain.setGyroSetpoint(gyroSetpoint);
		Robot.drivetrain.enableGyroPID();
	}

	protected void execute() {
		Robot.drivetrain.driveArcade(0, Robot.drivetrain.getGyroPIDOutput());
	}

	protected boolean isFinished() {
		return Robot.drivetrain.gyroOnTarget();
	}

	protected void end() {
		Robot.drivetrain.disableGyroPID();
	}

	protected void interrupted() {
		end();
	}
}
