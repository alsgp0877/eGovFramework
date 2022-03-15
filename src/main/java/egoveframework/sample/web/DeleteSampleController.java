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
public class DeleteSampleController{
/*		
	@RequestMapping(value="/deleteSample.do")
	public String deleteSample(SampleVO vo,SampleDAOJDBC sampleDAO) throws Exception{
		
		System.out.println("샘플 등록 조회 처리");
	
		//1.사용자 입력 정보 추출
		String id = request.getParameter("id");
		
		//2.DB 연동 처리
		SampleVO vo = new SampleVO();
		vo.setId(id);
		
		SampleDAOJDBC sampleDAO = new SampleDAOJDBC();
		sampleDAO.deleteSample(vo);
		
		//3.화면네비게이션
		ModelAndView mav = new ModelAndView();
		mav.setViewName("foward:selectSampleList.do");
		return "foward:selectSampleList.do";
		
		
	}
*/

}
