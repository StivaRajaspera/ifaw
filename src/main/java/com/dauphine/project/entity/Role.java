package com.dauphine.project.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Role {

	@Id
	@GeneratedValue (strategy = GenerationType. AUTO)
	private Long id;
	
	@Column
	private String role;
	
	public Role(String role) {
		super();
		this.role = role;
	}

	public Role() {
		super();
	}

	public String getRole () {
		return role;
	}

	public void setRole (String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "Role [id=" + id + ", role=" + role + "]";
	}
	
}