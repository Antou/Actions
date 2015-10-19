package pool.resource;

import static org.junit.Assert.*;

import org.junit.Test;

public class CubiclePoolTest extends ResourcePoolTest<Cubicle> {

	@Override
	protected ResourcePool<Cubicle> createResourcePoolTest(int capacity) {
		return new CubiclePool(capacity);
	}

	@Override
	protected Cubicle createResourceTest() {
		return new Cubicle();
	}
	
	@Test
	public void testCreateResource() {
		CubiclePool cubiclePool = new CubiclePool(1);
		assertTrue(cubiclePool.createResource() instanceof Cubicle);
	}

}
