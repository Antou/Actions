package actions.scheduler;

public class SequentialScheduler extends Scheduler {

	//methods 
	
	public void doStep() {
		
		Action a = this.actions.get(this.currentAction);
		
		if (!a.isFinished()) {
			a.doStep();
		}
		
		else {
			
			if (!this.isFinished()) {
			
				this.currentAction += 1; 
				this.actions.get(this.currentAction).doStep();
			
			}
		}
		
	}
}
