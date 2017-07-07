<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
<script type="text/javascript" src="js/board.js"></script>
</head>
<body>
	<h3>게시판 접속</h3>
	<form action="loginChk.do" name="frm" method="post">
		아이디 :
		<input type="text" name="id">
		비밀번호 :
		<input type="password" name="pw">
		<input type="button" value="관리자로그인" onclick="admincheck()">


		<br>
		<input type="submit" value="로그인">
		<input type="reset" value="종료" onclick="window.close()">
		<input type="button" value="회원가입" onclick="location.href='NewUserForm.do'">
	</form>
</body>
</html>