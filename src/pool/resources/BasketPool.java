package pool.resources;

public class BasketPool extends ResourcePool<BasketResource> {

	public BasketPool(int capacity) {
		super(capacity);
	}

	@Override
	public BasketResource createResource() {
		return new BasketResource();
	}
	
	public String description() {
		return "pool basket";
	}
	
}
