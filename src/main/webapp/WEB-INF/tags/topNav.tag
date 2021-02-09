<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="${root }/index.jsp">HOME</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="${root }/index.jsp">Home <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          산게시판
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
          <a class="dropdown-item" href="#">전체보기</a>
          <div class="dropdown-divider"></div>
          <a class="dropdown-item" href="#">지역1</a>
          <a class="dropdown-item" href="#">지역2</a>
          <a class="dropdown-item" href="#">지역3</a>
        </div>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">자유게시판</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">맛집게시판</a>
      </li>
    </ul>
    <form class="form-inline my-2 my-lg-0">
      <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
      <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
    </form>
    
    <c:if test="${empty sessionScope.authUser }">
	    <ul>
	      <li class="nav-item">
	       <a class="nav-link" href="${root }/member/join">회원가입</a>
	      </li>
	      <li class="nav-item">
	       <a class="nav-link" href="${root }/member/login">로그인</a>
	      </li>
	     </ul>
     </c:if>
     
     
    <c:if test="${not empty sessionScope.authUser }">
	     <ul> 
	    	 <li class="nav-item">
	      		 <a class="nav-link" href="${root }/member/myHome">마이홈</a>
	   		 </li>
	     
	   		 <li class="nav-item">
	    		<a class="nav-link" href="${root }/member/logout">로그아웃</a>
	    	 </li>
	    </ul>
    </c:if>
    
  </div>
</nav>