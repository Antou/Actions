package pool.action.scheduler;

import pool.action.Action;

/**
 * Scheduler which will execute its actions at the same time, it will do one
 * step of his first action then one step of the next one... until all actions
 * are finished.
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
