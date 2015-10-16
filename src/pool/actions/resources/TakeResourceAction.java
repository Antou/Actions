package pool.actions.resources;

import java.util.NoSuchElementException;

import pool.actions.exceptions.ActionFinishedException;
import pool.resources.*;

/**
 * TODO
 * @param <R>
 */
public class TakeResourceAction<R extends IResource> extends ResourceAction<R> {

	public TakeResourceAction(ResourcefulUser<R> resourcefulUser, ResourcePool<R> resourcePool) {
		super(resourcefulUser, resourcePool);
	}

	@Override
	protected void doStepAction() throws ActionFinishedException {
		try {
			System.out.print(" \\ Trying to take resource from " + this.resourcePool.description() + "... ");
			this.resourcefulUser.setResource(this.resourcePool.provideResource());
			System.out.println("success");
		}
		catch(NoSuchElementException e) {
			this.resourcefulUser.setResource(null);
			System.out.println("failed");
		}
		
	}

	@Override
	public boolean isFinished() {
		return this.resourcefulUser.getResource() != null;
	}

}
