package solver;

import org.chocosolver.solver.Model;
import org.chocosolver.solver.Solver;
import org.chocosolver.solver.search.strategy.Search;
import org.chocosolver.solver.variables.IntVar;

public class KnapsackSolverInputOrderUBSearch extends KnapsackSolver {

	public KnapsackSolverInputOrderUBSearch(int nbItems, int capacity, int[] weights, int[] profits) {
		super(nbItems, capacity, weights, profits);
	}

	@Override
	public void solve() {
		model = new Model("KNAPSACK PROBLEM");

		IntVar profit = model.intVar("v_" + n, 0, 9999, true);
		IntVar weight = model.intVar("v_" + n, 0, 9999, true);
		
		IntVar[] objects = new IntVar[n];
		
		for (int i = 0; i < n; i++) {
			objects[i] = model.intVar("v_" + i, 0, 1, false);
		}
		model.scalar(objects, weights, "=", weight).post();
		model.scalar(objects, profits, "=", profit).post();
		model.arithm(weight, "<=", capacity).post();
		
		model.setObjective(Model.MAXIMIZE, profit);
		model.addHook("obj", profit);
		
		Solver solver = model.getSolver();
//		 solver.setSearch(Search.activityBasedSearch(objects)); // Power : 251 - Volume : 153
		solver.setSearch(Search.inputOrderUBSearch(objects)); // Power : 309 - Volume : 165
//		 solver.setSearch(Search.intVarSearch(objects)); // Power : 222 - Volume : 150
//		 solver.setSearch(Search.randomSearch(objects, System.currentTimeMillis())); // RANDOM
		
		if (solver.solve()) {
			for (int i = 0; i < objects.length; i++)
				System.out.println(objects[i]);
			solver.printStatistics();
			solver.showSolutions();
			
			System.out.println("Power : " + profit.getValue());
			System.out.println("Volume : " + weight.getValue());
		}
	}

}
