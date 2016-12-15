<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/user/css/search.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/user/js/jquery-1.12.4.min.js"></script>
<script type="text/javascript"	src="${pageContext.request.contextPath}/resources/user/js/search.js"></script>

<!-- Page Title -->
<div class="section section-breadcrumbs">
	<div class="container">
		<div class="row">
			<div class="col-md-3">
				<h1>Search</h1>
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
						<th><h3>IMAGE</h3></th>
						<th><h3>BRAND</h3></th>
						<th><h3>MODEL NAME</h3></th>
						<th><h3>MODEL NUMBER</h3></th>
						<th></th>
					</tr>
					<c:forEach var="model" items="${list}">
						<tr>
							<td class="image"><img
								src="${pageContext.request.contextPath}/model/${model.mo_image}" width="80px" height="50px"></td>
							<td class="event-day">${model.mo_brand}</td>
							<td class="event-day">${model.mo_model}</td>
							<td class="event-day">${model.mo_code}</td>
							<td><input type="button" class="btn btn-grey btn-sm event-more" value="Choose" onclick="location.href='${pageContext.request.contextPath}/item/write.do?mo_code=${model.mo_code}'"></td>
						</tr>
					</c:forEach>
				</table>
				<div class="pagination-wrapper">${pagingHtml}</div>
			</div>
			<form action="model.do" id="search_form" class="form">
				<div class="col-sm-7 col-sm-offset-2">
					<input type="text" name="mo_model" class="form-control" id="search" onchange="javascript:this.value=this.value.toUpperCase();" placeholder="검색어를 입력하세요" />
				</div>
				<input type="submit" class="btn pull-right" value="Search">
			</form>
		</div>
	</div>
</div>
