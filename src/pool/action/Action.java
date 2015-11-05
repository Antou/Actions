package pool.action;

import pool.action.exception.ActionFinishedException;

/**
 * Things evolving from an initial state to a final state by steps.
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
	 * Returns true if this action is finished
	 * 
	 * @return true if this action is finished
	 */
	public abstract boolean isFinished();

	/**
	 * Changes the state of this action to get closer or to get to its final state.
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
