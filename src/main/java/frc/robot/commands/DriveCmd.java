package frc.robot.commands;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants.Drive;
import frc.robot.commands.DriveCmd;
import frc.robot.subsystems.DriveMotorSubsystem;

public class DriveCmd extends Command {
	private final DriveMotorSubsystem driveSubsystem;
	private final XboxController controller;

	public DriveCmd(DriveMotorSubsystem driveMotorSubsystem, XboxController controller) {
		this.driveSubsystem = driveMotorSubsystem;
		this.controller = controller;
		this.addRequirements(this.driveSubsystem);
	}

	@Override
	public void execute() {
		double driveSpeed = -MathUtil.applyDeadband(this.controller.getLeftY(), Drive.DEAD_BAND) * Drive.MAX_SPEED;
		double turnSpeed = MathUtil.applyDeadband(this.controller.getRightX(), Drive.DEAD_BAND) * Drive.MAX_TURN_SPEED;

		double leftSpeed = driveSpeed + turnSpeed;
		double rightSpeed = driveSpeed - turnSpeed;
		

		this.driveSubsystem.move(leftSpeed, rightSpeed);
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