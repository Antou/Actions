package pool.action.scheduler;

import pool.action.Action;

/**
 * Scheduler which execute one step of the next action in
 * line
 */
public class FairScheduler extends Scheduler {

	protected int indexOfCurrentAction = 0;

	@Override
	protected Action nextAction() {
		return this.actions.get(this.indexOfCurrentAction %= this.actions.size());
	}
	
	protected boolean removeActionIfFinished(Action action) {
		if(!super.removeActionIfFinished(action)) {
			this.indexOfCurrentAction++;
			return false;
		}
		return true;
	}

}
