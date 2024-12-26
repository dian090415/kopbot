package frc.robot.subsystems;

import edu.wpi.first.math.MathUtil;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkBase.IdleMode;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.DutyCycleEncoder;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.DeviceId;
import frc.robot.lib.helpers.IDashboardProvider;

public class IntakeArmSubsystem extends SubsystemBase implements IDashboardProvider {
    private final CANSparkMax motor;
    private final DutyCycleEncoder encoder = new DutyCycleEncoder(0);
    private final PIDController lifterPid = new PIDController(0.01, 0, 0); // TODO
    private final double MIN_DEGREE = -0.388300284707507;
    private final double MAX_DEGREE =0.368803809220095;

    public IntakeArmSubsystem() {
        this.registerDashboard();
        this.motor = new CANSparkMax(DeviceId.DriveMotor.IntakeOnSubsystem, MotorType.kBrushless);
        this.motor.setSmartCurrentLimit(30); // 電流限制
        this.motor.setInverted(true); // 是否反轉
        this.motor.setIdleMode(IdleMode.kBrake); // kBrake 停止後鎖住馬達, kCoast 停止後保持慣性
    }

    public void execute(double speed) {
        if (this.encoder.get() >= this.MIN_DEGREE &&  this.encoder.get() <= this.MAX_DEGREE) {
            this.motor.set(speed);
        } else if (this.encoder.get() > this.MAX_DEGREE && speed >= 0.0) {
            this.motor.set(speed);
        } else if (this.encoder.get() < this.MIN_DEGREE && speed <= 0.0) {
            this.motor.set(speed); // 輸出速度到
        } else {
            this.motor.set(0);
        } 
    }

    public void up(double speed) {
        while (true) {
            if (this.encoder.get() - this.MIN_DEGREE >= 0.05) {
                this.motor.set(speed);
            } else {
                break;
            }
        }
    }

    public void down(double speed) {
        while (true) {
            if (this.encoder.get() - this.MAX_DEGREE <= (-0.005)) {
                this.motor.set(speed);
            } else {
                break;
            }
        }
    }

    public void stop() {
        this.motor.stopMotor();
    }

    @Override
    public void putDashboard() {
        // SmartDashboard.putNumber("IntakeOn Speed",
        // Constants.Drive.IntakeOn_MAX_SPEED); // SmartDashboard
        SmartDashboard.putNumber("IntakeArmDEG", this.encoder.get());
    }
}