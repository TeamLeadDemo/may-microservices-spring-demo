package com.demo.employeeservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.demo.employeeservice.dao.EmployeeDao;
import com.demo.employeeservice.entity.Employee;
import com.demo.employeeservice.vo.Department;
import com.demo.employeeservice.vo.ResEmpDept;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EmployeeService {
	
	@Autowired
	EmployeeDao employeeDao;
	
	@Autowired // autowiring is possible because the bean in configured in EmployeeServiceApllication.java
	RestTemplate restTemplate;

	public Employee addEmployee(Employee employee) {
		log.info("Entering addEmployee of EmployeeService...");
		Employee returnedEmployee = employeeDao.saveAndFlush(employee);
		return returnedEmployee;
	}

	public ResEmpDept getAEmployee(int employeeId) {
		log.info("Entering getAEmployee of EmployeeService...");
		// get the empolyee info from the DB
		Employee employee = employeeDao.findByEmployeeId(employeeId);
		
		// get the corresponding department info by consuming the department enpoint of fetching a department
		// for this we need to use an object of RestTemplate, 
		// so configure the rest template as a bean in the EmployeeServiceApplication.java file 
		// so now lets use restTemplate to consume an endpoint of department service
		Department department = restTemplate.getForObject("http://localhost:4001/departments/"+employee.getEmployeeDepartmentId(), Department.class);
		
		// set both the objects in red and return it to controller
		ResEmpDept red = new ResEmpDept();
		red.setEmployee(employee);
		red.setDepartment(department);
		
		return red;
	}

}
