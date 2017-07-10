<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1" />
<title>Welcome Neverland</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/bootstrap.min.css" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/custom.css" />
</head>
<body>
<body>


	<c:if test="${not empty pwChk}">
		<jsp:include page="alert.jsp" />
	</c:if>

	<jsp:include page="header.jsp" />

	<div class="container">

		<div class="form-group">
			<form action="idCheck.do" method="post">
				<button type="submit" class="btn btn-danger pull-right" id="idCheck">
					<strong>ID 중복체크</strong>
				</button>
				<br />
				<br />
				<input class="form-control" type="text" name="idCheck" required="required" placeholder="ID 중복체크" autofocus="autofocus" />
			</form>
		</div>
		<form action="NewUserAction.do" method="post">
			<div class="form-group">
				<label for="id">
					<strong>I&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;D</strong>
				</label>
				<input class="form-control" type="text" name="id" id="id" required="required" placeholder="I    D">
			</div>
			<div class="form-group">
				<label for="name">
					<strong>이&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;름</strong>
				</label>
				<input class="form-control" type="text" name="name" id="name" required="required" placeholder="이    름">
			</div>
			<div class="form-group">
				<label for="pwd">
					<strong>비밀번호</strong>
				</label>
				<input class="form-control" type="password" name="pwd" id="pwd" required="required" placeholder="비밀번호">
			</div>
			<div class="form-group">
				<label for="addr">
					<strong>주&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;소</strong>
				</label>
				<input class="form-control" type="text" name="addr" id="addr" required="required" placeholder="주    소">
			</div>
			<div class="form-group">
				<label for="email">
					<strong>E-MAIL</strong>
				</label>
				<input class="form-control" type="email" name="email" id="email" required="required" placeholder="E-MAIL">
			</div>
			<div class="form-group">
				<label for="who">
					<strong>추천인 ID</strong>
				</label>
				<input class="form-control" type="text" name="who" id="who" placeholder="추천인 ID">
			</div>

			<button type="button" class="btn btn-danger pull-right" onclick="location.href='MainPage.do'">
				<strong>취소</strong>
			</button>

			<button type="submit" class="btn btn-danger pull-right">
				<strong>확인</strong>
			</button>
		</form>

	</div>
	<script src="<%=request.getContextPath()%>/js/jquery-3.2.1.min.js" type="text/javascript"></script>
	<script src="<%=request.getContextPath()%>/js/bootstrap.min.js" type="text/javascript"></script>
</body>
</html>