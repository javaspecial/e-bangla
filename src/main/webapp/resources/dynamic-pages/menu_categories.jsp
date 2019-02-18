<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
<link rel="stylesheet"
	href="<spring:url value="/resources/admin/css/bootstrap.min.css" />">
<script src="<spring:url value="/resources/js/angular.js"/>"></script>
<script
	src="<spring:url value="/resources/js/ui-bootstrap-tpls-0.13.4.min.js" />"></script>
<script src="<spring:url value="/resources/js/angular.categories.js" />"></script>
<script
	src="<spring:url value="https://code.jquery.com/jquery-3.3.1.js" />"></script>
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
	<div class="content-wrapper" ng-app="category"
			ng-controller="getAllCategoriesController">
		<!-- Content Header (Page header) -->
		<section class="content-header">
		<h1>Menu categories</h1>
		<ol class="breadcrumb">
			<li><button class="btn-primary" ng-click="getAllCategories()">Add</button></li>
			<li><button class="btn-primary">Edit</button></li>
			<li><button class="btn-primary">Delete</button></li>
		</ol>
		</section>
		<hr style="border-top: 1px solid blue;">
		<table id="example" class="table table-striped table-bordered"
			style="width: 100%">
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
			<tfoot>
				<tr>
					<td align="center" colspan="6"><span
						class="form-group pull-left page-size form-inline"> <select
							id="ddlPageSize" class="form-control control-color"
							ng-model="pageSizeSelected" ng-change="changePageSize()">
								<option value="5">5</option>
								<option value="10">10</option>
								<option value="25">25</option>
								<option value="50">50</option>
						</select>
					</span>
						<div class="pull-right">
							<pagination total-items="totalCount" ng-change="pageChanged()"
								items-per-page="pageSizeSelected" direction-links="true"
								ng-model="pageIndex" max-size="maxSize" class="pagination"
								boundary-links="true" rotate="false" num-pages="numPages">
							</pagination>
							<a class="btn btn-primary">Page: {{pageIndex}} / {{numPages}}</a>
						</div></td>
				</tr>
			</tfoot>
		</table>
	</div>
</body>
</html>