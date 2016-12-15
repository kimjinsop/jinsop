<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/user/js/jquery-1.9.1.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/user/js/marketValue.js"></script>
<div class="section section-breadcrumbs">
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<h1>Products</h1>
			</div>
		</div>
	</div>
</div>
<div class="eshop-section section">
	<div class="container">
		<div class="row">
			<div class="col-md-12">
			<input type="hidden" id="it_code" value="${it_code}">
				<table class="col-sm-10 pull-right" id="marketPrice">	</table>
				<c:forEach var="item" items="${listByModel}">
					<!-- Product -->
					<div class="col-md-3 col-sm-6">
						<div class="shop-item">
							<!-- Product Image -->
							<div class="shop-item-image">
								<a
									href="${pageContext.request.contextPath}/item/detail.do?it_num=${item.it_num}">
									<img
									src="${pageContext.request.contextPath}/upload/${item.it_image}"
									alt="Item Name" width="220px;" height="150px;">
								</a>
							</div>
							<!-- Product Title -->
							<div class="title">
								<h3>
									${item.it_brand}<br>
									<br> <a
										href="${pageContext.request.contextPath}/item/detail.do?it_num=${item.it_num}">${item.it_model}
									</a>
								</h3>
							</div>
							<!-- Product Price-->
							<div class="price">￦ ${item.it_price}</div>
							<!-- Add to Cart Button -->
							<div class="actions">
								<a
									href="${pageContext.request.contextPath}/item/detail.do?it_num=${item.it_num}"
									class="btn btn-small"><i
									class="icon-shopping-cart icon-white"></i> View Detail</a>
							</div>
						</div>
					</div>
					<!-- End Product -->
				</c:forEach>
			</div>
		</div>
		<div class="pagination-wrapper">${pagingHtml}</div>
	</div>
</div>