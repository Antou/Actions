package pool.resource;

/**
 * A cubicle manager which role is to provide and free baskets according to the
 * resources availability
 */
public class CubiclePool extends ResourcePool<Cubicle> {

	public CubiclePool(int capacity) {
		super(capacity);
	}

	@Override
	public Cubicle createResource() {
		return new Cubicle();
	}

	public String description() {
		return "pool cubicle";
	}

}
