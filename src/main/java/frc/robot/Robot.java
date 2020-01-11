/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import frc.robot.subsystems.DriveTrain;

public class Robot extends TimedRobot {
  public static DriveTrain drivetrain;
  public static OI oi;


  @Override
  public void robotInit() {
    oi = new OI();
    drivetrain = new DriveTrain();
  }

  @Override
  public void disabledInit() {
  }

  @Override
  public void disabledPeriodic() {
  }

  @Override
  public void autonomousInit() {
    Scheduler.getInstance().run();
  }

  @Override
  public void autonomousPeriodic() {
    Scheduler.getInstance().run();
   }

  
  @Override
  public void teleopInit() {
    
  }

  @Override
  public void teleopPeriodic() {
    System.out.println(oi.getTwist());
    Scheduler.getInstance().run();
  }
}