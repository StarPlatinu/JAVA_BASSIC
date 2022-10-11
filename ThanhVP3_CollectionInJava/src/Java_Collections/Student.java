package Java_Collections;

public class Student implements Comparable<Student> {
	int rollno;
	String name;
	int age;

	public Student(String name) {
		super();
		this.name = name;
	}

	Student(int rollno, String name, int age) {
		this.rollno = rollno;
		this.name = name;
		this.age = age;
	}

	public int compareTo(Student person) {
		return name.compareTo(person.name);

	}

}
