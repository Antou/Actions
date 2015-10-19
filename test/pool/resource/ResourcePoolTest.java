package pool.resource;

import static org.junit.Assert.*;

import java.util.NoSuchElementException;

import org.junit.Test;

public abstract class ResourcePoolTest<R extends Resource> {

	protected abstract ResourcePool<R> createResourcePoolTest(int capacity);
	protected abstract R createResourceTest();

	@Test(expected= NoSuchElementException.class)
	public void testProvideResourceWhenThereAreNoResource() {
		ResourcePool<R> resourcePool = this.createResourcePoolTest(0);

		resourcePool.provideResource();
	}

	@Test(expected= IllegalArgumentException.class)
	public void testFreeResourceWithAnIllegalArgument() {
		ResourcePool<R> resourcePool = this.createResourcePoolTest(1);
		R resource = this.createResourceTest();

		resourcePool.freeResource(resource);
	}

	@Test
	public void testProvideResource() {
		ResourcePool<R> resourcePool = this.createResourcePoolTest(2);
		R resource1 = resourcePool.availableResources.get(0);
		R resource2 = resourcePool.availableResources.get(1);

		assertTrue(resourcePool.availableResources.contains(resource1));
		assertTrue(resourcePool.availableResources.contains(resource2));
		assertFalse(resourcePool.usedResources.contains(resource1));
		assertFalse(resourcePool.usedResources.contains(resource2));

		assertEquals(resource1, resourcePool.provideResource());

		assertFalse(resourcePool.availableResources.contains(resource1));
		assertTrue(resourcePool.availableResources.contains(resource2));
		assertTrue(resourcePool.usedResources.contains(resource1));
		assertFalse(resourcePool.usedResources.contains(resource2));

		assertEquals(resource2, resourcePool.provideResource());

		assertFalse(resourcePool.availableResources.contains(resource1));
		assertFalse(resourcePool.availableResources.contains(resource2));
		assertTrue(resourcePool.usedResources.contains(resource1));
		assertTrue(resourcePool.usedResources.contains(resource2));
	}

	@Test
	public void testFreeResource() {
		ResourcePool<R> resourcePool = this.createResourcePoolTest(2);
		R resource1 = resourcePool.availableResources.get(0);
		R resource2 = resourcePool.availableResources.get(1);

		resourcePool.provideResource();
		resourcePool.provideResource();

		resourcePool.freeResource(resource1);

		assertTrue(resourcePool.availableResources.contains(resource1));
		assertFalse(resourcePool.availableResources.contains(resource2));
		assertFalse(resourcePool.usedResources.contains(resource1));
		assertTrue(resourcePool.usedResources.contains(resource2));

		resourcePool.freeResource(resource2);

		assertTrue(resourcePool.availableResources.contains(resource1));
		assertTrue(resourcePool.availableResources.contains(resource2));
		assertFalse(resourcePool.usedResources.contains(resource1));
		assertFalse(resourcePool.usedResources.contains(resource2));
	}

}