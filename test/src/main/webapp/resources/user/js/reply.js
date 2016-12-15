$(document).ready(function() {
	var currentPage;
	var count;
	var rowCount;
	var pageCount;
	
	//댓글 목록
	function selectData(pageNum, cm_num) {
		currentPage = pageNum;
		
		$('#output').empty();

		$.ajax({
			type:'post', data:{pageNum:pageNum, cm_num:cm_num}, url:'re_listAjax.do', dataType:'json', cache:false, tiemout:30000,
			success:function(data) {
				$('#loading').hide();
				count = data.count;
				rowCount = data.rowCount;
				pageCount = data.pageCount;
				var list = data.list;
													
				if(count<0 || list==null) {
					alert('목록 호출 실패');
				} else {
					$(list).each(function(index, re_list) {
						var output = '';
						output += '<li>'
						output += '<div class="comment-wrapper" id="i' + re_list.re_num +'">';
						output += '<div class="comment-author">' + re_list.mem_id + '</div>';
						output += '<p>' + re_list.re_content + '</p>';
						output += '<div class="comment-action">';
						output += '<span class="comment-date">' + re_list.re_register + '</span>';
						if($('#mem_id').val() && $('#mem_id').val()==re_list.mem_id) {
							output += '<div class="form-group pull-right">';
							output += ' <input type="button" value="Modify" data-num="' + re_list.re_num + '"data-id="' + re_list.mem_id + '" class="btn btn-large re_update">';
							output += ' <input type="button" value="Delete" data-num="' + re_list.re_num + '"data-id="' + re_list.mem_id + '" class="btn btn-large re_delete">';
							output += '</div>';             
						}
						output += '</div>';
						output += '</div>';
						output += '</li>';
						
						$('#output').append(output);
					})
					
					if(currentPage>=Math.ceil(count/rowCount)) {
						$('.paging_button').hide();
					} else {
						$('.paging_button').show();
					}
				}
				
				setPage();
				
			}, error:function() {
				$('#loading').hide();
				alert('네트워크 오류');
			}
		});
	}
	
	function setPage() {
		$('.paging_button').empty();
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
			$('.paging_button').append(add);						
		}
		
		for(var i=startPage; i<=endPage; i++) {
			if (i == currentPage) {
				add = $('<li style="color: red;"> </li>').html(i).attr('data-page', i);
			} else {
				add = $('<li> </li>').html(i).attr('data-page', i); 
			}
			$('.paging_button').append(add);
		}
		
		if(totalPage-startPage >= pageCount) {
			add = $('<li></li>').html('[다음]').attr('data-page', (endPage+1));
			$('.paging_button').append(add);						
		}
	}
	$(document).on('click', '.paging_button li', function() {
		currentPage = $(this).attr('data-page');
		selectData(currentPage, $('#cm_num').val());
	})


	//댓글 등록
	$('#re_form').submit(function(event) {
		if($('#re_content').val()=='') {
			alert('내용이 없습니다.');
			return false;
		}
		
		var data = $(this).serialize();

		$.ajax({
			type:'post', data:data, url:'re_writeAjax.do', dataType:'json', cache:false, timeout:30000,
			success:function(data) {
				if(data.result=='logout') {
					alert('로그인 후 이용 가능');
				} else if(data.result=='success') {
					initForm();
					initModifyForm();
					selectData(1, $('#cm_num').val());
				} else {
					alert('등록 중 오류 발생');
				}
			}, error:function() {
				alert('네트워크 오류 발생');
			}
		});
		event.preventDefault();
	});
	
	$(document).on('click', '.re_update', function() {
		var re_num = $(this).attr('data-num');
		var mem_id = $(this).attr('data-id');
		$('.comment-authorr').show();
		$('#' + re_num + ' .comment-author').hide();
		
		$('#mre_num').val(re_num);
		$('#mmem_id').val(mem_id);
	    $('#mre_content').val($('#i' + re_num + ' p').text());
	    
	    $('#i' + re_num).append($('#mre_form'));
	});
	
	$('#re_reset').click(function() {
		initModifyForm();
	});
	
	function initForm() {
		$('textarea').val('');
	};
	
	function initModifyForm() {
		$('.comment-author').show();
		$('#re_update').append($('#mre_form'));
		$('#mre_num').val('');
		$('#mmem_id').val('');
		$('#mre_content').val('');
	}
	
	$('#mre_form').submit(function(event){
		if($('#mre_content').val()=='') {
			alert('수정할 내용이 없습니다.');
			return false;
		}
	
      //폼에 입력한 데이터 반환
      var data = $(this).serialize();
   
      //수정
      $.ajax({
         type:'post',
         data:data,
         url:'re_updateAjax.do',
         dataType:'json',
         cache:false,
         timeout:30000,
         success:function(data){
            if(data.result=='logout'){
            alert('로그인 후 이용가능.');
            }else if(data.result=='wrongAccess'){
               alert(mem_id + '님의 댓글이 아닙니다.');
            }else if(data.result=='success'){
               $('#i'+$('#mre_num').val() + ' p').html($('#mre_content').val());
               //수정폼 초기화
               initModifyForm();               
            }else{
               alert('수정 중 오류 발생!');
            }
         },
         error:function(){
            alert('네트워크 오류 발생!');
         }         
      });      
      //기본 이벤트 제거
      event.preventDefault();
   });
	
	$(document).on('click', '.re_delete', function() {
		var re_num = $(this).attr('data-num');
		var mem_id = $(this).attr('data-id');
		
		$.ajax({
			type:'post', data:{re_num:re_num, mem_id:mem_id}, url:'re_deleteAjax.do', dataType:'json', cache:false, timeout:30000,
			success:function(data) {
				if(data.result=='logout') {
					alert('로그인을 하십시오');
				} else if(data.result=='wrongAccess'){
		            alert(mem_id + '님의 댓글이 아닙니다.');
	            } else if(data.result=='success'){
	               alert('삭제 완료!');
	               //수정폼 초기화
	               initModifyForm();
	               selectData(1,$('#cm_num').val());
	            } else{
	               alert('삭제 중 오류 발생!');
	            }
			}, error:function() {
				alert('네트워크 오류 발생');
			}
		})	
	});
	
	
	//초기 데이터 호출
	selectData(1, $('#cm_num').val());
	
});