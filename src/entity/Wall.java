package entity;

import java.awt.Color;
import java.awt.Graphics2D;

public class Wall extends Entity {

	protected Color color;
	
	public void draw(Graphics2D g2){
		g2.setColor(color);
		g2.fillRect(x.val, y.val, width, height);
	}
	
	public Wall(int x, int y, int width, int height) {
		super(x, y, width, height);
		color = Color.BLUE;
	}

}
