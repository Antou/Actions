package pool.resource;

/**
 * An item defined by its description and used generally in a pool.
 */
public interface Resource {

	/**
	 * Describes the current resource
	 * @return the resource description as a String
	 */
	public String description();
}
