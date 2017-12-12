package org.robockets.robot.commands;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 * @author Jake Backer
 */
public class Fire extends CommandGroup {

	public Fire() {
		addParallel(new Flap(DoubleSolenoid.Value.kForward));
		addSequential(new WaitCommand(0.2)); // TODO: Change this value
		addParallel(new Flap(DoubleSolenoid.Value.kOff));
	}
}
