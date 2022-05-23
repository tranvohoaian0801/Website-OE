package Entity;

import javax.persistence.*;

@Entity
@Table(name="Users")
public class User {
    @Id
	@Column(name="ID")
	String Id;
	@Column(name="Password")
	String Password;
	@Column(name="Fullname")
	String Fullname;
	@Column(name="Email")
	String Email;
	@Column(name="Admin")
	boolean Admin= false;
	
	public User() {
		
	}

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getFullname() {
		return Fullname;
	}

	public void setFullname(String fullname) {
		Fullname = fullname;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public boolean isAdmin() {
		return Admin;
	}

	public void setAdmin(boolean admin) {
		Admin = admin;
	}

	public User(String id, String password, String fullname, String email, boolean admin) {
		super();
		Id = id;
		Password = password;
		Fullname = fullname;
		Email = email;
		Admin = admin;
	}
	
	
}
