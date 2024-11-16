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
        public static final double MAX_SPEED = 0.5;
        public static final double MAX_TURN_SPEED = 0.36;
        public static final double DEAD_BAND = 0.05; // 當前面的值小於0.05則視為0
        public static final double Intake_MAX_TURN_SPEEN = 0.6;
        public static final double Shooter_MAX_TURN_SPEEN = 0.8;
    }

}
