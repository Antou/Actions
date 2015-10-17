package pool.action.foreseeable;

import pool.action.exception.ActionFinishedException;

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
