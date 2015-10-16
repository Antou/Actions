package pool.actions.schedulers;

import pool.actions.Action;
import pool.actions.exceptions.ActionFinishedException;


/**
 * TODO
 */
public class FairScheduler extends Scheduler {

	protected int indexOfCurrentAction = 0;
	
	@Override
	protected void doStepAction() throws ActionFinishedException {		
		Action action = this.actions.get(this.indexOfCurrentAction++ % this.actions.size());
		action.doStep();
		this.removeActionIfFinished(action);
	}

}
