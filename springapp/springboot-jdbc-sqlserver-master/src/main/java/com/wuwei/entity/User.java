package com.wuwei.entity;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import org.hibernate.validator.constraints.Email;

@Entity(name = "User")
@Table (name = "Users")
public class User {

	public User(String email, String password) {
		super();
		this.email= email;
		this.password = password;
		
	}

	public User() {
	}



	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name = "UserId")
	private int userId;
	
	@Column(unique = true, name = "Email")
	private String email;
	
	@Column(name = "Password")
	private String password;

//	  @OneToMany(
//		        mappedBy = "userId",
//		        cascade = CascadeType.ALL,
//		        orphanRemoval = true
//		    )
//		    private List<Values> values = new ArrayList<>();
	  
	

	public int getUserId() {
		return userId;
	}
	

	public String getEmail() {
		return email;
	}
	

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
