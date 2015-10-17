package pool.action;

import pool.action.exception.ActionFinishedException;

/**
 * TODO
 */
public abstract class Action {
	
	protected boolean isInProgress = false;
	
	/**
	 * TODO
	 * @return
	 */
	public boolean isReady() {
		return !this.isInProgress;
	}
	
	/**
	 * TODO
	 * @return
	 */
	public boolean isInProgress() {
		return this.isInProgress && !this.isFinished();
	}
	
	/**
	 * TODO
	 * @return
	 */
	public abstract boolean isFinished();
	
	/**
	 * TODO
	 * @throws ActionFinishedException
	 */
	public final void doStep() throws ActionFinishedException {		
		if(this.isFinished()) {
			throw new ActionFinishedException();
		}
		
		this.isInProgress = true;
		this.doStepAction();
	}
	
	/**
	 * TODO
	 * @throws ActionFinishedException
	 */
	protected abstract void doStepAction() throws ActionFinishedException;
}
