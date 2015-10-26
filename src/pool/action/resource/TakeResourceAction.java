package pool.action.resource;

import java.util.NoSuchElementException;

import pool.action.exception.ActionFinishedException;
import pool.resource.*;

/**
 * Action which, when executed, take a resource from a ResourcePool and give it
 * to a ResourcefulUser
 * 
 * @param <R>
 *            type of the resource
 */
public class TakeResourceAction<R extends Resource> extends ResourceAction<R> {

	public TakeResourceAction(ResourcefulUser<R> resourcefulUser,
			ResourcePool<R> resourcePool) {
		super(resourcefulUser, resourcePool);
	}

	@Override
	protected void doStepAction() throws ActionFinishedException {
		System.out.print(" \\ Trying to take resource from "
				+ this.resourcePool.description() + "... ");
		try {
			this.resourcefulUser.setResource(this.resourcePool
					.provideResource());
			System.out.println("success");
		} catch (NoSuchElementException e) {
			this.resourcefulUser.setResource(null);
			System.out.println("failed");
		}

	}

	@Override
	public boolean isFinished() {
		return this.resourcefulUser.getResource() != null;
	}

}
