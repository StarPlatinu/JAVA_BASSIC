package Java_Collections;

import java.util.*;

/*
 * Java LinkedList class uses a doubly linked list to store the elements. 
 * It provides a linked-list data structure. It inherits the AbstractList class and implements List and Deque interfaces.

The important points about Java LinkedList are:

Java LinkedList class can contain duplicate elements.
Java LinkedList class maintains insertion order.
Java LinkedList class is non synchronized.
In Java LinkedList class, manipulation is fast because no shifting needs to occur.
Java LinkedList class can be used as a list, stack or queue.
 */
public class JavaCollection_LinkedList {
	public static void main(String[] args) {
		LinkedList<String> ll = new LinkedList<String>();
		System.out.println("Initial list of elements: " + ll);
		ll.add("Ravi");
		ll.add("Vijay");
		ll.add("Ajay");
		System.out.println("After invoking add(E e) method: " + ll);
		// Adding an element at the specific position
		ll.add(1, "Gaurav");
		System.out.println("After invoking add(int index, E element) method: " + ll);
		LinkedList<String> ll2 = new LinkedList<String>();
		ll2.add("Sonoo");
		ll2.add("Hanumat");
		// Adding second list elements to the first list
		ll.addAll(ll2);
		System.out.println("After invoking addAll(Collection<? extends E> c) method: " + ll);
		LinkedList<String> ll3 = new LinkedList<String>();
		ll3.add("John");
		ll3.add("Rahul");
		// Adding second list elements to the first list at specific position
		ll.addAll(1, ll3);
		System.out.println("After invoking addAll(int index, Collection<? extends E> c) method: " + ll);
		// Adding an element at the first position
		ll.addFirst("Lokesh");
		System.out.println("After invoking addFirst(E e) method: " + ll);
		// Adding an element at the last position
		ll.addLast("Harsh");
		System.out.println("After invoking addLast(E e) method: " + ll);
		// Removing specific element from arraylist
		ll.remove("Vijay");
		System.out.println("After invoking remove(object) method: " + ll);
		System.out.println("----------Traversing the list of elements in reverse order  -----------");

		Iterator i = ll.descendingIterator();
		while (i.hasNext()) {
			System.out.println(i.next());
		}
		System.out.println("----------ListObject---------");
		// Creating list of Books
		List<Book> list = new LinkedList<Book>();
		// Creating Books
		Book b1 = new Book(101, "Let us C", "Yashwant Kanetkar", "BPB", 8);
		Book b2 = new Book(102, "Data Communications & Networking", "Forouzan", "Mc Graw Hill", 4);
		Book b3 = new Book(103, "Operating System", "Galvin", "Wiley", 6);
		// Adding Books to list
		list.add(b1);
		list.add(b2);
		list.add(b3);
		// Traversing list
		for (Book b : list) {
			System.out.println(b.id + " " + b.name + " " + b.author + " " + b.publisher + " " + b.quantity);
		}

	}
}
