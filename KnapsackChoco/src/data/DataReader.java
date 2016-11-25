package data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class DataReader {
	private int capacity;
	private List<Integer> profits;
	private List<Integer> weights;
	
	private File fileWeight;
	private File fileProfit;
	private File fileCapacity;
	
	public DataReader(String pathWeight, String pathProfit, String pathCapacity) throws IOException, DataReaderException {
		fileWeight = new File(pathWeight);
		fileProfit = new File(pathProfit);
		fileCapacity = new File(pathCapacity);
		
		profits = new ArrayList<>();
		weights = new ArrayList<>();
		
		readWeight();
		System.out.println("Poids : " + weights);
		readProfit();
		System.out.println("Profit : " + profits);
		readCapacity();
		System.out.println("Capacité : " + capacity);
		
		validate();
		System.out.println("Données validées.");
	}
	
	//	GETTERS
	public int getCapacity() { return capacity; }
	
	public List<Integer> getProfits() { return profits; }
	
	public Integer[] getProfitsTab() { return (Integer[]) profits.toArray(); }
	
	public List<Integer> getWeights() { return weights; }
	
	public Integer[] getWeightsTab() { return (Integer[]) weights.toArray(); }
	
	//	METHODES
	private void readWeight() throws IOException {
		System.out.println("Lecture Poids");
		FileInputStream fileInputStreamWeight = new FileInputStream(fileWeight);
		BufferedReader br = new BufferedReader(new InputStreamReader(fileInputStreamWeight));
		String line = null;
		while ((line = br.readLine()) != null)
			weights.add(Integer.parseInt(line.trim()));
		br.close();
	}
	
	private void readProfit() throws IOException {
		System.out.println("Lecture Profit");
		FileInputStream fileInputStreamProfit = new FileInputStream(fileProfit);
		BufferedReader br = new BufferedReader(new InputStreamReader(fileInputStreamProfit));
		String line = null;
		while ((line = br.readLine()) != null)
			profits.add(Integer.parseInt(line.trim()));
		br.close();
	}
	
	private void readCapacity() throws IOException {
		System.out.println("Lecture Capacité");
		FileInputStream fileInputStreamCapacity = new FileInputStream(fileCapacity);
		BufferedReader br = new BufferedReader(new InputStreamReader(fileInputStreamCapacity));
		String line = null;
		while ((line = br.readLine()) != null)
			capacity = Integer.parseInt(line.trim());
		br.close();
	}
	
	private void validate() throws DataReaderException {
		if(profits.size() != weights.size())
			throw new DataReaderException("Les fichiers ne contiennent pas le même nombre de valeur.");
	}
}
