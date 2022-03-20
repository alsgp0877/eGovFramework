package egoveframework.sample.service;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import egoveframework.sample.vo.SampleVO;


public class SampleServiceClient {

	public static void main(String[] args) throws Exception{
		
		//1.spring 컨테이너를 구동한다.
		AbstractApplicationContext container = new GenericXmlApplicationContext("egovframework/spring/context-*.xml");
		
		//2.spring 컨테이너로 부터 SampleServiceImpl 객체를 Lookup한다.
		SampleService sampleService = (SampleService)container.getBean("sampleService");
		
		SampleVO vo= new SampleVO();
		vo.setTitle("아이디 자동생성테스트");
		vo.setReg_user("테스터");
		vo.setContent("임시내용");
		sampleService.insertSample(vo);
		
		List<SampleVO> sampleList = sampleService.selectSampleList(vo);
		System.out.println("SAMPLE LIST");
		for(SampleVO sample : sampleList) {
			System.out.println("--->" + sample.toString());
		}
		
		//3. Spring 컨테이너 종료한다.
		container.close();
		
	}

}
