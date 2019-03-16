<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
<style>
table tr th {
	background: #337ab7;
	color: white;
	text-align: left;
	vertical-align: center;
}

.selected {
	background-color: #337ab7;
	color: white;
	font-weight: bold;
}
</style>
</head>
<body>
	<!-- Content Wrapper. Contains page content -->
	<div class="content-wrapper" ng-controller="MenuGroupsController">
		<!-- Content Header (Page header) -->
		<section class="content-header">
		<h4>Menu groups</h4>
		<ol class="breadcrumb">
			<li>
				<div class="input-group input-group-sm">
					<ul class="nav nav-tabs">
						<li><select ng-model="selectedCat" ng-init="getAllMenuGroups()" style="height:34px;">
								<option value="">Search in all categories</option>
								<option ng-repeat="MENU_GROUP in groups.data"
									ng-selected="selectedCat == MENU_GROUP.parent.id"
									value="{{MENU_GROUP.parent.name}}">{{MENU_GROUP.parent.name}}</option>
						</select></li>
						<li><input type="text" class="form-control"
							placeholder="Search:e.g breakfast" ng-model="nameSearch">
						</li>
						<li>
							<button type="button" class="btn btn-info btn-flat"
								ng-click="showSearchResult()">Search</button>
						</li>
					</ul>
				</div>
			</li>
		</ol>
		</section>
		<hr style="border-top: 1px solid blue;">
		<table id="example" class="table table-bordered" style="width: 100%"
			ng-init="getAllMenuGroups()">
			<thead>
				<tr>
					<th>Id</th>
					<th>Name</th>
					<th>Translated name</th>
					<th>Visible</th>
					<th>Sort order</th>
					<th>Menu category</th>
				</tr>
			</thead>
			<tbody>
				<tr ng-repeat="MENU_GROUP in groups.data"
					ng-click="setClickedRow(MENU_GROUP)"
					ng-class="{selected:MENU_GROUP.groupId === selectedRow}">
					<td>{{MENU_GROUP.groupId}}</td>
					<td>{{MENU_GROUP.name }}</td>
					<td>{{MENU_GROUP.translatedName}}</td>
					<td>{{MENU_GROUP.visible}}</td>
					<td>{{MENU_GROUP.sortOrder}}</td>
					<td>{{MENU_GROUP.parent.name}}</td>
				</tr>
			</tbody>
			<tfoot>
				<tr>
					<td align="center" colspan="6">
						<div class="pull-left">
							<table>
								<tr>
									<td>
										<button id="add" ng-click="doAdd()"
											class="btn btn-block btn-primary btn-xs">
											<i class="fa fa-plus-square"></i>
										</button>
									</td>
									<td>
										<button id="edit" ng-click="doEdit()"
											class="btn btn-block btn-primary btn-xs">
											<i class="fa fa-edit"></i>
										</button>
									</td>
									<td>
										<button id="delete" ng-click="doDelete()"
											class="btn btn-block btn-primary btn-xs">
											<i class="fa fa-trash"></i>
										</button>
									</td>
								</tr>
							</table>
						</div>
						<div class="pull-right">
							<table>
								<tr>
									<td><label class="paginationText">{{err}}</label></td>
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
		<!-- /start modal -->
		<div class="modal fade" tabindex="-1" role="dialog" id="category_form">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">×</span>
						</button>
						<h4 class="modal-title">{{title}}</h4>
					</div>
					<div class="modal-body">
						<input style="margin-top: 3px;" type="text" class="form-control"
							placeholder="Enter name" ng-model="name" ng-bind="name">
						<input style="margin-top: 3px;" type="text" class="form-control"
							placeholder="Enter translated name" ng-model="translatedName"
							ng-bind="translatedName"> <input style="margin-top: 3px;"
							type="number" min="0" max="99999" class="form-control"
							placeholder="Enter sort order" ng-model="sortOrder"
							ng-bind="sortOrder">
						<div style="margin-top: 3px;" class="checkbox">
							<label> <input type="checkbox" ng-model="visible"
								ng-bind="visible"> Visible
							</label>
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-primary"
							ng-click="saveCategory('false')">Save</button>
						<button id=type= "button" class="btn btn-primary"
							ng-click="saveCategory('true')">Ok</button>
						<button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>

					</div>
				</div>
				<!-- /.modal-content -->
			</div>
			<!-- /.modal-dialog -->
		</div>
		<!-- /end modal -->
	</div>
</body>
</html>