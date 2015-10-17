package pool.resource;

public class CubiclePoolTest extends ResourcePoolTest<Cubicle> {

	@Override
	protected ResourcePool<Cubicle> createResourcePool(int capacity) {
		return new CubiclePool(capacity);
	}

	@Override
	protected Cubicle createResource() {
		return new Cubicle();
	}

}
