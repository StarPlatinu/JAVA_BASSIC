
public class candidate extends Person{
private double gpa;

public candidate(int id, String candidateName, String gender, String birthDate, String email,double gpa) {
	super(id,candidateName,gender,birthDate,email);
	this.gpa = gpa;
}

public double getGpa() {
	return gpa;
}

public void setGpa(double gpa) {
	this.gpa = gpa;
}

}
