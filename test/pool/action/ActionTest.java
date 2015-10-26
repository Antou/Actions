package pool.action;

import static org.junit.Assert.*;

import org.junit.Test;

import pool.action.exception.ActionFinishedException;

public abstract class ActionTest {

	protected abstract Action createAction();

	@Test(expected = ActionFinishedException.class, timeout = 2000)
	public void doStepWhileFinishedThrowsException()
			throws ActionFinishedException {
		Action action = createAction();
		while (!action.isFinished()) {
			try {
				action.doStep();
			} catch (ActionFinishedException e) {
				fail("action was not supposed to be finished, we just checked");
			}
		}
		assertTrue(action.isFinished());
		action.doStep();
	}
}