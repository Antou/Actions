package pool.action.resource;

import java.util.NoSuchElementException;

import pool.action.exception.ActionFinishedException;
import pool.resource.*;

/**
 * Action which, when is executed, takes a resource from a ResourcePool and permits
 * to a ResourcefulUser to use it 
 * 
 * @param <R>
 *            type of the resource
 */
public class TakeResourceAction<R extends Resource> extends ResourceAction<R> {

	/**
	 * Constructs a new action that allows a user to take a resource from a pool
	 * @param resourcefulUser the user employing the resource
	 * @param resourcePool the pool from where the resource is from
	 */
	public TakeResourceAction(ResourcefulUser<R> resourcefulUser, ResourcePool<R> resourcePool) {
		super(resourcefulUser, resourcePool);
	}

	@Override
	protected void doStepAction() throws ActionFinishedException {
		System.out.print(" \\ Trying to take resource from " + this.resourcePool.description() + "... ");
		try {
			R resourceProvide = this.resourcePool.provideResource();
			this.resourcefulUser.setResource(resourceProvide);
			System.out.println("success");
		} catch (NoSuchElementException e) {
			System.out.println("failed");
		}
	}

	@Override
	public boolean isFinished() {
		return this.resourcefulUser.getResource() != null;
	}

}
