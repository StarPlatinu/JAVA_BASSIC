package Java_Collections;
import java.util.*;  
/*
 We can sort the elements of:
String objects
Wrapper class objects
User-defined class objects
 */
public class JavaCollection_Sorting {
	public static void main(String[] args) {
		ArrayList<String> al=new ArrayList<String>();  
		al.add("Viru");  
		al.add("Saurav");  
		al.add("Mukesh");  
		al.add("Tahir");  
		  
		Collections.sort(al);  
		Iterator itr=al.iterator();  
		System.out.println("----Original-----");
		while(itr.hasNext()){  
		System.out.println(itr.next());  
		 }  
		System.out.println("----ReverOrder------");
		   Collections.sort(al,Collections.reverseOrder());  
	        Iterator i=al.iterator();  
	        while(i.hasNext())  
	        {  
	            System.out.println(i.next());  
	        }  
	        System.out.println("----SortStudent----");
	        ArrayList<Student> alStudent=new ArrayList<Student>();  
	        alStudent.add(new Student("Viru"));  
	        alStudent.add(new Student("Saurav"));  
	        alStudent.add(new Student("Mukesh"));  
	        alStudent.add(new Student("Tahir"));  
	        
	      Collections.sort(al);  
	      for (Student s : alStudent) {  
	        System.out.println(s.name);  
	      }  
	}
}
