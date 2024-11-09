package com.employeemanagement.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employeemanagement.restapi.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
//the interface is inheriting the properties of the main class JPA spring boot to access its methods like: .save(), findbyid(), delete(), findAll(), etc
}
