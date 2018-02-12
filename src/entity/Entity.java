package entity;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.concurrent.atomic.AtomicInteger;

import integer.IntRef;

public abstract class Entity {

	protected IntRef x;
	protected IntRef y;
	protected int width;
	protected int height;
	
	// public methods
	public void setX(int x){this.x = new IntRef(x);}
	public int getX(){return x.val;}
	
	public void setY(int y){this.y = new IntRef(y);}
	public int getY(){return y.val;}
	
	public void setWidth(int width){this.width = width;}
	public int getWidth(){return width;}
	
	public void setHeight(int height){this.height = height;}
	public int getHeight(){return height;}
	
	public Rectangle getRect(){
		return new Rectangle(x.val, y.val, width, height);
	}
	
	abstract public void draw(Graphics2D g2);
	
	// constructors
	protected Entity(int x, int y, int width, int height) {
		this.x = new IntRef(x);
		this.y = new IntRef(y);
		this.width = width;
		this.height = height;
	}
}
