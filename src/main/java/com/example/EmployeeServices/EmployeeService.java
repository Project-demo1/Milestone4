package com.example.EmployeeServices;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.Employee.Employee;
@Service
public class EmployeeService {
	private List<Employee> Employees = new ArrayList<>(Arrays.asList(
			new Employee("1","Core java","Java description"),
			new Employee("2","DevOps","DevOps description"),
			new Employee("3","DSA","DSA description")
			));
	
	public List<Employee> getAllEmployees()
	{
		return Employees;
	}
	
	public Employee getEmployee(String id)
	{
		try {
			
		
		return Employees.stream().filter(t->t.getId().equals(id)).findFirst().get();
	}
		catch (Exception e)
		{
			return null;
		}
		}
	
	public void addEmployee(Employee Employee)
	{
		Employees.add(Employee);
	}
	
	public void updateEmployee(String id,Employee Employee)
	{
		for(int i=0;i<Employees.size();i++)
		{
			Employee t = Employees.get(i);
			if(t.getId().equals(id))
			{
				Employees.set(i, Employee);
				return;
			}
		}
	}
	
	public void deleteEmployee(String id)
	{
		Employees.removeIf(t->t.getId().equals(id));
	}


}




