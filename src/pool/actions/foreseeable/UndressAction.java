package pool.actions.foreseeable;

import pool.actions.exceptions.ActionFinishedException;

/**
 * TODO
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
