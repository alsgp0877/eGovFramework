<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head><meta charset="UTF-8"><title>기본에러화면</title></head>
<body>
<!-- 타이틀 시작 -->
<table width="100%" border="1" cellspacing="0" cellpadding="0" align="center">
	<tr>
		<td align="center">
		Message:${exception.message}
		</td> 
	</tr>
</table>
</body>
</html>