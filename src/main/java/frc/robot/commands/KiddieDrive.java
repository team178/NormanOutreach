/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;
import libs.OI.ConsoleController;

/**
 * Clone of JoystickDrive but for kiddies
 */

public class KiddieDrive extends CommandBase {
  
  DriveTrain driveTrain;
  DoubleSupplier maxSpeed;
  ConsoleController controller;

  public KiddieDrive(DriveTrain drivetrain, ConsoleController controller, DoubleSupplier maxSpeed) {
    this.controller = controller;
    this.driveTrain = drivetrain;
    this.maxSpeed = maxSpeed;
    addRequirements(drivetrain);
  }

  public void initialize() {
    driveTrain.resetGyro();
  }

  public void execute() {

    double speedMult = maxSpeed.getAsDouble();

    double thrust = controller.getLeftStickY() * speedMult;
    double turn = controller.getRightStickX() * speedMult;

    if (Math.abs(thrust) < 0.2) {
      thrust = 0;
    }
    if (Math.abs(turn) < 0.2) {
      turn = 0;
    }

    driveTrain.drive(0, thrust, turn);
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