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

public class ManagerManagement {
	private static final String STRING_VALID = "[A-Za-z\\s]+";
	private static final String MNID_VALID = "^MN[0-9]{3}$";

	private List<Manager> listOfManager = new ArrayList<>();

	public void inputData() {
		Validation v = new Validation();
			Manager manager = new Manager(v.inputString("Enter Manager Id: ", MNID_VALID),
					v.inputString("Enter fullname: ", STRING_VALID),
					v.inputDate("Enter date of birth: "),
					v.inputString("Enter gender: ", STRING_VALID), 
					v.inputString("Enter address: ", STRING_VALID),
					v.inputString("Enter department", STRING_VALID));
			listOfManager.add(manager);
	}

	public void save() {
		String fname = "src/fa/training/services/manager.txt";
		String st = "";
		for (Manager m : listOfManager) {
			st += m.getMnId() + ";" + m.getFullName() + ";" + m.getDateOfBirth() + ";" + m.getGender() + ";"
					+ m.getAddress() + ";" + m.getDepartment() + "\n";
		}
		try {
			PrintWriter pt = new PrintWriter(fname);
			pt.print(st);
			pt.close();
		} catch (FileNotFoundException ex) {
			System.out.println(ex);
		}
	}

	public List<Manager> findAll() throws ParseException {
		listOfManager.clear();
		// read file
		String fname = "src/fa/training/services/manager.txt";
		String line;
		try {
			BufferedReader br = new BufferedReader(new FileReader(new File(fname)));
			while ((line = br.readLine()) != null) {
				String[] s = line.split(";");		
				 
				Manager m = new Manager(s[0], s[1], s[2], s[3], s[4], s[5]);
				listOfManager.add(m);
			}
			br.close();
		} catch (FileNotFoundException ex) {
			System.out.println(ex);
		} catch (IOException ex) {
			System.out.println(ex);
		} catch (NumberFormatException e) {
			System.out.println(e);
		}

		return listOfManager;
	}

	public void display() throws ParseException {
		List<Manager>  list = findAll();
		for (Manager manager : list) {
			System.out.println(manager.toString());
		}
	}

	public Manager findByDepartment(String department) throws ParseException {
		String fname = "src/fa/training/services/manager.txt";
		String line;
		try {
			BufferedReader br = new BufferedReader(new FileReader(new File(fname)));
			while ((line = br.readLine()) != null) {
				String[] s = line.split(";");
				Manager m = new Manager(s[0], s[1], s[2], s[3], s[4], s[5]);	
				if(m.getDepartment().equalsIgnoreCase(department)) {
					return m;
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
		return null;
	}

}
