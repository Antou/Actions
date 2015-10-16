package resources;

import java.util.ArrayList;
/**
 * I am a resource manager able to provide and free resources that I include 
 * @param <T> specific kind of resource managed
 */
public abstract class ResourcePool<T extends Resource>{
	
	protected ArrayList<T> resources ;
	protected ArrayList<T> usedResources ;
	
	public ResourcePool(int nb){
		resources = new ArrayList<T>(nb);
		usedResources = new ArrayList<T>(nb);
		for(int i=0;i<nb;i++){
			resources.add(createResource());
		}
	}
	
	public abstract T createResource();
	
	/**
	 * I can return a unused resource from my pool 
	 * @return the unused resource
	 * @throws NoSuchElementException if no resource is currently available
	 */
	public T provideResource() throws NoSuchElementException{
		for(T res : resources){
		  if(!usedResources.contains(res)){
			  usedResources.add(res);
			  return res;
		  }
		}
		throw new NoSuchElementException();
	}
	
	/**
	 * I can make available a resource previously used 
	 * @param res the resource we want to free 
	 * @return true if the resource got freed, false if she was already
	 * @throws IllegalArgumentException if this resource is not managed by this pool
	 */
	public boolean freeResource(T res) throws IllegalArgumentException{
		if(resources.contains(res)){
			if(usedResources.contains(res)){
				usedResources.remove(res);
				return true;
			}
			else{
				return false;
			}
		}
		else{
			throw new IllegalArgumentException();
		}
	}
	
	
}
