'use strict';
var app = angular.module('category', [ 'ui.bootstrap' ]);
app.controller('getAllCategoriesController', function($scope, $http) {
	$scope.maxSize = 5; // Limit number for pagination display number.
	$scope.totalCount = 0; // Total number of items in all pages. initialize as
	$scope.pageIndex = 1; // Current page number. First page is 1.-->
	$scope.pageSizeSelected = 10; // Maximum number of items per page.

	$scope.getAllCategories = function() {
		var url = 'http://localhost:8080/ebangla/categoryList/?pageIndex=' + $scope.pageIndex + '&pageSizeSelected=' + $scope.pageSizeSelected;
		var config = {
			headers : {
				'Content-Type' : 'application/json;charset=utf-8;'
			}
		}

		$http.get(url, config).then(function(response) {
			if (response.data.status == "ok") {
				$scope.categories = response.data;
				$scope.totalCount = response.data.totalCount;
			}
		}, function(err) {
			var error = err;
		});
	}

	// Loading employees list on first time
	$scope.getAllCategories();

	// This method is calling from pagination number
	$scope.pageChanged = function() {
		$scope.getAllCategories();
	};

	// This method is calling from dropDown
	$scope.changePageSize = function() {
		$scope.pageIndex = 1;
		$scope.getAllCategories();
	};
});
