package pool.action.foreseeable;

import pool.action.exception.ActionFinishedException;

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
