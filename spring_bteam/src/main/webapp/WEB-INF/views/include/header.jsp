<%@ page import="com.project.bteam.user.UserVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
UserVO vo = (UserVO) session.getAttribute("login_info");
pageContext.setAttribute("vo", vo);
%>
<header>
	<a href="companyPage">회사소개</a>
	<a href="productPage">제품소개</a>
	<a href="noticeBoard?board_category=0">공지사항</a>
	<a href="reviewBoard?board_category=1">사용후기</a>
	<a href="qnaBoard">문의하기</a>
	<div class="right">
		<c:if test="${login_info eq null}">
		<a href="login">로그인</a>
		<a href="signup">회원가입</a>
		</c:if>
		<c:if test="${login_info ne null}">
		<img src="profileImgDn?user_email=${login_info.user_email}" style="width:40px; border-radius:40px; border:1px solid black;" />
					${login_info.user_nickname}님
			<c:if test="${login_info.user_email eq 'admin'}">
			<a href="adminPage">관리페이지</a>
			</c:if>
			<c:if test="${login_info.user_email ne 'admin'}">
			<a href="myPage?user_email=${login_info.user_email }">마이페이지</a>
			</c:if>
		<a onclick="go_logout()">로그아웃</a>
		</c:if>
	</div>
</header>
<script type="text/javascript">
function go_logout(){
	$.ajax({
		url: 'logout',
		success: function(){
			location.reload();
		},
		error: function(req, text){
			alert(text+':'+req.status);
		}		
	});	
}
</script>