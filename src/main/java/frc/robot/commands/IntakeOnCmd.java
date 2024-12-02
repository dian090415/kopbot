package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants.Drive;
import frc.robot.subsystems.IntakeOnSubsystem;

public class IntakeOnCmd extends Command {
	private final IntakeOnSubsystem intakeonSubsystem;
	private final XboxController controller;


	public IntakeOnCmd(IntakeOnSubsystem intakeOnSubsystem , XboxController controller){
		this.intakeonSubsystem = intakeOnSubsystem;
		this.controller = controller;
		this.addRequirements(this.intakeonSubsystem);
	}

	@Override
	public void initialize() {
	}

	@Override
	public void execute() {
		if (this.controller.getLeftBumper()) {
			this.intakeonSubsystem.execute(1.0);
		} else {
			this.intakeonSubsystem.stop();
		}
		if (this.controller.getRightBumper()) {
			this.intakeonSubsystem.execute(-1.0);
		}	
	}

	@Override
	public void end(boolean interrupted) {
		this.intakeonSubsystem.stop();
	}

	@Override
	public boolean isFinished() {
		return false;
	}
}