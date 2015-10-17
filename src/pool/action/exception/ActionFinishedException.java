package pool.action.exception;

@SuppressWarnings("serial")
public class ActionFinishedException extends Exception {

	public ActionFinishedException() {
		super();
	}
	
	public ActionFinishedException(String message) {
		super(message);
	}
}
