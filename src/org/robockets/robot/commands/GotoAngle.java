package org.robockets.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.robockets.robot.Robot;

/**
 * @author Jake Backer
 */
public class GotoAngle extends Command {

	double angle = 0;

	public GotoAngle(double angle) {
		this.angle = angle;
	}

	protected void initialize() {
		Robot.drivetrain.setAngle(angle);
	}

	protected void execute() {
	}

	protected boolean isFinished() {
		return Robot.drivetrain.gyroPID.onTarget();
	}

	protected void end() {

	}

	protected void interrupted() {
		end();
	}
}
