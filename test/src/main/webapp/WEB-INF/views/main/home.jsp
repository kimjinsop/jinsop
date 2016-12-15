<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/user/js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/user/js/newList.js"></script>
<!-- Homepage Slider -->
<div class="homepage-slider">
	<div id="sequence">
		<ul class="sequence-canvas" >
			<!-- Slide 1 -->
			<li class="bg4">
			
			
				<!-- Slide Title -->
				<h2 class="title">Security123</h2> <!-- Slide Text -->
				<h3 class="subtitle">Security is the degree of resistance to, or protection from, harm. It applies to any vulnerable and valuable asset, such as a person, dwelling, community, item, nation, or organization. As noted by the Institute for Security and Open Methodologies (ISECOM) in the OSSTMM 3, security provides "a form of protection where a separation is created between the assets and the threat." These separations are generically called "controls," and sometimes include changes to the asset or the threat.</h3><!-- Slide Image --> <img class="slide-img"
				src="${pageContext.request.contextPath}/model/slide5.png" width="200px" height="200px"
				alt="Slide 1" />
			</li>
			<!-- End Slide 1 -->
			<!-- Slide 2 -->
			<li class="bg3">
				<!-- Slide Title -->
				<h2 class="title">Creativity</h2> <!-- Slide Text -->
				<h3 class="subtitle">"Creative engineering" redirects here. For the animatronic and arcade games manufacturer, see Creative Engineering Inc. Creativity is a phenomenon whereby something new and somehow valuable is formed. The created item may be intangible (such as an idea, a scientific theory, a musical composition, or a joke) or a physical object (such as an invention, a literary work, or a painting).</h3> <!-- Slide Image --> <img class="slide-img"
				src="${pageContext.request.contextPath}/model/slide3.png" width="300px" height="300px"
				alt="Slide 2" />
			</li>
			<!-- End Slide 2 -->
			<!-- Slide 3 -->
			<li class="bg1">
				<!-- Slide Title -->
				<h2 class="title">Market value</h2> <!-- Slide Text -->
				<h3 class="subtitle" align="left" margin-left>For values of entire markets, see Market size. For market value of the shares outstanding of a publicly traded company, see Market capitalization. Market value or OMV (Open Market Valuation) is the price at which an asset would trade in a competitive auction setting. Market value is often used interchangeably with open market value, fair value or fair market value, although these terms have distinct definitions in different standards, and may differ in some circumstances.</h3> <!-- Slide Image --> <img class="slide-img"
				src="${pageContext.request.contextPath}/model/slider1.png"
				alt="Slide 3" />
			</li>
			<!-- End Slide 3 -->
		</ul>
		<div class="sequence-pagination-wrapper">
			<ul class="sequence-pagination">
				<li>1</li>
				<li>2</li>
				<li>3</li>
			</ul>
		</div>
	</div>
</div>
<!-- End Homepage Slider -->

<!-- Press Coverage -->
<div class="section">
	<div class="container">

		<h2>NEW ARRIVALS</h2>
		<div class="row" id="newList">
		</div>
		<!-- End Product -->
	</div>
</div>

<!-- Deadline table -->
<div class="section">
	<div class="container">
		<h2>DEADLINE APPROACHING</h2>
			<div class="row" id="deadList">
				
		</div>
	</div>	
</div>
<!-- LOWEST Table -->
<div class="section">
<div class="container">
<!-- 최저입찰가 -->
<h2>RECENT LOWEST ASKS</h2>
		<div class="row" id="lowList">
			
			</div>
	</div>
</div>
