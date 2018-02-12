package movement;

import java.util.concurrent.atomic.AtomicInteger;

import integer.IntRef;

public interface Moveable {
	public void move(IntRef x, IntRef y, int speedX, int speedY, Direction direct);
}
