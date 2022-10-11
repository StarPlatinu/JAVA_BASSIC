package fa.training.stringbufferdemo;

public class StringBufferExample {

	/**
	 * Demonstrate how to use StringBuffer
	 *
	 */
	 public void demonstrateStringBuffer() {
	 System.out.println("demonstrateStringBuffer() !!!");	
	StringBuffer buffer = new StringBuffer();	
	 // Append the string representation of the argument to
	 // the end of the buffer.
	 // In this example we use a string,
	 // but the method also accepts int, float,
	 // double, boolean, char (or char[]), as well as objects.
	 buffer.append("Hello World!");
	 System.out.println(buffer.toString());
	
	 // Delete the specified substring by providing the start and the end
	 // of the sequence.
	 buffer.delete(5, 11);
	 System.out.println(buffer.toString());
	
	 // Delete just one char by providing its position.
	 buffer.deleteCharAt(5);
	 System.out.println(buffer.toString());
	
	 // Insert a string in a specified place inside the buffer.
	 buffer.insert(0, "World ");
	 System.out.println(buffer.toString());
	
	 // Get the index that the specified substring starts at.
	System.out.println("Index of Hello: " + buffer.indexOf("Hello"));
	 System.out.println(); // Empty line
	
	
	 // You can also instantiate a new StringBuffer and provide
	 // the initial String in the constructor.
	 StringBuffer newBuffer = new StringBuffer("This is a Hello World string. Hello!");
	
	 // You can use lastIndexOf(String) to get the last time
	 // that a specified
	 // substring appears in the StringBuffer.
	 System.out.println("Index of Hello: " + newBuffer.indexOf("Hello"));
	 System.out.println("Last index of Hello: " +
	 newBuffer.lastIndexOf("Hello"));
	
	 // You can also replace a specific sub-sequence of
	 // the StringBuffer with another string.
 // The size does not need to be the same, as shown here.
	 newBuffer.replace(0, 4, "That here");
	 System.out.println(newBuffer.toString());
	
	 // You can replace a single char using this method here. We want to
	 // replace the last character of the string,
	 // so instead of counting the length,
	 // we will use the provided length() method,
	 // and replace the char in the last index.
	 newBuffer.setCharAt(newBuffer.length() - 1, '?');
	 System.out.println(newBuffer.toString());
	
	 // You can reverse the StringBuffer as well!
	 newBuffer.reverse();
 System.out.println(newBuffer.toString());
	 comparePerformance();
	
	 }

	/**
	 * Compare performance between String and StringBuffer
	 *
	 */
	private static void comparePerformance() {
		long startTime;
		String str = "";
		StringBuffer buffer = new StringBuffer();

		// Using String
		startTime = System.currentTimeMillis();
		for (int i = 0; i < 10000; i++) {
			str += "extra";
		}
		System.out.println("Time using String: " + (System.currentTimeMillis() - startTime) + " ms.");
		// Using StringBuffer
		startTime = System.currentTimeMillis();
		for (int i = 0; i < 10000; i++) {
			buffer.append("extra");
		}
		System.out.println("Time using StringBuffer: " + (System.currentTimeMillis() - startTime) + " ms.");
	}
}
