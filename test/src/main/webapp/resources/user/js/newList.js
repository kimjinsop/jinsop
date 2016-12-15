$(document).ready(function() {
	var currentPage;
	var count;
	var rowCount;
	var pageCount;

	function newList(pageNum) {
		currentPage = pageNum;

		$('#newList').empty();

		$.ajax({
			type:'post', data:{pageNum:pageNum}, url:'newList.do', dataType:'json', cache:false, timeout:30000,
			success:function(data) {
				count = data.count;
				rowCount = data.rowCount;
				pageCount = data.pageCount;
				var newList = data.newList;
				$(newList).each(function(index, list) {
					if(index<4) {
						var output ='';

						output += '<div class="col-md-3 col-sm-6">';
						output += '<div class="shop-item">';
						output += '<div class="shop-item-image">';
						output += '<img src="../upload/'+list.it_image+'" width="250px;" height="150px;">';
						output += '</div>';
						output +='<div class="title">';
						output +='<h3>';
						output +=list.it_model + '</h3>';
						output+='</div>';
						output+='<div class="price">' +list.it_price+'</div>';
						output+='<div class="actions">';
						output+='<a href=../item/detail.do?it_num='+list.it_num+' class="btn btn-small">';
						output+='<i class="icon-shopping-cart icon-white">View Detail</i></a>';
						output+='</div>';
						output+='</div>';
						output+='</div>';

						$('#newList').append(output);
					}
				});
			},error:function(){
				alert('네트워크 오류');
			}	
		});
	}
	newList(1, count);
	
	function deadList(pageNum) {
		currentPage = pageNum;

		$('#deadList').empty();

		$.ajax({
			type:'post', data:{pageNum:pageNum}, url:'deadList.do', dataType:'json', cache:false, timeout:30000,
			success:function(data) {
				count = data.count;
				rowCount = data.rowCount;
				pageCount = data.pageCount;
				var deadList = data.deadList;
				$(deadList).each(function(index, list) {
					if(index<4) {
						var output ='';

						output += '<div class="col-md-3 col-sm-6">';
						output += '<div class="shop-item">';
						output += '<div class="shop-item-image">';
						output += '<img src="../upload/'+list.it_image+'" width="250px;" height="150px;">';
						output += '</div>';
						output +='<div class="title">';
						output +='<h3>';
						output +=list.it_model + '</h3>';
						output+='</div>';
						output+='<div class="price">' +list.it_price+'</div>';
						output+='<div class="actions">';
						output+='<a href=../item/detail.do?it_num='+list.it_num+' class="btn btn-small">';
						output+='<i class="icon-shopping-cart icon-white">View Detail</i></a>';
						output+='</div>';
						output+='</div>';
						output+='</div>';

						$('#deadList').append(output);
					}
				});
			},error:function(){
				alert('네트워크 오류');
			}	
		});
	}
	deadList(1, count);
	
	function lowList(pageNum) {
		currentPage = pageNum;

		$('#lowList').empty();

		$.ajax({
			type:'post', data:{pageNum:pageNum}, url:'lowList.do', dataType:'json', cache:false, timeout:30000,
			success:function(data) {
				count = data.count;
				rowCount = data.rowCount;
				pageCount = data.pageCount;
				var lowList = data.lowList;
				$(lowList).each(function(index, list) {
					if(index<4) {
						var output ='';

						output += '<div class="col-md-3 col-sm-6">';
						output += '<div class="shop-item">';
						output += '<div class="shop-item-image">';
						output += '<img src="../upload/'+list.it_image+'" width="250px;" height="150px;">';
						output += '</div>';
						output +='<div class="title">';
						output +='<h3>';
						output +=list.it_model + '</h3>';
						output+='</div>';
						output+='<div class="price">' +list.it_price+'</div>';
						output+='<div class="actions">';
						output+='<a href=../item/detail.do?it_num='+list.it_num+' class="btn btn-small">';
						output+='<i class="icon-shopping-cart icon-white">View Detail</i></a>';
						output+='</div>';
						output+='</div>';
						output+='</div>';

						
						
						
						$('#lowList').append(output);
					}
				});
			},error:function(){
				alert('네트워크 오류');
			}	
		});
	}
	lowList(1, count);
});

