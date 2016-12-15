<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/user/js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/user/js/itemAndPoint.js"></script>

<!-- Page Title -->
<div class="section section-breadcrumbs">
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<h1>Buy</h1>
			</div>
		</div>
	</div>
</div>
<form:form role="form" action="buy.do" id="buy_form">
	<div class="section">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<!-- Shopping Cart Items -->
					<table class="shopping-cart">
						<!-- Shopping Cart Item -->
						<tr>
							<!-- Shopping Cart Item Image -->
							<td class="image"><a href="page-product-details.html"><img
									src="${pageContext.request.contextPath}/upload/${item.it_image}"
									alt="Item Name"></a></td>
							<!-- Shopping Cart Item Description & Features -->
							<td>
								<div class="cart-item-title">
									<a href="detail.do?it_num=${item.it_num}">${item.it_model}</a>
								</div>
								<div class="feature">
									Size: <b>${item.it_size}</b>
								</div>
							</td>
							<!-- Shopping Cart Item Price -->
							<td class="price"><b>￦ ${item.it_price}</b></td>
						</tr>
						<!-- End Shopping Cart Item -->
					</table>
				</div>
			</div>
			<div class="row">
				<!-- 주소 입력창 -->
				<input type="hidden" id="point" value="${point.point}">
				<input type="hidden" id="it_price" value="${item.it_price}">
				<input type="hidden" id="it_status" value="${item.it_status}">
				<input type="hidden" name="mem_id" value="${userId}"> 
				<input type="hidden" name="it_num" value="${item.it_num}">
		
				<div class="form-group">
					<label for="buy_zip" class="col-sm-2 control-label"> 
						<b>zipcode</b>
					</label>
					<div class="col-sm-3">
						<input type="text" class="form-control col-sm-1" name="buy_zip" id="buy_zip" maxlength="6">
						<div id="err_zip"></div>
					</div>
				</div>
				<br><br>
				<div class="form-group">
					<label for="buy_addr1" class="col-sm-2"> 
						<b>address</b>
					</label>
					<div class="col-sm-6">
						<input type="text" class="form-control" name="buy_addr1" id="buy_addr1">
						<div id="err_addr1"></div>
					</div>
				</div>
				<br><br>
				<div class="form-group">
					<label for="buy_addr2" class="col-sm-2 control-label"> <b>address</b>
					</label>
					<div class="col-sm-6">
						<input type="text" class="form-control" name="buy_addr2" id="buy_addr2">
						<div id="err_addr2"></div>
					</div>
				</div>
				<br><br>
				<!-- Shopping Cart Totals -->
				<div class="col-md-4 col-md-offset-8 col-sm-6 col-sm-offset-6">
					<table class="cart-totals">
						<tr>
							<td><b>Point</b></td>
							<td>
								<c:if test="${point.point == 0}">￦ 0</c:if>
							 	<c:if test="${point.point != 0}">￦ ${point.point}</c:if>
							</td>
						</tr>
						<tr>
							<td><b>Price</b></td>
							<td>- ￦ ${item.it_price}</td>
						</tr>
						<tr class="cart-grand-total">
							<td><b>Total</b></td>
							<td>
								<c:if test="${point.point - item.it_price > 0}"><b>￦ ${point.point - item.it_price}</b></c:if>
								<c:if test="${point.point - item.it_price < 0}"><b style="color: red;">￦ ${point.point - item.it_price}</b></c:if>
								<c:if test="${point.point - item.it_price == 0}"><b>￦ 0</b></c:if>
							</td>
						</tr>
					</table>
					<!-- Action Buttons -->
					<div class="pull-right">
						<c:if test="${item.it_status == 'Y'}">
							<input type="submit" class="btn" value=BUY>
						</c:if> 
						<a href="${pageContext.request.contextPath}/member/point.do"	class="btn">Add Point</a>
						<a href="${pageContext.request.contextPath}/item/list.do"	class="btn">list</a>
					</div>
				</div>
			</div>
		</div>
	</div>
</form:form>