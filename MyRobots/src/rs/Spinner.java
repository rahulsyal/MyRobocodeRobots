package rs; //name of my package

import robocode.*; //import all of the classes we need

public class Spinner extends AdvancedRobot {
	public void run (){ //this fxn is called as soon as the game loads
		while (true){ //infinite loop
			//turn gun & radar
			turnGunRightRadians(Double.POSITIVE_INFINITY); 
			turnRadarRightRadians(Double.POSITIVE_INFINITY); 
		}	
	}
	public void onScannedRobot (ScannedRobotEvent e){
		fire(2);
	}
}
