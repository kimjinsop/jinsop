<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- Navigation -->
<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
	<!-- Brand and toggle get grouped for better mobile display -->
	<div class="navbar-header">
		<button type="button" class="navbar-toggle" data-toggle="collapse"
			data-target=".navbar-ex1-collapse">
			<span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span>
			<span class="icon-bar"></span> <span class="icon-bar"></span>
		</button>
		<a class="navbar-brand"
			href="${pageContext.request.contextPath}/admin/main.do">SHOES KING</a>
	</div>
	<!-- Top Menu Items -->
	<ul class="nav navbar-right top-nav">
		<li class="dropdown"><a href="#" class="dropdown-toggle"
			data-toggle="dropdown"><i class="fa fa-user"></i>관리자<b
				class="caret"></b></a>
			<ul class="dropdown-menu">
			<li><a href="${pageContext.request.contextPath}/member/logout.do"><i class="fa fa-fw fa-power-off"></i>로그아웃</a>
			</ul></li>
	</ul>
	<!-- Sidebar Menu Items - These collapse to the responsive navigation menu on small screens -->
	<div class="collapse navbar-collapse navbar-ex1-collapse">
		<ul class="nav navbar-nav side-nav">
			<li class="active"><a
				href="${pageContext.request.contextPath}/admin/main.do"><i
					class="fa fa-fw fa-dashboard"></i>최신 업데이트 현황</a></li>
			<li><a href="${pageContext.request.contextPath}/admin/membermng.do"><i
					class="fa fa-fw fa-bar-chart-o"></i>회원 관리</a></li>
			<li><a href="${pageContext.request.contextPath}/admin/vipmng.do"><i
				class="fa fa-fw fa-dashboard"></i>우수 회원 목록</a></li>
			<li><a href="${pageContext.request.contextPath}/admin/boardmng.do"><i
					class="fa fa-fw fa-table"></i>게시판 관리</a></li> 
			<li><a href="${pageContext.request.contextPath}/admin/list.do"><i
					class="fa fa-fw fa-edit"></i>커뮤니티 관리</a></li>
			<li><a href="${pageContext.request.contextPath}/admin/selltotalmng.do"><i
							class="fa fa-fw fa-desktop"></i>판매 목록</a></li>
			<li><a href="${pageContext.request.contextPath}/admin/buymng.do"><i
							class="fa fa-fw fa-wrench"></i>구매 목록</a></li>							
		</ul>
	</div>
</nav>