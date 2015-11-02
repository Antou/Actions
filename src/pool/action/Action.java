package pool.action;

import pool.action.exception.ActionFinishedException;

/**
 * TODO
 */
public abstract class Action {

	protected boolean isReady = true;

	/**
	 * Returns true if this action has not started
	 * 
	 * @return true if this action has not started
	 */
	public boolean isReady() {
		return this.isReady;
	}

	/**
	 * Returns true if this action is in progress
	 * 
	 * @return true if this action is in progress
	 */
	public boolean isInProgress() {
		return !this.isReady && !this.isFinished();
	}

	/**
	 * TODO
	 * 
	 * @return
	 */
	public abstract boolean isFinished();

	/**
	 * TODO
	 * 
	 * @throws ActionFinishedException if this action is finished
	 */
	public final void doStep() throws ActionFinishedException {
		if (this.isFinished()) {
			throw new ActionFinishedException();
		}

		this.isReady = false;
		this.doStepAction();
	}

	/**
	 * Defines the body of doStep
	 * 
	 * @throws ActionFinishedException if this action is finished
	 */
	protected abstract void doStepAction() throws ActionFinishedException;
}
