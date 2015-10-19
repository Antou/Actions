package pool.resource;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class BasketPoolTest extends ResourcePoolTest<Basket> {

	@Override
	protected ResourcePool<Basket> createResourcePoolTest(int capacity) {
		return new BasketPool(capacity);
	}

	@Override
	protected Basket createResourceTest() {
		return new Basket();
	}
	
	@Test
	public void testCreateResource() {
		BasketPool basketPool = new BasketPool(1);
		assertTrue(basketPool.createResource() instanceof Basket);
	}

}
