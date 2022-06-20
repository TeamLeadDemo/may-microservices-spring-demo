package com.demo.employeeservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.employeeservice.entity.Employee;
import com.demo.employeeservice.service.EmployeeService;
import com.demo.employeeservice.vo.ResEmpDept;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("employees")
@Slf4j
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;
	
	// add an employee
	@PostMapping("/")
	public Employee addEmployee(@RequestBody Employee employee) {
		log.info("Entering addEmployee of EmployeeController...");
		Employee returnedEmployee = employeeService.addEmployee(employee);
		return returnedEmployee;
	}
	
	
	// fetch an employee
	@GetMapping("/{eid}")
	public ResEmpDept getAEmployee(@PathVariable("eid") int employeeId) {
		log.info("Entering getAEmployee of EmployeeController...");
		ResEmpDept red = employeeService.getAEmployee(employeeId);
		return red;
		
	}
	
}
