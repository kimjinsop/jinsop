$(document).ready(function() {
	var currentPage;
	var sellCount;
	var sellingCount;
	var soldCount;
	var rowCount;
	var pageCount;

	function sell(pageNum, mem_id) {
		currentPage = pageNum;

		$('#sellList').empty();

		$.ajax({
			type:'post', data:{pageNum:pageNum, mem_id:mem_id}, url:'sellAjax.do', dataType:'json', cache:false, timeout:30000,
			success:function(data) {

				sellCount = data.sellCount;
				rowCount = data.rowCount;
				pageCount = data.pageCount;
				var sellList = data.sellList;

				$('#sellList').empty();

				$(sellList).each(function(index, sell) {
					
					var output = '';
					output+='<tr>';
					output+='<td class="image"><img src="../upload/'+sell.it_image+'" width="150px" height="100px"></td>';
					output+='<td>';
					output+='<div class="cart-item-title">' + sell.it_model + '</div>';
					output+='<div class="feature">Size : ' + sell.it_size + '</div>';
					output+='</td>';
					output+='<td class="price">' + sell.it_price + '</td>';
					output+='</tr>';

					$('#sellList').append(output);
				})
				sellPage();
			}, error:function() {
				alert('네트워크 오류 발생');
			}
		});
	}
	function sellPage() {
		$('#sell_paging').empty();
		if(sellCount==0) {
			return;
		}
		var totalPage = Math.ceil(sellCount/rowCount);
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
			$('#sell_paging').append(add);						
		}
		$('#sell_paging').append('&nbsp;&nbsp;|&nbsp;&nbsp;');
		for(var i=startPage; i<=endPage; i++) {
			if (i == currentPage) {
				add = $('<li style="color: red;"> </li>').html(i).attr('data-page', i);
			} else {
				add = $('<li> </li>').html(i).attr('data-page', i); 
			}
			$('#sell_paging').append(add);
		}
		$('#sell_paging').append('&nbsp;&nbsp;|&nbsp;&nbsp;');
		if(totalPage-startPage >= pageCount) {
			add = $('<li></li>').html('[다음]').attr('data-page', (endPage+1));
			$('#sell_paging').append(add);						
		}

	}
	$(document).on('click', '#sell_paging li', function() {
		currentPage = $(this).attr('data-page');
		sell(currentPage, rowCount);
	})

	sell(1, sellCount);
	
	//selling
	function selling(pageNum, mem_id) {
		currentPage = pageNum;

		$('#sellingList').empty();

		$.ajax({
			type:'post', data:{pageNum:pageNum, mem_id:mem_id}, url:'sellingAjax.do', dataType:'json', cache:false, timeout:30000,
			success:function(data) {

				sellingCount = data.sellingCount;
				rowCount = data.rowCount;
				pageCount = data.pageCount;
				var sellingList = data.sellingList;

				$('#sellingList').empty();

				$(sellingList).each(function(index, selling) {

					var output = '';
					output+='<tr>';
					output+='<td class="image"><img src="../upload/'+selling.it_image+'" width="150px" height="100px"></td>';
					output+='<td>';
					output+='<div class="cart-item-title">' + selling.it_model + '</div>';
					output+='<div class="feature">Size : ' + selling.it_size + '</div>';
					output+='</td>';
					output+='<td class="price">' + selling.it_price + '</td>';
					output+='</tr>';

					$('#sellingList').append(output);
				})
				sellingPage();
			}, error:function() {
				alert('네트워크 오류 발생');
			}
		});
	}
	function sellingPage() {
		$('#selling_paging').empty();
		if(sellingCount==0) {
			return;
		}
		var totalPage = Math.ceil(sellingCount/rowCount);
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
			$('#selling_paging').append(add);						
		}
		$('#selling_paging').append('&nbsp;&nbsp;|&nbsp;&nbsp;');
		for(var i=startPage; i<=endPage; i++) {
			if (i == currentPage) {
				add = $('<li style="color: red;"> </li>').html(i).attr('data-page', i);
			} else {
				add = $('<li> </li>').html(i).attr('data-page', i); 
			}
			$('#selling_paging').append(add);
		}
		$('#selling_paging').append('&nbsp;&nbsp;|&nbsp;&nbsp;');
		if(totalPage-startPage >= pageCount) {
			add = $('<li></li>').html('[다음]').attr('data-page', (endPage+1));
			$('#selling_paging').append(add);						
		}

	}
	$(document).on('click', '#selling_paging li', function() {
		currentPage = $(this).attr('data-page');
		selling(currentPage, rowCount);
	})

	selling(1, sellingCount);
	
	//sold
	function sold(pageNum, mem_id) {
		currentPage = pageNum;

		$('#soldList').empty();

		$.ajax({
			type:'post', data:{pageNum:pageNum, mem_id:mem_id}, url:'soldAjax.do', dataType:'json', cache:false, timeout:30000,
			success:function(data) {

				soldCount = data.soldCount;
				rowCount = data.rowCount;
				pageCount = data.pageCount;
				var soldList = data.soldList;

				$('#soldList').empty();

				$(soldList).each(function(index, sold) {

					var output = '';
					output+='<tr>';
					output+='<td class="image"><img src="../upload/'+sold.it_image+'" width="150px" height="100px"></td>';
					output+='<td>';
					output+='<div class="cart-item-title">' + sold.it_model + '</div>';
					output+='<div class="feature">Size : ' + sold.it_size + '</div>';
					output+='</td>';
					output+='<td class="price">' + sold.it_price + '</td>';
					output+='</tr>';

					$('#soldList').append(output);
				})
				soldPage();
			}, error:function() {
				alert('네트워크 오류 발생');
			}
		});
	}
	function soldPage() {
		$('#sold_paging').empty();
		if(soldCount==0) {
			return;
		}
		var totalPage = Math.ceil(soldCount/rowCount);
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
			$('#sold_paging').append(add);						
		}
		$('#sold_paging').append('&nbsp;&nbsp;|&nbsp;&nbsp;');
		for(var i=startPage; i<=endPage; i++) {
			if (i == currentPage) {
				add = $('<li style="color: red;"> </li>').html(i).attr('data-page', i);
			} else {
				add = $('<li> </li>').html(i).attr('data-page', i); 
			}
			$('#sold_paging').append(add);
		}
		$('#sold_paging').append('&nbsp;&nbsp;|&nbsp;&nbsp;');
		if(totalPage-startPage >= pageCount) {
			add = $('<li></li>').html('[다음]').attr('data-page', (endPage+1));
			$('#sold_paging').append(add);						
		}

	}
	$(document).on('click', '#sold_paging li', function() {
		currentPage = $(this).attr('data-page');
		sold(currentPage, rowCount);
	})

	sold(1, soldCount);

})
