package edu.jspiders.studentmanagementsystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.jspiders.studentmanagementsystem.entity.Employee;
import edu.jspiders.studentmanagementsystem.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;

	public Employee addEmployye(Employee employee) {
		return employeeRepository.save(employee);
	}

	public void deleteEmployee(int id) {
		
		 employeeRepository.deleteById(id);
	}

	public Employee updateEmployee(Employee employee) {
		
		return employeeRepository.save(employee);
		
	}

	public List<Employee> findAllEmployee() {
		return employeeRepository.findAll();
		
	}

	public Employee findById(int id) {
	 
		Optional<Employee> employee = employeeRepository.findById(id);
		if(employee.isPresent())
			return employee.get();
		else
			return null;
			
		
	}

	
	public List<Employee> findEmployeeByName(String name) {
		List<Employee> employeeByName = employeeRepository.findEmployeeByName(name);
		if(employeeByName != null)
			return  employeeByName;
		else
			return null;
	}

	public Employee findByEmail(String email) {
		Optional<Employee> byEmail = employeeRepository.findByEmail(email);
		if(byEmail .isPresent())
			return byEmail.get();
		else
			return null;
		
	}

	public List<Employee> findBySalary(double salary) {
		List<Employee> bySalary = employeeRepository.findBySalary(salary);
		if(bySalary != null)
			return bySalary;
		else 
	      return null;
		
	}

}
