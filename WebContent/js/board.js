/**
 * 
 */
function boardCheck() {
	if (document.frm.title.value.length == 0) {
		alert("제목을 입력하세요.");
		frm.title.focus();
		return false;
	}

	if (document.frm.content.value.length == 0) {
		alert("본문을 입력하세요.");
		frm.content.focus();
		return false;
	}
	return true;
}

function admincheck() {
	if (frm.id.value == "admin" && frm.pw.value == "admin") {
		alert("관리자 로그인");
		location.href = "AdminPage.do";
		// location.href="ShowConfirmUserAction.do";
	}
}
