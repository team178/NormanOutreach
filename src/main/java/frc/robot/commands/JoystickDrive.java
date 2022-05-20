/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.subsystems.DriveTrain;

/**
 * An example command.  You can replace me with your own command.
 */

public class JoystickDrive extends CommandBase {
  
  DriveTrain driveTrain;
  
  final double SPEED_CONTROL = 1;
  double xVal, yVal, twistVal;
  double currentAngle;

  public JoystickDrive() {
    addRequirements(Robot.drivetrain);
  }

  public void initialize() {
    
    driveTrain = Robot.drivetrain;
    driveTrain.resetGyro();
  }

  public void execute() {

    double thrust = Robot.main_controller.getLeftStickY();
    double strafe = Robot.main_controller.getLeftStickX();
    double turn = Robot.main_controller.getRightStickX();

    thrust *= SPEED_CONTROL;
    strafe *= SPEED_CONTROL;
    turn *= SPEED_CONTROL;

    if (Math.abs(thrust) < 0.1) {
      thrust = 0;
    }
    if (Math.abs(strafe) < 0.1) {
      strafe = 0;
    }
    if (Math.abs(turn) < 0.1) {
      turn = 0;
    }

    //Naruto runs, weight needed
    driveTrain.drive(strafe, thrust, turn);
  }

  public boolean isFinished() {
    return false;
  }

  public void end() {
    driveTrain.drive(0, 0, 0);
  }

  public void interrupted() {
    end();
  }
}