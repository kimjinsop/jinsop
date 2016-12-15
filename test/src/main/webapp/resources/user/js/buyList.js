$(document).ready(function() {
	var currentPage;
	var count;
	var rowCount;
	var pageCount;

	function buyList(pageNum, mem_id) {
		currentPage = pageNum;

		$('#buyList').empty();

		$.ajax({
			type:'post', data:{pageNum:pageNum, mem_id:mem_id}, url:'buyAjax.do',dataType:'json',cache:false,timeout:30000,
			success:function(data){

				count = data.count;
				rowCount = data.rowCount;
				pageCount = data.pageCount;
				var buyList = data.buyList;


				$(buyList).each(function(index,buyList){
					var output = '';
					output+='<tr>';
					output+='<td class="image"><img src="../upload/'+buyList.it_image +'"width="150px" height="100px"></td>';
					output+='<td>';
					output+='<div class="cart-item-title">' + buyList.it_model + '</div>';
					output+='<div class="feature">Size : ' + buyList.it_size + '</div>';
					output+='</td>';
					output+='<td class="price">' + buyList.it_price + '</td>';
					output+='</tr>';

					$('#buyList').append(output);
				})

				setPage();

			}, error:function() {
				alert('네트워크 오류');
			}
		});
	}

	function setPage() {
		$('.buyPaging').empty();
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
			$('.buyPaging').append(add);						
		}

		for(var i=startPage; i<=endPage; i++) {
			add = $('<li></li>').html(i).attr('data-page', i);
			$('.buyPaging').append(add);
		}

		if(totalPage-startPage >= pageCount) {
			add = $('<li></li>').html('[다음]').attr('data-page', (endPage+1));
			$('.buyPaging').append(add);						
		}
	}
	$(document).on('click', '.buyPaging li', function() {
		currentPage = $(this).attr('data-page');
		selectData(currentPage, rowCount);
	})
	buyList(1,count);

})