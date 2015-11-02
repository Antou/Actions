package pool.action.scheduler;

import java.util.ArrayList;
import java.util.List;

import pool.action.Action;
import pool.action.exception.ActionFinishedException;

/**
 * Scheduler selecting the next Actions to be admitted into the system and the next step to run
 * When an Action is finished, it is removed from the scheduler
 */
public abstract class Scheduler extends Action {

	protected List<Action> actions = new ArrayList<Action>();

	/**
	 * Add an action to the scheduler.
	 * 
	 * @param actionToAdd
	 *            the action to add to the scheduler
	 * @throws IllegalArgumentException
	 *             if the action to add is already finished
	 * @throws IllegalStateException
	 *             if the scheduler is already finished
	 */
	public void addAction(Action actionToAdd) throws IllegalArgumentException, IllegalStateException {
		if (actionToAdd.isFinished()) {
			throw new IllegalArgumentException(
					"You can’t add an already finished action");
		} else if (this.isFinished()) {
			throw new IllegalStateException(
					"You can’t add an action to a finished scheduler");
		} else {
			this.actions.add(actionToAdd);
		}
	}

	protected void doStepAction() throws ActionFinishedException {
		Action nextAction = this.nextAction();
		nextAction.doStep();
		this.removeActionIfFinished(nextAction);
	}

	/**
	 * @return the next action for which a step will be executed, depending of the type of scheduler
	 */
	protected abstract Action nextAction();

	/**
	 * Check if the action sent as a parameter is finished, and if it does,
	 * remove it from the List
	 * 
	 * @param action
	 */
	protected boolean removeActionIfFinished(Action action) {
		if (action.isFinished()) {
			return this.actions.remove(action);
		}
		return false;
	}

	public boolean isFinished() {
		return !this.isReady && this.actions.isEmpty();
	}
	
	/**
	 * TODO
	 * 
	 * @param index
	 * @return
	 */
	protected Action getActionAt(int index) {
		return this.actions.get(index);
	}
	
	/**
	 * TODO
	 * 
	 * @return
	 */
	protected int getSize() {
		return this.actions.size();
	}
	
}