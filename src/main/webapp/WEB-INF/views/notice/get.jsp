<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script src="https://kit.fontawesome.com/a076d05399.js"></script>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<script>
var result = '${result }';
</script>
<script src="${root }/resources/js/notice_get.js"></script>
<link rel="stylesheet" type="text/css" href="${root }/resources/css/font.css">
<link rel="stylesheet" type="text/css" href="${root }/resources/css/notice_get.css">
<title>Insert title here</title>
</head>
<body>
<div class="container-sm m-5">
	<div class="row">
		<div class="col-md-6 offset-md-3">
			<h3 class="text-center">공지/이벤트</h3> ${result }
			<br>
			<form id="deleteForm" action="${root }/notice/delete?no=${notice.no}" method="post">
			<%--
			  <div class="form-group">
			    <label for="no">글 번호</label>
			    <input type="text" class="form-control" name="no" id="no" value="${notice.no}" readonly>
			  </div>
			  <div class="form-group">
			    <label for="regdate">작성일</label>
			    <fmt:formatDate var="regdate" value="${notice.regdate }" pattern="yyyy-MM-dd HH:mm" />
			    <input type="text" class="form-control" name="regdate" id="regdate" value="${regdate}" readonly>
			  </div>  
			 --%>
			  <div>
			  	<fmt:formatDate var="regdate" value="${notice.regdate }" pattern="yyyy-MM-dd HH:mm" />
			  	<span>No. ${notice.no }</span>
			  	<span class="float-right">작성일시: ${regdate }</span>
			  </div>
			  <br>
			  <div class="form-group">
			    <label for="category">분류</label>
			    <select class="form-control" name="category" id="category" disabled>
			      <c:if test="${notice.category eq 'notice' }">
			      	<c:set var="n" value="selected" />
			      </c:if>
			      <c:if test="${notice.category eq 'event' }">
			      	<c:set var="e" value="selected" />
			      </c:if>
			      <option value="notice" ${n } selected>공지</option> <%-- ? 잘 되는지 --%>
			      <option value="event" ${e }>이벤트</option>
			    </select>
			  </div>
			  <div class="form-group">
			    <label for="writer">작성자</label>
			    <input type="text" class="form-control" name="writer" id="writer" value="${user.name }" readonly>
			  </div>
			  <div class="form-group">
			    <label for="title">제목</label>
			    <input type="text" class="form-control" name="title" id="title" value="${notice.title }" readonly>
			  </div>
			  <div class="form-group">
			    <label for="content">내용</label>
			    <textarea class="form-control" name="content" id="content" rows="10" readonly>${notice.content }</textarea>
			  </div>
			  <button id="deleteBtn" class="btn btn-danger float-right">삭제</button>
			</form>	
			<a href="${root }/notice/modify?no=${notice.no }" class="btn btn-primary float-right mr-1">수정</a>
			<a href="${root }/notice/list" class="btn btn-success">목록</a>
		</div>
	</div>
	
	<hr>
	<%-- Reply --%>
	<div class="row m-3">
		<div class="col-md-8 offset-md-2">
			<form method="post" id="replyForm">
			  <div class="d-flex justify-content-between align-items-center">
				<label for="content">nickname</label>
				<input type="text" class="form-control mx-1" name="reply" id="reply">
				<button class="btn btn-light float-right" id="newReplyBtn">등록</button>
			  </div>
			</form>
		</div>
	</div>
</div>
</body>
</html>