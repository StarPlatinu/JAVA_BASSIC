
public class Interviewer extends Person {
	private int experience;

	public Interviewer(int id, String name, String gender, String birthDate, String email, int experience) {
		super(id, name, gender, birthDate, email);
		this.experience = experience;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

}
