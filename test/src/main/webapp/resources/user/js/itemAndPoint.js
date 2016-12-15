$(document).ready(function(){
	//AddPoint
	$('.account').keyup(function(){
		var limit = $(this).attr('maxlength');
		if(this.value.length >= limit){
			$(this).next('.account').focus();
			return false;
		}
	});
	$('#add_form').submit(function(){
		if($(':input[name=point]:radio:checked').val() == undefined){
			alert('충전시킬 액수를 선택하세요');
			return false;
		}
		if($('#account1').val().length < 4 || !$.isNumeric($('#account1').val())){
			$('#err_account').text('');
			$('#err_account').append('카드번호를 제대로 입력하세요');
			return false;
		}
		if($('#account2').val().length < 4 || !$.isNumeric($('#account2').val())){
			$('#err_account').text('');
			$('#err_account').append('카드번호를 제대로 입력하세요');
			return false;
		}
		if($('#account3').val().length < 4 || !$.isNumeric($('#account3').val())){
			$('#err_account').text('');
			$('#err_account').append('카드번호를 제대로 입력하세요');
			return false;
		}
		if($('#account4').val().length < 4 || !$.isNumeric($('#account4').val())){
			$('#err_account').text('');
			$('#err_account').append('카드번호를 제대로 입력하세요');
			return false;
		}
		if($('#cvc').val().length < 3 || !$.isNumeric($('#cvc').val())){
			$('#err_cvc').text('');
			$('#err_cvc').append('CVC 코드를 제대로 입력하세요');
			return false;
		}
	});
	//Point Refund
	$('.refund_account').keyup(function(){
		var limit = $(this).attr('maxlength');
		if(this.value.length >= limit){
			$(this).next('.refund_account').focus();
			return false;
		}
	});
	$('#refund_form').submit(function(){
		var re_point = parseInt($('#refund_point').val());
		var myPoint = parseInt($('#myPoint').val());
		var point = $('#refund_point').val();

		if($('#refund_account1').val().length < 4 || !$.isNumeric($('#refund_account1').val())){
			$('#err_reaccount').text('');
			$('#err_reaccount').append('계좌번호를 제대로 입력하세요');
			return false;
		}
		if($('#refund_account2').val().length < 4 || !$.isNumeric($('#refund_account2').val())){
			$('#err_reaccount').text('');
			$('#err_reaccount').append('계좌번호를 제대로 입력하세요');
			return false;
		}
		if($('#refund_account3').val().length < 4 || !$.isNumeric($('#refund_account3').val())){
			$('#err_reaccount').text('');
			$('#err_reaccount').append('계좌번호를 제대로 입력하세요');
			return false;
		}
		if($('#refund_account4').val().length < 4 || !$.isNumeric($('#refund_account4').val())){
			$('#err_reaccount').text('');
			$('#err_reaccount').append('계좌번호를 제대로 입력하세요');
			return false;
		}
		if($('#refund_point').val() == 0 || $('#refund_point').val().length > 6 || !$.isNumeric($('#refund_point').val())){
			$('#err_repoint').text('');
			$('#err_repoint').append('포인트를 제대로 입력하세요');
			return false;
		}
		if(re_point > myPoint){
			$('#err_repoint').text('');
			$('#err_repoint').append('원래 포인트보다 환불 포인트가 많습니다.');
			return false;
		}
		if(point <= 0){
			$('#err_repoint').text('');
			$('#err_repoint').append('포인트를 0 이하로 입력할 수 없습니다.');
			return false;
		}
	});
	//ItemBuy
	var it_price = $('#it_price').val();
	var point = $('#point').val();
	var it_status = $('#it_status').val();

	$('#buy_form').submit(function(){
		if($('#buy_zip').val().length < 5){
			$('#err_zip').text('');
			$('#err_zip').append('우편번호는 5~6자리만 입력하세요');
			return false;
		}
		if(!$.isNumeric($('#buy_zip').val())){
			$('#err_zip').text('');
			$('#err_zip').append('우편번호는 숫자만 입력하세요');
			return false;
		}
		if($('#buy_addr1').val() == ''){
			$('#err_addr1').text('');
			$('#err_addr1').append('주소를 입력하세요');
			return false;
		}
		if($('#buy_addr2').val() == ''){
			$('#err_addr2').text('');
			$('#err_addr2').append('상세주소를 입력하세요');
			return false;
		}
		//신발을 살 수 있을 때
		if((point - it_price) >= 0){
			if(!confirm("Buy this item?")){
				return false;	
			}
		}
		//신발을 살 수 없을 때
		if((point - it_price) < 0){
			alert('잔액이 부족합니다');
				return false;
		}
	});
	//수정 폼 유효성 체크
	$('#modify_form').submit(function(){
		if($('#it_model').val() == ''){
			$('#err_model').text('');
			$('#err_model').append('상품명을 반드시 입력해주십시오');
			return false;
		}
		if($('#it_price').val() <= 0 || $('#it_price').val() == '' || !$.isNumeric($('#it_price').val())){
			$('#err_price').text('');
			$('#err_price').append('가격을 제대로 설정해주십시오');
			return false;
		}
	});
	//등록 폼 유효성 체크
	$('#sell_form').submit(function(){
		if($('#it_model').val() == ''){
			$('#err_model').text('');
			$('#err_model').append('상품명을 반드시 입력해주십시오');
			return false;
		}
		if($('#upload').val() == ''){
			$('#err_upload').text('');
			$('#err_upload').append('이미지를 반드시 선택해주십시오');
			return false;
		}
		if($('#it_price').val() <= 0 || $('#it_price').val() == '' || !$.isNumeric($('#it_price').val())){
			$('#err_price').text('');
			$('#err_price').append('가격을 제대로 설정해주십시오');
			return false;
		}
	});
});