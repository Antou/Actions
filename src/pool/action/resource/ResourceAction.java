package pool.action.resource;

import pool.action.Action;
import pool.resource.*;

/**
 * Action defining something to do with a resource
 * 
 * @param <R>
 *            type of the resource
 */
public abstract class ResourceAction<R extends Resource> extends Action {

	protected ResourcefulUser<R> resourcefulUser;
	protected ResourcePool<R> resourcePool;

	/**
	 * Define a pool of resource and the user which will take action
	 * 
	 * @param resourcefulUser
	 * @param resourcePool
	 */
	public ResourceAction(ResourcefulUser<R> resourcefulUser, ResourcePool<R> resourcePool) {
		this.resourcefulUser = resourcefulUser;
		this.resourcePool = resourcePool;
	}

}
