package rs;

import robocode.AdvancedRobot;
import robocode.Rules;
import robocode.ScannedRobotEvent;

public class BestLock extends AdvancedRobot {
	public void run(){
		do {
			if (getRadarTurnRemaining()== 0.0){//change this later, imprecise double calc will be close to 0.0
				setTurnRadarRightRadians(Double.POSITIVE_INFINITY);
			}
			execute(); //execute pending actions
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
		
		//distance from the center of the other robot
		double turnMore = Math.min(Math.atan(36.0/e.getDistance()), Rules.RADAR_TURN_RATE_RADIANS);
		
		turn+= (turn < 0 ? -turnMore : turnMore);
		setTurnRadarRightRadians(turn);
	}
}
