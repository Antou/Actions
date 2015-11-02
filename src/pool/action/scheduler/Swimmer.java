package pool.action.scheduler;

import pool.action.exception.ActionFinishedException;
import pool.action.foreseeable.*;
import pool.action.resource.*;
import pool.resource.*;

/**
 * A swimmer represents an user in the simulation. Each one of them is assigned a name, and it can
 * use a basket and a cubicle.
 */
public class Swimmer extends SequentialScheduler {

	protected String name;
	protected ResourcefulUser<Basket> basket;
	protected ResourcefulUser<Cubicle> cubicle;

	public Swimmer(String name, BasketPool baskets, CubiclePool cubicles,
			int timeToUndress, int timeToSwim, int timeToDress) {
		this.name = name;
		this.basket = new ResourcefulUser<Basket>();
		this.cubicle = new ResourcefulUser<Cubicle>();
		this.addAction(new TakeResourceAction<Basket>(this.basket, baskets));
		this.addAction(new TakeResourceAction<Cubicle>(this.cubicle, cubicles));
		this.addAction(new ForeseeableAction(timeToUndress, "Undressing"));
		this.addAction(new FreeResourceAction<Cubicle>(this.cubicle, cubicles));
		this.addAction(new ForeseeableAction(timeToSwim, "Swimming"));
		this.addAction(new TakeResourceAction<Cubicle>(this.cubicle, cubicles));
		this.addAction(new ForeseeableAction(timeToDress, "Dressing"));
		this.addAction(new FreeResourceAction<Cubicle>(this.cubicle, cubicles));
		this.addAction(new FreeResourceAction<Basket>(this.basket, baskets));
	}

	protected void doStepAction() throws ActionFinishedException {
		System.out.println(this.name + "'s turn");
		super.doStepAction();
	}

}
