package com.luv2code.springboot.cruddemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springboot.cruddemo.entity.Employee;
import com.luv2code.springboot.cruddemo.service.EmployeeService;


@RestController
@RequestMapping("/api")
public class EmployeeRestController {

	private EmployeeService employeeService;
	
	@Autowired
	public EmployeeRestController(EmployeeService theEmployeeService) {
		employeeService = theEmployeeService;
	}
	
	@GetMapping("/employees")
	public List<Employee> findAll() {
		return employeeService.findAll();
	}
	
	@GetMapping("/employees/{employeeId}")
	public Employee findById(@PathVariable int employeeId) {
		
		Employee emp = employeeService.findById(employeeId);
		
		if(emp == null)
		{
			throw new EmployeeNotFoundException("Can't find customer with id "+ employeeId);
		}
		
		return emp;
	}
	
	@PostMapping("/employees")
	public Employee save(@RequestBody Employee emp)
	{
		emp.setId(0);
		employeeService.save(emp);
		return emp;
	}
	
	@PutMapping("/employees")
	public Employee update(@RequestBody Employee emp)
	{
		employeeService.save(emp);
		return emp;
	}
	
	@DeleteMapping("/employees/{theid}")
	public String delete(@PathVariable int theid)
	{
		Employee emp = employeeService.findById(theid);
	
		if(emp == null)
		{
			throw new EmployeeNotFoundException("Can't find customer with id "+ theid);
		}
		employeeService.delete(theid);
		return "Emplyee with id " + theid + "was deleted";
	}
}










