<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>

<meta charset=UTF-8">
<title>Welcome Neverland!!</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
<script type="text/javascript" src="js/board.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1" />
<title>Welcome Neverland</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/bootstrap.min.css" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/custom.css" />
</head>
<body>

	<c:set var="pwChk" value="${param.pwChk }" />
	<c:if test="${not empty pwChk}">
		<jsp:include page="/board/alert.jsp" />
	</c:if>

	<h3>게시판 접속</h3>
	<form action="loginChk.do" name="frm" method="post">
		아이디 :
		<input type="text" name="id">
		비밀번호 :
		<input type="password" name="pwd">
		<input type="button" value="관리자로그인" onclick="admincheck()">


		<br>
		<input type="submit" value="로그인">
		<input type="reset" value="종료" onclick="window.close()">
		<input type="button" value="회원가입" onclick="location.href='NewUserForm.do'">
	</form>
</body>
</html>