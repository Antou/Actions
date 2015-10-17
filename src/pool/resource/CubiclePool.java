package pool.resource;

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
