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

<script>
//string email = email.concat(email, select);
</script>

<!-- 이메일 주소 선택  -->
<script>
    $(function() {
        $('#select').change(function() {
            if ($('#select').val() == 'directly') {
                $('#textEmail').attr("disabled", false);
                $('#textEmail').val("");
                $('#textEmail').focus();
            } else {
                $('#textEmail').val($('#select').val());
            }
        });
        
        /* 이메일 값을 합쳐서 name으로 보내기 */
        function setEmailInput() {
        	var email = $("#email").val() + "@" + $("#textEmail").val();  
        	$("#email-input").val(email);
        }
        
        $("#select").change(setEmailInput);
        $("#email").keyup(setEmailInput);
        $("#textEmail").keyup(setEmailInput);
        
    });
</script>

<title>산산산</title>
</head>
<body>

<m:topNav />

<form method="post">
  <div class="form-group row">
    <label for="id" class="col-sm-2 col-form-label">아이디</label>
    <div class="col-sm-10">
      <input type="text" name="id" class="form-control" id="id" value="">
      
      <c:if test="${errors.memberId }">
      	<small class="form-text" style="color: tomato">
      		아이디를 입력해주세요.
      	</small>
      </c:if>
      
    </div>
  </div>
  <div class="form-group row">
    <label for="password" class="col-sm-2 col-form-label">비밀번호</label>
    <div class="col-sm-10">
      <input type="password" name="password" class="form-control" id="password">
      
      <c:if test="${errors.memberPw }">
      	<small class="form-text" style="color: tomato">
      		비밀번호를 입력해주세요.
      	</small>
      </c:if>
      
    </div>
  </div>
  <div class="form-group row">
    <label for="pwConfirm" class="col-sm-2 col-form-label">비밀번호 확인</label>
    <div class="col-sm-10">
      <input type="password" name="pwConfirm" class="form-control" id="pwConfirm">
      
      <c:if test="${errors.pwNotMatch }">
      	<small class="form-text" style="color: tomato">
      		비밀번호와 일치하지 않습니다.
      	</small>
      </c:if>
      <c:if test="${errors.memberPwConfirm }">
      	<small class="form-text" style="color: tomato">
      		비밀번호 확인을 입력해주세요.
      	</small>
      </c:if>
      
    </div>
  </div>  
  
  
  
  <div class="form-group row">
    <label for="email" class="col-sm-2 col-form-label">E-mail</label>
    <div class="col-sm-10">
      
     
<!--    <input type="text" name="email" class="form-control" id="email"> -->
 	
 	<div>
        <input type="text" id="email" value="" placeholder="이메일 입력"> 
 		<span>@</span>
		 <input id="textEmail" placeholder="이메일을 선택하세요."> 
 		<select id="select">
         	   <option value="" disabled selected>E-Mail 선택</option>
	            <option value="naver.com" id="naver.com">naver.com</option>
	            <option value="hanmail.net" id="hanmail.net">hanmail.net</option>
	            <option value="gmail.com" id="gmail.com">gmail.com</option>
	            <option value="nate.com" id="nate.com">nate.com</option>
	            <option value="directly" id="textEmail">직접 입력하기</option>
	        </select>
	    <input type="hidden" name="email" id="email-input" />
	</div>

      <c:if test="${errors.memberEmail }">
      	<small class="form-text" style="color: tomato">
      		이메일을 입력해주세요.
      	</small>
      </c:if>
      
      </div>
    </div>
  </div>
  
  <div class="form-group row">
    <label for="name" class="col-sm-2 col-form-label">이름</label>
    <div class="col-sm-10">
      <input type="text" name="name" class="form-control" id="name">
      
      <c:if test="${errors.memberName }">
      	<small class="form-text" style="color: tomato">
      		이름을 입력해주세요.
      	</small>
      </c:if>
      
    </div>
  </div>
  
  
  <div class="form-group row">
    <label for="nickname" class="col-sm-2 col-form-label">닉네임</label>
    <div class="col-sm-10">
      <input type="text" name="nickname" class="form-control" id="nickname">
      
      <c:if test="${errors.memberNickname }">
      	<small class="form-text" style="color: tomato">
      		닉네임을 입력해주세요.
      	</small>
      </c:if>
      
    </div>
  </div>
  
  <div class="form-group row">
  
    <label for="loc" class="col-sm-2 col-form-label">주소</label>
    <div class="col-sm-10">
      <input type="text" name="loc" class="form-control" id="loc">
	//주소api 어떻게 받아오는 거지?
		
      <c:if test="${errors.memberLoc }">
      	<small class="form-text" style="color: tomato">
      		주소를 입력해주세요.
      	</small>
      </c:if>
      
    </div>
  </div>
  

  <button type="submit" class="btn btn-primary">회원 가입</button>
  
</form>

</body>
</html>