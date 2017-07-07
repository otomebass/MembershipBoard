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

		<form action="boardModifyPro.do" method="post" name="modifyForm">

			<div class="row">
				<button class="btn btn-danger pull-right" type="button" onclick="location.href='boardDetail.do?boardNo=${article.boardNo}&page=${page }'">
					<strong>뒤로</strong>
				</button>
				<button class="btn btn-danger pull-right" type="submit">
					<strong>수정</strong>
				</button>
			</div>

			<input type="hidden" name="boardNo" value="${article.boardNo }" />
			<input type="hidden" name="page" value="${page }" />
			<input type="hidden" name="pwChk" value="false" />

			<div class="form-group">
				<label for="name"> <strong>이&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;름</strong>
				</label>
				<input autofocus="autofocus" class="form-control" type="text" name="name" id="name" value="${article.name }" required="required" />
			</div>
			<div class="form-group">
				<label for="password"> <strong>비밀번호</strong>
				</label>
				<input class="form-control" type="password" name="password" id="password" required="required" />
			</div>
			<div class="form-group">
				<label for="title"> <strong>제&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;목</strong>
				</label>
				<input class="form-control" type="text" name="title" id="title" value="${article.title }" required="required" />
			</div>
			<div class="form-group">
				<label for="content"> <strong>내&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;용</strong>
				</label>
				<textarea class="form-control" name="content" id="content" rows="15" required="required">${article.content}</textarea>
			</div>
		</form>
	</div>
	<script src="<%=request.getContextPath()%>/js/jquery-3.2.1.min.js" type="text/javascript"></script>
	<script src="<%=request.getContextPath()%>/js/bootstrap.min.js" type="text/javascript"></script>
</body>
</html>