import java.io.IOException;

import data.DataReader;
import data.DataReaderException;

public class Knapsack {

	public static void main(String[] args) {
		try {
			new DataReader("data/p01/p01_w.txt", "data/p01/p01_p.txt", "data/p01/p01_c.txt");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (DataReaderException e) {
			e.printStackTrace();
		}
	}

}
