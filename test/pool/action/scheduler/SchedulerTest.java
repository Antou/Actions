package pool.action.scheduler;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import pool.action.exception.ActionFinishedException;
import pool.action.foreseeable.ForeseeableAction;
import pool.action.mock.MockOneStepAction;

public abstract class SchedulerTest {
	
	protected Scheduler scheduler;
	protected ForeseeableAction action1;
	protected ForeseeableAction action2;
	
	protected abstract Scheduler createScheduler();
	
	@Before
	public void createElements() {
		this.scheduler = (Scheduler) this.createScheduler();
		this.action1 = new ForeseeableAction(2, "test1");
		this.action2 = new ForeseeableAction(2, "test2");
		this.scheduler.addAction(this.action1);
	}
	
	@Test
	public void withMockOneStepAction() throws ActionFinishedException {
		MockOneStepAction mockAction = new MockOneStepAction();
		Scheduler scheduler = (Scheduler) this.createScheduler();
		scheduler.addAction(mockAction);
		
		assertTrue(scheduler.isReady());
		assertTrue(mockAction.isReady());
		assertFalse(scheduler.isFinished());
		assertFalse(mockAction.isFinished());
		
		scheduler.doStep();
		
		assertFalse(scheduler.isReady());
		assertFalse(mockAction.isReady());
		assertTrue(scheduler.isFinished());
		assertTrue(mockAction.isFinished());
	}

	@Test
	public void addActionNormalTest() throws ActionFinishedException {
		this.scheduler.doStep();
		
		assertTrue(this.scheduler.isInProgress());
		assertFalse(this.scheduler.isFinished());
		
		this.scheduler.addAction(this.action2);
		this.scheduler.doStep();
		
		/* checks if the second action has been correctly add, therefore the scheduler isn't finished */
		assertFalse(this.scheduler.isFinished());
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void addFinishedActionTest() throws ActionFinishedException {
		while (!this.action2.isFinished()) {
			this.action2.doStep();
		}
		this.scheduler.addAction(this.action2);
	}
	
	@Test (expected = IllegalStateException.class)
	public void addActionToFinishedScheduler() throws ActionFinishedException {
		while (!this.scheduler.isFinished()) {
			this.scheduler.doStep();
		}
		this.scheduler.addAction(this.action2);
	}
	
	@Test
	public void isFinishedTest() throws ActionFinishedException {
		this.scheduler.addAction(this.action2);
		
		this.scheduler.doStep();
		this.scheduler.doStep();
		assertFalse(this.scheduler.isFinished());
		
		this.scheduler.doStep();
		this.scheduler.doStep();
		assertTrue(this.scheduler.isFinished());
	}

}
