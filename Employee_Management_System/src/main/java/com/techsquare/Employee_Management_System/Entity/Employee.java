package com.techsquare.Employee_Management_System.Entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Employee 
{
	@Id
	@GeneratedValue(generator = "Employee_gen",strategy = GenerationType.AUTO )
	@SequenceGenerator(name="Employee_gen",sequenceName ="Employee_seq" ,initialValue = 1,allocationSize = 1)

	private int id;
	private String name;
	private String emailId;
	private Date date;
	private char gender;
	private int salary;
	private long phoneNumber;
	private String employeeStatus;
	
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
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmployeeStatus() {
		return employeeStatus;
	}
	public void setEmployeeStatus(String employeeStatus) {
		this.employeeStatus = employeeStatus;
	}
	
	public Employee(int id, String name, String emailId, Date date, char gender, int salary, long phoneNumber,
			String employeeStatus) {
		super();
		this.id = id;
		this.name = name;
		this.emailId = emailId;
		this.date = date;
		this.gender = gender;
		this.salary = salary;
		this.phoneNumber = phoneNumber;
		this.employeeStatus = employeeStatus;
	}
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

}
