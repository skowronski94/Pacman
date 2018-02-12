package entity;

import java.awt.Graphics2D;
import java.awt.Color;

public class Ball extends Entity {
	
	protected Color color;
	public static int counter = 0;
	protected int points;
	
	// public methods
	public void incCounter(){counter++;} 
	public void decCounter(){counter--;} 
	
	public int getPoints(){return points;}
	public void setPoints(int points){this.points = points;}

	@Override
	public void draw(Graphics2D g2) {
		g2.setColor(color);
		g2.fillOval(x.val, y.val, width, height);
	}
	
	// constructors
	protected Ball(int x, int y, int width, int height, boolean incCounter) {
		super(x, y, width ,height);
		if(incCounter){
			incCounter();
		}
	}
		
	public Ball(int x, int y, int width, int height) {
		super(x + width * 3 / 8, y + height * 3 / 8, width / 4, height / 4);
		color = Color.WHITE;
		incCounter();
		points = 100;
	}
}
	
