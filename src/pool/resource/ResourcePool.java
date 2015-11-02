package pool.resource;

import java.util.ArrayList;
import java.util.NoSuchElementException;

/**
 * A resource manager able to provide and free resources that it contains
 * 
 * @param <R>
 *            specific kind of resource managed
 */
public abstract class ResourcePool<R extends Resource> implements Resource {

	protected ArrayList<R> availableResources;
	protected ArrayList<R> usedResources;

	/**
	 * TODO
	 * 
	 * @param capacity the number of resource available at the creation
	 */
	public ResourcePool(int capacity) {
		this.availableResources = new ArrayList<R>(capacity);
		this.usedResources = new ArrayList<R>();

		for (int i = 0; i < capacity; i++) {
			this.availableResources.add(this.createResource());
		}
	}

	/**
	 * Creates a resource corresponding to the type of ResourcePool.
	 * 
	 * @return a resource
	 */
	public abstract R createResource();

	/**
	 * Can make available a resource previously used.
	 * 
	 * @param resourceToFree
	 *            the resource to free
	 * @throws IllegalArgumentException
	 *             if this resource is not managed by this pool
	 */
	public void freeResource(R resourceToFree) throws IllegalArgumentException {
		if (!this.usedResources.contains(resourceToFree)) {
			throw new IllegalArgumentException();
		}

		this.usedResources.remove(resourceToFree);
		this.availableResources.add(resourceToFree);
	}

	/**
	 * Returns a unused resource from this pool.
	 * 
	 * @return the unused resource
	 * @throws NoSuchElementException
	 *             if no resource is currently available
	 */
	public R provideResource() throws NoSuchElementException {
		if (this.availableResources.isEmpty()) {
			throw new NoSuchElementException();
		}

		R resourceToReturn = this.availableResources.remove(0);
		this.usedResources.add(resourceToReturn);

		return resourceToReturn;
	}
}
