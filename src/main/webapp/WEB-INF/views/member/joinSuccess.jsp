<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<<<<<<< HEAD
<%@ taglib prefix="m" tagdir="/WEB-INF/tags"%> 
=======
<%@ taglib prefix="m" tagdir="/WEB-INF/tags"%>
>>>>>>> branch 'mountain_team' of https://github.com/bomiyu/teamproject.git

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
  href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
  src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
  src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
  src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script src="https://kit.fontawesome.com/a076d05399.js"></script>



<title>Insert title here</title>
</head>
<body>


	<m:topNav />


	<div class="media">
		<div class="media-body">
			<h5 class="mt-0">WELCOME</h5>
			회원 가입을 축하합니다.
		</div>
	</div>

	<a href="${root }/member/login">
		<button type="submit" class="btn btn-primary">로그인</button>
	</a>


</body>
</html>