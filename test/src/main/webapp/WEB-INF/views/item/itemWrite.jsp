<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/user/js/jquery-1.9.1.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/user/js/itemWrite.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/user/js/marketValue.js"></script>	
<!-- Page Title -->
<div class="section section-breadcrumbs">
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<h1>Upload Item</h1>
			</div>
		</div>
	</div>
</div>
<div class="section">
	<div class="container">
		<div class="row">
			<div class="col-sm-12">
				<div class="contact-form-wrapper">
					<h2>Upload Item</h2>
					<form:form action="write.do" enctype="multipart/form-data"
						commandName="command" id="write_form" class="form-horizontal"
						role="form">
						<div class="form-group">
							<label for="it_brand" class="col-sm-2 control-label"> <b>brand</b>
							</label>
							<div class="col-sm-4">
								<input type="text" class="form-control" name="it_brand"
									id="it_brand" value="${command.it_brand}" readonly="readonly">
							</div>
						</div>
						<div class="form-group">
							<label for="it_model" class="col-sm-2 control-label"> <b>model
									name</b>
							</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" name="it_model"
									id="it_model" value="${command.it_model}" readonly="readonly">
							</div>
						</div>
						<div class="form-group">
							<label for="it_code" class="col-sm-2 control-label"> <b>model
									number</b>
							</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" name="it_code"
									id="it_code" value="${command.it_code}" readonly="readonly">
							</div>
						</div>
						<div class="form-group">
							<label for="it_image" class="col-sm-2 control-label"> <b>image</b>
							</label>
							<div class="col-sm-8">
								<input id="upload" name="upload" id="upload" type="file">
							</div>
						</div>
						<div class="form-group">
							<label for="it_size" class="col-sm-2 control-label"> <b>size</b>
							</label>
							<div class="col-sm-8">
								<select id="it_size" name="it_size" class="col-sm-2">
								   <option value="">------</option>
									<option value="250">250</option>
									<option value="255">255</option>
									<option value="260">260</option>
									<option value="265">265</option>
									<option value="270">270</option>
									<option value="275">275</option>
									<option value="280">280</option>
									<option value="285">285</option>
								</select>
							</div>
						</div>
						<div class="form-group">
							<label for="it_price" class="col-sm-2 control-label"> <b>price</b>
							</label>
							<div class="col-sm-4">
								<input type="number" class="form-control" name="it_price"
									id="it_price" value="">
							</div>
						</div>
						<div class="form-group">
							<input type="hidden" id="it_code" value="${it_code}">
							<table id="marketPrice" class="col-sm-10 pull-right"></table>
							<br>
						</div>
						<div class="form-group">
							<div class="pull-right">
								<input type="submit" class="btn" value="Send"> 
								<input type="button" onclick="location.href='${pageContext.request.contextPath}/item/model.do'"
									class="btn" value="List">
								<input type="button" onclick="location.href='${pageContext.request.contextPath}/main/main.do'"
									class="btn" value="Home">
							</div>
						</div>
					</form:form>
				</div>
			</div>
		</div>
	</div>
</div>