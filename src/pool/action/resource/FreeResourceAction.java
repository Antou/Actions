package pool.action.resource;

import pool.action.exception.ActionFinishedException;
import pool.resource.*;

/**
 * Action which, when is executed, takes its resource from a ResourcefulUser and makes
 * it available once again in the ResourcePool.
 * 
 * @param <R>
 *            type of the resource
 */
public class FreeResourceAction<R extends Resource> extends ResourceAction<R> {

	/**
	 * Constructs a new action that frees a Resource from a user.
	 * 
	 * @param resourcefulUser the user employing the resource
	 * @param resourcePool the pool from where the resource is from
	 */
	public FreeResourceAction(ResourcefulUser<R> resourcefulUser, ResourcePool<R> resourcePool) {
		super(resourcefulUser, resourcePool);
	}

	@Override
	protected void doStepAction() throws ActionFinishedException {
		try {
			this.resourcePool.freeResource(this.resourcefulUser.getResource());
			this.resourcefulUser.resetResource();
			this.isFinished = true;
		}
		catch (IllegalArgumentException e) {
			// nothing to do
		}
		
		System.out.println(" \\ " + (this.isFinished ? "" : "[ERROR] ")
				+ this.resourcefulUser.getUserName()
				+ " freeing resource from " + this.resourcePool.description());
	}

}
