package rs;

import robocode.AdvancedRobot;
import robocode.ScannedRobotEvent;
import robocode.util.Utils;

public class MoreLocking extends AdvancedRobot {
	public void run() {
		turnRadarRightRadians(Double.POSITIVE_INFINITY); //keep turning 360 radians
		do {
			scan(); //manually call the scan fxn
		}
		while (true);
	}
	public void onScannedRobot(ScannedRobotEvent e){
		//absolute bearing to the found robot
		double absBearing = getHeadingRadians() + e.getBearingRadians();
		//let's get the current heading
		double curHeading = getRadarHeadingRadians();
		//subtract to find out how much to turn
		double turn = absBearing-curHeading;
		
		setTurnRadarRightRadians(Utils.normalRelativeAngle(turn)); //normalize turn btw -+pi
		


	}
}
