package egoveframework.sample.service.impl;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import egoveframework.sample.service.SampleDAO;
import egoveframework.sample.service.SampleService;
import egoveframework.sample.service.SampleVO;

@Service("sampleService")
public class SampleServiceImpl implements SampleService {
	
	@Resource(name="daoSpring")
	private SampleDAO sampleDAO;
	
	@Override
	public void insertSample(SampleVO vo) throws Exception {
		// TODO Auto-generated method stub
		sampleDAO.insertSample(vo);
		
	}

	@Override
	public void updateSample(SampleVO vo) throws Exception {
		// TODO Auto-generated method stub
		sampleDAO.updateSample(vo);
	}

	@Override
	public void deleteSample(SampleVO vo) throws Exception {
		// TODO Auto-generated method stub
		sampleDAO.deleteSample(vo);
		
	}

	@Override
	public List<SampleVO> selectSampleList(SampleVO vo) throws Exception {
		// TODO Auto-generated method stub
		return sampleDAO.selectSampleList(vo);
	}

	@Override
	public SampleVO selectSample(SampleVO vo) throws Exception {
		// TODO Auto-generated method stub
		return sampleDAO.selectSample(vo);
	}

}
