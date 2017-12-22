package org.robockets.robot;

import edu.wpi.first.wpilibj.*;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	public static Victor frontLeft = new Victor(5);
	public static Victor frontRight = new Victor(8);
	public static Victor backLeft = new Victor(1);
	public static Victor backRight = new Victor(4);

	public static Victor shooterFront = new Victor(8);
	public static Victor shooterBack = new Victor(9);
	
	public static RobotDrive robotDrive = new RobotDrive(frontLeft, backLeft, frontRight, backRight);
		
	public static DoubleSolenoid flapper = new DoubleSolenoid(2, 3); // TODO: Get these channels
}
