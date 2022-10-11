package Java_Collections;

import java.util.*;

/*
 * Java HashSet class is used to create a collection that uses a hash table for storage. 
 * It inherits the AbstractSet class and implements Set interface.

The important points about Java HashSet class are:

HashSet stores the elements by using a mechanism called hashing.
HashSet contains unique elements only.
HashSet allows null value.
HashSet class is non synchronized.
HashSet doesn't maintain the insertion order. Here, elements are inserted on the basis of their hashcode.
HashSet is the best approach for search operations.
The initial default capacity of HashSet is 16, and the load factor is 0.75.
Difference between List and Set
A list can contain duplicate elements whereas Set contains unique elements only.

Hierarchy of HashSet class
The HashSet class extends AbstractSet class which implements Set interface. 
The Set interface inherits Collection and Iterable interfaces in hierarchical order.


HashSet class declaration
Let's see the declaration for java.util.HashSet class.
 */

public class JavaCollection_HashSet {
	public static void main(String[] args) {
		  HashSet<String> set=new HashSet<String>();  
          set.add("Ravi");  
          set.add("Vijay");  
          set.add("Arun");  
          set.add("Sumit");  
          System.out.println("An initial list of elements: "+set);  
          //Removing specific element from HashSet  
          set.remove("Ravi");  
          System.out.println("After invoking remove(object) method: "+set);  
          HashSet<String> set1=new HashSet<String>();  
          set1.add("Ajay");  
          set1.add("Gaurav");  
          set.addAll(set1);  
          System.out.println("Updated List: "+set);  
          //Removing all the new elements from HashSet  
          set.removeAll(set1);  
          System.out.println("After invoking removeAll() method: "+set);  
          //Removing elements on the basis of specified condition  
          set.removeIf(str->str.contains("Vijay"));    
          System.out.println("After invoking removeIf() method: "+set);  
          //Removing all the elements available in the set  
          set.clear();  
          System.out.println("After invoking clear() method: "+set);  
          System.out.println("-------------Java HashSet from another Collection--------------");
          ArrayList<String> list=new ArrayList<String>();  
          list.add("Ravi");  
          list.add("Vijay");  
          list.add("Ajay");  
          HashSet<String> set2=new HashSet(list);  
          set.add("Gaurav");  
          Iterator<String> i=set2.iterator();  
          while(i.hasNext())  
          {  
          System.out.println(i.next());  
          }  
          System.out.println("----------HashSet Object----------");
          HashSet<Book> set3=new HashSet<Book>();  
          //Creating Books  
          Book b1=new Book(101,"Let us C","Yashwant Kanetkar","BPB",8);  
          Book b2=new Book(102,"Data Communications & Networking","Forouzan","Mc Graw Hill",4);  
          Book b3=new Book(103,"Operating System","Galvin","Wiley",6);  
          //Adding Books to HashSet  
          set3.add(b1);  
          set3.add(b2);  
          set3.add(b3);  
          //Traversing HashSet  
          for(Book b:set3){  
          System.out.println(b.id+" "+b.name+" "+b.author+" "+b.publisher+" "+b.quantity);  
          }  
		
	}
}
