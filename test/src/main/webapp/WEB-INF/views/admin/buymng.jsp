<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
    <link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/user/css/main.css">
        <div id="page-wrapper">
            <div class="container-fluid">
                <!-- Page Heading -->
                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header">
                           구매 완료 목록
                        </h1>
                        <ol class="breadcrumb">
                            <li>
                                <i class="fa fa-dashboard"></i>  <a href="${pageContext.request.contextPath}/admin/main.do">최신 업데이트 현황</a>
                            </li>
                            <li class="active">
                                <i class="fa fa-table"></i> 구매 완료 목록
                            </li>
                        </ol>
                    </div>
                </div>
                <!-- /.row -->
                <div class="row">
                    <div class="col-lg-12">
                        <h2>구매 완료 목록</h2>
                          총 거래량 : ${buyCount}
                        <div class="table-responsive">
                        <c:if test="${buyCount == 0}">
						<div class="align-center">등록된 게시물이 없습니다.</div>
						</c:if>
                            <table class="table table-bordered table-hover">
                                <thead>
                                    <tr>
                                    <th>ID</th>
									<th>브랜드</th>
									<th>가격</th>
									<th>모델명</th>
									<th>사이즈</th>
									<th>구매 일자</th>
                                    </tr>
                                </thead>
                                <c:if test="${buyCount > 0}">
                                <tbody>
                                	<c:forEach var="buy" items="${buyList}">
                                    <tr>
                                        <td>${buy.mem_id}</td>
                                        <td>${buy.it_brand}</td>
                                        <td><fmt:formatNumber value="${buy.it_price}" pattern="#,###"/>원</td>                                        
                                        <td>${buy.it_model}</td>
                                        <td>${buy.it_size}</td>
                                        <td>${buy.buy_register}</td>                                       
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

    