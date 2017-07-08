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
<!-- <script type="text/javascript"
	src="https://code.jquery.com/jquery-3.1.0.js"></script>
<script>
	$(document).ready(function(){
		$("#admin").click(function(){
		var str = "admin";
			if($("#id").text() == str && $(":password").text() == str)
			location.href="AdminPage.do";
		})
	}) 
</script>-->
</head>
<body>

	<c:if test="${not empty param.pwChk}">
		<jsp:include page="/board/alert.jsp" />
	</c:if>

	<jsp:include page="/board/header.jsp" />
	<br />
	<br />
	<br />
	<div class="container">

		<form action="loginChk.do" name="frm" method="post" role="form">

			<input class="btn btn-dnager pull-right" type="button" id="admin" name="admin" value="관리자로그인" onclick="location.href='AdminPage.do'">
			<br />
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
			<input type="submit" id="login" value="로그인">
			<input type="reset" value="종료" onclick="window.close()">
			<input type="button" value="회원가입" onclick="location.href='NewUserForm.do'">
		</form>
	</div>

	<script src="<%=request.getContextPath()%>/js/jquery-3.2.1.min.js" type="text/javascript"></script>
	<script src="<%=request.getContextPath()%>/js/bootstrap.min.js" type="text/javascript"></script>
</body>
</html>