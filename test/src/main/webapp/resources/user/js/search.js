$(document).ready(function(){
	$('#search_form').submit(function(){
		if($('#search').val()==''){
			alert('검색어를 입력하세요!');
			$('#search').focus();
			return false;
		}
	});
});