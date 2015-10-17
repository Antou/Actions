package pool.action.scheduler;

import java.util.ArrayList;
import java.util.List;

import pool.action.Action;

public abstract class Scheduler extends Action {

	protected List<Action> actions = new ArrayList<Action>();
	
	/**
	 * TODO
	 * @param actionToAdd
	 * @throws IllegalArgumentException
	 * @throws IllegalStateException
	 */
	public void addAction(Action actionToAdd) throws IllegalArgumentException, IllegalStateException {
		if(actionToAdd.isFinished()) {
			throw new IllegalArgumentException("You can’t add an already finished action");
		}
		else if(this.isFinished()) {
			throw new IllegalStateException("You can’t add an action to a finished scheduler");
		}
		else {
			this.actions.add(actionToAdd);
		}
	}
	
	protected void removeActionIfFinished(Action action) {
		if(action.isFinished()) {
			this.actions.remove(action);
		}
	}
	
	public boolean isFinished() {
		return !this.isReady && this.actions.isEmpty();
	}
}