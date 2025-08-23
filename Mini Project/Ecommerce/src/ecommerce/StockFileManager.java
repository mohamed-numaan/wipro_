package ecommerce;

import java.io.*;
import java.util.*;

public class StockFileManager {

	private static final String STOCK_FILE = "stock.txt";

	// Load stock from file or create default
	public static Map<String, Integer> loadStock() {
		Map<String, Integer> stockMap = new HashMap<>();

		// Default values
		stockMap.put("P1001", 10); // iPhone
		stockMap.put("C1002", 10); // Shirt
		stockMap.put("B1003", 10); // Book
		stockMap.put("F1004", 10); // Furniture

		File file = new File(STOCK_FILE);
		if (!file.exists()) {
			saveStock(stockMap); // Save default if file missing
			return stockMap;
		}

		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String line;
			while ((line = br.readLine()) != null) {
				String[] parts = line.split("=");
				if (parts.length == 2) {
					stockMap.put(parts[0].trim(), Integer.parseInt(parts[1].trim()));
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return stockMap;
	}

	// Save current stock map to file
	public static void saveStock(Map<String, Integer> stockMap) {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(STOCK_FILE))) {
			for (Map.Entry<String, Integer> entry : stockMap.entrySet()) {
				bw.write(entry.getKey() + "=" + entry.getValue());
				bw.newLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Reset all stocks to 10 manually
	public static void resetStock() {
		Map<String, Integer> resetMap = new HashMap<>();
		resetMap.put("P1001", 10);
		resetMap.put("C1002", 10);
		resetMap.put("B1003", 10);
		resetMap.put("F1004", 10);
		saveStock(resetMap);
		System.out.println("🔁 Stock reset to default (10) for all products.");
	}
}
