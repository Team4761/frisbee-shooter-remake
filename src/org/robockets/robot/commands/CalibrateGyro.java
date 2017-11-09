package org.robockets.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.robockets.robot.RobotMap;

/**
 * @author Jake Backer
 */
public class CalibrateGyro extends Command {

	public CalibrateGyro() {

	}

	protected void initialize() {
		RobotMap.gyro.calibrate();
	}

	protected void execute() {
	}

	protected boolean isFinished() {
		return true;
	}

	protected void end() {

	}

	protected void interrupted() {
		end();
	}
}
