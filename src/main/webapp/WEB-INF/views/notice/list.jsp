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
var root = '${root}';	
var result = '${result }';
var isManager = ('${authUser.manager}' == 1);
</script>
<script src="${root }/resources/js/notice_list.js"></script>
<link rel="stylesheet" type="text/css" href="${root }/resources/css/font.css">
<link rel="stylesheet" type="text/css" href="${root }/resources/css/notice_list.css">
<title>Insert title here</title>
</head>
<body>
<div class="container-sm my-5">
	<div class="row">
		<div class="col-12 col-md-8 offset-md-2">
			<h3 class="text-center">공지/이벤트</h3>
			<br>
			
			<%-- search --%>
			<form class="form-inline my-2 float-right">
		      <input class="form-control mr-sm-2" type="search" placeholder="Search">
		      <button class="btn btn-outline-success my-2" type="submit"><i class="fas fa-search"></i></button>
		    </form>
			<br>
			
			<%-- notice list --%>
			<table class="table table-hover">
			  <thead>
			    <tr id="list-head">
			      <th scope="col">No.</th>
			      <th scope="col">분류</th>
			      <th scope="col">제목</th>
			      <th scope="col">작성일</th>
			      <th scope="col"><i class="far fa-eye"></i></th>
			    </tr>
			  </thead>
			  <tbody>
			  	<c:if test="${empty list}">
			  		<tr class="list-item">
				      <th scope="row" colspan="5">
				      	<span>게시물이 존재하지 않습니다.</span>
				      </th>
			  		</tr>
			  	</c:if>
				<c:forEach items="${list }" var="notice">
					<fmt:formatDate var="regdate" value="${notice.regdate }" pattern="yyyy-MM-dd HH:mm" />
					<c:choose>
						<c:when test="${notice.category eq 'notice' }"><c:set var="category" value="공지" /></c:when>
						<c:when test="${notice.category eq 'event' }"><c:set var="category" value="이벤트" /></c:when>
					</c:choose>
				    <tr class="list-item">
				      <th scope="row" class="no">${notice.no }</th>
				      <td>${category }</td>
				      <td>${notice.title }</td>
				      <td>${regdate }</td>
				      <td>${notice.cnt }</td>
				    </tr>
				</c:forEach>
			  </tbody>
			</table>			
			<a id="newNoticeBtn" href="${root }/notice/register" class="btn btn-success float-right">새 공지</a>					
		</div>
	</div>
	
	<br>
	
	<%-- Pagination --%>
	<div class="row">
		<div class="col-md-8 offset-md-2">
			<nav aria-label="Page navigation example">
			  <ul class="pagination justify-content-center">
			    <c:if test="${!pages.prev }">
			    	<c:set var="prev" value="disabled" />
			    </c:if>
			    <li class="page-item ${prev }">
			      <a class="page-link" href="${root }/notice/list?curPage=${pages.startPage-1 }&amount=10">Previous</a>
			    </li>
			    
			    <c:forEach var="pageNum" begin="${pages.startPage }" end="${pages.endPage }">
			    	<c:if test="${pageNum eq pages.cri.curPage }">
			    		<c:set var="active" value="active" />
			    	</c:if>
				    <li class="page-item ${active }">
				    	<a class="page-link" href="${root }/notice/list?curPage=${pageNum }&amount=10">${pageNum }</a>
				    </li>			    
				    <c:remove var="active" />
			    </c:forEach>
			    
			    <c:if test="${!pages.next }">
			    	<c:set var="next" value="disabled" />
			    </c:if>
			    <li class="page-item ${next }">
			      <a class="page-link" href="${root }/notice/list?curPage=${pages.endPage+1 }&amount=10">Next</a>
			    </li>
			  </ul>
			</nav>
		</div>
	</div>
</div>
</body>
</html>