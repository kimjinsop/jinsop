<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/user/js/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/user/js/reply.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/user/js/list.js"></script>
<!-- Page Title -->
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
			<!-- Blog Post -->
			<div class="col-sm-8">
				<div class="blog-post blog-single-post">
					<div class="single-post-title">
						<h3>${community.cm_title}</h3>
					</div>
					<div class="single-post-info">
						<i class="glyphicon glyphicon-time"></i>
						${community.cm_register} <a href="#" title="Show Comments">
						<i class="glyphicon glyphicon-comment"></i>${cm_reply}</a>
					</div>
					<c:if test="${!empty community.cm_image}">
					<div class="single-post-image">
						<img src="${pageContext.request.contextPath}/upload/${community.cm_image}" alt="Post Title">
					</div>
					</c:if>
					<div class="single-post-content">
						${community.cm_content}
						<c:if test="${!empty userId && userId==community.mem_id}">
						<div class="form-group pull-right">
							<input type="button" class="btn btn-large" value="Modify" onclick="location.href='update.do?cm_num=${community.cm_num}'">
							<input type="button" class="btn btn-large" value="Delete" onclick="location.href='delete.do?cm_num=${community.cm_num}'">
						</div>
					</c:if>
					</div>
					
					<!-- Comments -->
					<div class="post-coments">
						<h4>Comments</h4>
						<ul class="post-comments" id="output"></ul>
						<!-- Pagination -->
						<div class="pagination-wrapper">
							<ul class="pagination pagination-sm  paging_button" style="cursor:pointer;"></ul>
						</div>
						<div class="comment-form-wrapper" id="re_update" style="display: none;">
							<form id="mre_form">
								<input type="hidden" name="re_num" id="mre_num">
								<input type="hidden" name="mem_id" id="mmem_id">
								<div class="form-group">
									<label for="re_content"><i class="glyphicon glyphicon-comment"></i> <b>Your Message</b></label>
									<textarea class="form-control" rows="5" id="mre_content" name="re_content" maxlength="300" style="resize:none;"></textarea>
								</div>
								<div class="form-group pull-right">
									<input type="submit" class="btn btn-large" value="Send">
									<input type="button" class="btn btn-large" id="re_reset" value="Cancle">
								</div>
								<div class="clearfix"></div>
							</form>
						</div>
						<!-- Comments Form -->
						<h4>Leave a Comment</h4>
						<div class="comment-form-wrapper">
							<form id="re_form">
								<input type="hidden" name="cm_num" value="${community.cm_num}" id="cm_num">
								<input type="hidden" name="mem_id" value="${userId}" id="mem_id">
								<div class="form-group">
									<label for="userId">
									<i	class="glyphicon glyphicon-user"></i> 
									<b>${userId}</b>
									</label> 
								</div>
								<div class="form-group">
									<label for="re_content"><i class="glyphicon glyphicon-comment"></i> <b>Your Message</b></label>
									<textarea class="form-control" rows="5" id="re_content" name="re_content" maxlength="300" style="resize:none;"></textarea>
								</div>
								<div class="form-group">
									<input type="submit" class="btn btn-large pull-right" value="Send">
								</div>
								<div class="clearfix"></div>
							</form>
						</div>
						<!-- End Comment Form -->
					</div>
					<!-- End Comments -->
				</div>
			</div>
			<!-- End Blog Post -->
			<!-- Sidebar -->
			<div class="col-sm-4 blog-sidebar">
				<h4>community</h4>
				<ul class="recent-posts" id="output2"></ul>
				<div class="pagination-wrapper">
					<ul class="pagination pagination-sm  paging_button2" style="cursor:pointer;"></ul>
				</div>
			</div>
			<!-- End Sidebar -->
		</div>
	</div>
</div>