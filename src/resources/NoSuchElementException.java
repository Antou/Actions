package resources;
/**
 * I am thrown when a pool is unable to provide any resource
 */
public class NoSuchElementException extends Exception {
	private static final long serialVersionUID = 1L;

	public NoSuchElementException(){
		System.out.println("No resource of this kind are actually available");
	}

}
