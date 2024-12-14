package frc.robot.commands;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants.Drive;
import frc.robot.commands.DriveCmd;
import frc.robot.subsystems.DriveMotorSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.IntakeArmSubsystem;

public class DriveCmd extends Command {
	private final DriveMotorSubsystem driveSubsystem;
	private final XboxController driver;

	public DriveCmd(DriveMotorSubsystem driveMotorSubsystem, XboxController driver) {
		this.driveSubsystem = driveMotorSubsystem;
		this.driver = driver;
		this.addRequirements(this.driveSubsystem);
	}

	@Override
	public void execute() {
		double driveSpeed = -MathUtil.applyDeadband(this.driver.getLeftY(), Drive.DEAD_BAND) * Drive.MAX_SPEED;
		double turnSpeed = MathUtil.applyDeadband(this.driver.getRightX(), Drive.DEAD_BAND) * Drive.MAX_TURN_SPEED;

		double leftSpeed = driveSpeed + turnSpeed;
		double rightSpeed = driveSpeed - turnSpeed;

		this.driveSubsystem.move(leftSpeed, rightSpeed);
		if(this.driver.getLeftBumper()) {

		}
	}

	@Override
	public void end(boolean interrupted) {
		this.driveSubsystem.stopModules();
	}

	@Override
	public boolean isFinished() {
		return false;
	}
}