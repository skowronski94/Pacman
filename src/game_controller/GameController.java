package game_controller;
import javax.swing.Timer;

import integer.IntRef;

public class GameController extends Subject {

	IntRef result;
	Timer timer;
	
	// public methods
	public int getResult(){return result.val;}
	public void setResult(int result){this.result.val = result;}
	
	public void stopTimer(){
		timer.stop();
	}
	
	// constructors
	public GameController(Supervisor supervisor) {
		super(supervisor);
		result = new IntRef(0);
		timer = new Timer(15, e -> {this.notifyAllObs();
									this.notifySupervisor(result);});
		timer.setRepeats(true);
		timer.start();
	}
}
