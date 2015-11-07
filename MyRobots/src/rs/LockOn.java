package rs;

import robocode.AdvancedRobot;
import robocode.ScannedRobotEvent;

public class LockOn extends AdvancedRobot {
	public void run(){
		turnRadarRightRadians(Double.POSITIVE_INFINITY); //keep turning 360 rads
	}
	public void onScannedRobot(ScannedRobotEvent e){
		setTurnRadarLeftRadians(getRadarTurnRemainingRadians());
	}
}
