$(document).ready(function(){
	$('#write_form').submit(function(){
		if($('#upload').val()==''){
			alert('이미지를 등록하세요!');
			return false;
		}
		if($('#it_size').val()==''){
			alert('사이즈를 선택하세요!');
			return false;
		}
		if($('#it_price').val()==''){
			alert('판매가격을 입력하세요!');
			return false;
		}
	});
});