package pool.action.scheduler;

import pool.action.Action;
import pool.action.exception.ActionFinishedException;


/**
 * A specific kind of scheduler which execute one step of the next action in line
 */
public class FairScheduler extends Scheduler {

	protected int indexOfCurrentAction = 0;
	
	@Override
	protected void doStepAction() throws ActionFinishedException {		
		Action action = this.actions.get(this.indexOfCurrentAction %= this.actions.size());
		action.doStep();
		if(!this.removeActionIfFinished(action)) {
			this.indexOfCurrentAction++;
		}
	}

}
