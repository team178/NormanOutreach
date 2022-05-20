/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.commands.JoystickDrive;
import frc.robot.subsystems.DriveTrain;
import libs.OI.ConsoleController;

public class Robot extends TimedRobot {
  public static DriveTrain drivetrain;
  public static ConsoleController main_controller;

  @Override
  public void robotInit() {
    main_controller = new ConsoleController(0);
    drivetrain = new DriveTrain();
    drivetrain.setDefaultCommand(new JoystickDrive());
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