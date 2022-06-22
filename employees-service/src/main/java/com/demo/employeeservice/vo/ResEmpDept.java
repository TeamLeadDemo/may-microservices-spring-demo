package com.demo.employeeservice.vo;

import com.demo.employeeservice.entity.Employee;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResEmpDept {

	private Employee employee;
	private Department department;
	
}
