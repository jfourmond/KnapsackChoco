import java.io.IOException;

import data.DataReader;
import data.DataReaderException;
import solver.*;

public class Knapsack {

	public static void main(String[] args) {
		DataReader data = null;
		try {
			// p01
			// Max profit : 309
			// Max poids : 165
			// OK pour KnapsackSolverInputOrderUBSearch
			// data = new DataReader("data/p01/p01_w.txt", "data/p01/p01_p.txt",
			// "data/p01/p01_c.txt");

			// p02
			// Max profit : 51
			// Max poids : 26
			data = new DataReader("data/p02/p02_w.txt", "data/p02/p02_p.txt",
			 "data/p02/p02_c.txt");

			// p03
			// Max profit : 150
			// Max poids : 190
			// OK avec KnapsackSolverExistingConstraint
			// OK avec KnapsackSolverDefaultStrategy
			// data = new DataReader("data/p03/p03_w.txt", "data/p03/p03_p.txt",
			// "data/p03/p03_c.txt");

			// p04
			// Max profit : 107
			// Max poids : 50
			// data = new DataReader("data/p04/p04_w.txt", "data/p04/p04_p.txt",
			// "data/p04/p04_c.txt");

			// p05
			// Max profit : 900
			// Max poids : 104
			// data = new DataReader("data/p05/p05_w.txt", "data/p05/p05_p.txt",
			// "data/p05/p05_c.txt");

			// p06
			// Max profit : 1735
			// Max poids : 169
			// data = new DataReader("data/p06/p06_w.txt", "data/p06/p06_p.txt",
			// "data/p06/p06_c.txt");

			// p07
			// Max profit : 1458
			// Max poids : 749
			// data = new DataReader("data/p07/p07_w.txt", "data/p07/p07_p.txt",
			// "data/p07/p07_c.txt");

			// p08
			// Max profit : 13 549 094
			// Max poids : 6 402 560
			// data = new DataReader("data/p08/p08_w.txt", "data/p08/p08_p.txt", "data/p08/p08_c.txt");

		} catch (IOException e) {
			e.printStackTrace();
		} catch (DataReaderException e) {
			e.printStackTrace();
		}

		System.out.println("\nWith KnapsackSolverInputOrderUBSearch");
		KnapsackSolver solver1 = new KnapsackSolverInputOrderUBSearch(data.getNbItems(), data.getCapacity(),
				data.getWeightsTab(), data.getProfitsTab());
		// solver1.solve();

		System.out.println("\nWith KnapsackSolverDefaultStrategy");
		KnapsackSolver solver2 = new KnapsackSolverDefaultStrategy(data.getNbItems(), data.getCapacity(),
				data.getWeightsTab(), data.getProfitsTab());
		// solver2.solve();

		System.out.println("\nWith KnapsackSolverExistingConstraint");
		KnapsackSolver solver3 = new KnapsackSolverExistingConstraint(data.getNbItems(), data.getCapacity(),
				data.getWeightsTab(), data.getProfitsTab());
		solver3.solve();

		System.out.println("\nWith KnapsackSolverActivityBasedSearch");
		KnapsackSolver solver4 = new KnapsackSolverActivityBasedSearch(data.getNbItems(), data.getCapacity(),
				data.getWeightsTab(), data.getProfitsTab());
		// solver4.solve();

		System.out.println("\nWith KnapsackSolverMinDomLBSearch");
		KnapsackSolver solver5 = new KnapsackSolverMinDomLBSearch(data.getNbItems(), data.getCapacity(),
				data.getWeightsTab(), data.getProfitsTab());
		// solver5.solve();
	}

}
