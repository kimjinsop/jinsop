<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/user/js/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/user/js/confirmId.js"></script>
<div class="section section-breadcrumbs">
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<h1>Register</h1>
			</div>
		</div>
	</div>
</div>
<div class="section">
	<div class="container">
		<div class="row">
			<div class="col-sm-6 col-sm-offset-3">
				<div class="basic-login">
						<form:form action="write.do" commandName="command" role="form"	id="register_form">
						<form:errors element="div" />
							<div class="form-group">
								<label for="mem_id"><i class="icon-user"></i><b>ID</b></label>
								<form:input class="form-control" path="mem_id" id="mem_id" />
								<input type="button" id="confirmId" value="ID중복체크">
								<span id="message_id"></span>
								<form:errors path="mem_id"/>
							</div>
							<div class="form-group">
								<label for="mem_name"><i class="icon-user"></i><b>NAME</b></label>
								<form:input class="form-control" path="mem_name" />
								<form:errors path="mem_name"/>
							</div>
							<div class="form-group">
								<label for="mem_passwd"><i class="icon-lock"></i><b>PassWord</b></label>
								<form:password class="form-control" path="mem_passwd" maxlength="15" />
								<form:errors path="mem_passwd"/>
							</div>
							<div class="form-group">
								<label for="mem_cell"><i class="icon-user"></i><b>Cell</b></label>
								<form:input class="form-control" path="mem_cell" />
								<form:errors path="mem_cell"/>
							</div>
							<div class="form-group">
								<input type="submit" class="btn pull-right" value="Sign in">
								<div class="clearfix"></div>
							</div>
						</form:form>
				</div>
			</div>
		</div>
	</div>
</div>
