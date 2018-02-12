package movement;

import java.util.Random;

public enum Direction {
	UP(0),
	RIGHT(1),
	DOWN(2),
	LEFT(3);
	
	static private Random generator = new Random();
	public final int val;
	
    private Direction(int value) {
        this.val = value;
    }
    
    public static Direction getRandomDirection(){
    	switch(generator.nextInt(4))
    	{
    	case 0:
    		return Direction.UP;
    	case 1:
    		return Direction.RIGHT;
    	case 2:
    		return Direction.DOWN;
    	case 3:
    		return Direction.LEFT;
    	}
		return Direction.UP;
    }
}
