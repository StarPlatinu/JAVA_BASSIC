package com.training.sevices;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.training.validation.Validation;

public class Manager {
	private Validation v = new Validation();

	public static int countWordInFile(String fileSource, String word) {
		FileReader fr = null;

		try {
			fr = new FileReader(fileSource);
			BufferedReader br = new BufferedReader(fr);
			String line = br.readLine();
			int count = 0;
			while (line != null) {
				String[] parts = line.split(" ");
				for (String w : parts) {
					if (w.equalsIgnoreCase(word)) {
						count++;
					}
				}
				line = br.readLine();
			}
			return count;
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			try {
				fr.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return 0;
	}

	public static void getFileNameContainsWordInDirectory(String source, String word) {
		File folder = new File(source);
		File[] listOfFiles = folder.listFiles();

		for (File file : listOfFiles) {
			if (file.isFile()) {
				if (countWordInFile(file.getAbsolutePath(), word) != 0) {
					System.out.println("file name: " + file.getName());
				}
			}
		}
	}
}
