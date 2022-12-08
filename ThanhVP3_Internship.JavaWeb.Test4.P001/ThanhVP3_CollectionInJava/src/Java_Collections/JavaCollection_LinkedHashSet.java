package Java_Collections;
import java.util.*;  
/*
 Java LinkedHashSet class is a Hashtable and Linked list implementation of the Set interface.
  It inherits the HashSet class and implements the Set interface.

The important points about the Java LinkedHashSet class are:

Java LinkedHashSet class contains unique elements only like HashSet.
Java LinkedHashSet class provides all optional set operations and permits null elements.
Java LinkedHashSet class is non-synchronized.
Java LinkedHashSet class maintains insertion order.
 */
public class JavaCollection_LinkedHashSet {
	public static void main(String[] args) {
		//Creating HashSet and adding elements  
        LinkedHashSet<String> set=new LinkedHashSet();  
               set.add("One");    
               set.add("Two");    
               set.add("Three");   
               set.add("Four");  
               set.add("Five");  
               Iterator<String> i=set.iterator();  
               while(i.hasNext())  
               {  
               System.out.println(i.next());  
               }  
            // Creating an empty LinekdhashSet of string type  
               LinkedHashSet<String> lhs = new LinkedHashSet<String>();  
                 
               // Adding elements to the above Set  
               // by invoking the add() method  
               lhs.add("Java");  
               lhs.add("T");  
               lhs.add("Point");  
               lhs.add("Good");  
               lhs.add("Website");  
                 
               // displaying all the elements on the console  
               System.out.println("The hash set is: " + lhs);  
                 
               // Removing an element from the above linked Set  
                 
               // since the element "Good" is present, therefore, the method remove()  
               // returns true  
               System.out.println(lhs.remove("Good"));  
                 
               // After removing the element  
               System.out.println("After removing the element, the hash set is: " + lhs);  
                 
               // since the element "For" is not present, therefore, the method remove()  
               // returns false  
               System.out.println(lhs.remove("For"));        
               System.out.println("------Object Book---------");
               LinkedHashSet<Book> hs=new LinkedHashSet<Book>();  
               //Creating Books  
               Book b1=new Book(101,"Let us C","Yashwant Kanetkar","BPB",8);  
               Book b2=new Book(102,"Data Communications & Networking","Forouzan","Mc Graw Hill",4);  
               Book b3=new Book(103,"Operating System","Galvin","Wiley",6);  
               //Adding Books to hash table  
               hs.add(b1);  
               hs.add(b2);  
               hs.add(b3);  
               //Traversing hash table  
               for(Book b:hs){  
               System.out.println(b.id+" "+b.name+" "+b.author+" "+b.publisher+" "+b.quantity);  
               }  
	}
}
