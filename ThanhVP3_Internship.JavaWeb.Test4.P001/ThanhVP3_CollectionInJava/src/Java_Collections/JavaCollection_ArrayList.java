package Java_Collections;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.*;
/*
 * Java ArrayList class uses a dynamic array for storing the elements. 
 * It is like an array, but there is no size limit.
 */

class JavaCollection_ArrayList {
	public static void main(String args[]) {
		ArrayList<String> list = new ArrayList<String>();// Creating arraylist
		list.add("Mango");// Adding object in arraylist
		list.add("Apple");
		list.add("Banana");
		list.add("Grapes");
		// Printing the arraylist object
		System.out.println(list);
		System.out.println("----------Use Iterator----------");
		// Traversing list through Iterator
		Iterator itr = list.iterator();// getting the Iterator
		while (itr.hasNext()) {// check if iterator has the elements
			System.out.println(itr.next());// printing the element and move to next
		}
		System.out.println("----------For-Each----------");
		// Traversing list through for-each loop
		for (String fruit : list) {
			System.out.println(fruit);
		}
		// accessing the element
		System.out.println("Returning element: " + list.get(1));// it will return the 2nd element, because index starts
																// from 0
		// changing the element
		list.set(1, "Dates");
		// Traversing list
		System.out.println("---------List-AfterSet----------");
		for (String fruit : list) {
			System.out.println(fruit);
		}
		System.out.println("----------List-AfterSort----------");
		Collections.sort(list);
		for (String fruit : list) {
			System.out.println(fruit);
		}
		System.out.println("----------Remove Element----------");
		list.remove(1);
		for (String fruit : list) {
			System.out.println(fruit);
		}
		
		System.out.println("---------ArrayListObject----------");
		  //Creating user-defined class objects  
		  Student s1=new Student(101,"Sonoo",23);  
		  Student s2=new Student(102,"Ravi",21);  
		  Student s3=new Student(103,"Hanumat",25);  
		  //creating arraylist  
		  ArrayList<Student> al=new ArrayList<Student>();  
		  al.add(s1);//adding Student class object  
		  al.add(s2);  
		  al.add(s3);  
		  //Getting Iterator  
		  Iterator itr2=al.iterator();  
		  //traversing elements of ArrayList object  
		  while(itr2.hasNext()){  
		    Student st=(Student)itr2.next();  
		    System.out.println(st.rollno+" "+st.name+" "+st.age);  
		  }
		  System.out.println("----------Serialization and Deserialization---------");
		  try  
          {  
              //Serialization  
              FileOutputStream fos=new FileOutputStream("file");  
              ObjectOutputStream oos=new ObjectOutputStream(fos);  
              oos.writeObject(list);  
              fos.close();  
              oos.close();  
              //Deserialization  
              FileInputStream fis=new FileInputStream("file");  
              ObjectInputStream ois=new ObjectInputStream(fis);  
            ArrayList  list2=(ArrayList)ois.readObject();  
            System.out.println(list2);    
          }catch(Exception e)  
          {  
              System.out.println(e);  
          }
		  System.out.println("----------adding books to the list and printing all the books----------");
		  //Creating list of Books  
		    List<Book> list3=new ArrayList<Book>();  
		    //Creating Books  
		    Book b1=new Book(101,"Let us C","Yashwant Kanetkar","BPB",8);  
		    Book b2=new Book(102,"Data Communications and Networking","Forouzan","Mc Graw Hill",4);  
		    Book b3=new Book(103,"Operating System","Galvin","Wiley",6);  
		    //Adding Books to list  
		    list3.add(b1);  
		    list3.add(b2);  
		    list3.add(b3);  
		    //Traversing list  
		    for(Book b:list3){  
		        System.out.println(b.id+" "+b.name+" "+b.author+" "+b.publisher+" "+b.quantity);  
		    }
		    
		    

	}
}