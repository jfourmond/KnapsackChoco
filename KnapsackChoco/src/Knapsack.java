import java.io.IOException;

import data.DataReader;
import data.DataReaderException;
import solver.KnapsackSolver;
import solver.KnapsackSolverDefaultStrategy;
import solver.KnapsackSolverExistingConstraint;
import solver.KnapsackSolverInputOrderUBSearch;

public class Knapsack {

	public static void main(String[] args) {

		DataReader data = null;

		try {
			data = new DataReader("data/p01/p01_w.txt", "data/p01/p01_p.txt", "data/p01/p01_c.txt");

			// p02 : Max profit : 26
			// data = new DataReader("data/p02/p02_w.txt", "data/p02/p02_p.txt", "data/p02/p02_c.txt");

			// p08 : Max profit : 13549094
			// data = new DataReader("data/p08/p08_w.txt", "data/p08/p08_p.txt",
			// "data/p08/p08_c.txt");

		} catch (IOException e) {
			e.printStackTrace();
		} catch (DataReaderException e) {
			e.printStackTrace();
		}

		System.out.println("\nWith KnapsackSolverInputOrderUBSearch");
		KnapsackSolver solver = new KnapsackSolverInputOrderUBSearch(data.getNbItems(), data.getCapacity(), data.getWeightsTab(),
				data.getProfitsTab());
		solver.solve();

		System.out.println("\nWith KnapsackSolverDefaultStrategy");
		KnapsackSolver solver2 = new KnapsackSolverDefaultStrategy(data.getNbItems(), data.getCapacity(),
				data.getWeightsTab(), data.getProfitsTab());
		solver2.solve();

		System.out.println("\nWith KnapsackSolverExistingConstraint");
		KnapsackSolver solver3 = new KnapsackSolverExistingConstraint(data.getNbItems(),
				data.getCapacity(), data.getWeightsTab(), data.getProfitsTab());
		solver3.solve();
	}

}
