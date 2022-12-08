package Java_Collections;
import java.util.*;  
/*
 Java Hashtable class implements a hashtable, which maps keys to values. 
 It inherits Dictionary class and implements the Map interface.

Points to remember
A Hashtable is an array of a list. Each list is known as a bucket. The position of the bucket is identified by calling the hashcode() method. A Hashtable contains values based on the key.
Java Hashtable class contains unique elements.
Java Hashtable class doesn't allow null key or value.
Java Hashtable class is synchronized.
The initial default capacity of Hashtable class is 11 whereas loadFactor is 0.75.
 */
public class JavaCollection_HashTable {
public static void main(String[] args) {
	Hashtable<Integer,String> map=new Hashtable<Integer,String>();        
    map.put(100,"Amit");    
    map.put(102,"Ravi");   
    map.put(101,"Vijay");    
    map.put(103,"Rahul");    
    System.out.println("Before remove: "+ map);    
      // Remove value for key 102  
      map.remove(102);  
      System.out.println("After remove: "+ map);  
      System.out.println("------- getOrDefault()-------");
      System.out.println(map.getOrDefault(101, "Not Found"));  
      System.out.println(map.getOrDefault(105, "Not Found"));  
      System.out.println("-------putIfAbsent()---------");
      System.out.println("Initial Map: "+map);  
      //Inserts, as the specified pair is unique  
      map.putIfAbsent(104,"Gaurav");  
      System.out.println("Updated Map: "+map);  
      //Returns the current value, as the specified pair already exist  
      map.putIfAbsent(101,"Vijay");  
      System.out.println("Updated Map: "+map);  
      System.out.println("-------Book--------");
      //Creating map of Books    
      Map<Integer,Book> mapbook=new Hashtable<Integer,Book>();    
      //Creating Books    
      Book b1=new Book(101,"Let us C","Yashwant Kanetkar","BPB",8);    
      Book b2=new Book(102,"Data Communications & Networking","Forouzan","Mc Graw Hill",4);    
      Book b3=new Book(103,"Operating System","Galvin","Wiley",6);    
      //Adding Books to map   
      mapbook.put(1,b1);  
      mapbook.put(2,b2);  
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
