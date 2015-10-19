package pool.action.foreseeable;

import static org.junit.Assert.*;

import org.junit.Test;

import pool.action.Action;
import pool.action.ActionTest;
import pool.action.exception.ActionFinishedException;
import pool.action.foreseeable.ForeseeableAction;

public class ForeseeableActionTest extends ActionTest {

	@Override
	protected Action createAction() {
		return new ForeseeableAction(2);
	}
	
	@Test
	public void testIsReady() throws ActionFinishedException {
		ForeseeableAction foreseeableAction = new ForeseeableAction(2);
		
		assertTrue(foreseeableAction.isReady());
		
		foreseeableAction.doStep();
		
		assertFalse(foreseeableAction.isReady());
	}
	
	@Test
	public void testIsInProgress() throws ActionFinishedException {
		ForeseeableAction foreseeableAction = new ForeseeableAction(3);
		
		assertFalse(foreseeableAction.isInProgress());
		
		foreseeableAction.doStep(); // 2
		
		assertTrue(foreseeableAction.isInProgress());
		
		foreseeableAction.doStep(); // 1
		
		assertTrue(foreseeableAction.isInProgress());
		
		foreseeableAction.doStep(); // 0
		
		assertFalse(foreseeableAction.isInProgress());
	}
	
	@Test
	public void testIsFinished() throws ActionFinishedException {
		ForeseeableAction foreseeableAction = new ForeseeableAction(1);
		
		assertFalse(foreseeableAction.isFinished());
		
		foreseeableAction.doStep();
		
		assertTrue(foreseeableAction.isFinished());
	}
	
	

}
