<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/user/js/jquery-1.9.1.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/user/js/search.js"></script>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/user/css/search.css">

<div class="section section-breadcrumbs">
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<h1>Community Board</h1>
			</div>
		</div>
	</div>
</div>

<div class="section">
	<div class="container">
		<div class="row">
			<!-- Latest News -->
			<div class="col-sm-12 latest-news">
				<h2>Community Board</h2>
				<c:forEach var="community" items="${list}">
					<div class="row">
						<div class="col-sm-12">
							<div class="caption">
								<b>${community.mem_id}</b>
							</div>
							<div class="date" align="right">${community.cm_register}</div>
							<div class="intro">
								${community.cm_title} <a
									href="view.do?cm_num=${community.cm_num}">Read more...</a>
							</div>
						</div>
					</div>
				</c:forEach>
				<div align="center">${pagingHtml}</div>
				<br>
				<form action="list.do" id="search_form" class="form">
					<div class="col-sm-2">
						<select name="keyfield" style="height: 35px;">
							<option value="cm_title">제목</option>
							<option value="mem_id">작성자</option>
							<option value="cm_content">내용</option>
							<option value="all">전체</option>
						</select>
					</div>
					<div class="col-sm-7" style="float: left;">
						<input type="text" name="it_model" class="form-control"
							id="search"
							onchange="javascript:this.value=this.value.toUpperCase();"
							placeholder="검색어를 입력하세요" />
					</div>
					<div class="pull-right">
					<input type="submit" class="btn" value="Search">
					<input type="button" class="btn"  value="Write"
						onclick="location.href='write.do'">
						</div>
				</form>
			</div>
		</div>
	</div>
</div>
