package fa.training.entities;

public class Employee {
	private int employeeId;
	private String employeeName;
	private double salary;
	private int spvrId;

	public Employee() {
	}

	public Employee(String employeeName, double salary, int spvrId) {
		super();
		this.employeeName = employeeName;
		this.salary = salary;
		this.spvrId = spvrId;
	}

	public Employee(int employeeId, String employeeName, double salary, int spvrId) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.salary = salary;
		this.spvrId = spvrId;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public int getSpvrId() {
		return spvrId;
	}

	public void setSpvrId(int spvrId) {
		this.spvrId = spvrId;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName + ", salary=" + salary
				+ ", spvrId=" + spvrId + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + employeeId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (employeeId != other.employeeId)
			return false;
		return true;
	}

}
