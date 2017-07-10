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

	<jsp:include page="/board/header.jsp" />

	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<button class="btn btn-danger pull-right" onclick="location.href='AdminPage.do'">
					<strong>뒤로가기</strong>
				</button>
			</div>
		</div>
		<br />

		<div class="table-responsive">
			<table class="table table-hover table-striped">
				<tr>
					<th class="col-md-1 text-center"><strong>이름</strong></th>
					<th class="col-md-1 text-center"><strong>아이디</strong></th>
					<th class="col-md-2 text-center"><strong>비밀번호</strong></th>
					<th class="col-md-2 text-center"><strong>이메일</strong></th>
					<th class="col-md-3 text-center"><strong>주소</strong></th>
					<th class="col-md-1 text-center"><strong>추천인</strong></th>
					<th class="col-md-2 text-center"><strong>Ban</strong></th>
				</tr>
				<c:if test="${empty reject }">
					<h4 style="color: red;">신청이 없습니다</h4>
				</c:if>
				<c:forEach var="reject" items="${reject}">
					<tr>
						<td class="col-md-1">${reject.name }</td>
						<td class="col-md-1">${reject.id }</td>
						<td class="col-md-2">${reject.pwd }</td>
						<td class="col-md-2">${reject.email }</td>
						<td class="col-md-3">${reject.addr }</td>
						<td class="col-md-1">${reject.who }</td>
						<td class="col-md-2">
							<button class="btn btn-dnager pull-right" onclick="location.href='DeleteUser.do?id=${reject.id}'">
								<strong>Delete</strong>
							</button>
							<button class="btn btn-danger pull-right" onclick="location.href='Rejoin.do?id=${reject.id}'">
								<strong>Allow</strong>
							</button>
						</td>
					</tr>
				</c:forEach>

			</table>
		</div>
	</div>
	<script src="<%=request.getContextPath()%>/js/jquery-3.2.1.min.js" type="text/javascript"></script>
	<script src="<%=request.getContextPath()%>/js/bootstrap.min.js" type="text/javascript"></script>
</body>
</html>
