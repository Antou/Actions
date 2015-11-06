package pool.resource;

import static org.junit.Assert.*;

import org.junit.Test;

public class ResourcefulUserTest {

	@Test
	public void testSetResource() {
		ResourcefulUser<Cubicle> resourcefulUserTest = new ResourcefulUser<Cubicle>("test");
		Cubicle resourceTest = new Cubicle();

		resourcefulUserTest.setResource(resourceTest);
		assertEquals(resourceTest, resourcefulUserTest.getResource());
	}

	@Test
	public void testGetResource() {
		ResourcefulUser<Basket> resourcefulUserTest = new ResourcefulUser<Basket>("test");
		Basket resourceTest = new Basket();

		resourcefulUserTest.setResource(resourceTest);
		assertEquals(resourceTest, resourcefulUserTest.getResource());
	}
	
	@Test
	public void testResetResource() {
		ResourcefulUser<Cubicle> resourcefulUserTest = new ResourcefulUser<Cubicle>("test");
		Cubicle resourceTest = new Cubicle();

		resourcefulUserTest.setResource(resourceTest);
		assertEquals(resourceTest, resourcefulUserTest.getResource());

		resourcefulUserTest.resetResource();
		assertNull(resourcefulUserTest.getResource());
	}
	
	@Test
	public void testGetName() {
		ResourcefulUser<Cubicle> resourcefulUserTest = new ResourcefulUser<Cubicle>("test");
		assertEquals("test", resourcefulUserTest.getUserName());
	}

}
