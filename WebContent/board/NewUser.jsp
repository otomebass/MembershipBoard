<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/style.css">
<script type="text/javascript" src="../script/board.js"></script>
<title>Insert title here</title>

</head>
<body>
	<form action="NewUserAction.do" method="post">
		<table border=1>
			<tr>
				<th>이름</th>
				<td>
					<input type="text" name="name">
				</td>
			</tr>
			<tr>
				<th>아이디</th>
				<td>
					<input type="text" name="id">
				</td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td>
					<input type="password" name="pwd">
				</td>
			</tr>
			<tr>
				<th>주소</th>
				<td>
					<input type="text" name="addr">
				</td>
			</tr>
			<tr>
				<th>이메일</th>
				<td>
					<input type="text" name="email">
				</td>
			</tr>
			<tr>
				<th>추천인아이디</th>
				<td>
					<input type="text" name="who">
				</td>
			</tr>
			<tr>
				<td colspan=2>
					<input type="submit" value="확인">
					<input type="button" value="취소" onclick="location.href='MainPage.do'">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>