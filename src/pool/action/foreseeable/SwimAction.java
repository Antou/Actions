package pool.action.foreseeable;

import pool.action.exception.ActionFinishedException;

/**
 * Action defined in several step during which the user is swimming in the simulation
 */
public class SwimAction extends ForeseeableAction {

	public SwimAction(int timeToEnd) {
		super(timeToEnd);
	}
	
	protected void doStepAction() throws ActionFinishedException {
		super.doStepAction();
		System.out.println(" \\ Swimming (" + (this.totalTime - this.remainingTime) + "/" + this.totalTime + ")");
	}
	
}
