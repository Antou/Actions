package pool.actions.foreseeable;

import pool.actions.exceptions.ActionFinishedException;

/**
 * TODO
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
