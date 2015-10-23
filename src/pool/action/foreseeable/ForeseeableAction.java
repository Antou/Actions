package pool.action.foreseeable;

import pool.action.Action;
import pool.action.exception.ActionFinishedException;

/**
 * Action which needs a specific number of steps to be finished 
 */
public class ForeseeableAction extends Action {
	
	protected final int totalTime;
	protected int remainingTime;
	
	public ForeseeableAction(int timeToEnd) {
		this.totalTime = timeToEnd;
		this.remainingTime = timeToEnd;
	}

	@Override
	protected void doStepAction() throws ActionFinishedException {
		this.remainingTime--;
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
