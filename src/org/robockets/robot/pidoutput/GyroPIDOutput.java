package org.robockets.robot.pidoutput;

import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.RobotDrive;
import org.robockets.robot.Robot;
import org.robockets.robot.pidsources.GyroPIDSource;

public class GyroPIDOutput implements PIDOutput {

	@Override
	public void pidWrite(double output) {
		Robot.drivetrain.driveArcade(0, output);
	}
}
