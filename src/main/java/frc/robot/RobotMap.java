/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {

    //Drive motors
    public static int DMTopLeft = 0;
    public static int DMBottomLeft = 1;
    public static int DMTopRight = 2;
    public static int DMBottomRight = 3;

    //Analog inputs
    public static int AnalogGyro = 0;

    //Joysticks
    public static int JoystickPort = 0;
    public static int JoystickPortXBOX = 1;
}