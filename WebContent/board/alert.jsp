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
	function auto() {
		$("#alertModal").modal();
	}
</script>
</head>

<body onload="auto()">

	<c:set var="pwChk" value="${param.pwChk }" />
	<div class="container">

		<div class="modal fade" id="alertModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">
							<span aria-hidden="true">&times;</span>
							<span class="sr-only">Close</span>
						</button>

						<c:choose>
							<c:when test="${pwChk eq 'pwFalse' }">
								<h4 class="modal-title" id="myModalLabel">잘못된 비밀번호</h4>
								<div class="modal-body">
									<h3 style="color: red;">비밀번호를 확인해 주세요</h3>
									<h4 style="color: red;">한영 키, Caps Lock 키!!</h4>
								</div>
							</c:when>
							<c:when test="${pwChk eq 'modifyFalse' }">
								<h4 class="modal-title" id="myModalLabel">글 수정 실패</h4>
								<div class="modal-body">
									<h3 style="color: red;">수정에 실패하였습니다</h3>
									<h4 style="color: red;">비밀번호 확인, 한영 키, Caps Lock 키!!</h4>
								</div>
							</c:when>
							<c:when test="${pwChk eq 'writeFalse' }">
								<h4 class="modal-title" id="myModalLabel">글 쓰기 실패</h4>
								<div class="modal-body">
									<h3 style="color: red;">글 쓰기에 실패하였습니다</h3>
									<h4 style="color: red;">비밀번호 확인, 한영 키, Caps Lock 키!!</h4>
								</div>
							</c:when>
							<c:when test="${pwChk eq 'replyWriteFalse' }">
								<h4 class="modal-title" id="myModalLabel">댓글 쓰기 실패</h4>
								<div class="modal-body">
									<h3 style="color: red;">댓글 쓰기에 실패하였습니다</h3>
								</div>
							</c:when>
							<c:when test="${pwChk eq 'deleteFalse' }">
								<h4 class="modal-title" id="myModalLabel">글 삭제 실패</h4>
								<div class="modal-body">
									<h3 style="color: red;">삭제에 실패하였습니다</h3>
									<h4 style="color: red;">비밀번호 확인, 한영 키, Caps Lock 키!!</h4>
								</div>
							</c:when>
							<c:when test="${pwChk eq 'loginFalse' }">
								<h4 class="modal-title" id="myModalLabel">로그인 실패</h4>
								<div class="modal-body">
									<h3 style="color: red;">로그인에 실패하였습니다</h3>
									<h3 style="color: red;">가입정보를 확인해 주세요</h3>
									<h4 style="color: red;">비밀번호 확인, 한영 키, Caps Lock 키!!</h4>
								</div>
							</c:when>
							<c:when test="${pwChk eq 'logout' }">
								<h4 class="modal-title" id="myModalLabel">로그아웃</h4>
								<div class="modal-body">
									<h3>좋은 하루 되세요</h3>
									<h3>Love & Peace</h3>
								</div>
							</c:when>
							<c:when test="${pwChk eq 'join' }">
								<h4 class="modal-title" id="myModalLabel">신청완료</h4>
								<div class="modal-body">
									<h3>Welcome Neverland</h3>
									<h3>회원 신청 해주셔서 감사합니다</h3>
									<h3>Neverland는 회원제 게시판으로</h3>
									<h3>가입 승인에는 약간의 시간이</h3>
									<h3>걸릴 수 있는 점 양해 바랍니다</h3>
									<h3>Love & Peace</h3>
								</div>
							</c:when>
							<c:when test="${pwChk eq 'joinFalse' }">
								<h4 class="modal-title" id="myModalLabel">회원가입 실패</h4>
								<div class="modal-body">
									<h3 style="color: red;">회원가입에 실패하였습니다</h3>
									<h3 style="color: red;">ID 중복체크를 실행해 주세요</h3>
									<h3 style="color: red;">ID 중복체크에 이상이 없다면</h3>
									<h3 style="color: red;">관리자에게 문의 바랍니다</h3>
									<h3 style="color: red;">190otomebass.gen@gamil.com</h3>
								</div>
							</c:when>
							<c:when test="${pwChk eq 'successDeleteReply' }">
								<h4 class="modal-title" id="myModalLabel">댓글 삭제 성공</h4>
								<div class="modal-body">
									<h3 style="color: red;">댓글을 삭제하였습니다</h3>
								</div>
							</c:when>
							<c:when test="${pwChk eq 'falseDeleteReply' }">
								<h4 class="modal-title" id="myModalLabel">댓글 삭제 실패</h4>
								<div class="modal-body">
									<h3 style="color: red;">댓글 삭제에 실패하였습니다</h3>
								</div>
							</c:when>
							<c:when test="${pwChk eq 'idCheckNot' }">
								<h4 class="modal-title" id="myModalLabel">ID 중복체크</h4>
								<div class="modal-body">
									<h3 style="color: red;">이미 존재하는 ID 입니다</h3>
									<h3 style="color: red;">다른 ID를 선택해 주세요</h3>
								</div>
								
							</c:when>
							<c:when test="${pwChk eq 'idCheckOk' }">
								<h4 class="modal-title" id="myModalLabel">ID 중복체크</h4>
								<div class="modal-body">
									<h3 style="color: red;">사용하실 수 있는 ID입니다</h3>
									<h3 style="color: red;">회원가입을 진행해 주세요</h3>
								</div>
							</c:when>
						</c:choose>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-danger" data-dismiss="modal">닫기</button>
					</div>
				</div>
			</div>
		</div>

	</div>
	<script src="<%=request.getContextPath()%>/js/jquery-3.2.1.min.js" type="text/javascript"></script>
	<script src="<%=request.getContextPath()%>/js/bootstrap.min.js" type="text/javascript"></script>
</body>
</html>