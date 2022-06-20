package com.demo.departmentservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.departmentservice.dao.DepartmentDao;
import com.demo.departmentservice.entity.Department;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DepartmentService {

	@Autowired
	DepartmentDao deptDao;
	
	public Department getADepartment(int departmentId) {
		log.info("Entering getADepartment in DepartmentService...");
		Department department = deptDao.findByDepartmentId(departmentId);
		return department;
	}

	public Department addDepartment(Department department) {
		log.info("Entering addDepartment in DepartmentService...");
		Department returnDepartment = deptDao.saveAndFlush(department);
		return returnDepartment;
	}

}
