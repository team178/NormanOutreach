/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import frc.robot.RobotMap;
import frc.robot.commands.JoystickDrive;
import edu.wpi.first.wpilibj.AnalogGyro;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.MecanumDrive;

/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class DriveTrain extends Subsystem {

  private static MecanumDrive mecanumDrive;

  private AnalogGyro gyro;
  private TalonSRX left1;
  private TalonSRX left2;
  private TalonSRX right1;
  private TalonSRX right2;

  public DriveTrain() {
    left1 = new TalonSRX(RobotMap.DMTopLeft);
    left2 = new TalonSRX(RobotMap.DMBottomLeft);
    right1 = new TalonSRX(RobotMap.DMTopRight);
    right2 = new TalonSRX(RobotMap.DMBottomRight);
    gyro = new AnalogGyro(RobotMap.AnalogGyro);
  }
  
  public void drive(double topLeft, double bottomLeft, double topRight, double bottomRight) {
    left1.set(ControlMode.PercentOutput, topLeft);
    left2.set(ControlMode.PercentOutput,bottomLeft);
    right1.set(ControlMode.PercentOutput,-topRight);
    right2.set(ControlMode.PercentOutput,-bottomRight);
  }

  public double getAngle() {
    double angle = gyro.getAngle();
    while (angle < 0) {
      angle += 360;
    }
    angle %= 360;
    
    angle += 90;
    if (angle > 360) {
      angle -= 360;
    }
    return angle;
  }

  public void resetGyro() {
    gyro.reset();
  }

  public void initDefaultCommand() {
    setDefaultCommand(new JoystickDrive(false));
  }
}
//This is an test comment.
