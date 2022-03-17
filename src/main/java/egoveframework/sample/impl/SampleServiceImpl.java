package egoveframework.sample.impl;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import egoveframework.sample.dao.SampleDAOIBatis;
import egoveframework.sample.dao.SampleDAOJDBC;
import egoveframework.sample.dao.SampleDAOMyBatis;
import egoveframework.sample.dao.SampleDAOSpring;
import egoveframework.sample.service.SampleService;
import egoveframework.sample.vo.SampleVO;
import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import egovframework.rte.fdl.idgnr.EgovIdGnrService;

@Service("sampleService")
public class SampleServiceImpl extends EgovAbstractServiceImpl implements SampleService{
	
/*	@Resource(name="daoJDBC")
	private SampleDAOJDBC sampleDAO;*/
	
/*	@Resource(name="daoSpring")
	private SampleDAOSpring sampleDAO;*/
	
/*	@Resource(name="daoIBatis")
	private SampleDAOIBatis sampleDAO;*/
	
	@Resource(name="daoMyBatis")
	private SampleDAOMyBatis sampleDAO;
	
	@Resource(name="egovIdGnrService")
	private EgovIdGnrService egovIdGnrService;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SampleServiceImpl.class);
	
	
	public void insertSample(SampleVO vo) throws Exception{
		LOGGER.trace("TRACE Level Logging");
		LOGGER.debug("debug Level Logging");
		LOGGER.info("info Level Logging");
		LOGGER.warn("warn Level Logging");
		LOGGER.error("error Level Logging");
		String id = egovIdGnrService.getNextStringId();
		vo.setId(id);
		sampleDAO.insertSample(vo);
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
