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
<title>Insert title here</title>
</head>
<body>
<div class="container-sm mt-5">
	<div class="row">
		<div class="col-md-6 offset-md-3">
			<h3 class="text-center">새 공지/이벤트</h3>
			<br>
			<form>
			  <div class="form-group">
			    <label for="category">분류</label>
			    <select class="form-control" name="category" id="category">
			      <c:if test="${category eq 'notice' }">
			      	<c:set var="n" value="selected" />
			      </c:if>
			      <c:if test="${category eq 'event' }">
			      	<c:set var="e" value="selected" />
			      </c:if>
			      <option ${n } selected>공지</option>
			      <option ${e }>이벤트</option>
			    </select>
			  </div>
			  <div class="form-group">
			    <label for="title">제목</label>
			    <input type="email" class="form-control" name="title" id="title" value="${title }">
			  </div>
			  <div class="form-group">
			    <label for="writer">작성자</label>
			    <input type="email" class="form-control" name="writer" id="writer" value=${writer }>
			  </div>
			  <div class="form-group">
			    <label for="content">내용</label>
			    <textarea class="form-control" name="content" id="content" rows="10">${content }</textarea>
			  </div>
			  <input type="submit" class="btn btn-success form-control" value="등록">
			</form>	
		</div>
	</div>
</div>
</body>
</html>