package pool.action.scheduler;

import pool.action.Action;
import pool.action.ActionTest;
import pool.resource.BasketPool;
import pool.resource.CubiclePool;

public class SwimmerTest extends ActionTest {
	
	protected Action createAction() {
		return new Swimmer("test", new BasketPool(1), new CubiclePool(1), 1, 2, 3);
	}
}
