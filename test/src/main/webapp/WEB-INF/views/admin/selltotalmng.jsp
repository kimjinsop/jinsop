<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!-- Bootstrap Core CSS -->
<link
	href="${pageContext.request.contextPath}/resources/admin/css/bootstrap.min.css"
	rel="stylesheet">

<!-- Custom CSS -->
<link
	href="${pageContext.request.contextPath}/resources/admin/css/sb-admin.css"
	rel="stylesheet">

<!-- Morris Charts CSS -->
<link
	href="${pageContext.request.contextPath}/resources/admin/css/plugins/morris.css"
	rel="stylesheet">

<!-- Custom Fonts -->
<link
	href="${pageContext.request.contextPath}/resources/admin/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/user/css/main.css">

<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/admin/js/jquery-1.12.4.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/admin/js/sell.mng.js"></script>

<div id="page-wrapper">
	<div class="container-fluid">
		<!-- Page Heading -->
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">판매 목록</h1>
				<ol class="breadcrumb">
					<li><i class="fa fa-dashboard"></i> <a
						href="${pageContext.request.contextPath}/admin/main.do">최신
							업데이트 현황</a></li>
					<li class="active"><i class="fa fa-table"></i> 판매 목록</li>
				</ol>
			</div>
		</div>
		<!-- /.row -->
		<div class="row">
			<div class="col-lg-4">
				<div id="sellCount"></div>				
				<div class="table-responsive">
					<table class="table table-bordered table-hover">
						<thead>
							<tr>
								<th>승인</th>
								<th>ID</th>
								<th>브랜드</th>
								<th>모델명</th>
								<th>사이즈</th>
								<th>가격</th>
							</tr>
						</thead>
						<tbody id="output">
						</tbody>
					</table>
					<div class="pagination-wrapper">
						<ul class="pagination pagination-sm paging_button"
							style="cursor: pointer;"></ul>
					</div>
				</div>
				<div align="right">
					<input type="button" class="btn btn-sm btn-primary" id="agree" value="판매승인">
				</div>
			</div>
			<div class="col-lg-4">
				<div id="sellingCount"></div>
				<div class="table-responsive">
					<table class="table table-bordered table-hover">
						<thead>
							<tr>
								<th>ID</th>
								<th>브랜드</th>
								<th>모델명</th>
								<th>사이즈</th>
								<th>가격</th>
							</tr>
						</thead>
						<tbody id="output1"></tbody>
					</table>
					<div class="pagination-wrapper">
						<ul class="pagination pagination-sm  paging_button1"
							style="cursor: pointer;"></ul>
					</div>
				</div>
			</div>


			<div class="col-lg-4">
				<div id="soldCount"></div>
				<div class="table-responsive">
					<table class="table table-bordered table-hover">
						<thead>
							<tr>
								<th>ID</th>
								<th>브랜드</th>
								<th>모델명</th>
								<th>사이즈</th>
								<th>가격</th>
							</tr>
						</thead>
						<tbody id="output2"></tbody>
					</table>
					<div class="pagination-wrapper">
						<ul class="pagination pagination-sm  paging_button2"
							style="cursor: pointer;"></ul>
					</div>
				</div>

			</div>
			<!-- /.row -->
		</div>
		<!-- /.container-fluid -->
	</div>
	<!-- /#page-wrapper -->
</div>