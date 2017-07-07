<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<body>
	<table border=1>
		<tr>
			<th>이름</th>
			<th>아이디</th>
			<th>추천인아이디</th>
			<th>승인</th>
		</tr>
		<c:forEach var="newuser" items="${newuser}">
			<tr>
				<td>${newuser.name}</td>
				<td>${newuser.id}</td>
				<td>${newuser.who}</td>
				<td><button onclick="location.href='ConfirmOk.do?id=${newuser.id}'">확인</button></td>
			</tr>
		</c:forEach>
		<tr>
			<td> <button onclick="location.href='AdminPage.do'">뒤로가기</button>
		</tr>
	</table>
</body>
</html>