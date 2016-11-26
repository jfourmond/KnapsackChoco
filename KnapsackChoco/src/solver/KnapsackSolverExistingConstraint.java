package solver;

import org.chocosolver.solver.Model;
import org.chocosolver.solver.Solver;
import org.chocosolver.solver.variables.IntVar;

public class KnapsackSolverExistingConstraint extends KnapsackSolver {
	public KnapsackSolverExistingConstraint(int _nbItems, int _capacity, int[] _weights, int[] _profits) {
		super(_nbItems, _capacity, _weights, _profits);
	}

	public void solve() {

		// 1. Modelling part
		model = new Model("KNAPSACK PROBLEM WITH EXISTING CONSTRAINT");

		IntVar[] occurences = new IntVar[this.nbItems];
		for (int i = 0; i < this.nbItems; i++) {
			occurences[i] = model.intVar(0, 1);
		}

		IntVar weightSum = model.intVar(0, this.capacity, true);
		IntVar profitSum = model.intVar(0, MAX);

		model.knapsack(occurences, weightSum, profitSum, this.weights, this.profits).post();

		// 2. Solving part
		Solver solver = model.getSolver();

		if (solver.solve()) {
			for (int i = 0; i < this.nbItems; i++)
				System.out.println(occurences[i].getValue());

			solver.printStatistics();
			solver.showSolutions();

			System.out.println("Power : " + profitSum.getValue());
			System.out.println("Volume : " + weightSum.getValue());
		}
	}
}
