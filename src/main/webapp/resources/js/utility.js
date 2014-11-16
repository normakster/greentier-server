
function updateStatusBox(obj) {
	obj.off();
	var value = obj.val();

	obj.on('change', function() {
		var crnt = $.trim($(this).val());
		var txtInput = $(this);
		txtInput.removeClass("yellow red");
		if (crnt == value) {
			txtInput.removeClass("yellow red");
		} else if (crnt != value && crnt != "") {
			txtInput.addClass("yellow");
		} else {
			txtInput.addClass("red");
		}
	});
}

function updateFocus(obj) {
	obj.off();
	var value = obj.val();

	obj.on('focus', function() {
		if ($(this).val() == value)
			$(this).val("");
	});
	obj.on('blur', function() {
		if ($(this).val() == "")
			$(this).val(value);
	});
}

function readd(contact) {
	for ( var attb in contact) {
		var value = contact[attb];
		var obj = $('#' + attb);
		obj.val(value);
		updateStatusBox(obj);
	}
}