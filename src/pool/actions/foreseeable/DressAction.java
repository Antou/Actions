package pool.actions.foreseeable;

import pool.actions.exceptions.ActionFinishedException;

/**
 * TODO
 */
public class DressAction extends ForeseeableAction {

	public DressAction(int timeToEnd) {
		super(timeToEnd);
	}
	
	protected void doStepAction() throws ActionFinishedException {
		super.doStepAction();
		System.out.println(" \\ Dressing (" + (this.totalTime - this.remainingTime) + "/" + this.totalTime + ")");
	}
	
}
