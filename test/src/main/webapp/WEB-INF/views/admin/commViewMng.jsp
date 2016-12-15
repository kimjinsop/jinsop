<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/admin/js/jquery-1.12.4.min.js"></script>
<script	type="text/javascript" src="${pageContext.request.contextPath}/resources/admin/js/reply.js"></script>

        <!-- <link rel="stylesheet" href="/kick/resources/user/css/bootstrap.min.css"> -->
        <link rel="stylesheet" href="/kick/resources/user/css/icomoon-social.css">
        <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,700,600,800' rel='stylesheet' type='text/css'>
        <link rel="stylesheet" href="/kick/resources/user/css/leaflet.css" />
		<link rel="stylesheet" href="/kick/resources/user/css/main.css">
        <script src="/kick/resources/user/js/modernizr-2.6.2-respond-1.1.0.min.js"></script>

<div class="section">
	<div class="container">
		<div class="row">
			<!-- Blog Post -->
			<div class="col-sm-12">
				<div class="blog-post blog-single-post">
					<div class="single-post-title">
						<h3>${community.cm_title}</h3>
					</div>
					<input type="hidden" name="cm_num" value="${community.cm_num}" id="cm_num">
					<div class="single-post-info">
						<i class="glyphicon glyphicon-time"></i> ${community.cm_register}
						<a href="#" title="Show Comments"> <i
							class="glyphicon glyphicon-comment"></i>${cm_reply}</a>
					</div>
					<c:if test="${!empty community.cm_image}">
						<div class="single-post-image">
							<img
								src="${pageContext.request.contextPath}/upload/${community.cm_image}"
								width="500px" height="500px" alt="Post Title">
						</div>
					</c:if>
					<div class="single-post-content">
						${community.cm_content}
						<div class="form-group pull-right">
							<input type="button" class="btn btn-large" value="Delete"
								onclick="location.href='delete.do?cm_num=${community.cm_num}'">
						</div>
					</div>

					<!-- Comments -->
					<div class="post-comments">
						<h4>Comments</h4>
						<ul class="post-comments" id="output"></ul>
						<!-- Pagination -->
						<div class="pagination-wrapper">
							<ul class="pagination pagination-sm  paging_button"
								style="cursor: pointer;"></ul>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
