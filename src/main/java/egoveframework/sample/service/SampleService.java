package egoveframework.sample.service;

import java.util.List;

import egoveframework.sample.vo.SampleVO;


public interface SampleService{
	
	public void insertSample(SampleVO vo) throws Exception;

	public void updateSample(SampleVO vo) throws Exception;
	
	public void deleteSample(SampleVO vo) throws Exception;
	
	public SampleVO selectSample(SampleVO vo) throws Exception;
		
	
	public List<SampleVO> selectSampleList(SampleVO vo) throws Exception;
	


}
