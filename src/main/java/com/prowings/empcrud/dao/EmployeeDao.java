package com.prowings.empcrud.dao;

import java.util.List;

import com.prowings.empcrud.model.Employee;

public interface EmployeeDao {
	
	
	public void saveEmployee(Employee employee);

	public Employee getEmployeeById(int id);

	public List<Employee> getAllEmployees();

	public List<Employee> getEmployeesByCityAndDept(String city, String department);
	
}
