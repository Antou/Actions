package pool.action.exception;

/**
 * Exception that will be threw if an Action is Finished.
 */
@SuppressWarnings("serial")
// The compiler will generate a serialVersionUID if the developer does not have
// it defines. In addition, this class is not serialized in this project.
public class ActionFinishedException extends Exception {

	public ActionFinishedException() {
		super();
	}

}
