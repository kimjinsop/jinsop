$(document).ready(function() {
	var currentPage;
	var count;
	var rowCount;
	var pageCount;

	function noticeList(pageNum) {
		currentPage = pageNum;
		
		$('#noticeList').empty();
		
		$.ajax({
			type:'post', data:{pageNum:pageNum}, url:'noticeAjax.do', dataType:'json', cache:false, timeout:30000,
			success:function(data) {
				count = data.count;
				rowCount = data.rowCount;
				pageCount = data.pageCount;
				var noticeList = data.noticeList;
					
				if(count<0 || noticeList==null) {
					alert('목록 호출 실패');
				} else {
					$(noticeList).each(function(index, noticeList) {
						var output = '';

						output += '<tr onclick="location.href=\'../notice/update.do?nb_num=' + noticeList.nb_num + '\'">';
						output += '<td>' + noticeList.nb_title + '</td>';
						output += '<td style="word-break:break-all;">' + noticeList.nb_content + '</td>';
						output += '<td>' + noticeList.nb_register + '</td>';
						output += '</tr>';

						$('#noticeList').append(output);
					});
				}
				
				setPage();

			}, error:function() {
				alert('네트워크 오류');
			}
		});
	};
	
	function setPage() {
		$('#notice_paging').empty();
		if(count==0) {
			return;
		}
		var totalPage = Math.ceil(count/rowCount);
		var startPage = Math.floor((currentPage-1)/pageCount)*pageCount+1;
		var endPage = startPage+pageCount-1;
		
		if(currentPage == undefined || currentPage == '') {
			currentPage = 1;
		}
		
		if(currentPage > totalPage) {
			currentPage = totalPage;
		}
		
		if(endPage > totalPage) {
			endPage = totalPage;
		}
		
		var add;
		if(currentPage > pageCount) {
			add = $('<li></li>').html('[이전]').attr('data-page', (startPage-1));
			$('#notice_paging').append(add);						
		}
		$('#notice_paging').append('&nbsp;&nbsp;|&nbsp;&nbsp;');
		for(var i=startPage; i<=endPage; i++) {
			if (i == currentPage) {
				add = $('<li style="color: red;"> </li>').html(i).attr('data-page', i);
			} else {
				add = $('<li> </li>').html(i).attr('data-page', i); 
			}
			$('#notice_paging').append(add);
		}
		$('#notice_paging').append('&nbsp;&nbsp;|&nbsp;&nbsp;');
		
		if(totalPage-startPage >= pageCount) {
			add = $('<li></li>').html('[다음]').attr('data-page', (endPage+1));
			$('#notice_paging').append(add);						
		}
	}
	$(document).on('click', '#notice_paging li', function() {
		currentPage = $(this).attr('data-page');
		noticeList(currentPage, rowCount);
	})	
	
	noticeList(1, rowCount);
});