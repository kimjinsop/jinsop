<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/admin/js/vip.main.mng.js"></script>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/user/css/main.css">

<!-- Page Heading -->
<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">
			최신 업데이트 현황 <small>통계 및 도표 자료</small>
		</h1>
		<ol class="breadcrumb">
			<li class="active"><i class="fa fa-dashboard"></i> 최신 업데이트 현황</li>
		</ol>
	</div>
</div>
<!-- /.row -->

<div class="row">
	<div class="col-lg-12">
		<div class="alert alert-info alert-dismissable">
			<button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
			<i class="fa fa-info-circle"></i> <strong>관리자 페이지</strong> 가 아닌 <a href="${pageContext.request.contextPath}/main/main.do" class="alert-link">사용자 홈페이지</a>로 가기
		</div>
	</div>
</div>
<!-- /.row -->

<div class="row">
	<div class="col-lg-3 col-md-6">
		<div class="panel panel-primary">
			<div class="panel-heading">
				<div class="row">
					<div class="col-xs-3">
						<i class="fa fa-comments fa-5x"></i>
					</div>
					<div class="col-xs-9 text-right">
						<div class="huge">${community}</div>
						<div>새로운 커뮤니티 게시글</div>
					</div>
				</div>
			</div>
			<a href="${pageContext.request.contextPath}/admin/boardmng.do">
				<div class="panel-footer">
					<span class="pull-left">목록으로 보기</span> 
					<span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
					<div class="clearfix"></div>
				</div>
			</a>
		</div>
	</div>
	<div class="col-lg-3 col-md-6">
		<div class="panel panel-green">
			<div class="panel-heading">
				<div class="row">
					<div class="col-xs-3">
						<i class="fa fa-tasks fa-5x"></i>
					</div>
					<div class="col-xs-9 text-right">
						<div class="huge">${member}</div>
						<div>새로운 회원</div>
					</div>
				</div>
			</div>
			<a href="${pageContext.request.contextPath}/admin/membermng.do">
				<div class="panel-footer">
					<span class="pull-left">목록으로 보기</span> <span class="pull-right"><i
						class="fa fa-arrow-circle-right"></i></span>
					<div class="clearfix"></div>
				</div>
			</a>
		</div>
	</div>
	<div class="col-lg-3 col-md-6">
		<div class="panel panel-yellow">
			<div class="panel-heading">
				<div class="row">
					<div class="col-xs-3">
						<i class="fa fa-shopping-cart fa-5x"></i>
					</div>
					<div class="col-xs-9 text-right">
						<div class="huge">${sell}</div>
						<div>판매 등록 신청 건수</div>
					</div>
				</div>
			</div>
			<a href="${pageContext.request.contextPath}/admin/selltotalmng.do">
				<div class="panel-footer">
					<span class="pull-left">자세히보기</span> 
					<span class="pull-right"><i	class="fa fa-arrow-circle-right"></i></span>
					<div class="clearfix"></div>
				</div>
			</a>
		</div>
	</div>
	<div class="col-lg-3 col-md-6">
		<div class="panel panel-red">
			<div class="panel-heading">
				<div class="row">
					<div class="col-xs-3">
						<i class="fa fa-support fa-5x"></i>
					</div>
					<div class="col-xs-9 text-right">
						<div class="huge">${buy}</div>
						<div>구매 완료 건수</div>
					</div>
				</div>
			</div>
			<a href="${pageContext.request.contextPath}/admin/buymng.do">
				<div class="panel-footer">
					<span class="pull-left">목록으로 보기</span> 
					<span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
					<div class="clearfix"></div>
				</div>
			</a>
		</div>
	</div>
</div>
<!-- /.row -->

<div class="col-lg-6">
		<div class="panel panel-default">
			<div class="panel-heading">
				<h3 class="panel-title">
					<i class="fa fa-money fa-fw"></i> 구매왕
				</h3>
			</div>
			<div class="panel-body">
				<div class="table-responsive">
					<table class="table table-bordered table-hover table-striped">
						<thead>
							<tr>
								<th>구매자 ID</th>
								<th>총 구매 수량</th>
								<th>총 구매 가격</th>
							</tr>
						</thead>
						<tbody id="vipBuy">							
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
	<div class="col-lg-6">
		<div class="panel panel-default">
			<div class="panel-heading">
				<h3 class="panel-title">
					<i class="fa fa-money fa-fw"></i> 판매왕
				</h3>
			</div>
			<div class="panel-body">
				<div class="table-responsive">
					<table class="table table-bordered table-hover table-striped">
						<thead>
							<tr>
								<th>판매자 ID</th>
								<th>총 판매 수량</th>
								<th>총 판매</th>
							</tr>
						</thead>
						<tbody id="vipSell">
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- /.row -->