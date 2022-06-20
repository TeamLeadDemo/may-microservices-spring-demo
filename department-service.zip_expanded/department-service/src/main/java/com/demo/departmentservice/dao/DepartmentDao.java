package com.demo.departmentservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.departmentservice.entity.Department;

@Repository
public interface DepartmentDao extends JpaRepository<Department, Integer>{

	Department findByDepartmentId(int departmentId);

}
