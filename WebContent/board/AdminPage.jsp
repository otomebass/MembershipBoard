<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>관리자 페이지</h2>
<button onclick="location.href='AdminConfirmUser.do'">신청목록 (${i })</button><br>
<button onclick="location.href='AdminUserList.do'">회원관리 (${j })</button><br>
<button onclick="location.href='AdminBanList.do'">차단목록 (${k }) </button>

<button onclick="location.href='MainPage.do'">로그인 화면으로</button>
</body>
</html>