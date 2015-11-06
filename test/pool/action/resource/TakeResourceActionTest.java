package pool.action.resource;

import pool.action.Action;
import pool.action.ActionTest;
import pool.resource.MockResource;
import pool.resource.MockResourcePool;
import pool.resource.ResourcefulUser;

public class TakeResourceActionTest extends ActionTest {

	@Override
	protected Action createAction() {
		ResourcefulUser<MockResource> user = new ResourcefulUser<MockResource>("test");
		MockResourcePool mockResourcePool = new MockResourcePool();
		return new TakeResourceAction<MockResource>(user, mockResourcePool);
	}
}
