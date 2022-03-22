package com.petcare.model;

public class RegisterContainer {
	private  long owner_id;
    private String fname;
    private String lname;
    private String gender;
    private int age;
    private String address;
    private String email;
    
	public long getOwner_id() {
		return owner_id;
	}

	public void setOwner_id(long owner_id) {
		this.owner_id = owner_id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public RegisterContainer(long owner_id, String fname, String lname, String gender, int age, String address,
			String email) {
		super();
		this.owner_id = owner_id;
		this.fname = fname;
		this.lname = lname;
		this.gender = gender;
		this.age = age;
		this.address = address;
		this.email = email;
	}
    
    
    
    
}
