package pool.action.foreseeable;

import pool.action.Action;
import pool.action.exception.ActionFinishedException;

/**
 * Action which needs a specific number of steps to be finished 
 */
public class ForeseeableAction extends Action {
	
	protected final int totalTime;
	protected int remainingTime;
	protected String actionName;
	
	public ForeseeableAction(int timeToEnd, String actionName) {
		this.totalTime = timeToEnd;
		this.remainingTime = timeToEnd;
		this.actionName = actionName;
	}

	@Override
	protected void doStepAction() throws ActionFinishedException {
		this.remainingTime--;
		System.out.println(" \\ " + this.actionName + " (" + (this.totalTime - this.remainingTime) + "/" + this.totalTime + ")");
	}

	public boolean isReady() {
		return this.totalTime == this.remainingTime;
	}

	public boolean isInProgress() {
		return this.totalTime > this.remainingTime && !this.isFinished();
	}

	@Override
	public boolean isFinished() {
		return this.remainingTime <= 0;
	}

}
