/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;
import libs.OI.ConsoleController;

/**
 * An example command.  You can replace me with your own command.
 */

public class JoystickDrive extends CommandBase {
  
  DriveTrain driveTrain;
  ConsoleController controller;
  
  final double SPEED_CONTROL = 1;

  public JoystickDrive(DriveTrain drivetrain, ConsoleController controller) {
    this.controller = controller;
    this.driveTrain = drivetrain;
    addRequirements(drivetrain);
  }

  public void initialize() {
    
    driveTrain.resetGyro();
  }

  public void execute() {

    double strafe = controller.getLeftStickX();
    double thrust = controller.getLeftStickY();
    double turn = controller.getRightStickX();

    thrust *= SPEED_CONTROL;
    strafe *= SPEED_CONTROL;
    turn *= SPEED_CONTROL;

    if (Math.abs(thrust) < 0.2) {
      thrust = 0;
    }
    if (Math.abs(strafe) < 0.2) {
      strafe = 0;
    }
    if (Math.abs(turn) < 0.2) {
      turn = 0;
    }

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