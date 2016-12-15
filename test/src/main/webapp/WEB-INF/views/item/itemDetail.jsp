<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div>
	<!-- Page Title -->
	<div class="section section-breadcrumbs">
		<div class="container">
			<div class="row">
				<div class="col-md-2">
					<h1 id="title">Detailed View</h1>
				</div>
			</div>
		</div>
	</div>

	<div class="section">
		<div class="container">
			<div class="row">
				<!-- Product Image & Available Colors -->
				<div class="col-sm-6">
					<div class="product-image-large">
						<img
							src="${pageContext.request.contextPath}/upload/${item.it_image}"
							alt="Item Name">
					</div>
				</div>
				<!-- End Product Image & Available Colors -->
				<!-- Product Summary & Options -->
				<div class="col-sm-6 product-details">
					<br>
					<h3>
						<b>BRAND : </b>${item.it_brand}</h3>
					<br> <br>
					<h3>
						<b>MODEL NAME : </b>${item.it_model}</h3>
					<br> <br>
					<h3>
						<b>PRICE : </b>￦ ${item.it_price}
					</h3>
					<br> <br>
					<h3>
						<b>SIZE : </b>${item.it_size}</h3>
					<br> <br>
					<table class="shop-item-selections">
						<!-- Add to Cart Button -->
						<tr>
							<td>&nbsp;</td>
							<c:if test="${!empty userId && userId != item.mem_id}">
								<td><a
									href="${pageContext.request.contextPath}/item/buy.do?it_num=${item.it_num}"
									class="btn btn"> <i class="icon-shopping-cart icon-white"></i>Buy
										Now!!
								</a> <a
									href="${pageContext.request.contextPath}/item/modelList.do?it_code=${item.it_code}"
									class="btn btn"> <i class="icon-shopping-cart icon-white"></i>
										Back
								</a></td>
							</c:if>
							<c:if test="${!empty userId && userId == item.mem_id}">
								<td><a
									href="${pageContext.request.contextPath}/item/update.do?it_num=${item.it_num}"
									class="btn btn"> <i class="icon-shopping-cart icon-white"></i>
										Modify
								</a> <a
									href="${pageContext.request.contextPath}/item/delete.do?it_num=${item.it_num}"
									class="btn btn"> <i class="icon-shopping-cart icon-white"></i>
										Delete
								</a> <a
									href="${pageContext.request.contextPath}/item/modelList.do?it_code=${item.it_code}"
									class="btn btn"> <i class="icon-shopping-cart icon-white"></i>
										Back
								</a></td>
							</c:if>
							<c:if test="${empty userId}">
								<td><a
									href="${pageContext.request.contextPath}/member/login.do"
									class="btn btn"> <i class="icon-shopping-cart icon-white"></i>
										Login
								</a> <a href="${pageContext.request.contextPath}/member/write.do"
									class="btn btn"> <i class="icon-shopping-cart icon-white"></i>
										Register
								</a> <a
									href="${pageContext.request.contextPath}/item/modelList.do?it_code=${item.it_code}"
									class="btn btn"> <i class="icon-shopping-cart icon-white"></i>
										Back
								</a> <br> <span>구매를 위해서는 로그인이 필요합니다!<br></span></td>
							</c:if>
						</tr>
					</table>
				</div>
				<!-- End Product Summary & Options -->
			</div>
		</div>
	</div>
</div>