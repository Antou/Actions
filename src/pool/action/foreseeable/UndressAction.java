package pool.action.foreseeable;

import pool.action.exception.ActionFinishedException;

/**
 * Action defined in several step during which the user remove its clothes in the simulation
 */
public class UndressAction extends ForeseeableAction {

	public UndressAction(int timeToEnd) {
		super(timeToEnd);
	}
	
	protected void doStepAction() throws ActionFinishedException {
		super.doStepAction();
		System.out.println(" \\ Undressing (" + (this.totalTime - this.remainingTime) + "/" + this.totalTime + ")");
	}

}
