package movement;

import java.util.concurrent.atomic.AtomicInteger;

import integer.IntRef;

public class Mover {

	private Direction direct;
	private Moveable movement;
	private Moveable specialMovement;
	int speedX;
	int speedY;
	
	// public methods
	public void setDirect(Direction direct){this.direct = direct;}
	public Direction getDirect(){return direct;}
	
	public void setSpeedX(int speed){this.speedX = speed;}
	public int getSpeedX(){return speedX;}
	
	public void setSpeedY(int speed){this.speedY = speed;}
	public int getSpeedY(){return speedY;}
	
	public void move(IntRef x, IntRef y, boolean special){
		if(special)
			specialMovement.move(x, y, speedX, speedY, direct);
		else
			movement.move(x, y, speedX, speedY, direct);
	}
	
	// constructors
	public Mover(Direction direct, Moveable move, Moveable specMove, int speedX, int speedY) {
		this.direct = direct;
		this.movement = move;
		this.specialMovement = specMove;
		this.speedX = speedX;
		this.speedY = speedY;
	}
}
