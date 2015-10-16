package pool.actions.resources;

import pool.actions.Action;
import pool.resources.*;

/**
 * TODO
 * @param <R>
 */
public abstract class ResourceAction<R extends IResource> extends Action {

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
