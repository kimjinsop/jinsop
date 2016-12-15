<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>SB Admin - Bootstrap Admin Template</title>

    <!-- Bootstrap Core CSS -->
    <link href="${pageContext.request.contextPath}/resources/admin/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="${pageContext.request.contextPath}/resources/admin/css/sb-admin.css" rel="stylesheet">

    <!-- Morris Charts CSS -->
    <link href="${pageContext.request.contextPath}/resources/admin/css/plugins/morris.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="${pageContext.request.contextPath}/resources/admin/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
	
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/admin/js/jquery-1.12.4.min.js"></script>
	
</head>

<body>

    <div id="wrapper">

        <!-- 헤더 시작 -->
        <tiles:insertAttribute name="header"/>
        <!-- 헤더 끝 -->

        <div id="page-wrapper">

            <div class="container-fluid">

            <!-- 바디 시작 -->
            <div class="admin-body">
            <tiles:insertAttribute name="body"/>
            </div>
            <!-- 바디 끝 -->

            </div>
            <!-- /.container-fluid -->

        </div>
        <!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper -->

    <!-- jQuery -->
    <script src="${pageContext.request.contextPath}/resources/admin/js/jquery.js"></script>
    

    <!-- Bootstrap Core JavaScript -->
    <script src="${pageContext.request.contextPath}/resources/admin/js/bootstrap.min.js"></script>

    <!-- Morris Charts JavaScript -->
    <script src="${pageContext.request.contextPath}/resources/admin/js/plugins/morris/raphael.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/admin/js/plugins/morris/morris.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/admin/js/plugins/morris/morris-data.js"></script>
	<script src="${pageContext.request.contextPath}/resources/admin/js/jquery-1.12.4.min.js"></script>
</body>

</html>
