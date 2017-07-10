<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>

<meta charset=UTF-8>
<title>Welcome Neverland!!</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
<script type="text/javascript" src="js/board.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1" />
<title>Welcome Neverland</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/bootstrap.min.css" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/custom.css" />


</head>
<body>

	<c:if test="${not empty param.pwChk}">
		<jsp:include page="/board/alert.jsp" />
	</c:if>

	<jsp:include page="/board/header.jsp" />

	<div class="container">

		<form action="loginChk.do" name="frm" method="post" role="form">
			<div class="form-group">
				<label for="id">
					<strong>ID</strong>
				</label>
				<input class="form-control" type="text" name="id" id="id" required="required" autofocus="autofocus" placeholder="ID">
			</div>
			<div class="form-group">
				<label for="pwd">
					<strong>비밀번호</strong>
				</label>
				<input class="form-control" type="password" name="pwd" id="pwd" required="required" placeholder="PASSWORD">
			</div>
			<button class="btn btn-danger pull-right" type="button" onclick="location.href='NewUserForm.do'">
				<strong>회원가입</strong>
			</button>
			<button class="btn btn-danger pull-right" type="submit" id="login">
				<strong>로그인</strong>
			</button>
		</form>
	</div>
	<br />
	<br />

	<jsp:include page="/board/carousel.jsp" />

	<script src="<%=request.getContextPath()%>/js/jquery-3.2.1.min.js" type="text/javascript"></script>
	<script src="<%=request.getContextPath()%>/js/bootstrap.min.js" type="text/javascript"></script>
</body>
</html>