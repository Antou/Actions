package pool.resource;

public class BasketPool extends ResourcePool<Basket> {

	public BasketPool(int capacity) {
		super(capacity);
	}

	@Override
	public Basket createResource() {
		return new Basket();
	}
	
	public String description() {
		return "pool basket";
	}
	
}
