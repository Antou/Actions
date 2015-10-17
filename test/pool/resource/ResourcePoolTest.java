package resources;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestResourcePool {
	
	@Test 
	public void NoSuchElementExceptionTest(){
		ResourcePool<Basket> baskets= new BasketPool(0);
		try {
			baskets.provideResource();
		    fail("Should throw exception when no resource is available");
		  }catch(NoSuchElementException Exp){
		    assert(Exp.getMessage().contains("No resource"));
		  }		
	}
	
	@Test 
	public void IllegalArgumentExceptionTest(){
		ResourcePool<Basket> baskets= new BasketPool(0);
		Basket basket = new Basket();
		try {
			baskets.freeResource(basket);
		    fail("Should throw exception when the resource is not managed by this ResourcePool");
		  }catch(IllegalArgumentException Exp){
		    assert(Exp.getMessage().contains("not included"));
		  }		
	}
	
	@Test
	public void provideResourceTest() throws NoSuchElementException{
		ResourcePool<Cubicle> cubicles = new CubiclePool(2);
		assertEquals(cubicles.resources.get(0),cubicles.provideResource());
		assertEquals(cubicles.resources.get(1),cubicles.provideResource());
	}
	
	@Test
	public void freeResourceTest() throws IllegalArgumentException, NoSuchElementException{
		ResourcePool<Cubicle> cubicles = new CubiclePool(1);
		assertFalse(cubicles.freeResource(cubicles.resources.get(0)));
		assertTrue(cubicles.freeResource(cubicles.provideResource()));	
	}

}
