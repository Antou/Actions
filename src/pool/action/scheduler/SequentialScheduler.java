package pool.action.scheduler;

import pool.action.Action;

/**
 * Scheduler executing the first Action in line
 */
public class SequentialScheduler extends Scheduler {

	@Override
	protected Action nextAction() {
		return this.getActionAt(0);
	}

}
