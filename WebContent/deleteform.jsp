﻿<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>



<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%int no = Integer.valueOf(request.getParameter("no")); %>
	<form method="post" action="gb">
	<input type="hidden" name="a" value="delete">
	<input type='text' name="no" value="<%=no%>">
	<table>
		<tr>
			<td>비밀번호</td>
			<td><input type="password" name="password"></td>
			<td><input type="submit" value="확인"></td>
			<td><a href="gb?a=list">메인으로 돌아가기</a></td>
		</tr>
	</table>
	</form>
</body>
</html>