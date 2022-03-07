package egoveframework.sample.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import egoveframework.sample.dao.SampleDAOJDBC;
import egoveframework.sample.vo.SampleVO;

public class UpdateSampleController implements Controller{
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		System.out.println("샘플 등록 조회 처리");
		
		//1.사용자 입력 정보 추출
		String id = request.getParameter("id");
		String title = request.getParameter("title");
		String regUser = request.getParameter("regUser");
		String content = request.getParameter("content");
		
		//2.DB 연동 처리
		SampleVO vo = new SampleVO();
		vo.setId(id);
		vo.setTitle(title);
		vo.setRegUser(regUser);
		vo.setContent(content);
		
		SampleDAOJDBC sampleDAO = new SampleDAOJDBC();
		sampleDAO.updateSample(vo);
		
		//3.화면네비게이션
		ModelAndView mav = new ModelAndView();
		mav.setViewName("selectSampleList.do");
		return mav;
		
		
	}


}
