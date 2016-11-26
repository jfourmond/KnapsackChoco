package solver;

import org.chocosolver.solver.Model;
import org.chocosolver.solver.Solver;
import org.chocosolver.solver.variables.IntVar;

public class KnapsackSolverExistingConstraint {

	private int capacity;
	private int[] weights;
	private int[] profits;

	private int n;

	Model model;

	public KnapsackSolverExistingConstraint(int _nbItems, int _capacity, int[] _weights, int[] _profits) {

		this.capacity = _capacity;
		this.weights = _weights;
		this.profits = _profits;
		this.n = _nbItems;
	}

	public void solve() {

		// 1. Modelling part
		model = new Model("KNAPSACK PROBLEM WITH EXISTING CONSTRAINT");

		IntVar[] occurences = new IntVar[this.n];
		for (int i = 0; i < this.n; i++) {
			occurences[i] = model.intVar(0, 1);
		}

		IntVar weightSum = model.intVar(0, this.capacity, true);
		IntVar energySum = model.intVar(0, 920);

		model.knapsack(occurences, weightSum, energySum, this.weights, this.profits).post();

		// 2. Solving part
		Solver solver = model.getSolver();

		if (solver.solve()) {

			for (int i = 0; i < this.n; i++)
				System.out.println(occurences[i].getValue());

			solver.printStatistics();
			solver.showSolutions();

			System.out.println("Power : " + energySum.getValue());
			System.out.println("Volume : " + weightSum.getValue());
		}
	}
}
