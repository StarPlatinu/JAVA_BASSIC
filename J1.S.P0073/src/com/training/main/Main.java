package com.training.main;

import com.training.services.ExpenseList;
import com.training.utils.Validation;

public class Main {
public static void main(String[] args) {
	  Validation check = new Validation();
      ExpenseList handyExpense = new ExpenseList();
      while (true) {
    	  System.out.println("=======Handy Expense program======");
          System.out.println("1. Add an expense");
          System.out.println("2. Display all expense");
          System.out.println("3. Delete an expense");
          System.out.println("4. Quit");
          int option = check.inputInt("Your choice: ", 1, 4);
          switch (option) {
              case 1:
            	  System.out.println("-------- Add an expense--------");
                  handyExpense.addExpense();
                  break;
              case 2:
            	  System.out.println("---------Display all expenses------------");
                  handyExpense.display();
                  break;
              case 3:
            	  System.out.println("---------Delete an expenses------------");
                  handyExpense.removeExpense();
                  break;
              case 4:
                  System.exit(0);
          }
      }
}
}
