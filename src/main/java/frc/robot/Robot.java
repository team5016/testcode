/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

 
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  
  TalonFX falcon;
  Joystick gamePad;
  
  @Override
  public void robotInit() {
    falcon = new TalonFX(0);
    gamePad = new Joystick(0);

  }

  @Override
  public void autonomousInit() {
  }

  @Override
  public void autonomousPeriodic() {
  }

  @Override
  public void teleopInit() {
  }

  @Override
  public void teleopPeriodic() {
    falcon.set(ControlMode.PercentOutput, gamePad.getRawAxis(1));

    double output = falcon.getStatorCurrent();
    double input = falcon.getSupplyCurrent();
    SmartDashboard.putNumber("Output Current", output);
    SmartDashboard.putNumber("Input Current", input);


    if (gamePad.getRawButton(2)){
      System.out.println(getEncoder());
    }
  }
  
  public double getEncoder(){
    return falcon.getSelectedSensorPosition();
  }

  @Override
  public void testInit() {
  }

  @Override
  public void testPeriodic() {
  }

}
