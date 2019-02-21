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
<link rel="stylesheet"
	href="<spring:url value="/resources/admin/css/pagination.css" />">
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
			<li><button class="btn-primary">Add</button></li>
			<li><button class="btn-primary">Edit</button></li>
			<li><button class="btn-primary">Delete</button></li>
		</ol>
		</section>
		<hr style="border-top: 1px solid blue;">
		<table id="example" class="table table-striped table-bordered"
			style="width: 100%" ng-init="getAllCategories()">
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
					<td align="center" colspan="6">
						<div class="pull-left">
							<table>
								<tr>
									<td><label class="paginationText">{{err}}</label></td>
								</tr>
							</table>
						</div>
						<div class="pull-right">
							<table>
								<tr>
									<td><label class="paginationText">Showing
											{{startNumber}} to {{endNumber}} of {{totalNumber}} &nbsp; </label></td>
									<td>
										<button ng-disabled="btnFirst !== true"
											ng-click="showFirstPage()" type="button" id="btnFirst"
											class="btn btn-block btn-primary btn-xs">
											<i class="fa fa-fast-backward"></i>
										</button>
									</td>
									<td>
										<button ng-disabled="btnPrev !== true"
											ng-click="showPrevPage()" type="button" id="btnPrev"
											class="btn btn-block btn-primary btn-xs">
											<i class="fa fa-step-backward"></i>
										</button>
									</td>
									<td>
										<button ng-disabled="btnNext !== true"
											ng-click="showNextPage()" type="button" id="btnNext"
											class="btn btn-block btn-primary btn-xs">
											<i class="fa fa-step-forward"></i>
										</button>
									</td>
									<td>
										<button ng-disabled="btnLast !== true"
											ng-click="showLastPage()" type="button" id="btnLast"
											class="btn btn-block btn-primary btn-xs">
											<i class="fa fa-fast-forward"></i>
										</button>
									</td>
								</tr>
							</table>
						</div>
					</td>
				</tr>
			</tfoot>
		</table>
	</div>
</body>
</html>