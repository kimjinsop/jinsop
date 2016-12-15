<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/user/css/main.css">
<div id="page-wrapper">
	<div class="container-fluid">
		<!-- Page Heading -->
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">회원관리</h1>
				<ol class="breadcrumb">
					<li><i class="fa fa-dashboard"></i> <a
						href="${pageContext.request.contextPath}/admin/main.do">최신
							업데이트 현황</a></li>
					<li class="active"><i class="fa fa-table"></i> 회원관리</li>
				</ol>
			</div>
		</div>
		<!-- /.row -->
		<div class="row">
			<div class="col-lg-12">
				<h2>회원 목록</h2>
				총 회원수 : ${count}
				<div class="table-responsive">
					<c:if test="${count == 0}">
						<div class="align-center">등록된 게시물이 없습니다.</div>
					</c:if>
					<table class="table table-bordered table-hover">
						<thead>
							<tr>
								<th>ID</th>
								<th>이름</th>
								<th>전화번호</th>
								<th>가입날짜</th>
							</tr>
						</thead>
						<c:if test="${count > 0}">
							<tbody>
								<c:forEach var="member" items="${list}">
									<tr>
										<td>${member.mem_id}</td>
										<td>${member.mem_name}</td>
										<td>${member.mem_cell}</td>
										<td>${member.mem_register}</td>
									</tr>
								</c:forEach>
							</tbody>
						</c:if>
					</table>
				</div>
				<div align="center">${pagingHtml}</div>
			</div>
		</div>
		<!-- /.row -->
	</div>
	<!-- /.container-fluid -->
</div>
<!-- /#page-wrapper -->

