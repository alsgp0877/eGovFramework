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
public class SelectSampleListController{
	/*	
	@RequestMapping(value="/selectSampleList.do")
	public ModelAndView selectSampleList(SampleVO vo,SampleDAOJDBC sampleDAO, ModelAndView mav) throws Exception{
		
		System.out.println("샘플 목록 검색 처리");
		
		//1.사용자 입력 정보 추출
		
		//2.DB 연동 처리
		SampleVO vo = new SampleVO();
		SampleDAOJDBC sampleDAO = new SampleDAOJDBC();
		List<SampleVO> sampleList = sampleDAO.selectSampleList(vo);
		
		//3.검색결과를 세션에 저장하고 목록 화면으로 이동한다.
		HttpSession session = request.getSession();
		session.setAttribute("sampleList", sampleList);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("sampleList", sampleDAO.selectSampleList(vo));
		mav.setViewName("selectSampleList");
		return mav;
		
		
	}
*/

}
