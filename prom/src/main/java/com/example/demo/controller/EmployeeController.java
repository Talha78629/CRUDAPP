package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.Service.EmployeeService;
import com.example.demo.model.Employee;

@RestController
public class EmployeeController {
@Autowired

private EmployeeService employeeservice;


@PostMapping("/employees")
public ResponseEntity<String> createEmployee(@RequestBody Employee employee){
	String status =employeeservice.upsert(employee);
	return new ResponseEntity <>(status,HttpStatus.CREATED);
	
	
}
@GetMapping("/employees/{id}")
public ResponseEntity<Employee> getEmployee(@PathVariable Long id){
	Employee employee=employeeservice.getById(id);
	return new ResponseEntity<>(employee,HttpStatus.OK);
}
@GetMapping("/employees")
public ResponseEntity<List<Employee>> getAllEmployees(){
	List<Employee> allEmployees=employeeservice.getAllEmployees();
	return new ResponseEntity<>(allEmployees,HttpStatus.OK);
}
@PutMapping("/employees")
public ResponseEntity<String> updateEmployee(@RequestBody Employee employee){
	String status= employeeservice.upsert(employee);
	return new ResponseEntity<>(status,HttpStatus.OK);
}
@DeleteMapping("/employees/{id}")
public ResponseEntity<String> deleteEmployee(@PathVariable Long id){
	String status= employeeservice.deleteById(id);
	return new ResponseEntity<>(status,HttpStatus.OK);
}
}
