package pool.actions.resources;

import pool.actions.exceptions.ActionFinishedException;
import pool.resources.*;

/**
 * TODO
 * @param <R>
 */
public class FreeResourceAction<R extends IResource> extends ResourceAction<R> {

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
		return this.isInProgress && this.resourcefulUser.getResource() == null;
	}

}
