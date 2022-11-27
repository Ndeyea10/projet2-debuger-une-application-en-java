package com.hemebiotech.analytics;

import java.io.*;
import java.util.*;

public class AnalyticsCounter {
	/**
	 *
	 * @param symptoms list and creates a TreeMap to check for each symptom the number of occurrences
	 * @return the list of different symptoms with their occurrence.
	 */
	public TreeMap<String,Integer> countSymptoms(List<String> symptoms) {

		TreeMap<String, Integer> listSymptoms = new TreeMap<>();
		if (listSymptoms != null) {
			for (String symptom : symptoms) {
				if (!listSymptoms.containsKey(symptom)){
					listSymptoms.put(symptom, 1);
				}
				else {
					int value = listSymptoms.get(symptom);
					value++;
					listSymptoms.put(symptom, value);
				}
			}
		}

		return listSymptoms;

	}

	/**
	 *
	 * @param symptoms a TreeMap containing the different symptoms and their occurrence
	 *        			in order to write them in a text file.
	 * @throws IOException
	 */
	public void writeResultInFile(TreeMap<String, Integer> symptoms ) throws IOException {

		FileWriter writer = new FileWriter ("result.txt");
		for(Map.Entry<String, Integer> entry: symptoms.entrySet()){
			writer.write(entry.getKey() +": " +entry.getValue());
			writer.write('\n');
		}
		writer.close();
	}

	public List<String> readFile(){
		ReadSymptomDataFromFile read = new ReadSymptomDataFromFile("symptoms.txt");
		List<String> listSymptoms = read.GetSymptoms();
		System.out.println(listSymptoms+ "\n");
		return listSymptoms;
	}
}

