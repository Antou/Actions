package pool.resource;

import static org.junit.Assert.*;

import org.junit.Test;

public class ResourcefulUserTest {

	@Test
	public void testSetResource() {
		ResourcefulUser<Cubicle> resourcefulUserTest = new ResourcefulUser<Cubicle>();
		Cubicle resourceTest = new Cubicle();

		resourcefulUserTest.setResource(resourceTest);
		assertEquals(resourceTest, resourcefulUserTest.resource);
	}

	@Test
	public void testResetResource() {
		ResourcefulUser<Cubicle> resourcefulUserTest = new ResourcefulUser<Cubicle>();
		Cubicle resourceTest = new Cubicle();

		resourcefulUserTest.setResource(resourceTest);
		assertEquals(resourceTest, resourcefulUserTest.resource);

		resourcefulUserTest.resetResource();
		assertNull(resourcefulUserTest.resource);
	}

	@Test
	public void testGetResource() {
		ResourcefulUser<Basket> resourcefulUserTest = new ResourcefulUser<Basket>();
		Basket resourceTest = new Basket();

		resourcefulUserTest.setResource(resourceTest);
		assertEquals(resourcefulUserTest.resource,
				resourcefulUserTest.getResource());
		assertEquals(resourceTest, resourcefulUserTest.getResource());
	}

}
