package entity;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import game_controller.Observer;
import movement.Direction;
import movement.Mover;
import movement.PacmanNormalMovement;
import movement.PacmanPoweredUpMovement;

import java.awt.Image;
import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;

public class Pacman extends Entity implements Observer {

	List<Image> imgList;
	Mover mover;
	int backupX;
	int backupY;
	boolean dead;
	int powerUp;
	
	// public methods	
	public void backup(){
		x.val = backupX;
		y.val = backupY;
	}
	
	public void setDirection(Direction direction){
		mover.setDirect(direction);
	}
	
	public void setDead(boolean dead){this.dead = dead;}
	public boolean isDead(){return dead;}
	
	public void setPowerUp(int powerUp){this.powerUp = powerUp;}
	public boolean isPoweredUp(){return powerUp > 0;}
	
	@Override
	public Rectangle getRect(){
		return new Rectangle(x.val + 4, y.val + 4, width - 4, height - 4);
	}
	
	@Override
	public void draw(Graphics2D g2) {
		g2.drawImage(imgList.get(mover.getDirect().val), x.val + 4, y.val + 4, width - 4, height - 4, null);
	}
	
	@Override
	public void execute() {
		backupX = x.val;
		backupY = y.val;
		mover.move(x, y, isPoweredUp());
		if(isPoweredUp())
			powerUp--;
	}
	
	// constructors
	public Pacman(int x, int y, int width, int height) throws IOException {
		super(x, y, width, height);
		backupX = x;
		backupY = y;
		dead = false;
		powerUp = 0;
		imgList = new ArrayList<>(2);
		imgList.add(ImageIO.read(new File(".\\images\\pacmanU.png")));
		imgList.add(ImageIO.read(new File(".\\images\\pacmanR.png")));
		imgList.add(ImageIO.read(new File(".\\images\\pacmanD.png")));
		imgList.add(ImageIO.read(new File(".\\images\\pacmanL.png")));
		mover = new Mover(Direction.RIGHT, new PacmanNormalMovement(), new PacmanPoweredUpMovement(), 2, 2);
	}
}
