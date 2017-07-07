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
<body>
	<jsp:include page="header.jsp" />

	<div class="container">

		<c:if test="${not empty pwChk}">
			<jsp:include page="alert.jsp" />
		</c:if>

		<form action="boardWritePro.do" method="post" name="boardForm">
			<div class="row">
				<div class="col-xs-3"></div>
				<div class="col-xs-9">
					<button class="btn btn-danger pull-right" type="button" onclick="location.href='boardList.do?page=${page}'">
						<strong>목록</strong>
					</button>
					<button class="btn btn-danger pull-right" type="reset">
						<strong>다시 쓰기</strong>
					</button>
					<button class="btn btn-danger pull-right" type="submit">
						<strong>등록</strong>
					</button>
				</div>
			</div>
			<br />


			<h5 style="color: red;">
				<strong>${userName}&nbsp;님 비방이나 욕설은 삼가해주세요 </strong>
			</h5>

			<div class="from-group">
				<label for="title">
					<strong>제&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;목</strong>
				</label>
				<input class="form-control" type="text" name="title" id="title" required="required" placeholder="제    목" autofocus="autofocus" />
			</div>

			<div class="form-group">
				<label for="content">
					<strong>내&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;용</strong>
				</label>
				<textarea class="form-control" name="content" id="content" rows="15" required="required" placeholder="내     용"></textarea>
			</div>
		</form>
	</div>
	<script src="<%=request.getContextPath()%>/js/jquery-3.2.1.min.js" type="text/javascript"></script>
	<script src="<%=request.getContextPath()%>/js/bootstrap.min.js" type="text/javascript"></script>
</body>
</html>