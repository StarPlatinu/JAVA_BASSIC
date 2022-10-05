package fa.training.entities;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author thanh
 *
 */
public class Department {
	public String departmentName;
	public List<Employee> employees;

	public Department(String departmentName) {
		this.departmentName = departmentName;
		employees = new ArrayList<>();
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	@Override
	public String toString() {
		return "Department [departmentName=" + departmentName + ", employees=" + employees + "]";
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	

}
