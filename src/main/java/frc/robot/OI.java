/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

    //JOYSTICK buttons
	public static Joystick normanMain = new Joystick(RobotMap.JoystickPort);
	public Button trigger = new JoystickButton(normanMain, 1);
	public Button headBottom = new JoystickButton(normanMain, 2);
	public Button headLeft = new JoystickButton(normanMain, 3);
	public Button headRight = new JoystickButton(normanMain, 4);
	public Button leftPadTop1 = new JoystickButton(normanMain, 5);
	public Button leftPadTop2 = new JoystickButton(normanMain, 6);
	public Button leftPadTop3 = new JoystickButton(normanMain, 7);
	public Button leftPadBottom3 = new JoystickButton(normanMain, 8);
	public Button leftPadBottom2  = new JoystickButton(normanMain, 9);
	public Button leftPadBottom1 = new JoystickButton(normanMain, 10);
	public Button rightPadTop3 = new JoystickButton(normanMain, 11);
	public Button rightPadTop2 = new JoystickButton(normanMain, 12);
	public Button rightPadTop1 = new JoystickButton(normanMain, 13);
	public Button rightPadBottom1 = new JoystickButton(normanMain, 14);
	public Button rightPadBottom2 = new JoystickButton(normanMain, 15);
	public Button rightPadBottom3 = new JoystickButton(normanMain, 16);

	//AUX controller buttons
	public static Joystick normanXBOX = new Joystick(RobotMap.JoystickPortXBOX); //Controller
	public Button auxA = new JoystickButton(normanXBOX, 1);
	public Button auxB = new JoystickButton(normanXBOX, 2);
	public Button auxX = new JoystickButton(normanXBOX, 3);
	public Button auxY = new JoystickButton(normanXBOX, 4);
	public Button auxLeftBumper = new JoystickButton(normanXBOX, 5);
	public Button auxRightBumper = new JoystickButton(normanXBOX, 6);
	public Button auxBack = new JoystickButton(normanXBOX, 7);
	public Button auxStart = new JoystickButton(normanXBOX, 8);

    public double getStrafe() {
      return normanMain.getRawAxis(0);
    }

    public double getThrust() {
      return -normanMain.getRawAxis(1);
    }

    public double getTwist() {
      return normanMain.getRawAxis(2);
    }

    public double getXboxRightY() {
      return normanXBOX.getRawAxis(5);
    }

    public double getXboxLeftY() {
      return normanXBOX.getRawAxis(1);
    }

    public double getTrigger() {
      return normanXBOX.getRawAxis(3);
    }
}