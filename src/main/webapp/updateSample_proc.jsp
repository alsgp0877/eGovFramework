<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="egoveframework.sample.dao.SampleDAOJDBC"%>
<%@ page import="egoveframework.sample.vo.SampleVO"%>
<%@ page import="java.util.List"%>
<%
	//1.사용자 입력 정보 추출
	request.setCharacterEncoding("UTF-8");
	String id = request.getParameter("id");
	String title = request.getParameter("title");
	String regUser = request.getParameter("regUser");
	String content = request.getParameter("content");

	//2.DB 연동처리 
	SampleVO vo = new SampleVO();
	vo.setId(id);
	vo.setTitle(title);
	vo.setRegUser(regUser);
	vo.setContent(content);
	
	SampleDAOJDBC sampleDAO = new SampleDAOJDBC();
	sampleDAO.updateSample(vo);
	
	//3.화면 네비게이션
	response.sendRedirect("selectSampleList.jsp");
%>
