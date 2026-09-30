package com.jsp;

import jakarta.persistence.*;

@Entity
@Table(name="employee")
public class Employe {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "emp_seq")
	@SequenceGenerator(name="emp_seq",initialValue = 1,allocationSize = 2)
	private int id;
	private String name;
	private String password;
	private String email;
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Employe [id=" + id + ", name=" + name + ", password=" + password + ", email=" + email + "]";
	}
}
