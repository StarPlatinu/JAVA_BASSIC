package Java_Collections;
/*
 * Java HashMap class implements the Map interface which allows us to store key and value pair, 
 * where keys should be unique
 */
import java.util.*;  
public class JavaCollection_HashMap {
public static void main(String[] args) {
	  HashMap<Integer,String> map1=new HashMap<Integer,String>();//Creating HashMap    
	   map1.put(1,"Mango");  //Put elements in Map  
	   map1.put(2,"Apple");    
	   map1.put(3,"Banana");   
	   map1.put(4,"Grapes");   
	       
	   System.out.println("Iterating Hashmap...");  
	   for(Map.Entry m : map1.entrySet()){    
	    System.out.println(m.getKey()+" "+m.getValue());    
	   } 
	   
	   HashMap<Integer,String> hm=new HashMap<Integer,String>();    
	    System.out.println("Initial list of elements: "+hm);  
	      hm.put(100,"Amit");    
	      hm.put(101,"Vijay");    
	      hm.put(102,"Rahul");   
	       
	      System.out.println("After invoking put() method ");  
	      for(Map.Entry m:hm.entrySet()){    
	       System.out.println(m.getKey()+" "+m.getValue());    
	      }  
	        
	      hm.putIfAbsent(103, "Gaurav");  
	      System.out.println("After invoking putIfAbsent() method ");  
	      for(Map.Entry m:hm.entrySet()){    
	           System.out.println(m.getKey()+" "+m.getValue());    
	          }  
	      HashMap<Integer,String> map=new HashMap<Integer,String>();  
	      map.put(104,"Ravi");  
	      map.putAll(hm);  
	      System.out.println("After invoking putAll() method ");  
	      for(Map.Entry m:map.entrySet()){    
	           System.out.println(m.getKey()+" "+m.getValue());    
	          }  
	   System.out.println("---------Java HashMap example to remove() elements--------");
	   //key-based removal  
	    map.remove(100);  
	    System.out.println("Updated list of elements: "+map);  
	    //value-based removal  
	    map.remove(101);  
	    System.out.println("Updated list of elements: "+map);  
	    //key-value pair based removal  
	    map.remove(102, "Rahul");  
	    System.out.println("Updated list of elements: "+map);  
	    System.out.println("----------Java HashMap example to replace() elements----------");
	    System.out.println("Initial list of elements:");  
	     for(Map.Entry m:hm.entrySet())  
	     {  
	        System.out.println(m.getKey()+" "+m.getValue());   
	     }  
	     System.out.println("Updated list of elements:");  
	     hm.replace(102, "Gaurav");  
	     for(Map.Entry m:hm.entrySet())  
	     {  
	        System.out.println(m.getKey()+" "+m.getValue());   
	     }  
	     System.out.println("Updated list of elements:");  
	     hm.replace(101, "Vijay", "Ravi");  
	     for(Map.Entry m:hm.entrySet())  
	     {  
	        System.out.println(m.getKey()+" "+m.getValue());   
	     }   
	     System.out.println("Updated list of elements:");  
	     hm.replaceAll((k,v) -> "Ajay");  
	     for(Map.Entry m:hm.entrySet())  
	     {  
	        System.out.println(m.getKey()+" "+m.getValue());   
	     }  
	     
	     //Creating map of Books    
	     Map<Integer,Book> mapbook=new HashMap<Integer,Book>();    
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
