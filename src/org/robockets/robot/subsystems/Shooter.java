package org.robockets.robot.subsystems;

import org.robockets.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Shooter extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public void setSpinnerSpeed(double speed){
    	RobotMap.shooterFront.set(speed);
    	RobotMap.shooterBack.set(speed);
    }
    
}

