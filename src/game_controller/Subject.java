package game_controller;

import java.util.ArrayList;
import java.util.List;

import integer.IntRef;

public class Subject {

	List<Observer> obsList;
	Supervisor supervisor;
	
	// public methods
	public void addObs(Observer obs){
		obsList.add(obs);
	}
	
	public void removeObs(Observer obs){
		obsList.remove(obs);
	}
	
	public void setSupervisor(Supervisor supervisor){
		this.supervisor = supervisor;
	}
	
	public void notifyAllObs(){
		obsList.forEach(o -> o.execute());
	}
	
	public void notifySupervisor(IntRef result){
		supervisor.verify(result);
	}
	
	//constructors
	public Subject(Supervisor supervisor) {
		this.supervisor = supervisor;
		obsList = new ArrayList<>(10);
	}

}
