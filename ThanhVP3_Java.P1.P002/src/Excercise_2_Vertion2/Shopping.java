package Excercise_2_Vertion2;

import java.util.Scanner;

public class Shopping {
	Scanner sc = new Scanner(System.in);

	public float[] inputBills() {
		System.out.print("input number of bill: ");
		int numBills = sc.nextInt();
		float[] bills = new float[numBills];
		for (int i = 0; i < bills.length; i++) {
			System.out.print("input value of bill " + (i + 1) + ": ");
			bills[i] = sc.nextFloat();
		}
		return bills;
	}

	public float calcTotal(float[] bills) {
		float total = 0;
		for (int i = 0; i < bills.length; i++) {
			total += bills[i];
		}
		return total;
	}
	
	public void purchase(float totalBills, Person person) {
		if((person.Payment(totalBills))) {
			System.out.println("You can buy it !");
		}else {
			System.out.println("You can't buy it !");
		}
	}
	
	public static void main(String[] args) {
		Shopping sp = new  Shopping();
		float[] bills = sp.inputBills();
		Person p = new Person();
		System.out.print("input value of wallet: ");
		p.setWallet(new Wallet(new Scanner(System.in).nextFloat())); 
		float totals = sp.calcTotal(bills);
        System.out.printf("this is total of bill:%s\n",totals);
        sp.purchase(totals, p);
        
	}
}
