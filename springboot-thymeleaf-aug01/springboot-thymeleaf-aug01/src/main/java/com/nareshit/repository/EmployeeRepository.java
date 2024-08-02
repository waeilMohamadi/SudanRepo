package com.nareshit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nareshit.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}
