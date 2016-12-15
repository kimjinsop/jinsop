<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/user/js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/user/js/itemAndPoint.js"></script>
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
				<!-- Product Image & Available Colors -->
				<div class="col-sm-6">
					<div class="product-image-large">
						<img
							src="${pageContext.request.contextPath}/upload/${command.it_image}"
							alt="Item Name">
					</div>
				</div>
				<!-- End Product Image & Available Colors -->
				<!-- Product Summary & Options -->
				<form:form action="update.do" enctype="multipart/form-data" commandName="command" id="updata_form" role="form">
				<div class="col-sm-6 product-details">
					<br>
					<h3>
						<b>BRAND : </b>${command.it_brand}</h3>
					<br> <br>
					<h3>
						<b>MODEL NAME : </b>${command.it_model}</h3>
					<br> <br>
					<h3>
						<b>PRICE : ￦</b><input type="text" name="it_price" id="it_price" value=" ${command.it_price}">
					</h3>
					<br> <br>
					<h3>
						<b>SIZE : </b>${command.it_size}</h3>
					<br> <br>
					<table class="shop-item-selections">
						<!-- Add to Cart Button -->
						<tr>
							<td>&nbsp;</td>
							<c:if test="${!empty userId && userId != command.mem_id}">
								<td><a
									href="${pageContext.request.contextPath}/item/buy.do?it_num=${command.it_num}"
									class="btn btn"> <i class="icon-shopping-cart icon-white"></i>Buy
										Now!!
								</a> <a
									href="${pageContext.request.contextPath}/item/listByModel.do?it_model=${command.it_model}"
									class="btn btn"> <i class="icon-shopping-cart icon-white"></i>
										Back
								</a></td>
							</c:if>
							<div class="form-group">
								<div class="pull-right">
									<input type="submit" class="btn" value="Send">
									<input type="button" class="btn" value="Cancle" onclick="location.href='${pageContext.request.contextPath}/item/list.do'">
								</div>
							</div>
						</tr>
					</table>
				</div>
				</form:form>
				<!-- End Product Summary & Options -->
			</div>
		</div>
	</div>