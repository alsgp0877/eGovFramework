package com.rubypaper.persistence.hibernate;

import java.sql.Timestamp;
import java.util.List;

import com.rubypaper.persistence.hibernate.EmployeeDAO;


public class EmployeeServiceClient {

	public static void main(String[] args) {

		EmployeeVO vo = new EmployeeVO();
		vo.setId(6L);
		vo.setName("고길동");
		vo.setStartDate(new Timestamp(System.currentTimeMillis()));
		vo.setTitle("부장");
		vo.setDeptName("총무부");
		vo.setSalary(4700.00);
		vo.setEmail("guest@ruby.co.kr");
	

		EmployeeDAO employeeDAO = new EmployeeDAO();
		employeeDAO.insertEmployee(vo);

		List<EmployeeVO> employeeList = employeeDAO.getEmployeeList();
		for (EmployeeVO employee : employeeList) {
			System.out.println("---->" + employee.toString());
		}

	}

}
