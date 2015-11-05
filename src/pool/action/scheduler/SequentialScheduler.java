package pool.action.scheduler;

import pool.action.Action;

/**
 * Type of Scheduler which will execute its actions one after the other, it will wait that the first action is finished before starting executing the next one.
 */
public class SequentialScheduler extends Scheduler {

	@Override
	protected Action nextAction() {
		return this.getActionAt(0);
	}

}
