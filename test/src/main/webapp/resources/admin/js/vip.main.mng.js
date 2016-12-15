$(document).ready(function(){

	var currentPage;
	var vipSellCount;
	var vipBuyCount;
	var rowCount;
	var pageCount;
	
	//VIP SELL 목록
	function vipSell(pageNum){
		
		currentPage = pageNum;

		$('#vipSell').empty();

		$.ajax({
			type:'post',
			data:{pageNum:pageNum},
			url:'mainvipsell.do',
			dataType:'json',
			cache:false,
			timeout:30000,
			success:function(data){
				
				vipSellCount = data.vipSellCount;
				rowCount = data.rowCount;
				pageCount = data.pageCount;
				var vipSellList = data.vipSellList;

				if(vipSellCount < 0 || vipSellList == null){
					alert('목록 호출 오류 발생');
				}else{
					$(vipSellList).each(function(index, vipSell){
											
						
						var output = '';
						
						output += '<tr>';
						output += '<td>'+vipSell.mem_id+'</td>';
						output += '<td>'+vipSell.model_cnt+' 켤레</td>';
						output += '<td>'+vipSell.total_price.toLocaleString('en').split(".")[0]+' 원</td>';
						output += '</tr>';
						//문서 객체에 추가
						$('#vipSell').append(output);
					});              
				}
				vipSellPage();
			},
			error:function(){
				alert('네트워크 오류 발생');
			}
		});		
	}	
	//페이지 설정
	function vipSellPage(){			
			
			$('#sell_paging').empty();
			
			if(vipSellCount==0) {
				return;
			}
			
			var totalPage = Math.ceil(vipSellCount/rowCount);
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
			vipSellList(currentPage, vipSellCount);
		});		
	
	//VIP BUY 목록
	function vipBuy(pageNum){
		currentPage = pageNum;

		$('#vipBuy').empty();

		$.ajax({
			type:'post',
			data:{pageNum:pageNum},
			url:'mainvipbuy.do',
			dataType:'json',
			cache:false,
			timeout:30000,
			success:function(data){

				vipBuyCount = data.vipBuyCount;
				rowCount = data.rowCount;
				pageCount = data.pageCount;
				var vipBuyList = data.vipBuyList;
								
				if(vipBuyCount < 0 || vipBuyList == null){
					alert('목록 호출 오류 발생');
				}else{
					$(vipBuyList).each(function(index, vipBuy){
						var output = '';
						output += '<tr>';
						output += '<td>'+vipBuy.mem_id+'</td>';
						output += '<td>'+vipBuy.model_cnt+' 켤레</td>';
						output += '<td>'+vipBuy.total_price.toLocaleString('en').split(".")[0]+' 원</td>';
						output += '</tr>';
						//문서 객체에 추가
						$('#vipBuy').append(output);
					});              
				}
				vipBuyPage();	
			},
			error:function(){
				alert('네트워크 오류 발생');
				}
			});		
		}
	
	//페이지 설정
	function vipBuyPage(){		
		
		$('#buy_paging').empty();
		
		if(vipBuyCount==0) {
			return;
		}
		
		var totalPage = Math.ceil(vipBuyCount/rowCount);
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
			$('#buy_paging').append(add);						
		}
		$('#buy_paging').append('&nbsp;&nbsp;|&nbsp;&nbsp;');
		for(var i=startPage; i<=endPage; i++) {
			if (i == currentPage) {
				add = $('<li style="color: red;"> </li>').html(i).attr('data-page', i);
			} else {
				add = $('<li> </li>').html(i).attr('data-page', i); 
			}
			$('#buy_paging').append(add);
		}
		$('#buy_paging').append('&nbsp;&nbsp;|&nbsp;&nbsp;');
		
		if(totalPage-startPage >= pageCount) {
			add = $('<li></li>').html('[다음]').attr('data-page', (endPage+1));
			$('#buy_paging').append(add);						
		}
	}
	$(document).on('click', '#buy_paging li', function() {
		currentPage = $(this).attr('data-page');
		vipBuyList(currentPage, vipBuyCount);
	});
	
	vipSell(1,vipSellCount);
	vipBuy(1,vipBuyCount);
});