package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkBase.IdleMode;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.DeviceId;
import frc.robot.lib.helpers.IDashboardProvider;

public class ShooterOnSubsystem extends SubsystemBase implements IDashboardProvider {
    private final CANSparkMax motor;

    public IntakeSubsystem() {
        this.registerDashboard();
        this.motor = new CANSparkMax(DeviceId.DriveMotor.IntakeSubsystem, MotorType.kBrushless);
        this.motor.setSmartCurrentLimit(30); // 電流限制
        this.motor.setInverted(true); // 是否反轉
        this.motor.setIdleMode(IdleMode.kCoast); // kBrake 停止後鎖住馬達, kCoast 停止後保持慣性
    }

    public void execute(double speed) {
        this.motor.set(Constants.shooterom); // 輸出速度到
    }

    public void stop() {
        this.motor.stopMotor();
    }

    @Override
    public void putDashboard() {
        SmartDashboard.putNumber("Intake Speed", Constants.Drive.Intake_MAX_TURN_SPEEN); // SmartDashboard

    }
}