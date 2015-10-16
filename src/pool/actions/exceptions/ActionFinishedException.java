package pool.actions.exceptions;

@SuppressWarnings("serial")
public class ActionFinishedException extends Exception {

	public ActionFinishedException() {
		super();
	}
	
	public ActionFinishedException(String message) {
		super(message);
	}
}
