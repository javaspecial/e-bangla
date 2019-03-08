
<!DOCTYPE html>
<html>
<head>
<style>
html {
	font-size: 14px;
	font-family: Arial, Helvetica, sans-serif;
}
</style>
<title></title>
<base href="https://demos.telerik.com/kendo-ui/progressbar/angular">
<link rel="stylesheet"
	href="https://kendo.cdn.telerik.com/2019.1.220/styles/kendo.common-material.min.css" />
<link rel="stylesheet"
	href="https://kendo.cdn.telerik.com/2019.1.220/styles/kendo.material.min.css" />
<link rel="stylesheet"
	href="https://kendo.cdn.telerik.com/2019.1.220/styles/kendo.material.mobile.min.css" />

<script src="https://kendo.cdn.telerik.com/2019.1.220/js/jquery.min.js"></script>
<script src="https://kendo.cdn.telerik.com/2019.1.220/js/angular.min.js"></script>
<script
	src="https://kendo.cdn.telerik.com/2019.1.220/js/kendo.all.min.js"></script>


</head>
<body>
	<h4>{{status}}</h4>
	<span kendo-progress-bar="progressBar" k-min="0" k-max="100"
		ng-model="progress" style="width: 100%;"></span>
</body>
</html>
