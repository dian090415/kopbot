package frc.robot.commands;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.Constants.Drive;
import frc.robot.subsystems.ShooterSubsystem;

public class ShooterCmd extends Command {
	private final ShooterSubsystem shooterSubsystem;
	private final XboxController controller;

	public ShooterCmd(ShooterSubsystem shooterSubsystem, XboxController controller) {
		this.shooterSubsystem = shooterSubsystem;
		this.controller = controller;
		this.addRequirements(this.shooterSubsystem);
	}

	@Override
	public void initialize() {
	}

	@Override
	public void execute() {
		if (this.controller.getLeftBumper()) {
			this.shooterSubsystem.execute(1.0);
		} else {
			this.shooterSubsystem.stop();
		}
		if (this.controller.getRightBumper()) {
			this.shooterSubsystem.execute(-1.0);
		}	
	}

	@Override
	public void end(boolean interrupted) {
		this.shooterSubsystem.stop();
	}

	@Override
	public boolean isFinished() {
		return false;
	}
}