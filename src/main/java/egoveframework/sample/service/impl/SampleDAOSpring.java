package egoveframework.sample.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import egoveframework.sample.service.SampleDAO;
import egoveframework.sample.service.SampleVO;
import egoveframework.sample.service.common.JDBCUtil;

@Repository("daoSpring")
public class SampleDAOSpring implements SampleDAO{
	
	@Resource(name="jdbcTemplate")
	private JdbcTemplate spring;
	private Connection conn;
	private PreparedStatement stmt;
	private ResultSet rs;
	
	private final String SAMPLE_INSERT = "INSERT INTO SAMPLE(ID, TITLE, REG_USER,CONTENT,REG_DATE) VALUES ((SELECT NVL(MAX(ID),0)+1 FROM SAMPLE),?,?,?,SYSDATE)";
	private final String SAMPLE_UPDATE = "UPDATE SAMPLE SET TITLE=?, REG_USER=?,CONTENT=? WHERE ID=?";
	private final String SAMPLE_DELETE = "DELETE FROM SAMPLE WHERE ID=?";
	private final String SAMPLE_GET = "SELECT ID,TITLE, REG_USER, CONTENT, REG_DATE FROM SAMPLE WHERE ID=?";
	private final String SAMPLE_LIST = "SELECT ID,TITLE,REG_USER,CONTENT,REG_DATE FROM SAMPLE ORDER BY REG_DATE DESC";
	
	public SampleDAOSpring() {
		System.out.println("SampleDAOJDBC 생성");
	}
	

	public void insertSample(SampleVO vo) throws Exception{
		System.out.println("insertSample 생성");
		Object[] args= {vo.getTitle(),vo.getRegUser(),vo.getContent()};
		spring.update(SAMPLE_INSERT,args);
	}
	
	public void updateSample(SampleVO vo) throws Exception{
		System.out.println("updateSample 생성");
		Object[] args= {vo.getId(),vo.getTitle(),vo.getRegUser(),vo.getContent(),vo.getId()};
		spring.update(SAMPLE_UPDATE,args);
	}
	
	public void deleteSample(SampleVO vo) throws Exception{
		System.out.println("deleteSample 생성");
		Object[] args= {vo.getId()};
		spring.update(SAMPLE_DELETE,vo.getId());
	}
	
	@SuppressWarnings("deprecation")
	public List<SampleVO> selectSampleList(SampleVO vo) throws Exception{
		System.out.println("selectSampleList 생성");
		return spring.query(SAMPLE_LIST,new SampleRowMapper());

	}
	
	public SampleVO selectSample(SampleVO vo) throws Exception{	
		System.out.println("selectSample 생성");
		Object[] args= {vo.getId()};
		return spring.queryForObject(SAMPLE_GET,args,new SampleRowMapper());
		
	}

}
