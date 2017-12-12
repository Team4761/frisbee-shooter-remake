package org.robockets.robot.commands;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Command;
import org.robockets.robot.Robot;

/**
 * @author Jake Backer
 */
public class Flap extends Command {

	private DoubleSolenoid.Value value;

	public Flap(DoubleSolenoid.Value value) {
		this.value = value;
	}

	protected void initialize() {
		Robot.flapper.setFlapper(value);
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
