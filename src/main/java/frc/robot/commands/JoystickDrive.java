/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.OI;
import frc.robot.Robot;
import frc.robot.subsystems.DriveTrain;

/**
 * An example command.  You can replace me with your own command.
 */

public class JoystickDrive extends Command {
  
  OI oi;
  DriveTrain driveTrain;
  
  final double SPEED_CONTROL = 1;
  boolean fieldCentric;
  double xVal, yVal, twistVal;
  double currentAngle;

  public JoystickDrive(boolean fieldCentric) {
    requires(Robot.drivetrain);
    this.fieldCentric = fieldCentric;
  }

  public JoystickDrive() {}

  protected void initialize() {
    oi = Robot.oi;
    driveTrain = Robot.drivetrain;
    driveTrain.resetGyro();
  }

  protected void execute() {

    // Joystick control
    // double thrust = oi.getThrust();
    // double strafe = oi.getStrafe();
    // double turn = oi.getTwist();

    // Xbox control
    double thrust = oi.getXboxLeftY();
    double strafe = oi.getXboxLeftX();
    double turn = oi.getXboxRightX();

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

  protected boolean isFinished() {
    return false;
  }

  protected void end() {
    driveTrain.drive(0, 0, 0);
  }

  protected void interrupted() {
    end();
  }
}