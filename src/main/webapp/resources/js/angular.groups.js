//'use strict';
//var app = angular.module('category', []);
//app.controller('getAllCategoriesController', function($scope, $http) {
//	$scope.getAllCategories = function() {
//		var url = 'http://localhost:8080/ebangla/categoryList/';
//		var config = {
//			headers : {
//				'Content-Type' : 'application/json;charset=utf-8;'
//			}
//		}
//		$http.get(url, config).then(function(response) {
//			if (response.data.status == "ok") {
//				$scope.categories = response.data;
//			}
//		}, function(response) {
//			alert('error');
//		});
//	}
//});
// app.controller('postController', function($scope, $http, $location) {
// $scope.submitForm = function(){
// var url = $location.absUrl() + "postcustomer";
//		
// var config = {
// headers : {
// 'Content-Type': 'application/json;charset=utf-8;'
// }
// }
//		
// var data = {
// firstName: $scope.firstname,
// lastName: $scope.lastname
// };
//		
//		
// $http.post(url, data, config).then(function (response) {
// $scope.postResultMessage = "Sucessful!";
// }, function (response) {
// $scope.postResultMessage = "Fail!";
// });
//		
// $scope.firstname = "";
// $scope.lastname = "";
// }
// });
// app.controller('getcustomerController', function($scope, $http, $location) {
//	
// $scope.showCustomer = false;
//	
// $scope.getCustomer = function() {
// var url = $location.absUrl() + "customer/" + $scope.customerId;
// 
// var config = {
// headers : {
// 'Content-Type' : 'application/json;charset=utf-8;'
// }
// }
// 
// $http.get(url, config).then(function(response) {
// 
// if (response.data.status == "Done") {
// $scope.customer = response.data;
// $scope.showCustomer = true;
// 
// } else {
// $scope.getResultMessage = "Customer Data Error!";
// }
// 
// }, function(response) {
// $scope.getResultMessage = "Fail!";
// });
// 
// }
// });
// 
// app.controller('getcustomersbylastnameController', function($scope, $http,
// $location) {
//	
// $scope.showCustomersByLastName = false;
//	
// $scope.getCustomersByLastName = function() {
// var url = $location.absUrl() + "findbylastname";
// 
// var config = {
// headers : { 'Content-Type' : 'application/json;charset=utf-8;' },
//		
// params: { 'lastName' : $scope.customerLastName }
// }
// 
// $http.get(url, config).then(function(response) {
// 
// if (response.data.status == "Done") {
// $scope.allcustomersbylastname = response.data;
// $scope.showCustomersByLastName = true;
// 
// } else {
// $scope.getResultMessage = "Customer Data Error!";
// }
// 
// }, function(response) {
// $scope.getResultMessage = "Fail!";
// });
// 
// }
// });
