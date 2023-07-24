package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.EmployeeRepository;
import com.example.demo.model.Employee;
@Service
public class EmployeeServiceImpl implements EmployeeService{
	@Autowired
private EmployeeRepository employeerepo;
	@Override
	public String upsert(Employee employee) {
		// TODO Auto-generated method stub
		employeerepo.save(employee);
		return "success";
	}

	@Override
	public Employee getById(Long id) {
		// TODO Auto-generated method stub
		Optional <Employee> findById=employeerepo.findById(id);
		if(findById.isPresent()) {
			return findById.get();
		}
		return null;
	}

	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
	
		return employeerepo.findAll();
	}

	@Override
	public String deleteById(Long id) {
		// TODO Auto-generated method stub
		if(employeerepo.existsById(id)) {
			employeerepo.deleteById(id);
			return "Delete Success";
		}
		else {
			return "id not found";
		}
	}

}
