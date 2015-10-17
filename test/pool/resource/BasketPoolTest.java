package pool.resource;

public class BasketPoolTest extends ResourcePoolTest<Basket> {

	@Override
	protected ResourcePool<Basket> createResourcePool(int capacity) {
		return new BasketPool(capacity);
	}

	@Override
	protected Basket createResource() {
		return new Basket();
	}

}
