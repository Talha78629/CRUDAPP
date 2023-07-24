package com.example.demo.Service;

import java.util.List;

import com.example.demo.model.Employee;

public interface EmployeeService {
	public String upsert(Employee employee);
	public Employee getById(Long id);
	public List<Employee> getAllEmployees();
	public String deleteById(Long id);
	
	

}
