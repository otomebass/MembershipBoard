<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1" />
<title>Welcome Neverland</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/bootstrap.min.css" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/custom.css" />
</head>
<title>Welcome Neverland</title>
</head>
<body>

	<jsp:include page="/board/header.jsp" />

	<div class="container">

		<br />
		<br />
		<div class="row">
			<div class="col-md-12 text-center">
				<h1>
					<strong>관리자 페이지</strong>
				</h1>
			</div>
		</div>
		<br />
		<br />
		<div class="row">
			<div class="col-md-3"></div>
			<div class="col-md-6">
				<button class="btn btn-danger btn-lg btn-block" onclick="location.href='AdminConfirmUser.do'">
					<h3>
						<strong>신청목록&nbsp;&nbsp;</strong>
						<span class="badge">${i }</span>
					</h3>
				</button>
			</div>
			<div class="col-md-3"></div>
		</div>
		<br />
		<div class="row">
			<div class="col-md-3"></div>
			<div class="col-md-6">
				<button class="btn btn-danger btn-lg btn-block" onclick="location.href='AdminUserList.do'">
					<h3>
						<strong>회원관리&nbsp;&nbsp;</strong>

						<span class="badge">${j }</span>
					</h3>
				</button>
			</div>
			<div class="col-md-3"></div>
		</div>
		<br />
		<div class="row">
			<div class="col-md-3"></div>
			<div class="col-md-6">
				<button class="btn btn-danger btn-lg btn-block" onclick="location.href='AdminBanList.do'">
					<h3>
						<strong>차단목록&nbsp;&nbsp;</strong>

						<span class="badge">${k }</span>
					</h3>
				</button>
			</div>
			<div class="col-md-3"></div>
		</div>
		<br />
		<div class="row">
			<div class="col-md-3"></div>
			<div class="col-md-6">
				<button class="btn btn-danger btn-lg btn-block" onclick="location.href='MainPage.do'">
					<h3>
						<strong>로그인 화면으로</strong>
					</h3>
				</button>
			</div>
			<div class="col-md-3"></div>
		</div>

	</div>

	<script src="<%=request.getContextPath()%>/js/jquery-3.2.1.min.js" type="text/javascript"></script>
	<script src="<%=request.getContextPath()%>/js/bootstrap.min.js" type="text/javascript"></script>
</body>
</html>