package actions;

public abstract class Scheduler extends Action {

	protected boolean isInitialized;
	protected boolean isReady; 
	
	public boolean isReady() {
		return this.isInitialized && this.isReady; 
	}
	
	public boolean isInprogress() {
		
	}
	
	public boolean isFinished() {
		
	}
	
	public abstract void doStep();
}
