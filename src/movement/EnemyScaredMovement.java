package movement;

import java.util.concurrent.atomic.AtomicInteger;

import integer.IntRef;

public class EnemyScaredMovement implements Moveable {

	
	// public
	@Override
	public void move(IntRef x, IntRef y, int speedX, int speedY, Direction direct) {
		speedX /= 2;
		speedY /= 2;
		switch(direct){
		case UP:
			y.val -= speedY;
			break;
		case RIGHT:
			x.val += speedX;
			break;
		case DOWN:
			y.val += speedY;
			break;
		case LEFT:
			x.val -= speedX;
			break;
		}
	}
}
