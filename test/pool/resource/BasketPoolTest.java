package pool.resource;

import org.junit.Test;

public class BasketPoolTest extends ResourcePoolTest<Basket> {

	@Override
	protected ResourcePool<Basket> createResourcePool(int capacity) {
		return new BasketPool(capacity);
	}

	@Override
	protected Basket createResource() {
		return new Basket();
	}

	@Test
	public void testCreateResource() {
		BasketPool basketPool = new BasketPool(1);
		@SuppressWarnings("unused")
		// this test only makes sure that createResource() returns a Basket
		// instance. If the test compiles, the test must pass.
		Basket basket = basketPool.createResource();
	}

}
