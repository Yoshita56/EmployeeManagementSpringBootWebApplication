package com.employeemanagement.restapi.entity;
import jakarta.persistence.*;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table //creates a table with the default class name, here, 'Employee'
public class Employee {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY) 
private int empID; //automatically incremented by new addition of details.

@Column(name="emp_name")  //the names in backets will be the table columns created in database but,
private String name;		//the variables of the each column in Java will be used for referencing, here in HTML Thymeleaf

@Column(name="emp_sal")
private Float salary;

@Column(name="emp_dept")
private String department;

@Column(name="emp_contact")
private Long phone; //automatically incremented by new addition of details.

@Column(name="emp_email")
private String email;

public Employee() {
	//default constructor is needed to avoid error
}
 
public Employee(String name, Float sal, String dept, String email, Long phone) {
	super();
	this.name = name;
	this.salary = sal;
	this.department = dept;
	this.email=email;
	this.phone=phone;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public int getEmpID() {
	return empID;
}

public void setEmpID(int empID) {
	this.empID = empID;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public Float getSalary() {
	return salary;
}

public void setSalary(Float salary) {
	this.salary = salary;
}

public String getDepartment() {
	return department;
}

public void setDepartment(String department) {
	this.department = department;
}

public Long getPhone() {
	return phone;
}

public void setPhone(Long phone) {
	this.phone = phone;
}



}
