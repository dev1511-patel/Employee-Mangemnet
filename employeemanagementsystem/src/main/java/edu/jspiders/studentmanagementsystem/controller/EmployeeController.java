package edu.jspiders.studentmanagementsystem.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.jspiders.studentmanagementsystem.entity.Employee;
import edu.jspiders.studentmanagementsystem.service.EmployeeService;

@RestController
public class EmployeeController {
	
	
	@Autowired
	private EmployeeService employeeService;

	@PostMapping(path = "/employees")
	protected ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) 
	{
		Employee addedEmployee = employeeService.addEmployye(employee);
		return new ResponseEntity<Employee>(addedEmployee, HttpStatus.CREATED);
	}
	
	@DeleteMapping(path = "/employees")
	protected ResponseEntity<String> deleteEmployee( @RequestParam int id) 
	{		
		employeeService.deleteEmployee(id);
		return new ResponseEntity<String>("Employee Deleted",HttpStatus.OK);	
	}
	
	@PutMapping(path = "/employees")
	protected ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) 
	{
		Employee updatedEmployee = employeeService.updateEmployee(employee);
		return new ResponseEntity<Employee>(updatedEmployee,HttpStatus.OK);
	}

	@GetMapping(path ="/employees" )
	protected ResponseEntity<Object> findAllEmployee()
	{
		List<Employee> employees = employeeService.findAllEmployee();
		if(employees .size()> 0)
			return new ResponseEntity<Object>(employees,HttpStatus.FOUND);
		else 
			return new ResponseEntity<Object>("No Data found",HttpStatus.NOT_FOUND); 
	}
	
	@GetMapping(path = "/employees-byid")
	protected ResponseEntity<Object> findBYId(@RequestParam int id) 
	{		
		 Employee employee = employeeService.findById(id);
		 if(employee != null)
			 return new ResponseEntity<Object>(employee,HttpStatus.FOUND);
		 else
			 return new ResponseEntity<Object>("Employee not found" ,HttpStatus.NOT_FOUND);		
	}
	
	@GetMapping(path = "/employees-byname")
	protected ResponseEntity<Object> findEmployeeByName(@RequestParam String name) 
	{	
		
		List<Employee> employeeByName =  employeeService.findEmployeeByName(name);
		if(employeeByName != null)
			return new ResponseEntity<Object>(employeeByName,HttpStatus.FOUND);
		else
			return new ResponseEntity<Object>("Employee not found",HttpStatus.NOT_FOUND);
	}
	
	@GetMapping(path = "/employees-byemail")
	protected ResponseEntity<Object> findByEmail(@RequestParam String email) 
	{
		Employee byEmail = employeeService.findByEmail(email);
		if(byEmail != null)
			return new ResponseEntity<Object>(byEmail, HttpStatus.FOUND);
		else
			return new ResponseEntity<Object>("Employee not found based on email",HttpStatus.NOT_FOUND);
	}
	@GetMapping(path = "/employees-bysalary")
	protected ResponseEntity<Object> findBySalary(@RequestParam double salary) {
		
		List<Employee> bySalary = employeeService.findBySalary(salary);
		if(bySalary != null)
		 return new ResponseEntity<Object>(bySalary, HttpStatus.FOUND);
		else
			return new ResponseEntity<Object>("Employee not found based on email",HttpStatus.NOT_FOUND);
		
	}
}
