$(function(){
	
	showModal(result);
	
	$('#deleteBtn').hide();
	$('#modifyBtn').hide();

	$('#newReplyBtn').hide();
	$('#reply').attr('placeholder', '댓글을 쓰려면 로그인을 해주세요');
	$('#reply').attr('readonly', true);
	
	
	if(logined) {
		if(isManager) {/* 관리자 */
			$('#deleteBtn').show();
			$('#modifyBtn').show();
		}
		
		$('#newReplyBtn').show();
		$('#reply').removeAttr('placeholder');
		$('#reply').removeAttr('readonly');	
	}
	
	function showModal(result){
		if(result == 'modSuccess') {
			swal({
			  title: "Modified",
			  text: "공지가 수정되었습니다.",
			  icon: "success",
			  button: "close",
			});
		}
	};
	
	$('#deleteBtn').click(function(e){
		e.preventDefault();
		
		swal({
		  title: "Are you sure?",
		  text: "게시글을 삭제하시겠습니까?",
		  icon: "warning",
		  buttons: true,
		  dangerMode: true,
		})
		.then((isConfirm) => {
		  if (isConfirm) {
		    //$('#deleteForm').submit();
		    
		    $.ajax(root + '/notice/delete/' + no, {// 페이지 이동하지 않고 처리한 다음
		    	method: 'delete'
		    }).done(function(data, status, xhr){
		    	//console.log(data);// = xhr.responseText
				location.replace(root + '/notice/list');
		    }).fail(function(e){
		    	console.log(e);
		    });

		  }
		});
		
	});
	
	$('#modifyBtn').click(function(){
		location.replace(root + '/notice/modify?no='+ no);
	});
	
	
});