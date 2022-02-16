package com.rubypaper.persistence.mybatis;

import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.ibatis.common.resources.Resources;

public class EmployeeDAO {
	
	private SqlSession mybatis;
	
	public EmployeeDAO() {
		try {
			Reader reader = Resources.getResourceAsReader("com/rubypaper/persistence/mybatis/sql-map-config.xml");
			
			SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
			mybatis = sessionFactory.openSession();
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

	public void insertEmployee(EmployeeVO vo){
		System.out.println("JDBC 기반으로 직원 등록 기능 처리");
		mybatis.insert("EmployeeDAO.insertEmployee",vo);
		mybatis.commit();
	
	}
	
	public List<EmployeeVO> getEmployeeList(){
		return mybatis.selectList("EmployeeDAO.getEmployeeList");

	}
}
