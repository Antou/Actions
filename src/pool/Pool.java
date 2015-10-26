package pool;

import pool.action.exception.ActionFinishedException;
import pool.action.scheduler.*;
import pool.resource.*;

public class Pool {

	public static void main(String[] args) throws ActionFinishedException {
		BasketPool baskets = new BasketPool(6);
		CubiclePool cubicles = new CubiclePool(3);
		FairScheduler fairScheduler = new FairScheduler();

		fairScheduler.addAction(new Swimmer("Camille", baskets, cubicles, 6, 4, 8));
		fairScheduler.addAction(new Swimmer("Loïs", baskets, cubicles, 2, 10, 4));
		fairScheduler.addAction(new Swimmer("Maé", baskets, cubicles, 10, 18, 10));
		fairScheduler.addAction(new Swimmer("Ange", baskets, cubicles, 3, 7, 5));
		fairScheduler.addAction(new Swimmer("Louison", baskets, cubicles, 18, 3, 3));
		fairScheduler.addAction(new Swimmer("Charlie", baskets, cubicles, 3, 6, 10));
		fairScheduler.addAction(new Swimmer("Alexis", baskets, cubicles, 6, 5, 7));

		int nbSteps = 0;
		while (!fairScheduler.isFinished()) {
			nbSteps++;
			fairScheduler.doStep();
		}
		System.out.println("Finished in " + nbSteps + " steps");
	}
}