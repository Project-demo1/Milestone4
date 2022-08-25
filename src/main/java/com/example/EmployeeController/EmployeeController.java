package com.example.EmployeeController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Employee.Employee;
import com.example.EmployeeServices.EmployeeService;
import com.example.Employee.Employee;
import com.example.exception.UserNotFoundException;

@RestController
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;
	
	@RequestMapping("/Employees")
	public List<Employee> getAllEmployees()
	{
		return employeeService.getAllEmployees();
	}	
	@RequestMapping("/employees/{id}")
	public Employee geEmployee(@PathVariable String id)
	{
		Employee to = employeeService.getEmployee(id);
		if (to==null)
		{
		throw new UserNotFoundException("id is not present");
		}
		return to;
		//return employeeservice.getEmployee(id);
	}
	
	@PostMapping("/employees")
	public void addEmployee(@RequestBody Employee Employee)
	{
		employeeService.addEmployee(Employee);
	}
	
	@PutMapping("/employees/{id}")
	public void updateEmployee(@RequestBody Employee Employee,@PathVariable String id)
	{
		employeeService.updateEmployee(id, Employee);
	}
	
	@DeleteMapping("/employees/{id}")
	public void deleteEmployee(@PathVariable String id)
	{
		employeeService.deleteEmployee(id);
	}
	

}




