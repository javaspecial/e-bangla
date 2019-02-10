//menu category handler
function getAllMenuCategories() {
	$.ajax({
		type : 'GET',
		url : 'menuCategory/categoryList',
		data : '',
		success : function(response) {
			
		},
		error : function(jqXHR) {
			$("#modal-danger").modal("show");
			$('#modal-body').text(jqXHR.responseText + ' (' + jqXHR.status + ' - ' + jqXHR.statusText + ')').css({
				"background-color" : "red"
			});
		}
	});
};