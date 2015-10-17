package pool.resource;

import java.util.ArrayList;
import java.util.NoSuchElementException;


/**
 * TODO
 * @param <R>
 */
public abstract class ResourcePool<R extends Resource> implements Resource {
	
	protected ArrayList<R> resources;
	protected ArrayList<R> usedResources;
	
	
	/**
	 * TODO
	 * @param capacity
	 */
	public ResourcePool(int capacity) {
		this.resources = new ArrayList<R>(capacity);
		this.usedResources = new ArrayList<R>();
		
		for(int i = 0; i < capacity; i++) {
			this.resources.add(this.createResource());
		}
	}
	
	/**
	 * TODO
	 * @return
	 */
	public abstract R createResource();
	
	
	/**
	 * TODO
	 * @param resourceToFree
	 * @throws IllegalArgumentException
	 */
	public void freeResource(R resourceToFree) throws IllegalArgumentException {
		if(!this.usedResources.contains(resourceToFree)) {
			throw new IllegalArgumentException();
		}
		
		this.usedResources.remove(resourceToFree);
		this.resources.add(resourceToFree);
	}
	
	
	/**
	 * TODO
	 * @return
	 * @throws NoSuchElementException
	 */
	public R provideResource() throws NoSuchElementException {
		if(this.resources.isEmpty()) {
			throw new NoSuchElementException();
		}
		
		R resourceToReturn = this.resources.remove(0);
		this.usedResources.add(resourceToReturn);
		
		return resourceToReturn;
	}
}
