package golondrinas.com.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import javax.persistence.Table;
@Entity
@Table(name="user_role")
public class User_role {
	@Id
	private String user_id;
	
	
	private String role_id;

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getRole_id() {
		return role_id;
	}

	public void setRole_id(String role_id) {
		this.role_id = role_id;
	}

	public User_role(String user_id, String role_id) {
		super();
		this.user_id = user_id;
		this.role_id = role_id;
	}

	public User_role() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
