<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- Page Title -->
<div class="section section-breadcrumbs">
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<h1>Login</h1>
			</div>
		</div>
	</div>
</div>

<div class="section">
	<div class="container">
		<div class="row">
			<div class="col-sm-6 col-sm-offset-3">
				<div class="basic-login">
					<form:form action="login.do" commandName="command" role="form" id="login_form">
					<form:errors element="div"/>
						<div class="form-group">
							<label for="mem_id"><i class="icon-user"></i> <b>ID</b></label> 
							<form:input class="form-control" path="mem_id"/>
							<form:errors path="mem_id"/>
						</div>
						<div class="form-group">
							<label for="mem_passwd"><i class="icon-lock"></i> <b>PW</b></label>
							<form:password class="form-control" path="mem_passwd"/>
							<form:errors path="mem_passwd"/>
						</div>
						<div class="form-group">
							<div class="not-member">
								<p>
									Not a member? <a onclick="location.href='${pageContext.request.contextPath}/member/write.do'">Register here</a>
								</p>
							</div>
							<input type="submit" class="btn pull-right" value="Login">
							<div class="clearfix"></div>
						</div>
					</form:form>
				</div>
			</div>
		</div>
	</div>
</div>