<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!--[if lt IE 7]>
            <p class="chromeframe">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> or <a href="http://www.google.com/chromeframe/?redirect=true">activate Google Chrome Frame</a> to improve your experience.</p>
        <![endif]-->
<!-- Page Title -->
<div class="section section-breadcrumbs">
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<h1>My Page</h1>
			</div>
		</div>
	</div>
</div>

<div class="section">
	<div class="container">
		<div class="row">
			<div class="col-sm-6 col-sm-offset-3">
				<div class="basic-login">
					<form:form action="update.do" commandName="command" id="modify_form" role="form" >
					<form:errors element="div" />
						<div class="form-group">
							<label for="mem_passwd" class="col-sm-3 control-label"><b>PassWord</b></label>
							<form:password path="mem_passwd" class="form-control"/>
							<form:errors path="mem_passwd"/>
						</div>
						<div class="form-group">
							<label for="mem_cell" class="col-sm-3 control-label"><b>Cell</b></label>
							<form:password path="mem_cell" class="form-control"/>
							<form:errors path="mem_cell"/>
						</div>
						<div class="pull-right">
							<input type="submit" class="btn" value="Update">
							<input type="button" class="btn" value="Cancle" onclick="location.href='${pageContext.request.contextPath}/main/main.do'">
						</div>
						<div class="clearfix"></div>
					</form:form>
				</div>
			</div>
		</div>
	</div>
</div>

