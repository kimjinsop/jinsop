$(document).ready(function(){
   var checkIdDuplicated = 0;
   var count = 0;
   
   //아이디 중복 체크
   $('#confirmId').click(function(){
      if($('#mem_id').val()==''){
         alert('아이디를 입력하세요!');
         $('#mem_id').focus();
         return false;
      }
      
      var text = $('#mem_id').val();
      
      var regexp = /[0-9a-zA-Z]/; // 숫자,영문,특수문자
      
      for(var i=0; i<text.length; i++){
            if(text.charAt(i) != " " && regexp.test(text.charAt(i)) == false){
            alert("영문 또는  영문 숫자조합으로 입력해주세요");
            return false;
         }
        }

      $('#message_id').html(''); //메세지 초기화
      
      $.ajax({
         url:'confirmId.do',
         type:'post',
         data:{id:$('#mem_id').val()},
         dataType:'json',
         cache:false,
         timeout:30000,
         success:function(data){
            
            if(data.result == 'idNotFound'){
               $('#message_id').css('color','#000000').text('등록가능ID');
               checkIdDuplicated = 1;
            }else if(data.result == 'idDuplicated'){
               $('#message_id').css('color','red').text('중복된 ID');
               checkIdDuplicated = 0;
            }
         },
         error:function(){
            $('#loading').hide(); //로딩 이미지 감추기
            alert('네트워크 오류 발생');
         }
      });
   });
   
   //아이디 중복 안내 메세지 초기화 및 아이디 중복 값 초기화
   $('#register_form #id').keyup(function(){
      checkIdDuplicated = 0;
      $('#message_id').text('');
   });
   
   //submit 이벤트 발생시 아이디 중복 체크 여부 확인
   $('#register_form').submit(function(){
      var cell = $('#mem_cell').val();
      
      if(checkIdDuplicated==0){
         alert('아이디 중복 체크 필수!');
         if($('#mem_id').val()==''){
            $('#mem_id').focus();
         }else{
            $('#confirmId').focus();
         }
         return false;
      }
      if(!$.isNumeric(cell)){
         $('#mem_cell').text('');
         alert('전화번호는 -없이 숫자로만 쓰세요');
         return false;
      }
   });
   /* 이름에 한글만 받기 */
   $("input[name=mem_name]").keyup(function(event){
        regexp = /[a-z0-9]|[ \[\]{}()<>?|`~!@#$%^&*-_+=,.;:\"'\\]/g;
        v = $(this).val();
        if( regexp.test(v) ) {
         alert("한글만입력하세요");
         $(this).val(v.replace(regexp,''));
        }
       });
});