package solver;

import org.chocosolver.solver.Model;

/**
 * Classe abstraite avec pour attribut la capacité du sac, le nombre d'items, le poids de chaque items
 *  et le profit de chaque item
 */
public abstract class KnapsackSolver {
	protected int capacity;
	protected int[] weights;
	protected int[] profits;
	
	protected int nbItems;
	
	protected Model model;
	
	public KnapsackSolver(int nbItems, int capacity, int[] weights, int[] profits) {
		this.capacity = capacity;
		this.weights = weights;
		this.profits = profits;
		this.nbItems = nbItems;
	}
	
	/**
	 * Création du modèle et résolution du problème
	 */
	public abstract void solve();
}
