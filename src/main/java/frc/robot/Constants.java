package frc.robot;

public class Constants {

    public static final class MotorReverse {
        public static final boolean FRONT_LEFT = false;
        public static final boolean FRONT_RIGHT = true;
        public static final boolean BACK_LEFT = false;
        public static final boolean BACK_RIGHT = true;
        public static final String LEFT_FRONT = null;
    }

    public static final class Drive {
        public static final double MAX_SPEED = 0.35;
        public static final double MAX_TURN_SPEED = 0.2;
        public static final double DEAD_BAND = 0.05; // 當前面的值小於0.05則視為0
        public static final double Intake_MAX_TURN_SPEEN = 0.5;
        public static final double IntakeOn_MAX_SPEED = 0.15;
        public static final double Shooter_MAX_TURN_SPEEN = 0.8;
        public static final double Hopper_MAX_SPEED = 0.7;
    }
    public static final class LimelightConstants {
        public static final double MOUNT_ANGLE_DEG = 0.0; // Limelight與地面傾斜角度
        public static final double LENS_HEIGHT_METERS = 0.42; // Limelight與地面高度
        public static final double GOAL_HEIGHT_METERS = 0.74; // Limelight偵測目標高度
        public static final double HORIZONTAL_OFFSET_METERS = 0; // 將水平距離歸0參數
        public static final double VERTICAL_MAX_SPEED = 1.3; // 水平運動最大速度
        public static final double HORIZONTAL_MAX_SPEED = 2.6; // 旋轉最大速度
        public static final boolean gyroField = false; // 相對機器方向
    }
}
