//create default menus
function createDefaultMenus() {
	var ajaxReq = $.ajax({
		type : 'POST',
		url : 'createDefaultMenus',
		data : '',
		cache : false,
		contentType : false,
		processData : false,
		xhr : function() {
			var xhr = $.ajaxSettings.xhr();
			xhr.upload.onprogress = function(event) {
				var perc = (event.loaded / event.total) * 100;
				$('#progress-bar').text(perc + '%');
				$('#progress-bar').css('width', perc + '%');
			};
			return xhr;
		},
		beforeSend : function(xhr) {
			$("#modal-success").modal("show");
			$('#modal-title').text('Operation in progress')
			$('#progress-bar').css('width', '0%');
		}
	});

	ajaxReq.done(function(msg) {
		$('#modal-title').text(msg);
		$('#progress-bar').css('width', '100%');
	});

	ajaxReq.fail(function(jqXHR) {
		$('#modal-title').text(jqXHR.responseText + ' (' + jqXHR.status + ' - ' + jqXHR.statusText + ')').css({
			"background-color" : "red"
		});
		$('#progress-bar').css('width', '0%');
		$('#progress-body').css({
			"background-color" : "red"
		});
	});
};