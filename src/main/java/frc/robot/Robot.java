/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import java.util.Map;

import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.shuffleboard.BuiltInWidgets;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj2.command.CommandScheduler;

import frc.robot.commands.JoystickDrive;
import frc.robot.commands.KiddieDrive;
import frc.robot.subsystems.DriveTrain;
import libs.OI.ConsoleController;

public class Robot extends TimedRobot {
  public DriveTrain drivetrain;
  public ConsoleController mainController;
  public ConsoleController kiddieController;

  @Override
  public void robotInit() {
    mainController = new ConsoleController(0);
    kiddieController = new ConsoleController(1);

    // Max speed is controllable from shuffleboard, for fine tuning
    NetworkTableEntry maxSpeedEntry = Shuffleboard.getTab("Norman")
      .add("KiddieDrive Speed", 0.3)
      .withWidget(BuiltInWidgets.kNumberSlider)
      .withProperties(Map.of("min", 0.0, "max", 1.0))
      .withSize(2, 1)
      .getEntry();

    drivetrain = new DriveTrain();
    drivetrain.setDefaultCommand(new KiddieDrive(drivetrain, kiddieController, () -> maxSpeedEntry.getDouble(0.3)));

    // Will be on kiddie drive by default until toggled by A button
    mainController.a.toggleWhenPressed(new JoystickDrive(drivetrain, mainController));
  }

  @Override
  public void disabledInit() {}

  @Override
  public void disabledPeriodic() {}

  @Override
  public void autonomousInit() {
    CommandScheduler.getInstance().run();
  }

  @Override
  public void autonomousPeriodic() {
    CommandScheduler.getInstance().run();
   }

  @Override
  public void teleopInit() {}

  @Override
  public void teleopPeriodic() {
    CommandScheduler.getInstance().run();
  }
}