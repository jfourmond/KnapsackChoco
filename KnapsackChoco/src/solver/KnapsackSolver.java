package solver;

import org.chocosolver.solver.Model;

public abstract class KnapsackSolver {
	protected int capacity;
	protected int[] weights;
	protected int[] profits;
	
	protected int n;
	
	protected Model model;
	
	public KnapsackSolver(int nbItems, int capacity, int[] weights, int[] profits) {
		this.capacity = capacity;
		this.weights = weights;
		this.profits = profits;
		this.n = nbItems;
	}
	
	public abstract void solve();
}
