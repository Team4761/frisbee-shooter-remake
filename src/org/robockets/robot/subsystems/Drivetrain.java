package org.robockets.robot.subsystems;

import edu.wpi.first.wpilibj.PIDController;
import org.robockets.robot.DummyPIDOutput;
import org.robockets.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;
import org.robockets.robot.commands.DriveGo;
import org.robockets.robot.pidsources.GyroPIDSource;

/**
 * A Subsystem for controlling the drivetrain
 * @author Jake Backer and Brian Shin
 */
public class Drivetrain extends Subsystem {

	public GyroPIDSource gyroPIDSource = new GyroPIDSource();
	public PIDController gyroPID;

	public Drivetrain() {
		gyroPID = new PIDController(-0.017, -0.0001, 0, gyroPIDSource, new DummyPIDOutput());
		gyroPID.disable();
		gyroPID.setOutputRange(-1.0, 1.0);
		gyroPID.setAbsoluteTolerance(2);
	}

    public void initDefaultCommand() {
    	setDefaultCommand(new DriveGo());
    }

    public void setGyroSetpoint(double angle) {
		gyroPID.setSetpoint(angle);
	}

	public boolean gyroOnTarget() {
		return gyroPID.onTarget();
	}

	public void enableGyroPID() {
		gyroPID.enable();
	}

	public void disableGyroPID() {
		gyroPID.disable();
	}

	public double getGyroPIDOutput() {
		return gyroPID.get();
	}
    
    public void driveArcade(double leftValue, double rightValue) {
    	RobotMap.robotDrive.arcadeDrive(-leftValue, rightValue);
    }
    
    public void stop() {
    	driveArcade(0, 0);
    }
}

