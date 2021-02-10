$(function(){
	
	if(performance.navigation.type == 2){
	  // 2 indicates the page was accessed by navigating into the history
 	  location.reload(true);
	}
	
	showModal(result);

	$('#newNoticeBtn').hide();
	
	if (isManager) {
		$('#newNoticeBtn').show();
	}
	
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