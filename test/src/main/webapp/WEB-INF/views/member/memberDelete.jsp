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
					<form:form action="delete.do" commandName="command">
					<form:errors element="div"/>
						<div class="form-group">
							<label for="mem_id">ID</label>
							<form:input path="mem_id" class="form-control" readonly="true"/>
						</div>
						<div class="form-group">
							<label for="mem_passwd">PassWord</label>
							<form:password path="mem_passwd" class="form-control"/>
							<form:errors path="mem_passwd"/>
						</div>
						<div class="form_group">
							<div class="pull-right">
								<input type="submit" class="btn" value="Quit">
								<input type="button" class="btn" value="Cancle" onclick="location.href='detail.do'">
							</div>
						</div>
						<div class="clearfix"></div>
					</form:form>
				</div>
			</div>
		</div>
	</div>
</div>

