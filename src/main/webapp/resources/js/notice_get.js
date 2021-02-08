$(function(){
	
	showModal(result);
	
	$('#deleteBtn').click(function(e){
		e.preventDefault();
		/*
		if(confirm('게시글을 삭제하시겠습니까?')) {
			$('#deleteForm').submit();
		}*/
		
		
		swal({
		  title: "Are you sure?",
		  text: "게시글을 삭제하시겠습니까?",
		  icon: "warning",
		  buttons: true,
		  dangerMode: true,
		})
		.then((isConfirm) => {
		  if (isConfirm) {
		    $('#deleteForm').submit();
		  }
		});
		
		
	});
	
	
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
	
});