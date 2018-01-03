package org.robockets.robot;

import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.robockets.robot.commands.DriveGo;
import org.robockets.robot.commands.DrivePID;
import org.robockets.robot.commands.SpinSpinners;
import org.robockets.robot.subsystems.Drivetrain;
import org.robockets.robot.subsystems.Shooter;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import org.robockets.robot.subsystems.Flapper;

/**
 * The VM is configured to automatically run this class, and to call the0
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	public static Drivetrain drivetrain;
	public static Flapper flapper;
  	public static Shooter shooter;
	public static OI oi;

    Command autonomousCommand;
    Command driveGo;
    Command SpinSpinners;
    Command drivePID;
    SendableChooser chooser;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
		oi = new OI();
		drivetrain = new Drivetrain();
		flapper = new Flapper();
		driveGo = new DriveGo();
		drivePID = new DrivePID();
		//shooter  = new Shooter();
		SmartDashboard.putNumber("GyroP", drivetrain.gyroPID.getP());
		SmartDashboard.putNumber("GyroI", drivetrain.gyroPID.getI());
		SmartDashboard.putNumber("GyroD", drivetrain.gyroPID.getD());
		SmartDashboard.putNumber("GyroSetpoint", 0);
    }

    public void robotPeriodic() {
    	Robot.drivetrain.gyroPID.setPID(
    			SmartDashboard.getNumber("GyroP", 0),
				SmartDashboard.getNumber("GyroI", 0),
				SmartDashboard.getNumber("GyroD", 0)
		);
    	SmartDashboard.putNumber("Gyro Value", Robot.drivetrain.gyroPIDSource.pidGet());
	}
	
	/**
     * This function is called once each time the robot enters Disabled mode.
     * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
     */
    public void disabledInit(){
    	
    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select between different autonomous modes
	 * using the dashboard. The sendable chooser code works with the Java SmartDashboard. If you prefer the LabVIEW
	 * Dashboard, remove all of the chooser code and uncomment the getString code to get the auto name from the text box
	 * below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the chooser code above (like the commented example)
	 * or additional comparisons to the switch structure below with additional strings & commands.
	 */
    public void autonomousInit() {
       drivePID.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
		NetworkTable.flush();
    	driveGo.start();
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}
