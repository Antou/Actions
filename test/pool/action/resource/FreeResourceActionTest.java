package pool.action.resource;

import static org.junit.Assert.*;

import org.junit.Test;

import pool.action.Action;
import pool.action.exception.ActionFinishedException;
import pool.resource.MockResource;
import pool.resource.MockResourcePool;
import pool.resource.ResourcefulUser;

public class FreeResourceActionTest {

	protected Action createAction() {
		ResourcefulUser<MockResource> user = new ResourcefulUser<MockResource>("test");
		MockResourcePool mockResourcePool = new MockResourcePool();
		return new FreeResourceAction<MockResource>(user, mockResourcePool);
	}
	
	@Test
	public void forceFreeResource() throws ActionFinishedException {
		Action action = createAction();
		for (int i = 0; i < 100; i++) {
			try {
				action.doStep();
			} catch (ActionFinishedException e) {
				fail("action was not supposed to be finished, we just checked");
			}
		}
		
		assertFalse(action.isFinished());
	}

}
