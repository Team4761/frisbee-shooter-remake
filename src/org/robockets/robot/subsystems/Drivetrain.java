package org.robockets.robot.subsystems;

import edu.wpi.first.wpilibj.PIDController;
import org.robockets.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;
import org.robockets.robot.pidoutput.GyroPIDOutput;
import org.robockets.robot.pidsources.GyroPIDSource;

/**
 * A Subsystem for controlling the drivetrain
 * @author Jake Backer and Brian Shin
 */
public class Drivetrain extends Subsystem {

	private final GyroPIDSource gyroPIDSource;

	public final PIDController gyroPID;

	public Drivetrain() {
		gyroPIDSource = new GyroPIDSource();
		gyroPID = new PIDController(0, 0, 0, gyroPIDSource, new GyroPIDOutput());
		gyroPID.disable();
		gyroPID.setOutputRange(-1.0, 1.0);
		gyroPID.setPercentTolerance(5.0);
	}

    public void initDefaultCommand() {

    }

    public void driveArcade(double translate, double rotate) {
    	RobotMap.robotDrive.arcadeDrive(translate, rotate);
    }

    public double getAngle() {
		return gyroPIDSource.pidGet();
	}

	// NOTE: THIS USES PID
	public void setAngle(double angle) {
		if (!gyroPID.isEnabled()) {
			gyroPID.enable();
		}
		gyroPID.setSetpoint(angle);
	}

    public void stop() {
    	driveArcade(0, 0);
    }
}

