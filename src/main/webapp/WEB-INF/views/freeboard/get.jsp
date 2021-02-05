<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%-- <%@ taglib prefix="u" tagdir="/WEB-INF/tags" %> --%>
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
<script>
var appRoot = '${root}';
var no = ${FreeBoard.no};
</script>
<script>

</script>
<title>Insert title here</title>

<style>/* css */
h5 {
	text-align: center;
	text-size: 60pt;
}
</style>
</head>
<body>

	<div class="container mt-5 ">
		<h5>글쓰기</h5>
	</div>
	<div class="container-sm">

		<div class="row">
			<div class="col-12 col-sm-6 offset-sm-3">

				<form method="post"<%-- action="${pageContext.request.contextPath }/freeboard/register" --%>>


					<div class="form-group">
						<label>번호</label> <input name="no" type="text"
							class="form-control" value='<c:out value="${freeboard.no }"/>'
							readonly="readonly">
					</div>
					<div class="form-group">
						<label for="input1">제목</label> <input name="title" type="text"
							class="form-control" value='<c:out value="${freeboard.title }"/>' readonly="readonly">
					</div>

					<div class="form-group">
						<label for="textarea1">내용</label>
						<textarea name="content" class="form-control" rows="3" 
							readonly="readonly"><c:out value="${freeboard.content }"/></textarea>
					</div>

					<div class="form-group">
						<label for="writer">작성자</label>
						<%--     <input type="text" class="form-control" name="writer" id="writer" value=${user.name } readonly="readonly">  --%>
					</div>
						<c:url value="/freeboard/modify" var="modifyLink">
						<c:param name="no" value="${freeboard.no }"></c:param>
						<%-- <c:param name="pageNum" value="${cri.pageNum }"></c:param>
						<c:param name="amount" value="${cri.amount }"></c:param>
						<c:param name="type" value="${cri.type }" ></c:param>
						<c:param name="keyword" value="${cri.keyword }" ></c:param> --%>
					</c:url>
					<a href="${modifyLink }" class="btn btn-outline-success">
						수정
					</a>
					</form>
			</div>

			
		</div>
	</div>
	</div>

</body>
</html>




