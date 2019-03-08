'use strict';
var admin = angular.module('admin', [ 'ui.bootstrap' ]);
admin.controller('getAllCategoriesController', function($scope, $http) {
	// focus menu category controller
	$scope.totalCount = 0; // Total number of items in all pages. initialize as
	$scope.actionCommand = 'firstPage';

	$scope.getAllCategories = function() {
		var url = 'http://localhost:8080/ebangla/categoryList/?actionCommand='
				+ $scope.actionCommand + '&nameSearch=' + $scope.nameSearch;
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
		$scope.name = "";
		$scope.translatedName = "";
		$scope.sortOrder = 0;
		$scope.visible = true;
		element.modal('show');
		$scope.update = false;
	}
	// select a row to edit
	$scope.selectedRow = null;
	$scope.selectedCategory = null;
	$scope.setClickedRow = function(menuCategory) {
		$scope.selectedCategory = menuCategory;
		$scope.selectedRow = menuCategory.id;
		$scope.name = menuCategory.name;
		$scope.translatedName = menuCategory.translatedName;
		$scope.sortOrder = menuCategory.sortOrder;
		$scope.visible = menuCategory.visible;
	}
	// open edit category dialogue
	$scope.doEdit = function() {
		if ($scope.selectedCategory === null) {
			ErrorToastMSG('Please select a row to edit.');
			return;
		}
		$scope.title = "Edit menu category";
		$scope.update = true;
		element.modal('show');
	}
	// save categories
	$scope.saveCategory = function(isCloseModal) {
		// focus menu category controller
		$scope.isCloseModal = isCloseModal;
		if ($scope.name === "undefined" || $scope.name === ""
				|| $scope.name == null) {
			ErrorToastMSG('Name is required');
			return;
		}
		var url = 'http://localhost:8080/ebangla/saveOrUpdateCategory/?name='
				+ $scope.name + '&translatedName=' + $scope.translatedName
				+ '&sortOrder=' + $scope.sortOrder + '&visible='
				+ $scope.visible + '&update=' + $scope.update + '&id='
				+ $scope.selectedRow;
		$http.post(url).then(function(response) {
			if (response.data.status === "ok") {
				if ($scope.isCloseModal === 'true') {
					element.modal('hide');
				}
				$scope.getAllCategories();
				SuccessToastMSG(response.data.message);
			} else {
				ErrorToastMSG(response.data.message);
			}
		});
	}

	// delete categories
	$scope.doDelete = function() {
		// focus menu category controller
		if ($scope.selectedCategory === null) {
			ErrorToastMSG('Please select a row to delete.');
			return;
		}
		$http({
			method : 'DELETE',
			url : 'http://localhost:8080/ebangla/deleteCategory/',
			data : angular.toJson($scope.selectedCategory),
			headers : {
				'Content-Type' : 'application/json'
			}
		}).then(function(response) {
			if (response.data.status === "ok") {
				$scope.getAllCategories();
				SuccessToastMSG(response.data.message);
				$scope.selectedCategory = null;
			} else {
				ErrorToastMSG(response.data.message);
			}
		});
	}
});
admin.controller('adminController', function($scope, $http, $timeout) {
	// progressbar working ...
	$scope.status = "Working...";
	$scope.progress = 0;
	$scope.labels = [ "Installing start menu items", "Registering components",
			"Having a coffee" ];
	var i = -1;
	function update() {
		$scope.progress += random(0, 10);
		if ($scope.progress > random(70, 90)) {
			$scope.progress = random(5, 50);
			i = (i + 1) % $scope.labels.length;
			$scope.status = $scope.labels[i];
		}
		$timeout(update, 200);
	}
	function random(a, b) {
		return a + Math.floor(Math.random() * (b - a));
	}
	update();
	// create default item angular controller
	// focus menus import export controller
	$scope.createDefaultMenus = function() {
		var url = 'http://localhost:8080/ebangla/createDefaultMenus/';
		$http.post(url).then(function(response) {
			if (response.data.status === "ok") {
				SuccessToastMSG(response.data.message);
				return;
			} else {
				$scope.error = response.data.message;
			}
		});
	}
});