/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Customer.Model;

import SupportClasses.Subject;

class Customer {
	private String id;
	private String fullName;
	private String yearRegistration; // nam tham gia
	private String TelNum;
	private String email;
	private String address;

	public Customer(String id, String fullName, String yearRegistration, String telNum, String email,
			String address) {
		this.id = id;
		this.fullName = fullName;
		this.yearRegistration = yearRegistration;
		TelNum = telNum;
		this.email = email;
		this.address = address;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getTelNum() {
		return TelNum;
	}

	public void setTelNum(String telNum) {
		TelNum = telNum;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setYearRegistration(String yearRegistration) {
		this.yearRegistration = yearRegistration;
	}

	public String getYearRegistration() {
		return yearRegistration;
	}
	
}
