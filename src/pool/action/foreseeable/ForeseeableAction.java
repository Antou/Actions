package pool.action.foreseeable;

import pool.action.Action;
import pool.action.exception.ActionFinishedException;

/**
 * TODO
 */
public class ForeseeableAction extends Action {
	
	protected final int totalTime;
	protected int remainingTime;
	
	/**
	 * TODO
	 * @param timeToEnd
	 */
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
