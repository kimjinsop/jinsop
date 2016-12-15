<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/admin/js/vip.mng.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/user/css/main.css">
<div id="page-wrapper">
	<div class="container-fluid">
		<!-- Page Heading -->
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">우수 회원 관리</h1>
				<ol class="breadcrumb">
					<li><i class="fa fa-dashboard"></i> <a
						href="${pageContext.request.contextPath}/admin/main.do">최신
							업데이트 현황</a></li>
					<li class="active"><i class="fa fa-table"></i> 우수 회원 관리</li>
				</ol>
			</div>
		</div>
		<!-- /.row -->
		<div class="row">
			<div class="col-lg-6">
				<h2>우수 구매 회원</h2>
				<div class="table-responsive">
					<table class="table table-bordered table-hover">
						<thead>
							<tr>
								<th>아이디</th>
								<th>총 구매량</th>
								<th>총 구매 금액</th>
							</tr>
						</thead>
						<tbody id="vipBuy">
						</tbody>
					</table>
					<div class="pagination-wrapper">
					<ul class="pagination pagination-sm paging_button" id="buy_paging"
						style="cursor: pointer;"></ul>
						</div>
				</div>
			</div>

			<div class="col-lg-6">
				<h2>우수 판매 회원</h2>
				<div class="table-responsive">
					<table class="table table-bordered table-hover">
						<thead>
							<tr>
								<th>아이디</th>
								<th>총 판매량</th>
								<th>총 판매 금액</th>
							</tr>
						</thead>
						<tbody id="vipSell">
						</tbody>
					</table>
					<div class="pagination-wrapper">
					<ul class="pagination pagination-sm paging_button"
						id="sell_paging" style="cursor: pointer;"></ul>
					</div>
				</div>
			</div>
		</div>
		<!-- /.row -->

	</div>
	<!-- /.container-fluid -->

</div>
<!-- /#page-wrapper -->

