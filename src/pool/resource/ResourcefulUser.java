package pool.resource;

/**
 * A user holding a resource
 * 
 * @param <R>
 *            type of the resource
 */
public class ResourcefulUser<R extends Resource> {

	protected R resource;

	/**
	 * Returns the resource which is held by the user
	 * @return the resource held 
	 */
	public R getResource() {
		return resource;
	}

	/**
	 * Changes the current resource held by the one given
	 * @param resource the new resource held by the user
	 */
	public void setResource(R resource) {
		this.resource = resource;
	}

	/**
	 * Takes the resource from the user 
	 */
	public void resetResource() {
		this.resource = null;
	}

}