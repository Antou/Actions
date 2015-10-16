package pool.resources;

public class CubiclePool extends ResourcePool<CubicleResource> {

	public CubiclePool(int capacity) {
		super(capacity);
	}

	@Override
	public CubicleResource createResource() {
		return new CubicleResource();
	}
	
	public String description() {
		return "pool cubicle";
	}

}
