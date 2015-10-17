package pool.action.scheduler;

import pool.action.Action;
import pool.action.exception.ActionFinishedException;

/**
 * TODO
 */
public class SequentialScheduler extends Scheduler {

	@Override
	protected void doStepAction() throws ActionFinishedException {
		Action action = this.actions.get(0);
		action.doStep();
		this.removeActionIfFinished(action);
	}

}
