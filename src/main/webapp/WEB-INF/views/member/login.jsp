<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="m" tagdir="/WEB-INF/tags"%> 
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

<title>산산산</title>
</head>
<body>

<m:topNav />

<form method="post">
  <div class="form-group row">
    <label for="inputId" class="col-sm-2 col-form-label">아이디</label>
    <div class="col-sm-10">
      <input type="text" name="id" class="form-control" id="inputId">
    </div>
  </div>
    <div class="form-group row">
    <label for="inputPassword" class="col-sm-2 col-form-label">비밀번호</label>
    <div class="col-sm-10">
      <input type="password" name="password" class="form-control" id="inputPassword">
    </div>
  </div>
  
   <button type="submit" class="btn btn-primary">로그인</button>
  
</form>

</body>
</html>