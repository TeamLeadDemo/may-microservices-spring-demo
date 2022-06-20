package com.demo.departmentservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.departmentservice.entity.Department;
import com.demo.departmentservice.service.DepartmentService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("departments")
@Slf4j
public class DepartmentController {
	
	@Autowired
	DepartmentService deptService;
	
	// fetch a department
	@GetMapping("/{did}")
	public Department getADepartment(@PathVariable("did") int departmentId) {
		log.info("Entering getADepartment in DepartmentController...");
		Department department = deptService.getADepartment(departmentId);
		return department;
	}
	
	
	// add a department
	@PostMapping("/")
	public Department addDepartment(@RequestBody Department department) {
		log.info("Entering addDepartment in DepartmentController...");
		Department returnDepartment = deptService.addDepartment(department);
		return returnDepartment;
	}
}
