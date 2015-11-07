package rs;

import robocode.*;
import java.util.Random;

public class rsBot extends Robot {
	Random random = new Random();
	private byte moveDirection = 1;
	
	public void run(){
		while (true) {
			ahead(50 * moveDirection);
			turnGunRight(30);
		}
	}
	public void onScannedRobot(ScannedRobotEvent e){
		turnRight(e.getBearing() + 90);
		fire(1);
		if (e.getDistance() < 50){
			moveDirection*=-1;
			ahead(100 * moveDirection);
		}
		turnRight(e.getBearing());
	}
	public void onHitWall(HitWallEvent e){
		moveDirection*=-1;
	}
}

