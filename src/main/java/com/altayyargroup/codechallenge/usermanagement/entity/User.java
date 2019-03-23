package com.altayyargroup.codechallenge.usermanagement.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name="User.findByUserID",query="select userID,pin from User b where b.pin=?1")
public class User implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@Column(name="user_id")
	private String userID;
	@Column(name="pin")
	private String pin;
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getPin() {
		return pin;
	}
	public void setPin(String pin) {
		this.pin = pin;
	}
	
	}
