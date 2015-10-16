package simulation;

import resources.*;

public class Swimmer {
	String name;
	BasketPool baskets;
	CubiclePool cubicles;
	int undressingTime;
	int swimmingTime;
	int dressingTime;
	
	public Swimmer(String name,BasketPool baskets,CubiclePool cubicles,int undressingTime,int swimmingTime,int dressingTime){
		this.name = name;
		this.baskets = baskets;
		this.cubicles = cubicles;
		this.undressingTime = undressingTime;
		this.swimmingTime = swimmingTime;
		this.dressingTime = dressingTime;
	}
	

}
