//create default menus
function createDefaultMenus() {
	$.ajax({
		type : 'POST',
		url : 'createDefaultMenus',
		data : '',
		success : function(data) {
			console.log("Success:", data);
			$("#modal-success").modal("show");
			document.getElementById("success").innerHTML = "Default menus are created successfull.";
		},
		error : function(e) {
			console.log("Error:", e);
			$("#modal-danger").modal("show");
			document.getElementById("modal-body").innerHTML = "An unexpected error occurred! Please try agin or you can go to system administrator to resolve it.";
		}
	});
};