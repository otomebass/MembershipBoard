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
	function deletePro() {
		$("#myModal").modal();
	}
</script>
</head>
<body>


	<jsp:include page="header.jsp" />

	<c:if test="${not empty pwChk}">

		<jsp:include page="alert.jsp" />
	</c:if>

	<div class="container">

		<div class="row">
			<div class="col-xs-5"></div>
			<div class="col-xs-7">
				<button class="btn btn-danger pull-right" type="button" onclick="location.href='boardList.do?page=${page}'">
					<strong>목록</strong>
				</button>
				<button class="btn btn-danger pull-right" type="button" onclick="deletePro();">
					<strong>삭제</strong>
				</button>
				<button class="btn btn-danger pull-right" type="button" onclick="location.href='boardModifyForm.do?boardNo=${article.boardNo}&page=${page }'">
					<strong>수정</strong>
				</button>
			</div>
		</div>
		<br />

		<table class="table">
			<tr>
				<td class="col-xs-1 text-center">글쓴이</td>
				<td class="col-xs-11">${article.name }</td>
			</tr>
			<tr>
				<td class="col-xs-1 text-center">제&nbsp;&nbsp;&nbsp;&nbsp;목</td>
				<td class="col-xs-11">${article.title }</td>
			</tr>
			<tr height="300px">
				<td colspan="2">${article.content}</td>
			</tr>
			<tr>
				<td colspan="2"></td>
			</tr>
		</table>

		<!-- 삭제 시 비밀번호 확인 -->

		<form action="boardDeletePro.do?boardNo=${article.boardNo }" method="post" name="deleteForm">
			<input type="hidden" name="page" value="${page }" />

			<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">

						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal">
								<span aria-hidden="true">&times;</span>
								<span class="sr-only">Close</span>
							</button>
							<h4 class="modal-title" id="myModalLabel">비밀번호 입력</h4>
						</div>

						<div class="modal-body">
							<div class="form-group">
								<label>
									<strong>글 비밀번호</strong>
								</label>
								<input class="form-control" type="password" name="password" required="required" placeholder="비밀번호" />
							</div>
						</div>


						<div class="modal-footer">
							<div class="row">
								<div class="col-xs-6"></div>
								<div class="col-xs-6">
									<button type="button" class="btn btn-danger pull-right" data-dismiss="modal">닫기</button>
									<button class="btn btn-danger pull-right" type="submit">
										<strong>삭제</strong>
									</button>
								</div>
							</div>
						</div>

					</div>
				</div>
			</div>
		</form>

	</div>
	<script src="<%=request.getContextPath()%>/js/jquery-3.2.1.min.js" type="text/javascript"></script>
	<script src="<%=request.getContextPath()%>/js/bootstrap.min.js" type="text/javascript"></script>
</body>
</html>