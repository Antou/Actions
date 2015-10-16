package pool.actions.schedulers;

import pool.actions.Action;
import pool.actions.exceptions.ActionFinishedException;

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
