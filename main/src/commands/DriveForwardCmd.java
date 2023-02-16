// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;
import frc.robot.subsystems.DriveSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;

/** An example command that uses an example subsystem. */
public class DriveForwardCmd extends CommandBase {
  private final DriveSubsystem driveSubsystem;
  private final double distance;

  public DriveForwardCmd(DriveSubsystem driveSubsystem, double distance) {
      this.driveSubsystem = driveSubsystem;
      this.distance = distance;
      addRequirements(driveSubsystem);
  }

  /**public DriveForwardCmd(DriveSubsystem subsystem) {
  } **/

  @Override
  public void initialize() {
      System.out.println("DriveForwardCmd started!");
  }

  @Override
  public void execute() {
     driveSubsystem.setMotors(distance, distance);
  }

  @Override
  public void end(boolean interrupted) {

      driveSubsystem.setMotors(0, 0);
      System.out.println("DriveForwardCmd ended!");

  }
}

  /** @Override
  public boolean isFinished() {
      if (driveSubsystem.getEncoderMeters() > distance)
          return true;
      else
          return false;
  }
} **/
