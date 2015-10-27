package pool.resource;

import org.junit.Test;

public class CubiclePoolTest extends ResourcePoolTest<Cubicle> {

	@Override
	protected ResourcePool<Cubicle> createResourcePool(int capacity) {
		return new CubiclePool(capacity);
	}

	@Override
	protected Cubicle createResource() {
		return new Cubicle();
	}

	@Test
	public void testCreateResource() {
		CubiclePool cubiclePool = new CubiclePool(1);
		@SuppressWarnings("unused")
		// this test only makes sure that createResource() returns a Cubicle
		// instance. If the test compiles, the test must pass.
		Cubicle cubicle = cubiclePool.createResource();
	}

}
