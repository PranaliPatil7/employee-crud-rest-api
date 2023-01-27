package com.prowings.empcrud.service;

import java.util.List;

import com.prowings.empcrud.model.Employee;

public interface EmployeeService {
	
	
	public void saveEmployee(Employee employee);

	public Employee getEmployeeByID(int id);

	public List<Employee> getAllEmployees();

	public List<Employee> getEmployeesByCityAndDept(String city, String department);
	
	
	
}
