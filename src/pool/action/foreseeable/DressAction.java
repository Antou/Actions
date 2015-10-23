package pool.action.foreseeable;

import pool.action.exception.ActionFinishedException;

/**
 * Action defined in several step during which the user put its clothes on in the simulation
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
