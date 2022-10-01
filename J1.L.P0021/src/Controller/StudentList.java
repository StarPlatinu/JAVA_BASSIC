package Controller;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;

import Model.Student;

public class StudentList extends ArrayList<Student> {
	private HashMap<Student, Integer> totalOfCourse;

	public StudentList() {
		totalOfCourse = new HashMap<>();
	}

	public boolean create(Student student) {
		boolean result = add(student);
		if (result) {
			increaseTotalCourse(student);
		}
		return result;
	}

	public boolean increaseTotalCourse(Student student) {
		Integer total = totalOfCourse.get(student);
		totalOfCourse.put(student, total == null ? 1 : total + 1);
		return total != null;
	}

	public boolean delete(Student student) {
		boolean result = remove(student);
		if (result) {
			totalOfCourse.remove(student);
		}
		return result;
	}

	public boolean decreaseTotalCourse(Student student) {
		Integer total = totalOfCourse.get(student);
		if (total == null || total <= 1) {
			totalOfCourse.remove(student);
		} else {
			totalOfCourse.put(new Student(student), total - 1);
		}
		return total != null && total > 1;
	}

	public Student find(String id) {
		for (Student student : this) {
			if (student.getId().equalsIgnoreCase(id)) {
				return student;
			}
		}
		return null;
	}

	public void sort() {
		sort(((o1, o2) -> o1.getAge() - o2.getAge()));
	}

	public String report() {
		return totalOfCourse.entrySet().stream().map((entry) -> String.format("%20s | %10s | %d\n",
				entry.getKey().getName(), entry.getKey().getCourseName(), entry.getValue())).reduce("", String::concat);
	}

}
