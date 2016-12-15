$(document).ready(function() {
	var currentPage;
	var count;
	var rowCount;
	var pageCount;
	
	function listData(pageNum) {
		currentPage = pageNum;
		
		$('#output2').empty();

		$.ajax({
			type:'post', data:{pageNum:pageNum}, url:'listAjax.do', dataType:'json', cache:false, tiemout:30000,
			success:function(data) {
				
				count = data.count;
				rowCount = data.rowCount;
				pageCount = data.pageCount;
				var list = data.list;
						
				if(count<0 || list==null) {
					alert('목록 호출 실패');
				} else {
					$(list).each(function(index, list) {
						var output = '';

						output += '<li>';
						output += '<a href="view.do?cm_num='+list.cm_num+'">';
						output += '<p>' + list.cm_title + '</p>';
						output += '</a>'
						output += '</li>';
						
						$('#output2').append(output);
					});
					
				}
				setPage();
			}, error:function() {
				alert('네트워크 오류');
			}
		});
	}
	function setPage() {
		$('.paging_button2').empty();
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
			$('.paging_button2').append(add);						
		}
		
		for(var i=startPage; i<=endPage; i++) {
			if (i == currentPage) {
				add = $('<li style="color: red;"> </li>').html(i).attr('data-page', i);
			} else {
				add = $('<li> </li>').html(i).attr('data-page', i); 
			}
			$('.paging_button2').append(add);
		}
		
		if(totalPage-startPage >= pageCount) {
			add = $('<li></li>').html('[다음]').attr('data-page', (endPage+1));
			$('.paging_button2').append(add);						
		}
	}
	$(document).on('click', '.paging_button2 li', function() {
		currentPage = $(this).attr('data-page');
		listData(currentPage, rowCount);
	})
	
	listData(1, count);
});