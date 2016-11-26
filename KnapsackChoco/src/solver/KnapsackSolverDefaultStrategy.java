package solver;

import org.chocosolver.solver.Model;
import org.chocosolver.solver.Solver;
import org.chocosolver.solver.variables.IntVar;

public class KnapsackSolverDefaultStrategy {

	private int capacity;
	private int[] weights;
	private int[] profits;

	private int n;

	private Model model;

	public KnapsackSolverDefaultStrategy(int nbItems, int capacity, int[] weights, int[] profits) {

		this.capacity = capacity;
		this.weights = weights;
		this.profits = profits;
		this.n = nbItems;
	}

	public void solve() {
		model = new Model("KNAPSACK PROBLEM WITH DEFAULT STRATEGY");

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