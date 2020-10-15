package com.Makket.demo.Model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "Shipping")
public class Shipping {

	@Id
	private String id;
	private String eMail;
	private String name;
	private String phoneNum;
	private Address address;
	
	
	public Shipping(String eMail, String name, String phoneNum, Address address) {
		super();
		this.eMail = eMail;
		this.name = name;
		this.phoneNum = phoneNum;
		this.address = address;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String geteMail() {
		return eMail;
	}
	public void seteMail(String eMail) {
		this.eMail = eMail;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}

	}
