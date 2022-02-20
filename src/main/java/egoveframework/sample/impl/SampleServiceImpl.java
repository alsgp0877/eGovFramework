package egoveframework.sample.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egoveframework.sample.dao.SampleDAOJDBC;
import egoveframework.sample.dao.SampleDAOSpring;
import egoveframework.sample.service.SampleService;
import egoveframework.sample.vo.SampleVO;

@Service("sampleService")
public class SampleServiceImpl implements SampleService{
	
/*	@Resource(name="daoJDBC")
	private SampleDAOJDBC sampleDAO;*/
	
	@Resource(name="daoSpring")
	private SampleDAOSpring sampleDAO;
	
	public void insertSample(SampleVO vo) throws Exception{
		sampleDAO.insertSample(vo);
		//sampleDAO.insertSample(vo);
	}
	
	public void updateSample(SampleVO vo) throws Exception{
		sampleDAO.updateSample(vo);
		
		
	}
	
	public void deleteSample(SampleVO vo) throws Exception{
		sampleDAO.deleteSample(vo);
		
	}
	
	public SampleVO selectSample(SampleVO vo) throws Exception{
		
		return sampleDAO.selectSample(vo);
		
		
	}
	
	public List<SampleVO> selectSampleList(SampleVO vo) throws Exception{
		
		return sampleDAO.selectSampleList(vo);
		
		
	}

}
