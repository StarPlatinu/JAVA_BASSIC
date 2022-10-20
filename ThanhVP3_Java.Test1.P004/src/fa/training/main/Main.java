package fa.training.main;

import fa.training.services.ManagerManagement;
import fa.training.services.WorkerManagement;
import fa.training.utils.Validation;

import java.text.ParseException;
import java.util.List;

import fa.training.entities.*;

public class Main {
	public static void main(String[] args) throws ParseException {
		ManagerManagement m = new ManagerManagement();
		WorkerManagement w = new WorkerManagement();
		Validation v = new Validation();
		  while(true){
	          System.out.println("1.Add new list of manager ");
	          System.out.println("2.Display all manager");
	          System.out.println("3.Find existed manager by department");
	          System.out.println("4.Add a new list of worker");
	          System.out.println("5.Find existed worker by level");
	          System.out.println("6. Exit.");
	            int chose = v.inputInt("Enter your choise: ", 1, 6);
	            switch (chose) {
	                
	                case 1:
	                 System.out.println("====================Add new list of manager==================");
	                 m.inputData();
	                 m.save();
	                 break;
	                case 2:
	                   System.out.println("==================Display all manager==================");
	                   m.display();
	                 break;
	                case 3:
	                    System.out.println("====================Find existed manager by department=================");
	                    String department = v.inputString("Enter department: ", "[A-Za-z\\s]+");
	                   System.out.println( m.findByDepartment(department).toString());
	                    break;
	                case 4:
	                   System.out.println("=================Add a new list of worker====================");
	                   w.inputData();
	                   w.save();
	                 break;
	                case 5:
		                   System.out.println("======================Find existed worker by level===================");
		                   int level = v.inputInt("Enter level:", 0, 7);
		                   List<Worker> list = w.findByLevel(level);
		                   for (Worker worker : list) {
							System.out.println(worker.toString());
						}
		                   break;
	                case 6:
		               System.exit(0);    
		                 break;

	                
	            }
		  }
	}
}
