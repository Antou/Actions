package pool.action.resource;

import pool.action.Action;
import pool.action.ActionTest;
import pool.resource.MockResource;
import pool.resource.MockResourcePool;
import pool.resource.ResourcefulUser;

public class FreeResourceActionTest extends ActionTest {

	protected Action createAction() {
		ResourcefulUser<MockResource> user = new ResourcefulUser<MockResource>("test");
		MockResourcePool mockResourcePool = new MockResourcePool(false);
		return new FreeResourceAction<MockResource>(user, mockResourcePool);
	}

}
