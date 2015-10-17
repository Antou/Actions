package pool.resource;

import static org.junit.Assert.*;

import java.util.NoSuchElementException;

import org.junit.Test;

public class ResourcePoolTest {
	
	@Test 
	public void NoSuchElementExceptionTest() {
		ResourcePool<Basket> baskets= new BasketPool(0);
		
		try {
			baskets.provideResource();
		    fail("Should throw exception when no resource is available");
		}
		catch(NoSuchElementException exp) {
			assert(exp.getMessage().contains("No resource"));
		}	
	}
	
	@Test 
	public void IllegalArgumentExceptionTest() {
		ResourcePool<Basket> baskets= new BasketPool(0);
		Basket basket = new Basket();
		
		try {
			baskets.freeResource(basket);
		    fail("Should throw exception when the resource is not managed by this ResourcePool");
		}
		catch(IllegalArgumentException exp) {
			assert(exp.getMessage().contains("not included"));
		}
	}
	
	@Test
	public void provideResourceTest() throws NoSuchElementException {
		ResourcePool<Cubicle> cubicles = new CubiclePool(2);
		Cubicle cubicle1 = cubicles.resources.get(0);
		Cubicle cubicle2 = cubicles.resources.get(1);
		
		assertEquals(cubicle1, cubicles.provideResource());
		assertEquals(cubicle2, cubicles.provideResource());
	}
	
	@Test
	public void freeResourceTest() throws IllegalArgumentException, NoSuchElementException {
		// NYI
	}

}