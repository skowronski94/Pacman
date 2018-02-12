package movement;

import java.util.concurrent.atomic.AtomicInteger;

import integer.IntRef;

public class EnemyNormalMovement implements Moveable {

	// public
	@Override
	public void move(IntRef x, IntRef y, int speedX, int speedY, Direction direct) {
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
