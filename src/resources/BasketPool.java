package resources;
/**
 * I am a basket manager which role is to provide and free baskets according to the resources availability 
 */
public class BasketPool extends ResourcePool<Basket> {
	
	public BasketPool(int nb){
		super(nb);
	}

	public Basket createResource() {
		return new Basket();
	}

}
