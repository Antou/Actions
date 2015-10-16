package pool.actions.schedulers;

import pool.actions.exceptions.ActionFinishedException;
import pool.actions.foreseeable.*;
import pool.actions.resources.*;
import pool.resources.*;

/**
 * TODO
 */
public class Swimmer extends SequentialScheduler {
	
	protected String name;
	protected ResourcefulUser<BasketResource> basket;
	protected ResourcefulUser<CubicleResource> cubicle;

	public Swimmer(String name, BasketPool baskets, CubiclePool cubicles, int timeToUndress, int timeToSwim, int timeToDress) {
		this.name = name;
		this.basket = new ResourcefulUser<BasketResource>();
		this.cubicle = new ResourcefulUser<CubicleResource>();
		this.addAction(new TakeResourceAction<BasketResource>(this.basket, baskets));
		this.addAction(new TakeResourceAction<CubicleResource>(this.cubicle, cubicles));
		this.addAction(new UndressAction(timeToUndress));
		this.addAction(new FreeResourceAction<CubicleResource>(this.cubicle, cubicles));
		this.addAction(new SwimAction(timeToSwim));
		this.addAction(new TakeResourceAction<CubicleResource>(this.cubicle, cubicles));
		this.addAction(new DressAction(timeToDress));
		this.addAction(new FreeResourceAction<CubicleResource>(this.cubicle, cubicles));
		this.addAction(new FreeResourceAction<BasketResource>(this.basket, baskets));
	}
	
	protected void doStepAction() throws ActionFinishedException {
		System.out.println(this.name + "'s turn");
		super.doStepAction();
	}

}
