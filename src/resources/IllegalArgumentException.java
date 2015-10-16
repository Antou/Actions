package resources;
/**
 * I am thrown when the specified resource is not included 
 */
public class IllegalArgumentException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public IllegalArgumentException(){
		System.out.println("This resource is not included in the pool");
	}

}
