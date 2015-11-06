package pool.action.mock;

import pool.action.Action;
import pool.action.exception.ActionFinishedException;

public class MockOneStepAction extends Action {
	
	protected boolean isFinished = false;

	@Override
	public boolean isFinished() {
		return this.isFinished;
	}

	@Override
	protected void doStepAction() throws ActionFinishedException {
		this.isFinished = true;
	}

}
