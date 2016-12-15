<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/user/js/jquery-1.9.1.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/user/js/itemAndPoint.js"></script>
<!-- Page Title -->
<div class="section section-breadcrumbs">
	<div class="container">
		<div class="row">
			<div class="col-md-6">
				<h1>Point</h1>
			</div>
		</div>
	</div>
</div>
<div class="section">
	<div class="contatiner">
		<div class="row">
			<div class="contact-form-wrapper">
				<div class="col-sm-12 col-sm-offset-4">
					<label class="col-sm-3 control-label"><h3>ID : ${point.mem_id}</h3></label>
					<label><h3>My Point : ${point.point}</h3></label>
					<input type="hidden" id="myPoint" value="${point.point}">
				</div>
			</div>
			<br> <br>
			<!-- 포인트 충전 -->
			<form:form action="addPoint.do" commandName="command" id="add_form"
				class="form-horizontal" role="form">
				<div class="col-sm-8 col-sm-offset-3">
				<h3>Add Point</h3>
				<br>
				<input type="hidden" name="mem_id" value="${userId}">
					<div class="form-group col-sm-6">
						<label class="control-label"><b>Point</b></label><br><br>
						<input type="radio" class="point" name="point" value="10000">10,000
						<b style="color: red;">￦ 11,000</b><br>
						<input type="radio" class="point" name="point" value="50000">50,000 
						<b style="color: red;">￦ 55,000</b><br> 
						<input type="radio" class="point" name="point" value="100000">100,000 
						<b style="color: red;">￦ 110,000</b><br>
						<input type="radio" class="point" name="point" value="150000">150,000 
						<b style="color: red;">￦ 165,000</b><br> 
						<input type="radio" class="point" name="point" value="200000">200,000 
						<b style="color: red;">￦ 220,000</b><br>
						<input type="radio" class="point" name="point" value="250000">250,000 
						<b style="color: red;">￦ 275,000</b><br> 
						<input type="radio" class="point" name="point" value="300000">300,000 
						<b style="color: red;">￦ 330,000</b><br>
						<input type="radio" class="point" name="point" value="500000">500,000 
						<b style="color: red;">￦ 550,000</b><br> 
						<input type="radio" class="point" name="point" value="800000">800,000 
						<b style="color: red;">￦ 880,000</b><br>
						<input type="radio" class="point" name="point" value="1000000">1,000,000 
						<b style="color: red;">￦ 1,100,000</b><br>
					</div>
					<div class="form-group col-sm-6">
						<label class="control-label"><b>account</b></label><br>
						<input type="text" size="4" maxlength="4" class="account" id="account1">
						 - <input type="password" size="4" maxlength="4" class="account" id="account2">
						 - <input type="text" size="4" maxlength="4" class="account" id="account3">
	 					 - <input type="password" size="4" maxlength="4" class="account" id="account4">
						<div id="err_account"></div><br>
						<label class="control-label"><b>CVC</b></label><br>
						<input type="password" size="3" maxlength="3" id="cvc">
						<div id="err_cvc"></div><br><br>
						<input type="submit" class="btn" value="Add">
						<input type="button" onclick="location.href='${pageContext.request.contextPath}/member/detail.do'"
						class="btn" value="My Page">
						<div class="clearfix"></div>
					</div>
				</div>
			</form:form>
			<br> <br>
			<!-- 포인트 환불 -->
			<form:form action="refundPoint.do" commandName="command"
				id="refund_form" class="form-horizontal" role="form">
				<div class="col-sm-8 col-sm-offset-3">
				<h3>Point Refund</h3>
				<br>
				<input type="hidden" name="mem_id" value="${userId}">
					<div class="form-group col-sm-6">
						<label class="control-label"><b>Account</b></label><br>
						<input type="text" size="4" maxlength="4" class="refund_account" id="refund_account1"> 
						- <input type="password" size="4" maxlength="4" class="refund_account" id="refund_account2"> 
						- <input type="text" size="4" maxlength="4" class="refund_account" id="refund_account3">
						- <input type="password" size="4" maxlength="4" class="refund_account" id="refund_account4">
						<div id="err_reaccount"></div>
						<label class="control-label">Point</label><br>
						<input type="text" maxlength="6" id="refund_point" name="point">
						<div id="err_repoint"></div>
					</div>
					<div class="col-sm-4">
						<input type="submit" class="btn" value="refund"> 
						<input type="button" onclick="location.href='${pageContext.request.contextPath}/member/detail.do'"
							class="btn" value="My Page">
						<div class="clearfix"></div>
					</div>
				</div>
			</form:form>
		</div>
	</div>
</div>