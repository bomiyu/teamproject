$(function(){

	showModal(result);
	
	
	$('.list-item').click(function(){
		var no =$(this).find('.no').text();
		location.href = root + '/notice/get?no=' + no;
	});
	
	
	function showModal(result){
		if(result == 'delSuccess') {
			swal({
			  title: "Deleted",
			  text: "공지가 삭제되었습니다.",
			  icon: "success",
			  button: "close",
			});
		}
	};
});