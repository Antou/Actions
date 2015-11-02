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
		return this.getActionAt(this.indexOfCurrentAction %= this.getSize());
	}
	
	protected boolean removeActionIfFinished(Action action) {
		boolean actionRemoved = super.removeActionIfFinished(action);
		
		if(!actionRemoved) {
			this.indexOfCurrentAction++;
		}
		
		return actionRemoved;
	}

}
