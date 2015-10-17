package pool.action.resource;

import pool.action.exception.ActionFinishedException;
import pool.resource.*;

/**
 * TODO
 * @param <R>
 */
public class FreeResourceAction<R extends Resource> extends ResourceAction<R> {

	public FreeResourceAction(ResourcefulUser<R> resourcefulUser, ResourcePool<R> resourcePool) {
		super(resourcefulUser, resourcePool);
	}

	@Override
	protected void doStepAction() throws ActionFinishedException {
		this.resourcePool.freeResource(this.resourcefulUser.getResource());
		this.resourcefulUser.resetResource();
		System.out.println(" \\ Freeing resource from " + this.resourcePool.description());
	}

	@Override
	public boolean isFinished() {
		return !this.isReady && this.resourcefulUser.getResource() == null;
	}

}
