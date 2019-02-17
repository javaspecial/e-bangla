<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
<%-- <link rel="stylesheet"
	href="<spring:url value="/resources/admin/css/dataTables.bootstrap.min.css" />">
<link rel="stylesheet"
	href="<spring:url value="/resources/admin/css/bootstrap.min.css" />">
<script
	src="<spring:url value="https://code.jquery.com/jquery-3.3.1.js" />"></script>
<script
	src="<spring:url value="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js" />"></script>
<script
	src="<spring:url value="https://cdn.datatables.net/1.10.19/js/dataTables.bootstrap.min.js" />"></script>
<script
	src="<spring:url value="http://ajax.googleapis.com/ajax/libs/angularjs/1.6.0/angular.min.js" />"></script>
<script src="<spring:url value="/resources/js/angular.groups.js" />"></script> --%>
<script>
	/* $(function() {
		$('#example').DataTable();
	}); */
</script>
<style>
table tr th {
	background: #337ab7;
	color: white;
	text-align: left;
	vertical-align: center;
}
</style>
</head>
<body>
	<!-- Content Wrapper. Contains page content -->
	<div class="content-wrapper">
		<!-- Content Header (Page header) -->
		<section class="content-header">
		<h1>Menu groups</h1>
		<ol class="breadcrumb">
			<li><button class="btn-primary">Add</button></li>
			<li><button class="btn-primary">Edit</button></li>
			<li><button class="btn-primary">Delete</button></li>
		</ol>
		</section>
		<hr style="border-top: 1px solid blue;">
		<!-- <table id="example" class="table table-striped table-bordered"
			style="width: 100%" ng-app="category"
			ng-controller="getAllCategoriesController"
			ng-init="getAllCategories()">
			<thead>
				<tr>
					<th>Id</th>
					<th>Name</th>
					<th>Translated name</th>
					<th>Visible</th>
					<th>Sort order</th>
					<th>Special</th>
				</tr>
			</thead>
			<tbody>
				<tr ng-repeat="MENU_CATEGORY in categories.data">
					<td>{{MENU_CATEGORY.id}}</td>
					<td>{{MENU_CATEGORY.name }}</td>
					<td>{{MENU_CATEGORY.translatedName}}</td>
					<td>{{MENU_CATEGORY.visible}}</td>
					<td>{{MENU_CATEGORY.sortOrder}}</td>
					<td></td>
				</tr>
			</tbody>
		</table> -->
	</div>
</body>
</html>