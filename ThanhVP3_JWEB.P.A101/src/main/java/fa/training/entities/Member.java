package fa.training.entities;

import java.sql.Date;

public class Member {
private int Id;
private String Firstname;
private String Lastname;
private String Username;
private String Password;
private String Phone;
private String Email;
private String Description;
private Date CreatedDate;
private Date UpdateTime;

public Member() {
	// TODO Auto-generated constructor stub
}

public Member(int id, String firstname, String lastname, String username, String password, String phone, String email,
		String description, Date createdDate, Date updateTime) {
	super();
	Id = id;
	Firstname = firstname;
	Lastname = lastname;
	Username = username;
	Password = password;
	Phone = phone;
	Email = email;
	Description = description;
	CreatedDate = createdDate;
	UpdateTime = updateTime;
}

public int getId() {
	return Id;
}

public void setId(int id) {
	Id = id;
}

public String getFirstname() {
	return Firstname;
}

public void setFirstname(String firstname) {
	Firstname = firstname;
}

public String getLastname() {
	return Lastname;
}

public void setLastname(String lastname) {
	Lastname = lastname;
}

public String getUsername() {
	return Username;
}

public void setUsername(String username) {
	Username = username;
}

public String getPassword() {
	return Password;
}

public void setPassword(String password) {
	Password = password;
}

public String getPhone() {
	return Phone;
}

public void setPhone(String phone) {
	Phone = phone;
}

public String getEmail() {
	return Email;
}

public void setEmail(String email) {
	Email = email;
}

public String getDescription() {
	return Description;
}

public void setDescription(String description) {
	Description = description;
}

public Date getCreatedDate() {
	return CreatedDate;
}

public void setCreatedDate(Date createdDate) {
	CreatedDate = createdDate;
}

public Date getUpdateTime() {
	return UpdateTime;
}

public void setUpdateTime(Date updateTime) {
	UpdateTime = updateTime;
}



}
