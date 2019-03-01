'use strict';
var app = angular.module('category', [ 'ui.bootstrap' ]);
app.controller('getAllCategoriesController', function($scope, $http) {
	$scope.totalCount = 0; // Total number of items in all pages. initialize as
	$scope.actionCommand = 'firstPage';

	$scope.getAllCategories = function() {
		var url = 'http://localhost:8080/ebangla/categoryList/?actionCommand=' + $scope.actionCommand + '&nameSearch=' + $scope.nameSearch;
		var config = {
			headers : {
				'Content-Type' : 'application/json;charset=utf-8;'
			}
		}

		$http.get(url, config).then(function(response) {
			if (response.data.status == "ok") {
				$scope.categories = response.data;
				$scope.startNumber = response.data.model.startNumber;
				$scope.endNumber = response.data.model.endNumber;
				$scope.totalNumber = response.data.model.totalNumber;
				$scope.btnFirst = response.data.model.hasPrevious;
				$scope.btnPrev = response.data.model.hasPrevious;
				$scope.btnNext = response.data.model.hasNext;
				$scope.btnLast = response.data.model.hasNext;
			} else if (response.data.status == "err") {
				$scope.err = response.data.message;
			}
		}, function(err) {
		});
	}

	// Loading categories list on first time
	$scope.getAllCategories();

	// This method is calling from first button
	$scope.showFirstPage = function() {
		$scope.actionCommand = 'firstPage';
		$scope.getAllCategories();
	};
	// This method is calling from prev button
	$scope.showPrevPage = function() {
		$scope.actionCommand = 'prevPage';
		$scope.getAllCategories();
	};
	// This method is calling from next button
	$scope.showNextPage = function() {
		$scope.actionCommand = 'nextPage';
		$scope.getAllCategories();
	};
	// This method is calling from last button
	$scope.showLastPage = function() {
		$scope.actionCommand = 'lastPage';
		$scope.getAllCategories();
	};
	// This method is calling from search button
	$scope.showSearchResult = function() {
		$scope.actionCommand = 'searchButton';
		$scope.getAllCategories();
	}
	// open add categories dialog
	var element = angular.element('#category_form');
	$scope.doAdd = function() {
		$scope.title = "Create menu category";
		$scope.error = "";
		$scope.success = "";
		$scope.name = "";
		$scope.translatedName = "";
		$scope.sortOrder = "";
		$scope.visible = "false";
		element.modal('show');
		$scope.update = false;
	}
	// select a row to edit
	$scope.selectRow = function(menuCategory) {
		$scope.id = menuCategory.id;
		$scope.name = menuCategory.name;
		$scope.translatedName = menuCategory.translatedName;
		$scope.sortOrder = menuCategory.sortOrder;
		$scope.visible = menuCategory.visible;
	}
	// open edit category dialogue
	$scope.doEdit = function() {
		$scope.error = "";
		$scope.success = "";
		$scope.title = "Edit menu category";
		$scope.update = true;
		element.modal('show');
	}
	// save categories
	$scope.saveCategory = function() {
		if (typeof $scope.name === "undefined") {
			$scope.success = "";
			$scope.err = "Name is required";
			return;
		}
		if (typeof $scope.translatedName === "undefined") {
			$scope.translatedName = "";
		}
		if (typeof $scope.sortOrder === "undefined") {
			$scope.sortOrder = "0";
		}
		if (typeof $scope.visible === "undefined") {
			$scope.visible = "false";
		}
		var url = 'http://localhost:8080/ebangla/saveCategory/?name=' + $scope.name + '&translatedName=' + $scope.translatedName + '&sortOrder=' + $scope.sortOrder + '&visible=' + $scope.visible+ '&update=' + $scope.update;
		$http.post(url).then(function(response) {
			if (response.data.status === "ok") {
				$scope.error = "";
				$scope.success = response.data.message;
			} else {
				$scope.success = "";
				$scope.error = response.data.message;
			}
		});
	}
	//delete categories
	$scope.doDelete = function() {
		element.modal('show');
	}
});
