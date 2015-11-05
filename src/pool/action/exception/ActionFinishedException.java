package pool.action.exception;

@SuppressWarnings("serial")
/**
 * Exeception that will be threw if an Action is Finished
 *
 */
public class ActionFinishedException extends Exception {

	/**
	 * Constructs a new action finished exception with null as a message
	 */
	public ActionFinishedException() {
		super();
	}

	/**
	 * Constructs a new action finished exception a specified message
	 * @param message 
	 */
	public ActionFinishedException(String message) {
		super(message);
	}
}
