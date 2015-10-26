package pool.action.resource;

import pool.action.exception.ActionFinishedException;
import pool.resource.*;

/**
 * Action which, when executed, take its resource to a ResourcefulUser and make
 * the resource available again in the ResourcePool
 * 
 * @param <R>
 *            type of the resource
 */
public class FreeResourceAction<R extends Resource> extends ResourceAction<R> {

	public FreeResourceAction(ResourcefulUser<R> resourcefulUser, ResourcePool<R> resourcePool) {
		super(resourcefulUser, resourcePool);
	}

	@Override
	protected void doStepAction() throws ActionFinishedException {
		this.resourcePool.freeResource(this.resourcefulUser.getResource());
		this.resourcefulUser.resetResource();
		System.out.println(" \\ Freeing resource from "
				+ this.resourcePool.description());
	}

	@Override
	public boolean isFinished() {
		return !this.isReady && this.resourcefulUser.getResource() == null;
	}

}
