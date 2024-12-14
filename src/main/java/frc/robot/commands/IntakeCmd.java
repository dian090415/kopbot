package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants.Drive;
import frc.robot.subsystems.IntakeSubsystem;

public class IntakeCmd extends Command {
	private final IntakeSubsystem intakeSubsystem;
	private final XboxController controller;

	public IntakeCmd(IntakeSubsystem intakeSubsystem, XboxController controller) {
		this.intakeSubsystem = intakeSubsystem;
		this.controller = controller;
		this.addRequirements(this.intakeSubsystem);
	}

	@Override
	public void initialize() {
	}

	@Override
	public void execute() {
		if (this.controller.getXButton()) {
			this.intakeSubsystem.execute(-Drive.Intake_MAX_TURN_SPEEN);
		}else if(this.controller.getBButton()){
			this.intakeSubsystem.execute(Drive.Intake_MAX_TURN_SPEEN);
		}else{
			this.intakeSubsystem.stop();
		}
	}

	@Override
	public void end(boolean interrupted) {
		this.intakeSubsystem.stop();
	}

	@Override
	public boolean isFinished() {
		return false;
	}
}