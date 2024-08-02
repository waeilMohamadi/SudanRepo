package com.nareshit.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nareshit.entity.Employee;
import com.nareshit.repository.EmployeeRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmployeeService {
	
	private final EmployeeRepository employeeRepository;
	
	@Transactional(rollbackForClassName = {"java.lang.Exception"})
	public Employee saveEmployee(Employee emp) {
		return employeeRepository.save(emp);
	}
	
	@Transactional(rollbackForClassName = {"java.lang.Exception"})
	public Employee updateEmployee(Employee emp) {
		return employeeRepository.save(emp);
	}
	
	@Transactional(rollbackForClassName = {"java.lang.Exception"})
	public void deleteEmployee(Integer id) {
		employeeRepository.deleteById(id);
	}
	
	public Employee getEmployee(Integer id) {
		return employeeRepository.findById(id).get();
	}
	
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}
}
