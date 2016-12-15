<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/admin/js/notice.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/admin/js/faq.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/user/css/main.css">
<div id="page-wrapper">
	<div class="container-fluid">
		<!-- Page Heading -->
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">게시판관리</h1>
				<ol class="breadcrumb">
					<li><i class="fa fa-dashboard"></i> <a
						href="${pageContext.request.contextPath}/admin/main.do">최신
							업데이트 현황</a></li>
					<li class="active"><i class="fa fa-table"></i> 게시판관리</li>
				</ol>
			</div>
		</div>
		<!-- /.row -->
		<div class="row">
			<div class="col-lg-6">
				<h2>FAQ(${faqCount})</h2>
				<input type="button" class="btn btn-primary pull-right" value="글 쓰기"
					onclick="location.href='../faq/write.do'"> <br> <br>
				<div class="table-responsive">
					<table class="table table-bordered table-hover">
						<thead>
							<tr>
								<th>질문</th>
								<th>대답</th>
								<th>작성일</th>
							</tr>
						</thead>
						<tbody id="faqList">
						</tbody>
					</table>
					<div class="pagination-wrapper">
					<ul class="pagination pagination-sm paging_button" id="faq_paging"
						style="cursor: pointer;"></ul>
						</div>
				</div>
			</div>

			<div class="col-lg-6">
				<h2>공지사항(${noticeCount})</h2>
				<input type="button" class="btn btn-primary pull-right" value="글 쓰기"
					onclick="location.href='../notice/write.do'"> <br> <br>
				<div class="table-responsive">
					<table class="table table-bordered table-hover">
						<thead>
							<tr>
								<th>제목</th>
								<th>내용</th>
								<th>작성일</th>
							</tr>
						</thead>
						<tbody id="noticeList">
						</tbody>
					</table>
					<div class="pagination-wrapper">
					<ul class="pagination pagination-sm  paging_button"
						id="notice_paging" style="cursor: pointer;"></ul>
				</div>
				</div>
			</div>
		</div>
		<!-- /.row -->

	</div>
	<!-- /.container-fluid -->

</div>
<!-- /#page-wrapper -->

