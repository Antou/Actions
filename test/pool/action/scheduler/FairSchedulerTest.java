package pool.action.scheduler;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import pool.action.exception.ActionFinishedException;

public class FairSchedulerTest extends SchedulerTest {
	
	@Override
	protected Scheduler createScheduler() {
		return new FairScheduler();
	}
	
	@Test
	public void nextActionTest() throws ActionFinishedException {
		this.scheduler.addAction(this.action2);
		
		assertEquals(this.action1,this.scheduler.nextAction());
		
		this.scheduler.doStep();
		assertEquals(this.action2,this.scheduler.nextAction());
		
		this.scheduler.doStep();
		assertEquals(this.action1,this.scheduler.nextAction());
	}
	
	@Test
	public void removeActionIfFinishedTest() throws ActionFinishedException {
		this.scheduler.addAction(this.action2);
		
		this.scheduler.doStep();
		assertFalse(this.scheduler.removeActionIfFinished(this.action1));
		this.scheduler.doStep();
		assertFalse(this.scheduler.removeActionIfFinished(this.action2));
		
		
		while (!this.scheduler.isFinished()) {
			this.scheduler.doStep();
		}
		// checks if all actions has been removed from the scheduler as they
		// were finished
		assertTrue(this.scheduler.isFinished());
		
	}

}
