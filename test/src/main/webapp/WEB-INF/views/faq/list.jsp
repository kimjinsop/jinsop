<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- Page Title -->
<div class="section section-breadcrumbs">
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<h1>Frequently Asked Questions</h1>
			</div>
		</div>
	</div>
</div>

<div class="section">
	<div class="container">
		<div class="row">
			<div class="col-md-12 faq-wrapper">
				<div class="panel-group" id="accordion2">
					<h2>Frequently Asked Questions</h2>
					<c:forEach var="faq" items="${list}">
					<div class="panel panel-default">
						<div class="panel-heading">
							<a class="accordion-toggle" data-toggle="collapse"
								data-parent="#accordion2" href="#collapse${faq.faq_num}"> ${faq.faq_title} </a>
						</div>
						<div id="collapse${faq.faq_num}" class="accordion-body collapse">
							<div class="accordion-inner">
								<div class="answer">Answer:</div>
								<p style="word-break:break-all; overflow:hidden;">${faq.faq_content}</p>
							</div>
						</div>
					</div>
					</c:forEach>
					<div align="center">${pagingHtml}</div>
				</div>
			</div>
		</div>
	</div>
</div>
