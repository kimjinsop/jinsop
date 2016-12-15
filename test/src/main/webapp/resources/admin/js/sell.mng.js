$(document).ready(function(){

	var currentPage;
	var sellCount;
	var sellingCount;
	var soldCount;
	var rowCount;
	var pageCount;

	//SELL 목록
	function sell(pageNum){
		
		currentPage = pageNum;
		
		$('#output').empty();
		$('#sellCount').empty();
		$.ajax({
			type:'post',
			data:{pageNum:pageNum},
			url:'sellmng.do',
			dataType:'json',
			cache:false,
			timeout:30000,
			success:function(data){
				
				sellCount = data.sellCount;
				rowCount = data.rowCount;
				pageCount = data.pageCount;
				var sellList = data.sellList;
				
				if(sellCount < 0 || sellList == null){
					alert('목록 호출 오류 발생');
				}else{ 
					var sell = '';
					sell += '<h2>판매 신청 목록 (총 : ' + sellCount + ')</h2>';
					$('#sellCount').append(sell);
					$(sellList).each(function(index, sellmng){
						var output = '';
						output += '<tr>';
						output += '<td align="center"><input type="checkbox" name="yes" id="agree'+sellmng.it_num+'" value="'+sellmng.it_num+'" class="yes"></td>'
						output += '<td>'+sellmng.mem_id+'</td>';
						output += '<td>'+sellmng.it_brand+'</td>';
						output += '<td>'+sellmng.it_model+'</td>';
						output += '<td>'+sellmng.it_size+'</td>';
						output += '<td>'+sellmng.it_price.toLocaleString('en').split(".")[0]+' 원</td>';
						output += '</tr>';
						//문서 객체에 추가
						$('#output').append(output);
					});						
				}
				sellPage();		
			},
			error:function(){
				alert('네트워크 오류 발생');
			}
		});		
	}
	
	$('#agree').click(function(){
		var yes = $('.yes').serialize();
		$.ajax({
			type:'post',
			data:yes,
			url:'sellAgree.do',
			dataType:'json',
			cache:false,
			timeout:30000,
			success:function(data){
				if(data.result=="success") {
					alert('승인 성공');
					sell(1,sellCount);
					selling(1,sellingCount);
				}else{
					alert('신청 건이 없습니다.');
				}
			},
			error:function(){
				alert('네트워크 오류 발생!');
			}         
		})
	});	

	//SELLING 목록
	function selling(pageNum){
		currentPage = pageNum;
		$('#output1').empty();
		$('#sellingCount').empty();
		$.ajax({
			type:'post',
			data:{pageNum:pageNum},
			url:'sellingmng.do',
			dataType:'json',
			cache:false,
			timeout:30000,
			success:function(data){

				sellingCount = data.sellingCount;
				rowCount = data.rowCount;
				pageCount = data.pageCount;
				var sellingList = data.sellingList;

				if(sellingCount < 0 || sellingList == null){
					alert('목록 호출 오류 발생');
				}else{
					var selling = '';
					selling += '<h2>판매 진행 목록 (총 : ' + sellingCount + ')</h2>';
					$('#sellingCount').append(selling);
					$(sellingList).each(function(index, sellingmng){
						var output = '';
						output += '<tr>';
						output += '<td>'+sellingmng.mem_id+'</td>';
						output += '<td>'+sellingmng.it_brand+'</td>';
						output += '<td>'+sellingmng.it_model+'</td>';
						output += '<td>'+sellingmng.it_size+'</td>';
						output += '<td>'+sellingmng.it_price.toLocaleString('en').split(".")[0]+' 원</td>';
						output += '</tr>';
						//문서 객체에 추가
						$('#output1').append(output);
					});              
				}
				sellingPage();
			},
			error:function(){
				alert('네트워크 오류 발생');
			}
		});		
	}

	//SOLD 목록
	function sold(pageNum){
		currentPage = pageNum;
		$('#output2').empty();
		$('#soldCount').empty();
		$.ajax({
			type:'post',
			data:{pageNum:pageNum},
			url:'soldmng.do',
			dataType:'json',
			cache:false,
			timeout:30000,
			success:function(data){

				soldCount = data.soldCount;
				rowCount = data.rowCount;
				pageCount = data.pageCount;
				var soldList = data.soldList;

				if(soldCount < 0 || soldList == null){
					alert('목록 호출 오류 발생');
				}else{
					var sold = '';
					sold += '<h2>판매 완료 목록 (총 : ' + soldCount + ')</h2>';
					$('#soldCount').append(sold);
					$(soldList).each(function(index, soldmng){
						var output = '';
						output += '<tr>';
						output += '<td>'+soldmng.mem_id+'</td>';
						output += '<td>'+soldmng.it_brand+'</td>';
						output += '<td>'+soldmng.it_model+'</td>';
						output += '<td>'+soldmng.it_size+'</td>';
						output += '<td>'+soldmng.it_price.toLocaleString('en').split(".")[0]+' 원</td>';
						output += '</tr>';
						//문서 객체에 추가
						$('#output2').append(output);
					});              
				}
				soldPage();
			},
			error:function(){
				alert('네트워크 오류 발생');
			}
		});
	
	}


	//페이지 설정
	function sellPage(){
		
				$('.paging_button').empty();

				if(sellCount == 0){
					return;					
				}

				//전체페이지수 구하기
				var totalPage = Math.ceil(sellCount/rowCount);
				//시작 페이지와 마지막 페이지 값을 구하기
				var startPage = Math.floor((currentPage-1)/pageCount)*pageCount +1;
				var endPage = startPage + pageCount - 1;
				
				if(currentPage == undefined || currentPage == ''){
					currentPage = 1;
				}

				//현재 페이지가 전체 페이지 수보다 크면 전체 페이지수로 설정
				if(currentPage > totalPage){
					currentPage = totalPage;
				}

				
				//마지막 페이지가 전체 페이지 수보다 크면 전체 페이지 수로 설정
				if(endPage > totalPage){
					endPage = totalPage;
				}

				var add;
				if(startPage > pageCount){
					add = $('<li></li>').html('[이전]').attr('data-page',(startPage-1));
					$('.paging_button').append(add);
				}
				$('.paging_button').append('&nbsp;&nbsp;|&nbsp;&nbsp;');
				for(var i=startPage;i<=endPage;i++){

					if(i == currentPage){
						add = $('<li style="color:red;"></li>').html(i).attr('data-page',i);			
					}else{
						add = $('<li></li>').html(i).attr('data-page',i);
					}
					$('.paging_button').append(add);
				}
				$('.paging_button').append('&nbsp;&nbsp;|&nbsp;&nbsp;');
				
				if(endPage < totalPage){
					add = $('<li></li>').html('[다음]').attr('data-page',(startPage+pageCount));
					$('.paging_button').append(add);
				}		
		};
		$(document).on('click', '.paging_button li', function() {
			currentPage = $(this).attr('data-page');
			sell(currentPage, sellCount);
		});				

	function sellingPage(){
		
				$('.paging_button1').empty();

				if(sellingCount == 0){
					return;					
				}
				
				//전체페이지수 구하기
				var totalPage = Math.ceil(sellingCount/rowCount);
				if(currentPage == undefined || currentPage == ''){
					currentPage = 1;
				}

				//현재 페이지가 전체 페이지 수보다 크면 전체 페이지수로 설정
				if(currentPage > totalPage){
					currentPage = totalPage;
				}

				//시작 페이지와 마지막 페이지 값을 구하기
				var startPage = Math.floor((currentPage-1)/pageCount)*pageCount +1;
				var endPage = startPage + pageCount - 1;
				//마지막 페이지가 전체 페이지 수보다 크면 전체 페이지 수로 설정
				if(endPage > totalPage){
					endPage = totalPage;
				}

				var add;
				if(startPage > pageCount){
					add = $('<li></li>').html('[이전]').attr('data-page',(startPage-1));
					$('.paging_button1').append(add);
				}

				$('.paging_button1').append('&nbsp;&nbsp;|&nbsp;&nbsp;');
				for(var i=startPage; i<=endPage; i++) {
					if (i == currentPage) {
						add = $('<li style="color: red;"> </li>').html(i).attr('data-page', i);
					} else {
						add = $('<li> </li>').html(i).attr('data-page', i); 
					}
					$('.paging_button1').append(add);
				}
				$('.paging_button1').append('&nbsp;&nbsp;|&nbsp;&nbsp;');

				if(endPage < totalPage){
					add = $('<li></li>').html('[다음]').attr('data-page',(startPage+pageCount));
					$('.paging_button1').append(add);
				}	
	}

	$(document).on('click','.paging_button1 li',function(){
		currentPage = $(this).attr('data-page');
		selling(currentPage, sellingCount);
	});

	function soldPage(){

				$('.paging_button2').empty();

				if(soldCount == 0){
					return;					
				}

				//전체페이지수 구하기
				var totalPage = Math.ceil(soldCount/rowCount);
				if(currentPage == undefined || currentPage == ''){
					currentPage = 1;
				}

				//현재 페이지가 전체 페이지 수보다 크면 전체 페이지수로 설정
				if(currentPage > totalPage){
					currentPage = totalPage;
				}

				//시작 페이지와 마지막 페이지 값을 구하기
				var startPage = Math.floor((currentPage-1)/pageCount)*pageCount +1;
				var endPage = startPage + pageCount - 1;
				//마지막 페이지가 전체 페이지 수보다 크면 전체 페이지 수로 설정
				if(endPage > totalPage){
					endPage = totalPage;
				}

				var add;
				if(startPage > pageCount){
					add = $('<li></li>').html('[이전]').attr('data-page',(startPage-1));
					$('.paging_button2').append(add);
				}

				$('.paging_button2').append('&nbsp;&nbsp;|&nbsp;&nbsp;');
				for(var i=startPage; i<=endPage; i++) {
					if (i == currentPage) {
						add = $('<li style="color: red;"> </li>').html(i).attr('data-page', i);
					} else {
						add = $('<li> </li>').html(i).attr('data-page', i); 
					}
					$('.paging_button2').append(add);
				}
				$('.paging_button2').append('&nbsp;&nbsp;|&nbsp;&nbsp;');

				if(endPage < totalPage){
					add = $('<li></li>').html('[다음]').attr('data-page',(startPage+pageCount));
					$('.paging_button2').append(add);
				}
		}

	//페이지 버튼 이벤트 연결
	$(document).on('click','.paging_button2 li',function(){
		//페이지 번호를 읽어들임
		currentPage = $(this).attr('data-page');
		//목록 호출
		sold(currentPage, soldCount);
	});

	sell(1,sellCount);
	selling(1,sellingCount);
	sold(1,soldCount);

});