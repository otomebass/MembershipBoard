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

	<jsp:include page="header.jsp" />

	<div class="container">

		<div class="row">
			<div class="col-md-12">
				<button class="btn btn-danger pull-right" onclick="location.href='logout.do'">
					<strong>로그아웃</strong>
				</button>
				<h5 class="pull-right">
					<strong>${userName }님 Love & Peace&nbsp;&nbsp;</strong>
				</h5>
			</div>
		</div>
		<div class="row">
			<div class="col-xs-2">
				<jsp:include page="sort.jsp"></jsp:include>
			</div>
			<div class="col-xs-10">
				<form action="boardWriteForm.do" method="post">
					<input type="hidden" name="page" value="${page }" />
					<a href="boardWriteForm.do"><button class="btn btn-danger pull-right">
							<strong>글&nbsp;&nbsp;쓰&nbsp;기</strong>
						</button></a>
				</form>
			</div>
		</div>

		<br />
		<div class="table-responsive">
			<table class="table table-hover table-striped">

				<tr id="trTop">
					<th class="col-md-1 text-center">번호</th>
					<th class="col-md-5 text-center">제목</th>
					<th class="col-md-2 text-center">글쓴이</th>
					<th class="col-md-2 text-center">날짜</th>
					<th class="col-md-1 text-center">조회수</th>
				</tr>

				<c:if test="${pageInfo.listCount>0}">
					<c:forEach var="article" items="${articleList}">
						<tr>
							<td class="col-md-1 text-center">${article.boardNo }</td>
							<td class="col-md-5">
								<a href="boardDetail.do?boardNo=${article.boardNo }&page=${page}">${article.title }&nbsp;&nbsp;&nbsp;&nbsp;<span class="badge">${article.replyCount } </span></a>
							</td>
							<td class="col-md-2 text-center">${article.name }</td>

							<td class="col-md-2 text-center">
								<fmt:formatDate value="${article.boardDate }" />
							</td>
							<td class="col-md-1 text-center">${article.readCount }</td>
						</tr>
						<c:if test="${not empty param.search }">
							<tr>
								<td colspan="5">
									<c:set var="searchContent" value="${article.content }" />
									<strong>간략한 내용</strong>&nbsp;&nbsp;&nbsp;&nbsp; ${fn:substring(searchContent,0,300) }
								</td>
							</tr>
						</c:if>
					</c:forEach>
				</c:if>
			</table>
		</div>

		<div class="row">
			<div class="col-md-1"></div>
			<div class="col-md-11">
				<div class="form-group pull-right">
					<form action="boardList.do?page=${page }&sort=searchPro" method="post" class="form-inline">
						<button class="btn btn-danger pull-right" type="button" onclick="location.href='boardList.do?page=${page}'">
							<strong>목록</strong>
						</button>
						<button class="btn btn-danger pull-right" type="submit">
							<strong>찾기</strong>
						</button>
						<input style="width: 260px" type="text" class="form-control pull-right" name="search" id="search" autofocus placeholder="검색어를 입력하세요(내용, 제목, 글쓴이)" />


					</form>
				</div>
			</div>
		</div>


		<ul class="pagination">
			<c:choose>
				<c:when test="${pageInfo.page<=1}">
					<li><span style="text-color: black;">&laquo;</span></li>
				</c:when>
				<c:otherwise>
					<li><a href="boardList.do?page=${pageInfo.page-1 }"><span style="text-color: black;">&laquo;</span></a></li>
				</c:otherwise>
			</c:choose>

			<c:forEach var="pNo" begin="${pageInfo.startPage}" end="${pageInfo.endPage}">
				<c:choose>
					<c:when test="${pNo==pageInfo.page}">
						<li class="active"><span style="text-color: white; background-color: black;">${pageInfo.page }</span></li>
					</c:when>
					<c:otherwise>
						<li><a href="boardList.do?page=${pNo }"><span style="text-color: black;">${pNo }</span></a></li>
					</c:otherwise>
				</c:choose>
			</c:forEach>

			<c:choose>
				<c:when test="${pageInfo.page>=pageInfo.maxPage}">
					<li><span style="text-color: black;">&raquo;</span></li>
				</c:when>
				<c:otherwise>
					<li><a href="boardList.do?page=${pageInfo.page+1 }"><span style="text-color: black;">&raquo;</span></a></li>
				</c:otherwise>
			</c:choose>
		</ul>
	</div>

	<script src="<%=request.getContextPath()%>/js/jquery-3.2.1.min.js" type="text/javascript"></script>
	<script src="<%=request.getContextPath()%>/js/bootstrap.min.js" type="text/javascript"></script>
</body>
</html>

<!-- 





















 -->