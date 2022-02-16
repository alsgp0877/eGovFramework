package com.rubypaper.persistence.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {

	
	private Connection conn = null ;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	
	private String INSERT_EMP = 
			"INSERT INTO s_emp(id,name,start_date,title,dept_name,salary)" + 
			"VALUES ((SELECT NVL(MAX(ID),0)+1 FROM s_emp),?,?,?,?,?)";
	private String LIST_EMP = 
			"SELECT id, name, start_date, title, dept_name, salary "+
			"FROM s_emp ORDER BY name";
	
/*	private final String SAMPLE_UPDATE = "UPDATE SAMPLE SET TITLE=?, REG_USER=?,CONTENT=? WHERE ID=?";
	private final String SAMPLE_DELETE = "DELETE FROM SAMPLE WHERE ID=?";
	private final String SAMPLE_GET = "SELECT ID,TITLE, REG_USER, CONTENT, REG_DATE FROM SAMPLE WHERE ID=?";*/

	public void insertEmployee(EmployeeVO vo){
		System.out.println("JDBC 기반으로 직원 등록 기능 처리");
		try {
			conn = getConnection();
			
			stmt = conn.prepareStatement(INSERT_EMP);
			stmt.setString(1, vo.getName());
			stmt.setTimestamp(2, vo.getStartDate());
			stmt.setString(3, vo.getTitle());
			stmt.setString(4, vo.getDeptName());
			stmt.setDouble(5, vo.getSalary());
			stmt.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(stmt,conn);
		}
	}
	
	public List<EmployeeVO> getEmployeeList(){
		System.out.println("JDBC 기반으로  직원 목록 조회 기능 처리");
		List<EmployeeVO> employeeList = new ArrayList<EmployeeVO>();
		try {
			conn = getConnection();
			stmt = conn.prepareStatement(LIST_EMP);
			rs = stmt.executeQuery();
			while(rs.next()) {
				EmployeeVO employee = new EmployeeVO();
				employee.setId(rs.getLong("ID"));
				employee.setName(rs.getString("NAME"));
				employee.setStartDate(rs.getTimestamp("START_DATE"));
				employee.setTitle(rs.getString("TITLE"));
				employee.setDeptName(rs.getString("DEPT_NAME"));
				employee.setSalary(rs.getDouble("SALARY"));
				employeeList.add(employee);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(rs,stmt,conn);
		}
		
		return employeeList;
	}
	
	public Connection getConnection() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			return DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","1111");
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return null;
	}
	
	public static void close(ResultSet rs, Statement stmt, Connection conn) {
		try {
			if(rs != null)
				rs.close();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			rs = null;
		}
		
		try {
			if(stmt != null)
				stmt.close();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			stmt = null;
		}
		
		try {
			if(!conn.isClosed() || conn!=null)
				conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}finally{
			conn = null;
		}
	}
	
	public static void close(Statement stmt, Connection conn) {
		try {
			if(stmt != null)
				stmt.close();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			stmt = null;
		}
		
		try {
			if(!conn.isClosed() || conn!=null)
				conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}finally{
			conn = null;
		}
	}

}
