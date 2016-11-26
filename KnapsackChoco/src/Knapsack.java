import java.io.IOException;

import data.DataReader;
import data.DataReaderException;
import solver.KnapsackSolver;
import solver.KnapsackSolverExistingConstraint;

public class Knapsack {

	public static void main(String[] args) {

		DataReader data = null;

		try {
			data = new DataReader("data/p01/p01_w.txt", "data/p01/p01_p.txt", "data/p01/p01_c.txt");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (DataReaderException e) {
			e.printStackTrace();
		}

		System.out.println("\nWith KnapsackSolver");
		KnapsackSolver solver = new KnapsackSolver(data.getNbItems(), data.getCapacity(), data.getWeightsTab(),
				data.getProfitsTab());
		solver.solve();

		System.out.println("\nWith KnapsackSolverExistingConstraint");
		KnapsackSolverExistingConstraint solver2 = new KnapsackSolverExistingConstraint(data.getNbItems(),
				data.getCapacity(), data.getWeightsTab(), data.getProfitsTab());
		solver.solve();
	}

}
