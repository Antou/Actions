package pool.action.scheduler;

import java.util.ArrayList;
import java.util.List;

import pool.action.Action;
import pool.action.exception.ActionFinishedException;

/**
 * Type of Action which is a Scheduler containing other Actions. It selects the
 * next Action which will evolve and the next step to run. When an Action is
 * finished, it is removed from the scheduler.
 */
public abstract class Scheduler extends Action {

	protected List<Action> actions = new ArrayList<Action>();

	/**
	 * Adds an action to the scheduler.
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
	 * Returns the next action for which a step will be executed, depending on
	 * the type of scheduler.
	 * 
	 * @return the next action
	 */
	protected abstract Action nextAction();

	/**
	 * Checks if the action is finished, and if it is,
	 * removes it from the Scheduler.
	 * 
	 * @param action action to check
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
	 * Returns the action at the specified position.
	 * 
	 * @param index specified position
	 * @return the action at the specified position
	 */
	protected Action getActionAt(int index) {
		return this.actions.get(index);
	}
	
	/**
	 * Returns the number of actions in this scheduler.
	 * 
	 * @return the number of actions in this scheduler
	 */
	protected int getSize() {
		return this.actions.size();
	}
	
}