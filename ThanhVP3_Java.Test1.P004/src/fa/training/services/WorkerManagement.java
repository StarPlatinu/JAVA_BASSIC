package fa.training.services;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import fa.training.entities.*;
import fa.training.utils.Validation;

public class WorkerManagement {
	private List<Worker> listOfWorker = new ArrayList<>();
	private static final String STRING_VALID = "[A-Za-z\\s]+";
	private static final String WOID_VALID = "^WO[0-9]{3}$";

	public void inputData() {
		Validation v = new Validation();	
			Worker worker = new Worker(v.inputString("Enter Worker Id: ", WOID_VALID),
					v.inputInt("Enter work level: ", 0, 7),
					v.inputString("Enter fullname: ", STRING_VALID), v.inputDate("Enter date of birth: "),
					v.inputString("Enter gender: ", STRING_VALID), v.inputString("Enter address: ", STRING_VALID));
			listOfWorker.add(worker);
	}

	public void save() {
		String fname = "src/fa/training/services/worker.txt";
		String st = "";
		for (Worker w : listOfWorker) {
			st += w.getWoId() + ";" + w.getWorkerLevel() +";" + w.getFullName() + ";" + w.getDateOfBirth() + ";" + w.getGender() + ";"
					+ w.getAddress() + "\n";
		}
		try {
			PrintWriter pt = new PrintWriter(fname);
			pt.print(st);
			pt.close();
		} catch (FileNotFoundException ex) {
			System.out.println(ex);
		}
	}

	public List<Worker> findAll() throws ParseException {
		listOfWorker.clear();
		// read file
				String fname = "src/fa/training/services/worker.txt";
				String line;
				try {
					BufferedReader br = new BufferedReader(new FileReader(new File(fname)));
					while ((line = br.readLine()) != null) {
						String[] s = line.split(";");  
					      Worker w = new Worker(s[0], Integer.parseInt(s[1]), s[2], s[3], s[4], s[4]);
						listOfWorker.add(w);
					}
					br.close();
				} catch (FileNotFoundException ex) {
					System.out.println(ex);
				} catch (IOException ex) {
					System.out.println(ex);
				} catch (NumberFormatException e) {
					System.out.println(e);
				}

		return listOfWorker;
	}

	public List<Worker> findByLevel(int level) throws ParseException {
		String fname = "src/fa/training/services/worker.txt";
		String line;
		List<Worker> list = new ArrayList<>();
		try {
			BufferedReader br = new BufferedReader(new FileReader(new File(fname)));
			while ((line = br.readLine()) != null) {
				String[] s = line.split(";");
				
			      Worker w = new Worker(s[0], Integer.parseInt(s[1]), s[2], s[3], s[4], s[4]);
				if(w.getWorkerLevel() == level) {
					list.add(w);
				}
			}
			br.close();
		} catch (FileNotFoundException ex) {
			System.out.println(ex);
		} catch (IOException ex) {
			System.out.println(ex);
		} catch (NumberFormatException e) {
			System.out.println(e);
		}

		return list;
	}
}
