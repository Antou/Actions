package actions.scheduler;

import java.util.ArrayList;
import actions.Action;

/**
 * Scheduler abstract class : 
 * 	
 * @author Marie Jones 
 *
 */
public abstract class Scheduler extends Action {

	//fields 
	
	protected boolean isInitialized;
	protected boolean isReady; 
	protected int currentAction; 
	protected ArrayList<Action> actions; 
	
	
	//constructor
	
	public Scheduler() {
		this.isInitialized = false;
		this.isReady = true;
		this.actions = new ArrayList<Action>();
		this.currentAction = 0; 
	}
	
	//methods
	
	/**
	 * @return 
	 * 	true if the scheduler is ready to execute the actions else false 
	 */
	public boolean isReady() {
		return this.isInitialized && this.isReady; 
	}
	
	/**
	 * @return
	 * 	true if the scheduler is currently doing some of the actions else false
	 */
	public boolean isInprogress() {
		return this.isInitialized && !this.isReady() && !this.isFinished();
	}
	
	/**
	 * @return
	 * 	true if the scheduler has finished else false 
	 */
	public boolean isFinished() {
		boolean tmp = true;
		
			for (Action a : this.actions) {
				tmp = tmp && a.isFinished();
				if (!tmp) {
					break;
				}
			}
		return tmp; 
	}
	
	/**
	 * @param action : 
	 * 	the action to add to the scheduler , it will not be added if the action is already finished 
	 */
	public void addAction(Action action) {
		if (!action.isFinished()) {
			this.actions.add(action); 
			
			if (!this.isInitialized) {
				this.isInitialized = true; 
			}
			
		}
		
	}
	
	
	public abstract void doStep();
}
