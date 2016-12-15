<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/user/css/main.css">
<div id="page-wrapper">
	<div class="container-fluid">
		<!-- Page Heading -->
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">커뮤니티 관리</h1>
				<ol class="breadcrumb">
					<li><i class="fa fa-dashboard"></i> <a
						href="${pageContext.request.contextPath}/admin/main.do">최신
							업데이트 현황</a></li>
					<li class="active"><i class="fa fa-table"></i> 커뮤니티 관리</li>
				</ol>
			</div>
		</div>
		<!-- /.row -->
		<div class="row">
			<div class="col-lg-12">
				<h2>커뮤니티 게시글(총 : ${count})</h2>			
				<div class="table-responsive">
					<table class="table table-bordered table-hover">
						<thead>
							<tr>
								<th>아이디</th>
								<th>제목</th>
								<th>내용</th>
								<th>작성일</th>
								<th>파일이름</th>
								<th>조회수</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="community" items="${list}">
								<tr onclick="location.href='view.do?cm_num=${community.cm_num}'">
									<td>${community.mem_id}</td>
									<td>${community.cm_title}</td>
									<td>${community.cm_content}</td>
									<td>${community.cm_register}</td>
									<td>${community.cm_image}</td>
									<td>${community.cm_readcount}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					<div align="center">${pagingHtml}</div>
				</div>
			</div>
		</div>
		<!-- /.row -->

	</div>
	<!-- /.container-fluid -->

</div>
<!-- /#page-wrapper -->

