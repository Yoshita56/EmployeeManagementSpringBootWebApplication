package com.employeemanagement.restapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.employeemanagement.restapi.entity.Employee;
import com.employeemanagement.restapi.repository.EmployeeRepository;

@Controller

//@RestController
//@EnableWebMvc
public class EmployeeController {

	
	@Autowired
	EmployeeRepository repo; //using this interface to use the methods of JPA repository class
	
	//localhost:8080/ --> PostMan URL/URI (REST POINT)
	@GetMapping("/")
	public String getAllEmployees(Model model){
		List<Employee> employees=repo.findAll();
		model.addAttribute("listofemployees", employees);

		System.out.print("Get / "+ employees);   //for debugging
		//  return mav;
//		return students;
		return "index";
	}
	
	
	@GetMapping("/emp/{id}")
	public Employee getEmployee(@PathVariable int id) {
		Employee std= repo.findById(id).get();
		//fetching the details by their resp no.
		return std;
	}
	  
	@GetMapping("/newEmp/Form") //worked only after mapping with the link reference in HTML file-> index.html
      public String add(Model model) {
          model.addAttribute("employee", new Employee());
          return "Form";
      }
	
	  @RequestMapping(value = "/save", method = RequestMethod.POST)
      public String saveEmployee(@ModelAttribute("employee") Employee std) {
          repo.save(std);
          return "redirect:/";
      }

	
	//Update the existing details
	@RequestMapping("/emp/edit/{id}")
	public ModelAndView updateEmployees(@PathVariable int id) {
		Employee employee=repo.findById(id).get();
		 ModelAndView mav = new ModelAndView("Form");
			  mav.addObject("employee", employee);
	          return mav;
	}
	//Contact Page
	@RequestMapping("/emp/contactUs/{id}")
	public ModelAndView contactEmployees(@PathVariable int id) {
		Employee employee=repo.findById(id).get();
		 ModelAndView mav = new ModelAndView("Contacts");
			  mav.addObject("employee", employee);
	          return mav;
	}
	//Delete Operation
	@RequestMapping("/delete/{id}")
	public String deleteEmployees(@PathVariable int id) {
		Employee employee=repo.findById(id).get();
		repo.delete(employee); //this line is very important to commit the changes in the database
		return "redirect:/";
		//return ResponseEntity.status(HttpStatus.CREATED).body("the record has been deleted"); //used to show message in the Postman Body -> ResponseEntity<> class
	} 
}
