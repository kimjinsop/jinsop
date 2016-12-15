<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/user/js/jquery-1.12.4.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/user/js/search.js"></script>
<!-- Page Title -->
<div class="section section-breadcrumbs">
	<div class="container">
		<div class="row">
			<div class="col-md-3">
				<h1>BRAND ITEM</h1>
			</div>
		</div>
	</div>
</div>
<div class="section">
	<div class="container">
		<div class="row">
			<div class="col-md-12">

				<table class="events-list">
					<tr>
						<th>BRAND</th>
						<th>MODEL NAME</th>
						<th>MODEL CODE</th>
						<th>STOCK STATUS</th>
						<th></th>
					</tr>
					<c:forEach var="item" items="${list}">
						<tr>
							<td class="event-day">${item.it_brand}</td>
							<td class="event-day">${item.it_model}</td>
							<td class="event-day">${item.it_code}</td>
							<td class="event-price hidden-xs">${item.model_cnt}item</td>
							<td><a
								href="${pageContext.request.contextPath}/item/modelList.do?it_code=${item.it_code}"
								class="btn btn-grey btn-sm event-more"> view this model >> </a></td>
						</tr>
					</c:forEach>
				</table>
				<div class="pagination-wrapper">${pagingHtml}</div>
				<form action="list.do" id="search_form" class="form">
					<div class="col-sm-7 col-sm-offset-2">
						<input type="text" name="it_model" class="form-control"
							id="search"
							onchange="javascript:this.value=this.value.toUpperCase();"
							placeholder="검색어를 입력하세요" />
					</div>
					<input type="submit" class="btn pull-right" value="Search">
				</form>
			</div>
		</div>
	</div>
</div>
