$(function(){
	
	$('#modifyBtn').click(function(e){
		e.preventDefault();
		
		var notice = {
			no: no,
			category: $('#category').val(),
			title: $('#title').val(),
			content: $('#content').val()
		};
		
		$.ajax(root + '/notice/modify?no=' + no, {
			method: 'post',
			contentType: 'application/json; charset=utf-8',
			data: JSON.stringify(notice)	// '{}'
		}).done(function(data, status, xhr){
	    	//console.log(data);// = xhr.responseText
			location.replace(root + '/notice/get?no=' + no);
	    }).fail(function(e){
	    	console.log(e);
	    });

	});
	
	$('#cancelyBtn').click(function(){
		location.replace(root + '/notice/get?no=' + no);
	});
});