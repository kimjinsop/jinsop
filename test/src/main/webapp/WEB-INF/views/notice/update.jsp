<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/user/css/main.css">
<div class="section section-breadcrumbs">
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<h1>Notice Board</h1>
			</div>
		</div>
	</div>
</div>

<div class="section">
	<div class="container">
		<div class="row">
			<div class="col-sm-6 col-sm-offset-3">
				<div class="contact-form-wrapper">
					<form:form action="update.do" commandName="command"
						class="form-forizontal" role="form" id="update_form">
						<div class="form-group">
							<label for="nb_title" class="col-sm-4 control-label"><b>제목</b></label>
							<div class="col-ms-8">
								<form:input class="form-control" path="nb_title" />
							</div>
						</div>
						<div class="form-group">
							<label for="nb_content" class="col-sm-4 control-label"><b>내용</b></label>
							<div class="col-ms-8">
								<form:textarea style="resize:none;" class="form-control"
									rows="10" path="nb_content" />
							</div>
						</div>
						<div class="form-group">
							<div class="col-sm-12">
								<div class=" pull-right">
									<input type="submit" class="btn" value="수정"> 
									<input type="button" class="btn" value="삭제" onclick="location.href='delete.do?nb_num=${command.nb_num}'">
									<input type="button" class="btn" value="취소" onclick="location.href='../admin/boardmng.do'">
								</div>
							</div>
						</div>
					</form:form>
				</div>
			</div>
		</div>
	</div>
</div>
