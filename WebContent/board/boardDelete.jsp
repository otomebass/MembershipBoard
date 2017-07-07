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
<script type="text/javascript">
	document.deleteForm.submit();
</script>
</head>
<body>
	<div class="container">
		<form action="boardDeletePro.do?boardNo=${boardNo }" method="post" name="deleteForm" target="parentWin">
			<input type="hidden" name="page" value="${page }" />
			<div class="form-group">
				<br />
				<label> <strong>사용자 비밀번호</strong>
				</label>
				<input class="form-control" type="password" name="password" required="required" placeholder="비밀번호" autofocus="autofocus" />
			</div>
			<button class="btn btn-danger center-block">
				<strong>삭제</strong>
			</button>
		</form>
	</div>
	<script src="<%=request.getContextPath()%>/js/jquery-3.2.1.min.js" type="text/javascript"></script>
	<script src="<%=request.getContextPath()%>/js/bootstrap.min.js" type="text/javascript"></script>
</body>
</html>