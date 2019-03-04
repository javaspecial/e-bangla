'use strict';
var SuccessToastMSG = function(message) {
	const Toast = Swal.mixin({
		toast : true,
		background : '#DFF2BF',
		position : 'bottom-end',
		showConfirmButton : false,
		timer : 3000
	});

	Toast.fire({
		type : 'success',
		title : '<span style="color:#4F8A10">' + message + '<span>'
	});
};

var ErrorToastMSG = function(message) {
	const Toast = Swal.mixin({
		toast : true,
		background : '#FFD2D2',
		position : 'bottom-end',
		showConfirmButton : false,
		timer : 3000
	});

	Toast.fire({
		type : 'error',
		title : '<span style="color:#D8000C">' + message + '<span>'
	});
};