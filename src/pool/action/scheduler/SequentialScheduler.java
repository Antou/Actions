package pool.action.scheduler;

import pool.action.Action;

/**
 * A specific kind of scheduler which execute the first Action in line
 */
public class SequentialScheduler extends Scheduler {

	@Override
	protected Action nextAction() {
		return this.actions.get(0);
	}

}
