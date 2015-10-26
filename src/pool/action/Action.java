package pool.action;

import pool.action.exception.ActionFinishedException;

/**
 * TODO
 */
public abstract class Action {

	protected boolean isReady = true;

	/**
	 * TODO
	 * 
	 * @return
	 */
	public boolean isReady() {
		return this.isReady;
	}

	/**
	 * TODO
	 * 
	 * @return
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
	 * @throws ActionFinishedException
	 */
	public final void doStep() throws ActionFinishedException {
		if (this.isFinished()) {
			throw new ActionFinishedException();
		}

		this.isReady = false;
		this.doStepAction();
	}

	/**
	 * TODO
	 * 
	 * @throws ActionFinishedException
	 */
	protected abstract void doStepAction() throws ActionFinishedException;
}
