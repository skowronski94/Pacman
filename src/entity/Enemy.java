package entity;

import java.awt.AWTException;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

import game_controller.Observer;
import movement.Direction;
import movement.EnemyNormalMovement;
import movement.EnemyScaredMovement;
import movement.Mover;
import movement.PacmanNormalMovement;
import movement.PacmanPoweredUpMovement;

public class Enemy extends Entity implements Observer{

	public static final Map<String, Image> imgMap;
    static {
        Map<String, Image> map = new HashMap<>(5);
        try {
			map.put("green", ImageIO.read(new File(".\\images\\enemyGreen.png")));
			map.put("blue", ImageIO.read(new File(".\\images\\enemyBlue.png")));
			map.put("magenta", ImageIO.read(new File(".\\images\\enemyMagenta.png")));
			map.put("red", ImageIO.read(new File(".\\images\\enemyRed.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}
        imgMap = Collections.unmodifiableMap(map);
    }
    
    Mover mover;
    int scare;
    Image img;
    int backupX;
	int backupY;
    
    // public methods
    public void setScare(int scare){this.scare = scare;}
    public boolean isScared(){return scare > 0;}
    
    public void setDirection(Direction direction){
		mover.setDirect(direction);
	}
    public Direction getDirection(){
    	return mover.getDirect();
    }
    
    public void backup(){
		x.val = backupX;
		y.val = backupY;
	}
    
    @Override
	public void draw(Graphics2D g2) {
    	g2.drawImage(img, x.val + 3, y.val + 3, width - 3, height - 3, null);
	}
    
    @Override
	public Rectangle getRect() {
    	return new Rectangle(x.val + 4, y.val + 4, width - 4, height  - 4);
	}

	@Override
	public void execute() {
		backupX = x.val;
		backupY = y.val;
		mover.move(x, y, isScared());
		if(isScared())
			scare--;
	}
	
	// constructors
	public Enemy(int x, int y, int width, int height, String color) {
		super(x, y, width, height);
		backupX = x;
		backupY = y;
		mover = new Mover(Direction.getRandomDirection(), new EnemyNormalMovement(), new EnemyScaredMovement(), 2, 2);
		scare = 0;
		img = imgMap.get(color);
	}
}
