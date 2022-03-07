package egoveframework.sample.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import egoveframework.sample.dao.SampleDAOJDBC;
import egoveframework.sample.vo.SampleVO;

public class SelectSampleListController implements Controller{
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		System.out.println("샘플 목록 검색 처리");
		
		//1.사용자 입력 정보 추출
		
		//2.DB 연동 처리
		SampleVO vo = new SampleVO();
		SampleDAOJDBC sampleDAO = new SampleDAOJDBC();
		List<SampleVO> sampleList = sampleDAO.selectSampleList(vo);
		
		//3.검색결과를 세션에 저장하고 목록 화면으로 이동한다.
/*		HttpSession session = request.getSession();
		session.setAttribute("sampleList", sampleList);*/
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("sampleList", sampleList);
		mav.setViewName("selectSampleList.jsp");
		return mav;
		
		
	}


}
