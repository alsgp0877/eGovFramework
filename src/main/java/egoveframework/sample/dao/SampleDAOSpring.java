package egoveframework.sample.dao;


import java.util.List;

import javax.annotation.Resource;


import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import egoveframework.sample.impl.SampleRowMapper;
import egoveframework.sample.vo.SampleVO;

@Repository("daoSpring")
public class SampleDAOSpring {
	
	
	@Resource(name="jdbcTemplate")
	private JdbcTemplate spring;
	//(SELECT NVL(MAX(ID),0)+1 FROM SAMPLE)
	private final String SAMPLE_INSERT = "INSERT INTO SAMPLE(ID,TITLE,REG_USER,CONTENT,REG_DATE) VALUES (?,?,?,?,SYSDATE)";
	private final String SAMPLE_UPDATE = "UPDATE SAMPLE SET TITLE=?,REG_USER=?,CONTENT=? WHERE ID=?";
	private final String SAMPLE_DELETE = "DELETE FROM SAMPLE WHERE ID=?";
	private final String SAMPLE_GET = "SELECT ID,TITLE,REG_USER,CONTENT,REG_DATE FROM SAMPLE WHERE ID=?"; 
	private final String SAMPLE_LIST = "SELECT ID,TITLE,REG_USER,CONTENT,REG_DATE FROM SAMPLE ORDER BY REG_DATE DESC"; 
	
	public SampleDAOSpring() {
		System.out.println("SampleDAOSpring 기능처리");
	}
	public void insertSample(SampleVO vo) throws Exception{
	
		System.out.println("insertSample 기능처리");
		Object[] args = {vo.getId(), vo.getTitle(),vo.getRegUser(), vo.getContent()};
		spring.update(SAMPLE_INSERT,args);
		
	}
	
	public void updateSample(SampleVO vo) throws Exception{
		
		System.out.println("updateSample 기능처리");
		Object[] args = {vo.getTitle(),vo.getRegUser(), vo.getContent(),vo.getId()};
		spring.update(SAMPLE_UPDATE,args);
		
	}
	
	public void deleteSample(SampleVO vo) throws Exception{
		
		System.out.println("deleteSample 기능처리");
		spring.update(SAMPLE_DELETE,vo.getId());
		
		
	}
	
	public SampleVO selectSample(SampleVO vo) throws Exception{
		
		System.out.println("selectSample 기능처리");
		Object[] args = {vo.getId()};
		return spring.queryForObject(SAMPLE_GET,args,new SampleRowMapper());
		
	}
	
	public List<SampleVO> selectSampleList(SampleVO vo) throws Exception{
		
		System.out.println("selectSampleList 기능처리");
		return spring.query(SAMPLE_LIST,new SampleRowMapper());
		
	}
	
	
	
	

}
