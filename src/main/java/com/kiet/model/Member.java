package com.kiet.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Member {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private String joinDate;
	private int issuedBooks;
	private boolean active;

	public Member() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Member(int id, String name, String joinDate, int issuedBooks, boolean active) {
		super();
		this.id = id;
		this.name = name;
		this.joinDate = joinDate;
		this.issuedBooks = issuedBooks;
		this.active = active;
	}

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
	
	
	public String getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(String joinDate) {
		this.joinDate = joinDate;
	}

	public int getIssuedBooks() {
		return issuedBooks;
	}

	public void setIssuedBooks(int issuedBooks) {
		this.issuedBooks = issuedBooks;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", issuedBooks=" + issuedBooks + ", active=" + active + "]";
	}

}
