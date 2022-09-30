package Excercise_2;

public class Main {
	public static void main(String[] args) {
		Validation v = new Validation();
		Person p = new Person();
		Wallet w = new Wallet();
		System.out.println("======= Shopping program ==========");
        System.out.print("input number of bill: ");
        int numBills = v.getInteger();
        int[] bills = new int[numBills];
        for (int i = 0; i < bills.length; i++) {
			System.out.print("input value of bill "+(i+1)+": ");
			bills[i] = v.getInteger();		
		}
        int totalbill = p.calcTotal(bills);
        System.out.print("input value of wallet: ");
        int wallet = v.getInteger();
        w.setMoney(wallet);
        System.out.println("this is total of bill: "+totalbill);
        if(w.Payment(totalbill)) {
        	System.out.println("You can buy it.");
        }else {
        	System.out.println("You can’t buy it.");
        }
	}
}
