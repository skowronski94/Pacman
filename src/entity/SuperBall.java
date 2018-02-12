package entity;

import java.awt.Color;

public class SuperBall extends Ball {

	protected int powerUp;
	
	// public methods
	public void setPowerUp(int powerUp){this.powerUp = powerUp;}
	public int getPowerUp(){return powerUp;}
	
	// constructors
	public SuperBall(int x, int y, int width, int height) {
		super(x + width * 1 / 4, y + height * 1 / 4, width / 2, height / 2, true);
		color = Color.GREEN;
		powerUp = 200;
	}

}
