package resources;

import java.util.ArrayList;

public abstract class ResourcePool<T extends Resource>{
	
	protected ArrayList<T> resources ;
	protected ArrayList<T> usedResources ;
	
	/*public RessourcePool(int nb){
		resources = new ArrayList<T>(nb);
		usedResources = new ArrayList<T>(nb);
		for(int i=0;i<nb;i++){
			resources.add(createResource());
		}
	}/*
	
	public abstract T createResource();
	
	/*public T provideResource(){
		for(resource T : resources){
			
		}
	}*/

}
