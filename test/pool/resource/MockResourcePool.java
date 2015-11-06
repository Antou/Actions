package pool.resource;

import java.util.NoSuchElementException;

public class MockResourcePool extends ResourcePool<MockResource> {

	protected MockResource resource;
	protected boolean resourceIsAvailable;
	
	public MockResourcePool() {
		super(0);
		this.resource = new MockResource();
		this.resourceIsAvailable = true;
	}

	@Override
	public String description() {
		return "pool mock";
	}

	@Override
	public MockResource createResource() {
		return new MockResource();
	}
	
	public MockResource provideResource() throws NoSuchElementException {
		if(this.resourceIsAvailable) {
			this.resourceIsAvailable = false;
			return this.resource;
		}
		else {
			throw new NoSuchElementException();
		}
	}
	
	public void freeResource(MockResource resourceToFree) throws IllegalArgumentException {
		if(!this.resourceIsAvailable) {
			this.resourceIsAvailable = true;
		}
		else {
			throw new IllegalArgumentException();
		}
	}
}
