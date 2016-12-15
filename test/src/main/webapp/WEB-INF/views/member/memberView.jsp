<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/user/css/member.css">
<div class="section section-breadcrumbs">
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<h1>회원정보</h1>
			</div>
		</div>
	</div>
</div>
<div class="section">
	<div class="container">
		<div class="row">
			<div class="col-sm-6 col-sm-offset-3">
				<div class="basic-login">
					<div>
						<label class="col-sm-6 control-label">ID</label>
						<label>${member.mem_id}</label>
					</div>
					<br>
					<div>
						<label class="col-sm-6 control-label">NAME</label>
						<label>${member.mem_name}</label>
					</div>
					<br>
					<div>
						<label class="col-sm-6 control-label">Cell</label>
						<label>${member.mem_cell}</label>
					</div>
					<br>
					<div>
						<label class="col-sm-6 control-label">Register</label>
						<label>${member.mem_register}</label>
					</div>
					<br>
					<div>
						<label class="col-sm-6 control-label">My Point</label>
						<label>${point.point}</label>
					</div>
					<br><br>
					<div class="pull-right">
						<input type="button" class="btn" value="Update"
							onclick="location.href='update.do'"> 
						<input type="button" class="btn" value="Quit"
							onclick="location.href='delete.do'"> 
						<input type="button" class="btn" value="My Point"
							onclick="location.href='point.do'">
					</div>
					<div class="clearfix"></div>
				</div>
			</div>
		</div>
	</div>
</div>

