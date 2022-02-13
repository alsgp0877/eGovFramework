package egoveframework.example.sample.service;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import egoveframework.sample.service.SampleVO;
import egoveframework.sample.service.impl.CollectionBean;
import egoveframework.sample.service.impl.SampleServiceImpl;

public class SampleServiceClient {
	
	public static void main(String[] args) throws Exception{
		//1.Spring 컨테이너를 구동한다.
		//AbstractApplicationContext container = new GenericXmlApplicationContext("egovframework/spring/context-common.xml");
		
		//String[] configurations= {"egovframework/spring/context-common.xml","egovframework/spring/context-datasource.xml"};
		//AbstractApplicationContext container = new GenericXmlApplicationContext(configurations);
		
		AbstractApplicationContext container = new GenericXmlApplicationContext("egovframework/spring/context-*.xml");
		
		
		//2.Spring 컨테이너로 부터 SampleServiceImpl 객체를 Lookup 한다.
		SampleServiceImpl sampleService = (SampleServiceImpl)container.getBean("sampleService");
		SampleVO vo = new SampleVO();
		vo.setTitle("임시제목");
		vo.setRegUser("테스터");
		vo.setContent("임시내용입니다..");
		sampleService.insertSample(vo);
		
		List<SampleVO> sampleList = sampleService.selectSampleList(vo);
		System.out.println("[Sample LIST]");
		for(SampleVO sample : sampleList) {
			System.out.println("-->" + sample.toString());
		}

		//3.Spring 컨테이너를 종료한다.
		container.close();
	}

}
