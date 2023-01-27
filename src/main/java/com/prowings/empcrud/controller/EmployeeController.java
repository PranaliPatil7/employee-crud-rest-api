package com.prowings.empcrud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.prowings.empcrud.exception.EmployeeNotPresentException;
import com.prowings.empcrud.model.Employee;
import com.prowings.empcrud.service.EmployeeService;

@Controller
public class EmployeeController {
	
	@Autowired
	EmployeeService service;
	                                       //now we can not use ModelAndAttribute
	
	@RequestMapping(value="/hello",method=RequestMethod.GET)   
	public @ResponseBody String hello()    //response in json use @responseBody
	{
		return "hello"; 
	}
	@RequestMapping(value="/employees",method=RequestMethod.POST)
	public @ResponseBody String saveEmployee(@RequestBody Employee employee)
	{
		service.saveEmployee(employee);
		
		return "successfully stored";
	}
	@GetMapping("/employees/{id}")
	public @ResponseBody Employee getEmployeeById(@PathVariable("id") int id) throws EmployeeNotPresentException
	{
		Employee emp= service.getEmployeeByID(id);
		if(null != emp)
			return emp;
		else
			throw new EmployeeNotPresentException("Employee not present with id:"+id);
		
	}
	
	@GetMapping("/employees")
	public @ResponseBody List<Employee> getAllEmployees()
	{
		return service.getAllEmployees();
	}
	
	@GetMapping("/employees1")
	public @ResponseBody List<Employee> getAllEmployeesByCityAndDept(@RequestParam String city) throws EmployeeNotPresentException//,@RequestParam String department)
	{
		System.out.println(city);
		//System.out.println(department);
		//return service.getEmployeesByCityAndDept( city,"");//, department);
		List<Employee> empList=service.getEmployeesByCityAndDept(city, "department");
		if(null !=empList)
			return empList;
		else
		    throw new  EmployeeNotPresentException("Employees not present with city:"+city);
		
		
	}
	 
}
