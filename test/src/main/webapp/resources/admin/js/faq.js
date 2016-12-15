$(document).ready(function() {
	var currentPage;
	var count;
	var rowCount;
	var pageCount;

	function faqList(pageNum) {
		currentPage = pageNum;

		$('#faqList').empty();

		$.ajax({
			type:'post', data:{pageNum:pageNum}, url:'faqAjax.do', dataType:'json', cache:false, timeout:30000,
			success:function(data) {
				count = data.count;
				rowCount = data.rowCount;
				pageCount = data.pageCount;
				var faqList = data.faqList;

				if(count<0 || faqList==null) {
					alert('목록 호출 실패');
				} else {
					$(faqList).each(function(index, faqList) {
						var output = '';

						output += '<tr onclick="location.href=\'../faq/update.do?faq_num=' + faqList.faq_num + '\'">';
						output += '<td>' + faqList.faq_title + '</td>';
						output += '<td style="word-break:break-all; overflow:hidden;">' + faqList.faq_content + '</td>';
						output += '<td>' + faqList.faq_register + '</td>';
						output += '</tr>';

						$('#faqList').append(output);
					});
				}
				setPage();
			}, error:function() {
				alert('네트워크 오류');
			}
		});
	};

	function setPage() {
		$('#faq_paging').empty();
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
			$('#faq_paging').append(add);						
		}
		$('#faq_paging').append('&nbsp;&nbsp;|&nbsp;&nbsp;');
		for(var i=startPage; i<=endPage; i++) {
			if (i == currentPage) {
				add = $('<li style="color: red;"> </li>').html(i).attr('data-page', i);
			} else {
				add = $('<li> </li>').html(i).attr('data-page', i); 
			}
			$('#faq_paging').append(add);
		}
		$('#faq_paging').append('&nbsp;&nbsp;|&nbsp;&nbsp;');
		if(totalPage-startPage >= pageCount) {
			add = $('<li></li>').html('[다음]').attr('data-page', (endPage+1));
			$('#faq_paging').append(add);						
		}
		
	}
	$(document).on('click', '#faq_paging li', function() {
		currentPage = $(this).attr('data-page');
		faqList(currentPage, rowCount);
	})

	faqList(1, count);
});