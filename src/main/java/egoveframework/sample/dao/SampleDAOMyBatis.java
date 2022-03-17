package egoveframework.sample.dao;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import egoveframework.sample.impl.SampleMapper;
import egoveframework.sample.vo.SampleVO;
import egovframework.rte.psl.dataaccess.EgovAbstractDAO;
import egovframework.rte.psl.dataaccess.EgovAbstractMapper;

@Repository("daoMyBatis")
public class SampleDAOMyBatis extends EgovAbstractMapper implements SampleDAO{
	
	@Resource(name="sampleMapper")
	private SampleMapper mybatis;
	
	public SampleDAOMyBatis() {
		System.out.println("SampleDAOIBatis 기능처리");
	}
	public void insertSample(SampleVO vo) throws Exception{
	
		System.out.println("MyBatis insertSample 기능처리");
		//insert("insertSample",vo);
		mybatis.insertSample(vo);
		
	}
	
	public void updateSample(SampleVO vo) throws Exception{
		
		System.out.println("MyBatis updateSample 기능처리");
		//update("updateSample",vo);
		mybatis.updateSample(vo);

		
	}
	
	public void deleteSample(SampleVO vo) throws Exception{
		
		System.out.println("MyBatis deleteSample 기능처리");
		//delete("deleteSample",vo);
		mybatis.deleteSample(vo);
	}
	
	public SampleVO selectSample(SampleVO vo) throws Exception{
		
		System.out.println("MyBatis selectSample 기능처리");
		//return (SampleVO)selectOne("selectSample",vo);
		return (SampleVO)mybatis.selectSample(vo);
		
	}
	
	public List<SampleVO> selectSampleList(SampleVO vo) throws Exception{
		
		System.out.println("MyBatis selectSampleList 기능처리");
		//return selectList("selectSampleList",vo);
		return mybatis.selectSampleList(vo);

/*		if(vo.getSearchCondition().equals("TITLE")) {
			return (List<SampleVO>)list("SampleDAO.selectSampleList_TITLE",vo);
		}else if(vo.getSearchCondition().equals("CONTENT")){
			return (List<SampleVO>)list("SampleDAO.selectSampleList_CONTENT",vo);
		}
		
		return null;
*/		
	}
	

}
