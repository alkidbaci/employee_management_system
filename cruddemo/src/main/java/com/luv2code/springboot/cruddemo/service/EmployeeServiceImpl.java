package com.luv2code.springboot.cruddemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luv2code.springboot.cruddemo.dao.JpaRepository;
import com.luv2code.springboot.cruddemo.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private JpaRepository employeeDAO;
	
	
	
	@Autowired
	public EmployeeServiceImpl(JpaRepository theEmployeeDAO) {
		employeeDAO = theEmployeeDAO;
	}

	@Override
	public List<Employee> findAll() {
		return employeeDAO.findAll();
	}

	@Override
	public Employee findById(int ID) {
		Optional<Employee> result = employeeDAO.findById(ID);
		Employee emp = null;
		if(result.isPresent())
		{
			emp=result.get();
			
		}
		else
		{
			throw new RuntimeException("Did not find the employee" + ID);
		}	
		return emp;
	}

	@Override
	public void save(Employee theEmployee) {
		
		employeeDAO.save(theEmployee);
	}

	@Override
	public void delete(int ID) {
		employeeDAO.deleteById(ID);

	}

}
