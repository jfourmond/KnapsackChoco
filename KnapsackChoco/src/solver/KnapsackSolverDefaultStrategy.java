package solver;

import org.chocosolver.solver.Model;
import org.chocosolver.solver.Solver;
import org.chocosolver.solver.variables.IntVar;

/**
 * Sous-classe de {@link KnapsackSolver} n'utilisant pas de méthode de résolution particulière
 * si ce n'est la méthode par défaut
 */
public class KnapsackSolverDefaultStrategy extends KnapsackSolver {

	public KnapsackSolverDefaultStrategy(int nbItems, int capacity, int[] weights, int[] profits) {
		super(nbItems, capacity, weights, profits);
	}

	public void solve() {
		model = new Model("KNAPSACK PROBLEM WITH DEFAULT STRATEGY");

		IntVar profit = model.intVar("v_" + nbItems, 0, MAX, true);
		IntVar weight = model.intVar("v_" + nbItems, 0, MAX, true);

		IntVar[] objects = new IntVar[nbItems];

		for (int i = 0; i < nbItems; i++) {
			objects[i] = model.intVar("v_" + i, 0, 1, false);
		}
		model.scalar(objects, weights, "=", weight).post();
		model.scalar(objects, profits, "=", profit).post();
		model.arithm(weight, "<=", capacity).post();

		model.setObjective(Model.MAXIMIZE, profit);
		model.addHook("obj", profit);

		Solver solver = model.getSolver();

//		if (solver.solve()) {
		while(solver.solve()){

//			for (int i = 0; i < objects.length; i++)
//				System.out.println(objects[i]);

			solver.printStatistics();
			solver.showSolutions();

			System.out.println("Profit : " + profit.getValue());
			System.out.println("Weight : " + weight.getValue());
		}
	}
}