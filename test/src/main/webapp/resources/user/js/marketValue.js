$(document).ready(function() {
	var currentPage;
	
	function marketPrice(pageNum, it_code) {
		currentPage = pageNum;
		
		$('#marketPrice').empty();
		
		$.ajax({
			type:'post', data:{pageNum:pageNum, it_code:it_code}, url:'marketValueAjax.do', dataType:'json', cache:false, timeout:30000,
			success:function(data) {
				var list = data.list;
				
				$(list).each(function(index, list) {
					var output = '';
					
					output += '<tr>';
					output += '<th>Min Price : ￦' + list.min + '</th>';
					output += '<th>Avg Price : ￦' + list.avg + '</th>';
					output += '<th>Max Price : ￦' + list.max + '</th>';
					output += '</tr>';
					
					$('#marketPrice').append(output);
				})
			}, error:function() {
				alert('네트워크 오류');	
			}
		});
	}
	marketPrice(1, $('#it_code').val());
});