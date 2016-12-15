<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- Navigation & Logo-->
<div class="mainmenu-wrapper">
	<div class="container">
		<div class="menuextras">
			<div class="extras">
				<div class="dropdown choose-country">
					<ul>
						<c:if test="${empty userId}">
							<li><a href="${pageContext.request.contextPath}/member/login.do">login</a></li>
							<li><a href="${pageContext.request.contextPath}/member/write.do">Sing in</a></li>
						</c:if>
						<c:if test="${!empty userId}">
							<li>${userId}님로그인중</li>
							<li><a href="${pageContext.request.contextPath}/member/detail.do">My page</a></li>
							<li><a href="${pageContext.request.contextPath}/member/receipts.do">My receipts</a></li>
							<li><a href="${pageContext.request.contextPath}/member/point.do">My point</a></li>
							<li><a href="${pageContext.request.contextPath}/member/logout.do">logout</a></li>
						</c:if>
					</ul>
				</div>
			</div>
		</div>
			
		<nav id="mainmenu" class="mainmenu">
			<ul>
				<li class="logo-wrapper">
				<img src="${pageContext.request.contextPath}/upload/logo.jpg" width="180px" height="120px"
					alt="Multipurpose Twitter Bootstrap Template"></li>
				<li class="active"><a href="${pageContext.request.contextPath}/main/main.do">HOME</a></li>
				<li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown">ABOUT</a>
					<div class="dropdown-menu" style="font-size:1.2em; color: #212121; background-color: #f6f6f6;">
						<div class="dropdown-menu-inner">
							<ul>
								<li><a href="${pageContext.request.contextPath}/notice/list.do">NOTICE</a></li>
								<li><a href="${pageContext.request.contextPath}/faq/list.do">FAQ</a></li>
							</ul>
						</div>
					</div></li>
				<li><a href="${pageContext.request.contextPath}/community/list.do">COMMUNITY</a></li>
				<li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown">BRAND</a>
					<div class="dropdown-menu" style="font-size:1.2em; color: #212121; background-color: #f6f6f6;">
					<div class="dropdown-menu-inner">
						<ul>
							<li><a id="nike">NIKE</a></li>
							<li><a id="jordan">JORDAN</a></li>
							<li><a id="adidas">ADIDAS</a></li>
							<li><a id="all">TO ALL</a></li>
						</ul>
					</div>
				</div></li>
				<li><a href="${pageContext.request.contextPath}/item/model.do">SELL</a></li>
		
			</ul>
		</nav>
	</div>
</div>