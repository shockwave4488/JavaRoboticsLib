package JavaRoboticsLib.Drive.Interfaces;

import edu.wpi.first.wpilibj.Gyro; //Change to Gyro Interface or GyroBase when new WPI comes out

public interface GyroscopeDrive extends TankDrive {
	public Gyro getGyroscope();
}
