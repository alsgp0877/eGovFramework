package egoveframework.sample.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import egoveframework.sample.vo.SampleVO;
import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

@Repository("daoIBatis")
public class SampleDAOIBatis extends EgovAbstractDAO implements SampleDAO{
		
	public SampleDAOIBatis() {
		System.out.println("SampleDAOIBatis 기능처리");
	}
	public void insertSample(SampleVO vo) throws Exception{
	
		System.out.println("insertSample 기능처리");
		insert("SampleDAO.insertSample",vo);
		
	}
	
	public void updateSample(SampleVO vo) throws Exception{
		
		System.out.println("updateSample 기능처리");
		update("SampleDAO.updateSample",vo);

		
	}
	
	public void deleteSample(SampleVO vo) throws Exception{
		
		System.out.println("deleteSample 기능처리");
		delete("SampleDAO.deleteSample",vo);
		
	}
	
	public SampleVO selectSample(SampleVO vo) throws Exception{
		
		System.out.println("selectSample 기능처리");
		return (SampleVO)select("SampleDAO.selectSample",vo);
		
	}
	
	public List<SampleVO> selectSampleList(SampleVO vo) throws Exception{
		
		System.out.println("selectSample 기능처리");
		return (List<SampleVO>)list("SampleDAO.selectSampleList",vo);

/*		if(vo.getSearchCondition().equals("TITLE")) {
			return (List<SampleVO>)list("SampleDAO.selectSampleList_TITLE",vo);
		}else if(vo.getSearchCondition().equals("CONTENT")){
			return (List<SampleVO>)list("SampleDAO.selectSampleList_CONTENT",vo);
		}
		
		return null;
*/		
	}
	

}
