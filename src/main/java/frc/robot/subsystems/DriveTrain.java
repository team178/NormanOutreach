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
import edu.wpi.first.wpilibj.motorcontrol.PWMTalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.MecanumDrive;

/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class DriveTrain extends Subsystem {

  private static MecanumDrive mecanumDrive;

  private AnalogGyro gyro;
  private PWMTalonSRX left1;
  private PWMTalonSRX left2;
  private PWMTalonSRX right1;
  private PWMTalonSRX right2;

  public DriveTrain() {
    left1 = new PWMTalonSRX(RobotMap.DMTopLeft);
    left2 = new PWMTalonSRX(RobotMap.DMBottomLeft);
    right1 = new PWMTalonSRX(RobotMap.DMTopRight);
    right2 = new PWMTalonSRX(RobotMap.DMBottomRight);
    gyro = new AnalogGyro(RobotMap.AnalogGyro);

    left1.setInverted(true);
    left2.setInverted(true);

    mecanumDrive = new MecanumDrive(left1, left2, right1, right2);
  }
  
  public void drive(double xSpeed, double ySpeed, double rotationSpeed) {
    mecanumDrive.driveCartesian(ySpeed, -xSpeed, -rotationSpeed);
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
