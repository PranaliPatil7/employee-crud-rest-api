package com.prowings.empcrud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.prowings.empcrud.dao.EmployeeDao;
import com.prowings.empcrud.model.Employee;
@Service
public class EmployeeServiceImpl implements EmployeeService{
	@Autowired
	EmployeeDao dao;
	
	@Override
	public void saveEmployee(Employee employee) {
		dao.saveEmployee(employee);
		
	}

	@Override
	public Employee getEmployeeByID(int id) {
		return dao.getEmployeeById(id);
	}

	@Override
	public List<Employee> getAllEmployees() {
		return dao.getAllEmployees();
	}

	@Override
	public List<Employee> getEmployeesByCityAndDept(String city, String department) {
		return dao.getEmployeesByCityAndDept(city,department);
	}

}
