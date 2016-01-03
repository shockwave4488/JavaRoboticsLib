package JavaRoboticsLib.Drive.Interfaces;

import JavaRoboticsLib.Drive.DriveEncoders;
import JavaRoboticsLib.ControlSystems.MotionController;
import static JavaRoboticsLib.Utility.Util.accurateWaitSeconds;

public interface EncoderDrive extends TankDrive {

	public DriveEncoders getEncoders();
	
	default public void driveToDistance(double location, double power, boolean brake, double interval) throws InterruptedException {
		double direction = getEncoders().getLinearDistance() < location ? -1 : 1;
		
		while((getEncoders().getLinearDistance() - location)*direction > 0){
			setPowers(power, power);
			accurateWaitSeconds(interval);
		}
		
		if(brake)
			setPowers(0, 0);
	}
	
	default public void driveToDistance(double location, double power, boolean brake) throws InterruptedException{
		driveToDistance(location, power, brake, 0.02);
	}
	
	default public void driveForDistance(double location, double power, boolean brake, double interval) throws InterruptedException{
		driveToDistance(location + getEncoders().getLinearDistance(), power, brake, interval);
	}
	
	default public void driveForDistance(double location, double power, boolean brake) throws InterruptedException{
		driveForDistance(location, power, brake, 0.02);
	}
}
