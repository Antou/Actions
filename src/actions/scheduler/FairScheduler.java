package actions.scheduler;

import actions.Action;

/**
 * Fair Scheduler class : 
 * 
 * @author Marie Jones 
 *
 */
public class FairScheduler extends Scheduler {
	
	//constructor
	
	public FairScheduler(){
		super();
	}
	
	
	//methods
	
	private void increaseCurrentAction() {
		if (this.currentAction == this.actions.size() -1) {
			this.currentAction =0;
		}
		else {
			this.currentAction +=1; 
		}
	}
	
	/**
	 * 
	 */
	public void doStep() {
		
		try {
			if (!this.isFinished()) {
			
				Action a = this.actions.get(this.currentAction);
			
				if (!a.isFinished()) {
				a.doStep();
				this.increaseCurrentAction();
			
				}
				
				else {
					
					while (this.actions.get(this.currentAction).isFinished()) {
						this.increaseCurrentAction();
					}
					this.actions.get(this.currentAction).doStep();
					
					
				}
			}
		}
		catch (Exception NullPointerException) {
			
		}
	
	}

}
