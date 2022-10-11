package Java_Collections;
/*
 * A Map doesn't allow duplicate keys, but you can have duplicate values. 
 * HashMap and LinkedHashMap allow null keys and values, but TreeMap doesn't allow any null key or value.
 */
import java.util.*;  
public class JavaCollection_Map {
public static void main(String[] args) {
	Map map=new HashMap();  
    //Adding elements to map  
    map.put(1,"Amit");  
    map.put(5,"Rahul");  
    map.put(2,"Jai");  
    map.put(6,"Amit");  
    //Traversing Map  
    Set set=map.entrySet();//Converting to Set so that we can traverse  
    Iterator itr=set.iterator();  
    while(itr.hasNext()){  
        //Converting to Map.Entry so that we can get key and value separately  
        Map.Entry entry=(Map.Entry)itr.next();  
        System.out.println(entry.getKey()+" "+entry.getValue());  
    }
    
    System.out.println("Returns a Set view of the mappings contained in this map ");   
    map.entrySet()  
    //Returns a sequential Stream with this collection as its source  
    .stream()  
    //Sorted according to the provided Comparator  
    .sorted(Map.Entry.comparingByKey())  
    //Performs an action for each element of this stream  
    .forEach(System.out::println);  
    System.out.println("----------comparingByValue()-----------");
    //Returns a Set view of the mappings contained in this map    
    map.entrySet()  
    //Returns a sequential Stream with this collection as its source  
    .stream()  
    //Sorted according to the provided Comparator  
    .sorted(Map.Entry.comparingByValue())  
    //Performs an action for each element of this stream  
    .forEach(System.out::println);  
    
}
}
