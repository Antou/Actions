package pool.action.resource;

import pool.action.Action;
import pool.resource.*;

/**
 * TODO
 * @param <R>
 */
public abstract class ResourceAction<R extends Resource> extends Action {

	protected ResourcefulUser<R> resourcefulUser;
	protected ResourcePool<R> resourcePool;

	/**
	 * TODO
	 * @param resourcefulUser
	 * @param resourcePool
	 */
	public ResourceAction(ResourcefulUser<R> resourcefulUser, ResourcePool<R> resourcePool) {
		this.resourcefulUser = resourcefulUser;
		this.resourcePool = resourcePool;
	}
	
}
