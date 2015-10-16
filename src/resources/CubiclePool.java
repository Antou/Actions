package resources;
/**
 * I am a cubicle manager which role is to provide and free baskets according to the resources availability 
 */
public class CubiclePool extends ResourcePool<Cubicle> {
	
	public CubiclePool(int nb){
		super(nb);
	}

	public Cubicle createResource() {
		return new Cubicle();
	}

}
