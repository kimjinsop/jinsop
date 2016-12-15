<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/user/js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/user/js/buyList.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/user/js/sellList.js"></script>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/user/css/main.css">

<div class="section section-breadcrumbs">
	<div class="container">
		<div class="row">
			<div class="menuextras">
				<h1>판매/구매 목록</h1>
			</div>
		</div>
	</div>
</div>
<div class="section">
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<!-- Shopping Cart Items -->
				<h2>구매 목록</h2>
				<table class="shopping-cart" id="buyList">
					<!-- Shopping Cart Item -->
					<!-- End Shopping Cart Item -->
				</table>
				<div class="pagination-wrapper">
					<ul class="pagination pagination-sm" id="buy_paging" style="cursor:pointer;"></ul>
				</div>
				<!-- End Shopping Cart Items -->
			</div>
			
			<div class="col-md-12">
				<!-- Shopping Cart Items -->
				<h2>판매 대기</h2>
				<table class="shopping-cart" id="sellList">
					<!-- Shopping Cart Item -->
					<!-- End Shopping Cart Item -->
				</table>
				<div class="pagination-wrapper">
					<ul class="pagination pagination-sm paging_button" id="sell_paging" style="cursor:pointer;"></ul>
				</div>
				<!-- End Shopping Cart Items -->
			</div>
			
			<div class="col-md-12">
				<!-- Shopping Cart Items -->
				<h2>판매 중</h2>
				<table class="shopping-cart" id="sellingList">
					<!-- Shopping Cart Item -->
					<!-- End Shopping Cart Item -->
				</table>
				<div class="pagination-wrapper">
					<ul class="pagination pagination-sm" id="selling_paging" style="cursor:pointer;"></ul>
				</div>
				<!-- End Shopping Cart Items -->
			</div>
			
			<div class="col-md-12">
				<!-- Shopping Cart Items -->
				<h2>판매 완료</h2>
				<table class="shopping-cart" id="soldList">
					<!-- Shopping Cart Item -->
					<!-- End Shopping Cart Item -->
				</table>
				<div class="pagination-wrapper">
					<ul class="pagination pagination-sm" id="sold_paging" style="cursor:pointer;"></ul>
				</div>
				<!-- End Shopping Cart Items -->
			</div>
		</div>
	</div>
</div>