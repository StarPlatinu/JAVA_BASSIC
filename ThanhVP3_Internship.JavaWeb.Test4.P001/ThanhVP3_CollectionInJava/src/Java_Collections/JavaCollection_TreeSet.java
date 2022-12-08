package Java_Collections;

import java.util.*;
/*
 * Java TreeSet class implements the Set interface that uses a tree for storage.
 *  It inherits AbstractSet class and implements the NavigableSet interface. The objects of the TreeSet class are stored in ascending order.

The important points about the Java TreeSet class are:

Java TreeSet class contains unique elements only like HashSet.
Java TreeSet class access and retrieval times are quiet fast.
Java TreeSet class doesn't allow null element.
Java TreeSet class is non synchronized.
Java TreeSet class maintains ascending order.
Java TreeSet class contains unique elements only like HashSet.
Java TreeSet class access and retrieval times are quite fast.
Java TreeSet class doesn't allow null elements.
Java TreeSet class is non-synchronized.
Java TreeSet class maintains ascending order.
The TreeSet can only allow those generic types that are comparable. 
For example The Comparable interface is being implemented by the StringBuffer class.
 */

public class JavaCollection_TreeSet {
	public static void main(String[] args) {
		// Creating and adding elements
		TreeSet<String> set = new TreeSet<String>();
		set.add("Ravi");
		set.add("Vijay");
		set.add("Ravi");
		set.add("Ajay");
		// traversing elements
		Iterator<String> itr = set.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}

		System.out.println("----------Traversing element through Iterator in descending order----------");
		Iterator i = set.descendingIterator();
		while (i.hasNext()) {
			System.out.println(i.next());
		}
		System.out.println("------------Lowest Highest----------");
		TreeSet<Integer> set2 = new TreeSet<Integer>();
		set2.add(24);
		set2.add(66);
		set2.add(12);
		set2.add(15);
		System.out.println("Lowest Value: " + set2.pollFirst());
		System.out.println("Highest Value: " + set2.pollLast());
		System.out.println("----------NavigableSet----------");
		TreeSet<String> set3=new TreeSet<String>();  
        set3.add("A");  
        set3.add("B");  
        set3.add("C");  
        set3.add("D");  
        set3.add("E");  
        System.out.println("Initial Set: "+set3);  
          
        System.out.println("Reverse Set: "+set3.descendingSet());  
          
        System.out.println("Head Set: "+set3.headSet("C", true));  
         
        System.out.println("SubSet: "+set3.subSet("A", false, "E", true));  
          
        System.out.println("TailSet: "+set3.tailSet("C", false));  
        System.out.println("----------TreSet Object---------");
        Set<Book> set4=new TreeSet<Book>();    
        //Creating Books    
        Book b1=new Book(121,"Let us C","Yashwant Kanetkar","BPB",8);    
        Book b2=new Book(233,"Operating System","Galvin","Wiley",6);    
        Book b3=new Book(101,"Data Communications & Networking","Forouzan","Mc Graw Hill",4);    
        //Adding Books to TreeSet    
        set4.add(b1);    
        set4.add(b2);    
        set4.add(b3);    
        //Traversing TreeSet    
        for(Book b:set4){    
        System.out.println(b.id+" "+b.name+" "+b.author+" "+b.publisher+" "+b.quantity);    
        }    
	}
}
