package org.robockets.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.robockets.robot.RobotMap;

/**
 * @author Jake Backer
 */
public class ResetGyro extends Command {

	public ResetGyro() {

	}

	protected void initialize() {
		setTimeout(5);
		RobotMap.gyro.reset();
		RobotMap.gyro.calibrate();
	}

	protected void execute() {
	}

	protected boolean isFinished() {
		return isTimedOut();
	}

	protected void end() {

	}

	protected void interrupted() {
		end();
	}
}
