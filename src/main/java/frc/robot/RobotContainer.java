package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.ParallelRaceGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.commands.DriveCmd;
import frc.robot.commands.IntakeCmd;
import frc.robot.commands.ShooterCmd;
import frc.robot.subsystems.DriveMotorSubsystem;
//import frc.robot.subsystems.IntakeOnSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.ShooterSubsystem;

public class RobotContainer {
    private final GamepadJoystick controller = new GamepadJoystick(GamepadJoystick.CONTROLLER_PORT);
    private final GamepadJoystick driver = new GamepadJoystick(GamepadJoystick.DRIVER_CONTROLLER_PORT);

    private final DriveMotorSubsystem driveMotorSubsystem = new DriveMotorSubsystem();
    private final IntakeSubsystem intakeSubsystem = new IntakeSubsystem();
    private final ShooterSubsystem shooterSubsystem = new ShooterSubsystem();
    //private final IntakeOnSubsystem inrIntakeOnSubsystem = new IntakeOnSubsystem();

    private final DriveCmd driveJoystickCmd = new DriveCmd(driveMotorSubsystem, driver);
    private final IntakeCmd intakeCmd = new IntakeCmd(intakeSubsystem, controller);
    private final ShooterCmd shooterCmd = new ShooterCmd(shooterSubsystem, controller);

    public RobotContainer() {
        this.driveMotorSubsystem.setDefaultCommand(this.driveJoystickCmd);
        this.intakeSubsystem.setDefaultCommand(this.intakeCmd);
        this.shooterSubsystem.setDefaultCommand(this.shooterCmd);
    }

    public Command getAutonomousCommand() {
        return null;
    }
}