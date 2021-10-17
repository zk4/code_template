package com.zk.entity;

import com.zk.validator.IsMobile;

public class User {
	Integer id;
	String name;

	@IsMobile
	String phonenumber;

	public String getPhonenumber() {
		return phonenumber;
	}

	public User setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
		return this;
	}

	public Integer getId() {
		return id;
	}

	public User setId(Integer id) {
		this.id = id;
		return this;
	}

	public String getName() {
		return name;
	}

	public User setName(String name) {
		this.name = name;
		return this;
	}
}
