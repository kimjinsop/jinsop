<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/user/css/main.css">
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
				<div class="col-sm-6 col-sm-offset-3">
					<div class="contact-form-wrapper">
						<form:form action="update.do" enctype="multipart/form-data" commandName="command"
							class="form-forizontal" role="form" id="modify_form">
							<div class="form-group">
								<label for="cm_title" class="col-sm-4 control-label"><b>제목</b></label>
								<div class="col-ms-8">
									<form:input class="form-control" path="cm_title" />
								</div>
							</div>
							<div class="form-group">
								<label for="cm_content" class="col-sm-4 control-label"><b>내용</b></label>
								<div class="col-ms-8">
									<form:textarea style="resize:none;" class="form-control" rows="10" path="cm_content" />
								</div>
							</div>
							<div class="form_group">
								<label for="upload">사진 첨부</label>
								<input type="file" name="upload" id="upload">
								<c:if test="${!empty command.cm_image}">
								<br>
								<span>${command.cm_image}</span>
								</c:if>
							</div>
							<div class="form-group">
								<div class="col-sm-12">
									<input type="submit" class="btn pull-right" value="등록">
									<input type="button" value="취소" onclick="location.href='list.do'">
								</div>
							</div>
						</form:form>
				</div>
			</div>
		</div>
	</div>
</div>
