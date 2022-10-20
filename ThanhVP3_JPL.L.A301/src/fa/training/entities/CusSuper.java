package fa.training.entities;

public class CusSuper {
private String  EmployeeName;
private String SupervisorName;
private int OrderId;
private int Total;

public CusSuper() {
	// TODO Auto-generated constructor stub
}

public CusSuper(String employeeName, String supervisorName, int orderId, int total) {
	super();
	EmployeeName = employeeName;
	SupervisorName = supervisorName;
	OrderId = orderId;
	Total = total;
}

public String getEmployeeName() {
	return EmployeeName;
}

public void setEmployeeName(String employeeName) {
	EmployeeName = employeeName;
}

public String getSupervisorName() {
	return SupervisorName;
}

public void setSupervisorName(String supervisorName) {
	SupervisorName = supervisorName;
}

public int getOrderId() {
	return OrderId;
}

public void setOrderId(int orderId) {
	OrderId = orderId;
}

public int getTotal() {
	return Total;
}

public void setTotal(int total) {
	Total = total;
}

@Override
public String toString() {
	return "EmployeeName=" + EmployeeName + ", SupervisorName=" + SupervisorName + ", OrderId=" + OrderId
			+ ", Total=" + Total ;
}

}
