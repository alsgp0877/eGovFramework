<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="egoveframework.sample.dao.SampleDAOJDBC"%>
<%@ page import="egoveframework.sample.vo.SampleVO"%>
<%@ page import="java.util.List"%>
<%
	//1.검색할 아이디 추출
	String id = request.getParameter("id");

	//2.DB 연동처리
	SampleVO vo = new SampleVO();
	vo.setId(id);
	
	SampleDAOJDBC dao = new SampleDAOJDBC();
	SampleVO sample = dao.selectSample(vo);
	
	//3.응답화면구성
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SAMPLE 상세</title>
</head>
<body>
<center>
<h1>SAMPLE 상세</h1>
<form action="updateSample_proc.jsp" method="post">
<input name="id" type="hidden" value="<%=sample.getId() %>"/></td>
<table border="1" cellpadding="0" cellspacing="0">
<tr>
	<td bgcolor="orange" width="70">아이디</td>
	<td align="left"><input name="id" type="text" value="<%=sample.getId() %>" disabled="disabled"/></td>
</tr>
<tr>
	<td bgcolor="orange" width="70">제목</td>
	<td align="left"><input name="title" type="text" value="<%=sample.getTitle() %>" size="52"/></td>
</tr>
<tr>
	<td bgcolor="orange" width="70">작성자</td>
	<td align="left"><input name="regUser" type="text" value="<%=sample.getRegUser() %>"/></td>
</tr>
<tr>
	<td bgcolor="orange" width="70">내용</td>
	<td align="left"><textarea name="content" cols="40" rows="5"/><%=sample.getContent() %></textarea></td>
</tr>
<tr>
	<td bgcolor="orange" width="70">등록일</td>
	<td align="left"><%=sample.getRegDate() %></td>
</tr>
<tr>
	<td colspan="2" align="center"><input type="submit" value="UPDATE"/></td>
</tr>
</table>
</form>
<br>
<a href="insertSample.jsp">INSERT</a><br>
<a href="deleteSample_proc.jsp?id=<%=sample.getId()%>">DELETE</a><br>
<a href="selectSampleList.jsp">LIST</a><br>
</center>
</body>
</html>