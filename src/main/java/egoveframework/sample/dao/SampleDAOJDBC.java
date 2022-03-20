package egoveframework.sample.dao;

import java.io.PrintStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;


import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import egoveframework.sample.common.JDBCUtil;
import egoveframework.sample.vo.SampleVO;

@Repository("daoJDBC")
public class SampleDAOJDBC {
	
	private Connection conn;
	private PreparedStatement stmt;
	private ResultSet rs;


	
	//private final String SAMPLE_INSERT = "INSERT INTO SAMPLE(ID,TITLE,REG_USER,CONTENT,REG_DATE) VALUES ((SELECT NVL(MAX(ID),0)+1 FROM SAMPLE),?,?,?,SYSDATE)";
	private final String SAMPLE_INSERT = "INSERT INTO SAMPLE(ID,TITLE,REG_USER,CONTENT,REG_DATE) VALUES (?,?,?,?,SYSDATE)";
	private final String SAMPLE_UPDATE = "UPDATE SAMPLE SET TITLE=?,REG_USER=?,CONTENT=? WHERE ID=?";
	private final String SAMPLE_DELETE = "DELETE FROM SAMPLE WHERE ID=?";
	private final String SAMPLE_GET = "SELECT ID,TITLE,REG_USER,CONTENT,REG_DATE FROM SAMPLE WHERE ID=?"; 
	private final String SAMPLE_LIST = "SELECT ID,TITLE,REG_USER,CONTENT,REG_DATE FROM SAMPLE ORDER BY REG_DATE DESC"; 
	
	private final String SAMPLE_LIST_TITLE = "SELECT ID,TITLE,REG_USER,CONTENT,REG_DATE FROM SAMPLE WHERE TITLE LIKE '%'||?||'%' ORDER BY REG_DATE DESC";
	private final String SAMPLE_LIST_CONTENT = "SELECT ID,TITLE,REG_USER,CONTENT,REG_DATE FROM SAMPLE WHERE CONTENT LIKE '%'||?||'%' ORDER BY REG_DATE DESC";
	
	public SampleDAOJDBC() {
		System.out.println("SampleDAOJDBC 기능처리");
	}
	public void insertSample(SampleVO vo) throws Exception{
	
		System.out.println("insertSample 기능처리");
		conn = JDBCUtil.getConnection();
		stmt = conn.prepareStatement(SAMPLE_INSERT);
		stmt.setString(1, "SAMPLE-00008");
		stmt.setString(2, vo.getTitle());
		stmt.setString(3, vo.getReg_user());
		stmt.setString(4, vo.getContent());
		stmt.executeUpdate();
		JDBCUtil.close(stmt,conn);
		
	}
	
	public void updateSample(SampleVO vo) throws Exception{
		
		System.out.println("updateSample 기능처리");
		conn = JDBCUtil.getConnection();
		stmt = conn.prepareStatement(SAMPLE_UPDATE);
		stmt.setString(1, vo.getTitle());
		stmt.setString(2, vo.getReg_user());
		stmt.setString(3, vo.getContent());
		stmt.setString(4, vo.getId());
		stmt.executeUpdate();
		JDBCUtil.close(stmt,conn);
		
	}
	
	public void deleteSample(SampleVO vo) throws Exception{
		
		System.out.println("deleteSample 기능처리");
		conn = JDBCUtil.getConnection();
		stmt = conn.prepareStatement(SAMPLE_DELETE);
		stmt.setString(1, vo.getId());
		stmt.executeUpdate();
		JDBCUtil.close(stmt,conn);
		
	}
	
	public SampleVO selectSample(SampleVO vo) throws Exception{
		
		System.out.println("selectSample 기능처리");
		SampleVO vo1 = null;
		conn = JDBCUtil.getConnection();
		stmt = conn.prepareStatement(SAMPLE_GET);
		stmt.setString(1, vo.getId());
		rs=stmt.executeQuery();
		if(rs.next()) {
			vo1 = new SampleVO();
			vo1.setId(rs.getString("ID"));
			vo1.setTitle(rs.getString("TITLE"));
			vo1.setReg_user(rs.getString("REG_USER"));
			vo1.setContent(rs.getString("CONTENT"));
			vo1.setReg_date(rs.getDate("REG_DATE"));
			
		}
		JDBCUtil.close(rs,stmt,conn);
		return vo1;
		
	}
	
	public List<SampleVO> selectSampleList(SampleVO vo) throws Exception{
		
		System.out.println("selectSampleList 기능처리");
		List<SampleVO> sampleList = new ArrayList<SampleVO>();
		conn = JDBCUtil.getConnection();
		if(vo.getSearchCondition().equals("TITLE")) {
			stmt = conn.prepareStatement(SAMPLE_LIST_TITLE);
		}else if(vo.getSearchCondition().equals("CONTENT")) {
			stmt = conn.prepareStatement(SAMPLE_LIST_CONTENT);
		}
		stmt.setString(1, vo.getSearchKeyword());
		rs=stmt.executeQuery();
		while(rs.next()) {
			
			SampleVO sample = new SampleVO();
			sample.setId(rs.getString("ID"));
			sample.setTitle(rs.getString("TITLE"));
			sample.setReg_user(rs.getString("REG_USER"));
			sample.setContent(rs.getString("CONTENT"));
			sample.setReg_date(rs.getDate("REG_DATE"));
			sampleList.add(sample);
		}

		JDBCUtil.close(rs,stmt,conn);
		return sampleList;
		
	}
	
	
	
	

}
