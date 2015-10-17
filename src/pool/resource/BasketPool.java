package pool.resource;

/**
 * A basket manager which role is to provide and free baskets according to the resources availability
 */
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
