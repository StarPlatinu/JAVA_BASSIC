package exercise1;

public class SumIntNumber {
	 static double SumInt(double m,double n) {	 
	  if(m>n) {
		double temp = m;
		m = n;
		n = temp;
	  }
	  int sum =0;
	  while(m<=n) {
		sum+=m;
		m++;
	  }
  	   return sum;
     }
	 static double SumInt2(double m,double n) {	 
		  if(m>n) {
			double temp = m;
			m = n;
			n = temp;
		  }
		  double sum = (m+n)/2*(n - m +1);
	  	   return sum;
	     }

	public static void main(String[] args) {
		System.out.println("Sum of m to n: "+SumInt(0, 9));
		System.out.println("Sum of m to n: "+SumInt2(0, 10));
	}

}
