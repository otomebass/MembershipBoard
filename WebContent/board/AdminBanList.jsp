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
	<table border="1">
		<tr>
			<th>이름</th>
			<th>아이디</th>
			<th>비밀번호</th>
			<th>이메일</th>
			<th>주소</th>
			<th>추천인</th>
			<th>Ban</th>
		</tr>
	<c:forEach var="reject" items="${reject}">
		<tr>
			<td>${reject.name }</td>
			<td>${reject.id }</td>
			<td>${reject.pwd }</td>
			<td>${reject.email }</td>
			<td>${reject.addr }</td>
			<td>${reject.who }</td>
			<td><button onclick="location.href='Rejoin.do?id=${reject.id}'">Allow</button></td>
		</tr>
	</c:forEach>
	<tr>
		<td colspan="7">
			<button onclick="location.href='AdminPage.do'">뒤로가기</button>
		</td>
	</tr>
	</table>
</body>
</html>