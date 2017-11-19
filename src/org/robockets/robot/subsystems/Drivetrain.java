package org.robockets.robot.subsystems;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.robockets.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * A Subsystem for controlling the drivetrain
 * @author Jake Backer and Brian Shin
 */
public class Drivetrain extends Subsystem {


    public void initDefaultCommand() {
    	
    }
    
    public void driveArcade(double leftValue, double rightValue) {
    	double scalar = SmartDashboard.getNumber("DriveSpeedMult", 1);

    	RobotMap.robotDrive.arcadeDrive(-leftValue*scalar, rightValue*scalar);
    }
    
    public void stop() {
    	driveArcade(0, 0);
    }
}

