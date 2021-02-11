<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="m" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<<<<<<< HEAD
<html> 
=======
<html>
>>>>>>> branch 'mountain_team' of https://github.com/bomiyu/teamproject.git
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<m:topNav />

<form>
  <div class="form-group row">
    <label for="staticId" class="col-sm-2 col-form-label">아이디</label>
    <div class="col-sm-10">
      <input type="text" readonly class="form-control-plaintext" id="staticId" value="${sessionScope.authUser.id }">
    </div>
  </div>
  <div class="form-group row">
    <label for="staticPw" class="col-sm-2 col-form-label">비밀번호</label>
    <div class="col-sm-10">
      <input type="text" name="password" class="form-control-plaintext" id="staticPw" value="${sessionScope.authUser.password }">
    </div>
  </div>
  <div class="form-group row">
    <label for="staticName" class="col-sm-2 col-form-label">이름</label>
    <div class="col-sm-10">
      <input type="text" readonly class="form-control-plaintext" id="staticName" value="${sessionScope.authUser.name }">
    </div>
  </div>
  <div class="form-group row">
    <label for="staticNickname" class="col-sm-2 col-form-label">닉네임</label>
    <div class="col-sm-10">
      <input type="text" name="nickname" class="form-control-plaintext" id="staticNickname" value="${sessionScope.authUser.nickname }">
    </div>
  </div>
  <div class="form-group row">
    <label for="staticEmail" class="col-sm-2 col-form-label">이메일</label>
    <div class="col-sm-10">
      <input type="text" name="email" class="form-control-plaintext" id="staticEmail" value="${sessionScope.authUser.email }">
    </div>
  </div>
  <div class="form-group row">
    <label for="staticLoc" class="col-sm-2 col-form-label">주소</label>
    <div class="col-sm-10">
      <input type="text" name="loc" class="form-control-plaintext" id="staticLoc" value="${authUser.loc }"> //얘는 왜 세션에서 안꺼내도 되는거지?
    </div>
  </div>

	<button type="submit" class="btn btn-primary">수정</button>
</form>

</body>
</html>