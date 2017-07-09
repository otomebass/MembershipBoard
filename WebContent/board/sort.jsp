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

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="btn-group">
		<button style="font-weight: bold;" type="button" class="btn btn-danger dropdown-toggle pull-right" data-toggle="dropdown">
			정렬
			<span class="caret"></span>
		</button>
		<ul class="dropdown-menu" role="menu">
			<li><a href="boardList.do?page=1&sort=readCount">조회수&nbsp;&nbsp;&nbsp;&nabla;</a></li>
			<li class="dropMenu"><a href="boardList.do?page=1&sort=replyCount">댓글수&nbsp;&nbsp;&nbsp;&nabla;</a></li>
			<li class="divider"></li>
			<li class="dropMenu"><a href="boardList.do?page=1">원래대로</a></li>
		</ul>
	</div>
	<script src="<%=request.getContextPath()%>/js/jquery-3.2.1.min.js" type="text/javascript"></script>
	<script src="<%=request.getContextPath()%>/js/bootstrap.min.js" type="text/javascript"></script>
</body>
</html>