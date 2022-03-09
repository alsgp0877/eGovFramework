package egoveframework.sample.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import egoveframework.sample.dao.SampleDAOJDBC;
import egoveframework.sample.vo.SampleVO;

@Controller
public class SelectSampleController{
	/*	
	@RequestMapping(value="/selectSample.do")
	public ModelAndView selectSample(SampleVO vo,SampleDAOJDBC sampleDAO, ModelAndView mav)throws Exception{
		
		System.out.println("샘플 상세 조회 처리");
		
		//1.검색할 아이디 추출
		String id=request.getParameter("id");
		
		//2.DB 연동 처리
		SampleVO vo = new SampleVO();
		vo.getId();
		
		SampleDAOJDBC sampleDAO = new SampleDAOJDBC();
		SampleVO sample = sampleDAO.selectSample(vo);
		
		//3.검색결과를 ModelAndView에 저장하여 리턴한다.
		ModelAndView mav = new ModelAndView();
		mav.addObject("sample", sampleDAO.selectSample(vo));
		mav.setViewName("selectSample");
		return mav;
		
		
	}
*/

}
