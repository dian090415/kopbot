package frc.robot.subsystems;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.MotorReverse;
import frc.robot.DeviceId.DriveMotor;
import frc.robot.lib.helpers.IDashboardProvider;

public class DriveMotorSubsystem extends SubsystemBase implements IDashboardProvider{
    private final DriveMotorModule frontLeft;
    private final DriveMotorModule frontRight;
    private final DriveMotorModule backLeft;
    private final DriveMotorModule backRight;
    private double leftSpeed;
    private double rightSpeed;

    public DriveMotorSubsystem() {
        this.registerDashboard();
        this.frontLeft = new DriveMotorModule(DriveMotor.FRONT_LEFT, MotorReverse.FRONT_LEFT);
        this.frontRight = new DriveMotorModule(DriveMotor.FRONT_RIGHT, MotorReverse.FRONT_RIGHT);
        this.backLeft = new DriveMotorModule(DriveMotor.BACK_LEFT, MotorReverse.BACK_LEFT);
        this.backRight = new DriveMotorModule(DriveMotor.BACK_RIGHT, MotorReverse.BACK_RIGHT);
    }

    public void move(double leftSpeed, double rightSpeed) {
        this.leftSpeed = leftSpeed;
        this.rightSpeed = rightSpeed;
        this.frontLeft.setDesiredState(leftSpeed);
        this.backLeft.setDesiredState(leftSpeed);
        this.frontRight.setDesiredState(rightSpeed);
        this.backRight.setDesiredState(rightSpeed);
    }

    public void stopModules() {
        this.frontLeft.stop();
        this.frontRight.stop();
        this.backLeft.stop();
        this.backRight.stop();
    }

    @Override
    public void putDashboard() {
        SmartDashboard.putNumber("Left Speed", this.leftSpeed);
        SmartDashboard.putNumber("Right Speed", this.rightSpeed);
    }
}