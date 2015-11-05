package pool.action.resource;

import pool.action.Action;
import pool.resource.*;

/**
 * Type of Action which define what to do with a resource
 * 
 * @param <R>
 *            type of the resource
 */
public abstract class ResourceAction<R extends Resource> extends Action {

	protected ResourcefulUser<R> resourcefulUser;
	protected ResourcePool<R> resourcePool;

	/**
	 * Defines a pool of resources and the user employing it
	 * 
	 * @param resourcefulUser the user
	 * @param resourcePool the pool from where the resource is from
	 */
	public ResourceAction(ResourcefulUser<R> resourcefulUser, ResourcePool<R> resourcePool) {
		this.resourcefulUser = resourcefulUser;
		this.resourcePool = resourcePool;
	}

}
