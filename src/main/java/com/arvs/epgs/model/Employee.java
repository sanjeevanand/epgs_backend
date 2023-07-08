package com.arvs.epgs.model;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name = "employee")
public class Employee {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long employeeId;
	private String name;
	private String mobile1;
	private String mobile2;
	private String email;
	private String address;
	private String role;
	private String type;
	private float salary;
	private float dailyWaseAmount;
	
	// Mapping to the other table
    @OneToMany(mappedBy="employee",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Set<Attendence> attendences;
	
	public Set<Attendence> getAttendences() {
		return attendences;
	}
	public void setAttendences(Set<Attendence> attendences) {
		this.attendences = attendences;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public long getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobile1() {
		return mobile1;
	}
	public void setMobile1(String mobile1) {
		this.mobile1 = mobile1;
	}
	public String getMobile2() {
		return mobile2;
	}
	public void setMobile2(String mobile2) {
		this.mobile2 = mobile2;
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
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
	public float getDailyWaseAmount() {
		return dailyWaseAmount;
	}
	public void setDailyWaseAmount(float dailyWaseAmount) {
		this.dailyWaseAmount = dailyWaseAmount;
	}
	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", name=" + name + ", mobile1=" + mobile1 + ", mobile2=" + mobile2
				+ ", email=" + email + ", address=" + address + ", role=" + role + ", type=" + type + ", salary="
				+ salary + ", dailyWaseAmount=" + dailyWaseAmount +  "]";
	}
	

}
