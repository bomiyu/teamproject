<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%-- <%@ taglib prefix="u" tagdir="/WEB-INF/tags" %> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- MOBILE최적화 -->
<meta name="viewport" content="width=device-width, initial-scale=1.0">
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
$(document).ready(function() {
/* 	$("#go").click(function(e) {
		if($("#input1") || $("#textarea1")  == null){
			e.preventDefault();
			
		} else{
			$("#go").submit();
		}

	}); */

    $("#go").click(function(e) {
    	
    	   e.preventDefault();// 바로 이벤트 버블링 막고
    	      if($("#input1").val() != '' && $("#textarea1").val() != ''){
    	         $("#newBoardForm").submit();
    	      }
    	   });
});
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

				<form id="newBoardForm" method="post"<%-- action="${pageContext.request.contextPath }/freeboard/register" --%>
		>
					<div class="form-group">
						<label for="input1">제목</label> <input name="title" type="text"
							class="form-control" id="input1" placeholder="제목을 입력하세요." required>
					</div>

					<div class="form-group">
						<label for="textarea1">내용</label>
						<textarea name="content" class="form-control" id="textarea1"
							rows="3" placeholder="내용을 입력하세요." required></textarea>
					</div>

				            <div class="form-group">
             <label for="writer">작성자</label>
     <input type="text" class="form-control" name="writer" id="writer" readonly="readonly" value="${authUser.nickname}" required/> 
           </div>

					<button id="go" type="submit" class="btn btn-outline-success">글쓰기</button>
				</form>
			</div>
		</div>
	</div>

</body>
</html>




