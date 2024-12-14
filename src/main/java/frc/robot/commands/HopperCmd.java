package frc.robot.commands;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.Constants.Drive;
import frc.robot.subsystems.HopperSubsystem;

public class HopperCmd extends Command {
    private final HopperSubsystem hopperSubsystem;
    private final XboxController controller;

    public HopperCmd(HopperSubsystem hopperSubsystem, XboxController controller) {
        this.hopperSubsystem = hopperSubsystem;
        this.controller = controller;
        this.addRequirements(this.hopperSubsystem);
    }

    @Override
    public void initialize() {
    }

    @Override
    public void execute() {
        if (this.controller.getAButton()) {
            this.hopperSubsystem.execute(-Drive.Hopper_MAX_SPEED);
        } else {
            this.hopperSubsystem.stop();
        }
        if (this.controller.getYButton()) {
            this.hopperSubsystem.execute(Drive.Hopper_MAX_SPEED);
        }
    }

    @Override
    public void end(boolean interrupted) {
        this.hopperSubsystem.stop();
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
