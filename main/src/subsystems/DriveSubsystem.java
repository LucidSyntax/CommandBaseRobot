// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.Joystick;

public class DriveSubsystem extends SubsystemBase {

  // motors and sensors set up
  
    private WPI_VictorSPX leftMotor1 = new WPI_VictorSPX(0);
    private WPI_VictorSPX leftMotor2 = new WPI_VictorSPX(1);
    private WPI_VictorSPX rightMotor1 = new WPI_VictorSPX(2);
    private WPI_VictorSPX rightMotor2 = new WPI_VictorSPX(3);
    private Joystick joy1 = new Joystick(0);

    double speed = -joy1.getRawAxis(1) * 0.6;
    double turn = joy1.getRawAxis(4) * 0.3;
    double left = speed + turn;
    double right = speed - turn;
    
  /** Creates a new ExampleSubsystem. */

    public DriveSubsystem() {
      // Sets the phase of the MotorFeedbackSensor so that it is set to be in phase with the motor itself.

        leftMotor1.setInverted(false);
        leftMotor2.setInverted(false);
        rightMotor1.setInverted(true);
        rightMotor2.setInverted(true);
    }

    // function / method used to easily set motor outputs 
    
    public void setMotors(double left, double right) {
        leftMotor1.set(left);
        leftMotor2.set(left);
        rightMotor1.set(-right);
        rightMotor2.set(-right);
      
      }

   @Override
    public void periodic() {
      // This method will be called once per scheduler run

   }


  /**
   * Example command factory method.
   *
   * @return a command
   */
  public CommandBase exampleMethodCommand() {
    // Inline construction of command goes here.
    // Subsystem::RunOnce implicitly requires `this` subsystem.
    return runOnce(
        () -> {
          /* one-time action goes here */
        });
  }

  /**
   * An example method querying a boolean state of the subsystem (for example, a digital sensor).
   *
   * @return value of some boolean subsystem state, such as a digital sensor.
   */
  public boolean exampleCondition() {
    // Query some boolean state, such as a digital sensor.
    return false;
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
