package egoveframework.sample.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;


import egoveframework.sample.dao.SampleDAOJDBC;
import egoveframework.sample.vo.SampleVO;

@Controller
@SessionAttributes("sample")
public class SampleController{
	@RequestMapping(value="/insertSample.do", method=RequestMethod.GET)
	public String insertSampleView(SampleVO vo) throws Exception{
		
		System.out.println("등록 화면으로 이동");
		vo.setTitle("sample등록입니다.");
		vo.setRegUser("테스터");
		vo.setContent("sample등록테스트중입니다");
		return "insertSample";
		
		
	}
	@RequestMapping(value="/insertSample.do", method=RequestMethod.POST)
	public String insertSample(SampleVO vo,SampleDAOJDBC sampleDAO) throws Exception{
		
		System.out.println("등록 처리");
		sampleDAO.insertSample(vo);
		
		
		return "forward:/selectSampleList.do";
		
	}
	@RequestMapping(value="/deleteSample.do")
	public String deleteSample(String id,SampleDAOJDBC sampleDAO) throws Exception{
		
		System.out.println("샘플 등록 조회 처리");
		//sampleDAO.deleteSample(vo);
		return "forward:/selectSampleList.do";
		
		
	}

	@RequestMapping(value="/selectSample.do")
	public String selectSample(SampleVO vo,SampleDAOJDBC sampleDAO, Model model)throws Exception{
		
		System.out.println("샘플 상세 조회 처리");
		model.addAttribute("sample", sampleDAO.selectSample(vo));
		return "selectSample";
		
		
	}
	
	//검색조건목록설정
	@ModelAttribute("conditionMap")
	public Map<String,String> searchConditionMap(){
		Map<String,String> conditionMap = new HashMap<String,String>();
		conditionMap.put("제목","TITLE");
		conditionMap.put("내용", "CONTENT");
		return conditionMap;
	}
	
	@RequestMapping(value="/selectSampleList.do")
	public String selectSampleList(SampleVO vo,SampleDAOJDBC sampleDAO, Model model) throws Exception{
		
		System.out.println("샘플 목록 검색 처리");
		
		model.addAttribute("sampleList", sampleDAO.selectSampleList(vo));
		return "selectSampleList";
		
		
	}
	
	//@ModelAttribute 컨트롤러에서 우선적으로 설정해서 view에 던져줄수도있고, view에서 sample이라는 이름에 맞게 객체를 던져주면 그걸 그대로 받을수도있고
	//SampleVO vo 이것보다 우선적으로 데이터를 받는다 .
	//한 세션안에서 수정하지 않는 이상 계속 도는 데이터인것같다 
	@RequestMapping(value="/updateSample.do")
	public String updateSample(@ModelAttribute("sample")SampleVO vo,SampleDAOJDBC sampleDAO) throws Exception{
		
		System.out.println("샘플 등록 조회 처리");
		sampleDAO.updateSample(vo);
		return "foward:selectSampleList.do";
		
		
	}



}
