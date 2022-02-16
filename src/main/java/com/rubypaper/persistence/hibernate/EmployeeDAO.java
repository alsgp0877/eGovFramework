package com.rubypaper.persistence.hibernate;

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
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.ibatis.common.resources.Resources;

public class EmployeeDAO {
	
	private Session session;
	private SessionFactory sessionFactory;
	private Transaction transaction;
	
	public EmployeeDAO() {

		String config ="com/rubypaper/persistence/hibernate/sql-map-config.xml";
		sessionFactory=new Configuration().configure(config).buildSessionFactory();
		session=sessionFactory.openSession();
		transaction = session.getTransaction();

	}

	public void insertEmployee(EmployeeVO vo){
		System.out.println("JDBC 기반으로 직원 등록 기능 처리");
		try {
			transaction.begin();
			session.persist(vo);
			transaction.commit();
		}catch(Exception e) {
			transaction.rollback();
		}
	
	}
	
	public List<EmployeeVO> getEmployeeList(){
		String jpql = "SELECT e FROM EmployeeVO e ORDER BY e.id";
		List<EmployeeVO> employeeList = session.createQuery(jpql).getResultList();
		return employeeList;

	}
}
