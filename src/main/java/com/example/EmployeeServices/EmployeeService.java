package com.example.EmployeeServices;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.Employee.Employee;
@Service
public class EmployeeService {
	private List<Employee> Employees = new ArrayList<>(Arrays.asList(
			new Employee("1","Shefali","10000"),
			new Employee("2","rohit","20000"),
			new Employee("3","Dinesh","30000"),
			new Employee("4","Mohan","40000"),
			new Employee("5","Sakshi","50000"),
			new Employee("6","Radha","60000"),
			new Employee("7","deepak","70000"),
			new Employee("8","anju","80000"),
			new Employee("9","anamika","90000"),
			new Employee("10","sanjay","100000")
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




