
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
	$(document).ready(
			function() {

				var result = '${result}';
				var message = '${message}';

				//checkModal(result);
				checkModal2(message);

				history.replaceState({}, null, null);

				function checkModal2(message) {
					if (message && history.state == null) {
						$("#myModal .modal-body p").html(message);
						$("#myModal").modal("show");
					}
				}

				function checkModal(result) {
					if (result === '' || history.state) {
						return;
					}

					if (parseInt(result) > 0) {
						$("#myModal .modal-body p").html(
								"게시글 " + result + "번이 등록되었습니다.");
					}
					$("#myModal").modal("show");
				}

				var actionForm = $("#actionForm"); //실제 페이지를 클릭하면 동작을 하는!
				$(".pagination a").click(
						function(e) {
							e.preventDefault(); //a태그 클릭해도 페이지 이동이없도록 

							actionForm.find("[name='pageNum']").val(
									$(this).attr('href'));

							actionForm.submit();
						});

			});
</script>
<%-- <link rel="stylesheet" type="text/css"
	href="${root }/resources/css/font.css"> --%>
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
	
	<a href='<c:url value='/freeboard/list'/>'> <h5>자유게시판</h5></a>
		
	</div>

	<div class="container-sm mt-5">
	<div class="col-lg-12 d-flex flex-row-reverse p-2 bd-highlight ">
					<form id="searchForm" action='${root }/freeboard/list' method='get'
						class="form-inline my-2 my-lg-0">
						<select name="type" class="btn btn-outline-success  ">
						    <option value="TWC" ${pageMaker.cri.type eq 'TWC' ? 'selected' : '' }>제목 / 내용 / 작성자</option>
							<option value="T" ${pageMaker.cri.type eq 'T' ? 'selected' : '' }>제목</option>
							<option value="C" ${pageMaker.cri.type eq 'C' ? 'selected' : '' }>내용</option>
							<option value="W" ${pageMaker.cri.type eq 'W' ? 'selected' : '' }>작성자</option>
						</select> <input name="keyword" class="form-control" required
							value="${pageMaker.cri.keyword }" type="search" /> 
							<input type="hidden" name="pageNum" value=${pageMaker.cri.pageNum } /> 
							<input type="hidden"
							name="amount" value='${pageMaker.cri.amount }' />


						<button class="btn btn-outline-success my-2 my-sm-0" type="submit">검색</button>
					</form>
				</div>
				
		<div class="d-flex flex-row-reverse p-2 bd-highlight">

		
				
			
			
			<a href='<c:url value='/freeboard/register'/>' role="button"
				class="btn btn-outline-success">글쓰기</a>

		</div>
		<div class="row">
			<table class="table table-striped table-hover">
				<thead>
					<tr>
						<th>#</th>
						<th>제목</th>
						<th>작성자</th>
						<th>작성일</th>
					</tr>
				</thead>
				<tbody>


					<c:forEach items="${list}" var="vo" varStatus="status">
						<tr>
							<td>${(pageMaker.cri.pageNum -1) * pageMaker.cri.amount + status.index + 1}
								<c:url value="/freeboard/get" var="boardLink">
									<c:param value="${vo.no  }" name="no" />
									<c:param value="${pageMaker.cri.pageNum }" name="pageNum" />
									<c:param value="${pageMaker.cri.amount }" name="amount" />
									<c:param value="${pageMaker.cri.type }" name="type" />
									<c:param value="${pageMaker.cri.keyword }" name="keyword" />
								</c:url>
							<td><a class='move' href='${boardLink }'> <c:out
										value="${vo.title}" /></a></td>

							<td><c:out value="${authUser.nickname }" /></td>
							<td><fmt:formatDate pattern="yyyy-MM-dd"
									value="${vo.regdate}" /></td>

						</tr>
					</c:forEach>


				</tbody>
			</table>



		</div>
	</div>


	<div id="myModal" class="modal" tabindex="-1">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title">알림</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<p>처리가 완료되었습니다.</p>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-success" data-dismiss="modal">Close</button>
				</div>
			</div>
		</div>
	</div>


<div class="row">
	<div class="container-sm mt-3">
		<div class="row justify-content-center">
			<nav aria-label="Page navigation example">
				<ul class="pagination">

					<c:if test="${pageMaker.prev }">
						<c:url value="/freeboard/list" var="prevLink">
							<c:param value="${pageMaker.startPage -1 }" name="pageNum" />
							<c:param value="${pageMaker.cri.amount }" name="amount" />
							<c:param name="type" value="${pageMaker.cri.type }" />
							<c:param name="keyword" value="${pageMaker.cri.keyword }" />
						</c:url>
						<li class="page-item"><a class="page-link"
							href="${pageMaker.startPage -1 }">Previous</a></li>
					</c:if>

					<c:forEach var="num" begin="${pageMaker.startPage }"
						end="${pageMaker.endPage }">
						<c:url value="/freeboard/list" var="pageLink">
							<c:param name="pageNum" value="${num }" />
							<c:param name="amount" value="${pageMaker.cri.amount }" />
							<c:param name="type" value="${pageMaker.cri.type }" />
							<c:param name="keyword" value="${pageMaker.cri.keyword }" />
						</c:url>
						<li
							class="page-item ${pageMaker.cri.pageNum eq num ? 'active' : '' }">
							<a class="page-link" href="${num }">${num }</a>
						</li>
					</c:forEach>

					<c:if test="${pageMaker.next }">
						<c:url value="/freeboard/list" var="nextLink">
							<c:param name="pageNum" value="${pageMaker.endPage +1 }" />
							<c:param name="amount" value="${pageMaker.cri.amount }" />
							<c:param name="type" value="${pageMaker.cri.type }" />
							<c:param name="keyword" value="${pageMaker.cri.keyword }" />
						</c:url>
						<li class="page-item"><a class="page-link"
							href="${pageMaker.endPage +1 }">Next</a></li>
					</c:if>
				</ul>
			</nav>
		</div>
	</div>

</div>

	<div class="d-none">
		<form id="actionForm" action="${root }/freeboard/list">
			<input name="pageNum" value="${pageMaker.cri.pageNum }" /> <input
				name="amount" value="${pageMaker.cri.amount }" /> <input
				name="type" value="${pageMaker.cri.type }" /> <input name="keyword"
				value="${pageMaker.cri.keyword }" /> <input type="submit" />
		</form>
	</div>



</body>
</html>