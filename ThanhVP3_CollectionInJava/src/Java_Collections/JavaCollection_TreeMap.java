package Java_Collections;
import java.util.*;  
/*
 *Java TreeMap class is a red-black tree based implementation. 
 *It provides an efficient means of storing key-value pairs in sorted order.

The important points about Java TreeMap class are:

Java TreeMap contains values based on the key. It implements the NavigableMap interface and extends AbstractMap class.
Java TreeMap contains only unique elements.
Java TreeMap cannot have a null key but can have multiple null values.
Java TreeMap is non synchronized.
Java TreeMap maintains ascending order.
 */
public class JavaCollection_TreeMap {
	public static void main(String[] args) {
		TreeMap<Integer,String> map=new TreeMap<Integer,String>();    
	      map.put(100,"Amit");    
	      map.put(102,"Ravi");    
	      map.put(101,"Vijay");    
	      map.put(103,"Rahul");    
	      System.out.println("Before invoking remove() method");  
	      for(Map.Entry m:map.entrySet())  
	      {  
	          System.out.println(m.getKey()+" "+m.getValue());      
	      }  
	      map.remove(102);      
	      System.out.println("After invoking remove() method");  
	      for(Map.Entry m:map.entrySet())  
	      {  
	          System.out.println(m.getKey()+" "+m.getValue());      
	      }  
	      System.out.println("-------- NavigableMap----------");
	      //Maintains descending order  
	      System.out.println("descendingMap: "+map.descendingMap());  
	      //Returns key-value pairs whose keys are less than or equal to the specified key.  
	      System.out.println("headMap: "+map.headMap(102,true));  
	      //Returns key-value pairs whose keys are greater than or equal to the specified key.  
	      System.out.println("tailMap: "+map.tailMap(102,true));  
	      //Returns key-value pairs exists in between the specified key.  
	      System.out.println("subMap: "+map.subMap(100, false, 102, true));   
	      System.out.println("---------Book---------");
	      Map<Integer,Book> mapbook=new TreeMap<Integer,Book>();    
	      //Creating Books    
	      Book b1=new Book(101,"Let us C","Yashwant Kanetkar","BPB",8);    
	      Book b2=new Book(102,"Data Communications & Networking","Forouzan","Mc Graw Hill",4);    
	      Book b3=new Book(103,"Operating System","Galvin","Wiley",6);    
	      //Adding Books to map   
	      mapbook.put(2,b2);  
	      mapbook.put(1,b1);  
	      mapbook.put(3,b3);  
	        
	      //Traversing map  
	      for(Map.Entry<Integer, Book> entry:mapbook.entrySet()){    
	          int key=entry.getKey();  
	          Book b=entry.getValue();  
	          System.out.println(key+" Details:");  
	          System.out.println(b.id+" "+b.name+" "+b.author+" "+b.publisher+" "+b.quantity);   
	      }    
	}
}
