package solver;

import org.chocosolver.solver.Model;
import org.chocosolver.solver.Solver;
import org.chocosolver.solver.search.strategy.Search;
import org.chocosolver.solver.variables.IntVar;

/**
 * Sous-Classe de {@link KnapsackSolver} ayant pour méthode de résolution une
 * recherche Input Order Upper Bound Search : initialisant les variables à leur
 * maximum (ici : 1)
 */
public class KnapsackSolverMinDomLBSearch extends KnapsackSolver {

	public KnapsackSolverMinDomLBSearch(int nbItems, int capacity, int[] weights, int[] profits) {
		super(nbItems, capacity, weights, profits);
	}

	@Override
	public void solve() {
		model = new Model("KNAPSACK PROBLEM MIN DOM LOWER BOUND SEARCH");

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
		solver.setSearch(Search.minDomLBSearch(objects));

		if (solver.solve()) {

			// for (int i = 0; i < objects.length; i++)
			// System.out.println(objects[i]);

			solver.printStatistics();
			solver.showSolutions();

			System.out.println("Profit : " + profit.getValue());
			System.out.println("Weight : " + weight.getValue());
		}
	}

}
