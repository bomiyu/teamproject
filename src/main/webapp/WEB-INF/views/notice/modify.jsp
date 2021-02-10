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
<script>
var root = '${root}';
var no = ${notice.no};// 수정했음
//var notice = '${notice.json}';// 이걸 넘기면 안 되네.,.? 수정된 내용을 넘겨야 하는데
</script>
<script src="https://kit.fontawesome.com/a076d05399.js"></script>
<script src="${root }/resources/js/notice_modify.js"></script>
<link rel="stylesheet" type="text/css" href="${root }/resources/css/font.css">
<title>Insert title here</title>
</head>
<body>
<div class="container-sm my-5">
	<div class="row">
		<div class="col-12 col-md-6 offset-md-3">
			<h3 class="text-center">공지/이벤트 수정</h3>
			<br>
			<form method="post">
			  <div>
			  	<fmt:formatDate var="regdate" value="${notice.regdate }" pattern="yyyy-MM-dd HH:mm" />
			  	<span>No. ${notice.no }</span>
			  	<span class="float-right">작성일시: ${regdate }</span>
			  </div>
			  <br>
			  <div class="form-group">
			    <label for="category">분류</label>
			    <select class="form-control" name="category" id="category">
			      <c:if test="${notice.category eq 'notice' }">
			      	<c:set var="n" value="selected" />
			      </c:if>
			      <c:if test="${notice.category eq 'event' }">
			      	<c:set var="e" value="selected" />
			      </c:if>
			      <option value="notice" ${n } selected>공지</option>
			      <option value="event" ${e }>이벤트</option>
			    </select>
			  </div>
			  <div class="form-group">
			    <label for="writer">작성자</label>
			    <input type="text" class="form-control" value="${notice.nickname }" readonly>
			  </div>
			  <div class="form-group">
			    <label for="title">제목</label>
			    <input type="text" class="form-control" name="title" id="title" value="${notice.title }">
			  </div>
			  <div class="form-group">
			    <label for="content">내용</label>
			    <textarea class="form-control" name="content" id="content" rows="10">${notice.content }</textarea>
			  </div>
			  <button id="modifyBtn" type="submit" class="btn btn-success float-right">수정</button>
			</form>	
		    <button id="cancelyBtn" class="btn btn-secondary  float-right mr-1">취소</button>
		</div>
	</div>
</div>
</body>
</html>