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
    double thrust = oi.getThrust();
    double strafe = oi.getStrafe();
    double turn = oi.getTwist();

    // Xbox control
    // double thrust = oi.getXboxLeftY();
    // double strafe = oi.getXboxLeftX();
    // double turn = oi.getXboxRightX();

    if (fieldCentric) {
      double currentAngle = driveTrain.getAngle();
      double requestedAngle = Math.toDegrees(Math.atan2(thrust, strafe));
      requestedAngle = requestedAngle > 360 ? requestedAngle - 360 : requestedAngle;
      requestedAngle = Math.abs(requestedAngle) - 90;
      requestedAngle = requestedAngle < 0 ? 360 + requestedAngle : requestedAngle;
      System.out.println(requestedAngle);
      double driveAngle = Math.toRadians(requestedAngle + 90 - currentAngle);

      thrust = Math.sin(driveAngle);
      strafe = Math.cos(driveAngle);
    }

    double xSpeed = thrust;
    double ySpeed = strafe;
    double rotSpeed = turn;
    
    //Raw wheel powers
    // double topLeftPower = thrust + strafe + turn;
    // double bottomLeftPower = thrust - strafe + turn;
    // double topRightPower = thrust - strafe - turn;
    // double bottomRightPower = thrust + strafe - turn;

    // //Scale based off max power
    // double maxPower = Math.max(Math.max(Math.max(topLeftPower, bottomLeftPower), topRightPower), bottomRightPower);
    // if (maxPower > 1.0) {
    //   topLeftPower /= maxPower;
    //   bottomLeftPower /= maxPower;
    //   topRightPower /= maxPower;
    //   bottomRightPower /= maxPower;
    // }

    // //Speed control
    // topLeftPower *= SPEED_CONTROL;
    // bottomLeftPower *= SPEED_CONTROL;
    // topRightPower *= SPEED_CONTROL;
    // bottomRightPower *= SPEED_CONTROL;

    // //Deadband
    // if (Math.abs(topLeftPower) < 0.1) {
    //   topLeftPower = 0;
    // }
    // if (Math.abs(bottomLeftPower) < 0.1) {
    //   bottomLeftPower = 0;
    // }
    // if (Math.abs(topRightPower) < 0.1)  {
    //     topRightPower = 0;
    // }
    // if (Math.abs(bottomRightPower) < 0.1) {
    //   bottomRightPower = 0;
    // }

    xSpeed *= SPEED_CONTROL;
    ySpeed *= SPEED_CONTROL;
    rotSpeed *= SPEED_CONTROL;

    if (Math.abs(xSpeed) < 0.1) {
      xSpeed = 0;
    }
    if (Math.abs(ySpeed) < 0.1) {
      ySpeed = 0;
    }
    if (Math.abs(rotSpeed) < 0.1) {
      rotSpeed = 0;
    }

    //Naruto runs, weight needed
    driveTrain.drive(xSpeed, ySpeed, rotSpeed);
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