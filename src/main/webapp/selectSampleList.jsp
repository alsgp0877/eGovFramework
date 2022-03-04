<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="egoveframework.sample.dao.SampleDAOJDBC"%>
<%@ page import="egoveframework.sample.vo.SampleVO"%>
<%@ page import="java.util.List"%>
<%
	//1.DB처리
	SampleVO vo = new SampleVO();
	SampleDAOJDBC dao = new SampleDAOJDBC();
	List<SampleVO> sampleList = dao.selectSampleList(vo);
	
	//2.응답화면구성
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SAMPLE 목록</title>
</head>
<body>
<h1>Sapple 목록</h1>
<table border="1" cellpadding="0" cellspacing="0" width="800">
<tr>
	<th bgcolor="orange" width="60">아이디</th>
	<th bgcolor="orange" width="240">제목</th>
	<th bgcolor="orange" width="40">작성자</th>
	<th bgcolor="orange" width="60">등록일</th>
</tr>

<%for(SampleVO sample : sampleList){ %>
<tr>
	<td align="center"><a href="selectSample.jsp?id=<%=sample.getId() %>"><%=sample.getId() %></td>
	<td align="center"><%=sample.getTitle() %></td>
	<td align="center"><%=sample.getRegUser() %></td>
	<td align="center"><%=sample.getRegDate() %></td>
</tr>
<%} %>
</table>
<br>
<a href="insertSample.jsp">샘플 등록</a>
</body>
</html>