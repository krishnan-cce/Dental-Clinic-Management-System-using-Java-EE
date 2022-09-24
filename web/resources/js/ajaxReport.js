/*$(document).ready(function() {
	initializeReportView();
});*/

function initializeReportView() {
	if($(".pdfreport").length > 0) {
		$(".pdfreport").each(function() {
			var _self = this;
			var $btn = $("<button>");
			$btn.text($(this).text());
			$btn.attr("class", $(this).attr("class"));
			$btn.append($(this).children());
			$btn.attr("id", $(this).attr("id") + "_exporter");
			$btn.on('click', function() {
				if(validateForm()) {
					populateIframe(_self);
				}
				return false;
			});
			$(this).hide();
			$(this).after($btn);
		});
	}
}

function populateIframe(elem) {
	var ifm;
	if($(jq($(elem).attr("id")) + "_viewer").length == 0) {
		$if = $("<iframe>");
		$if.attr("id", $(elem).attr("id") + "_viewer");
		$if.width("96%");
		$if.height("1476px");
		$if.css("border", "0");
		$(elem).parents("form").eq(0).after($if);
	}
	ifm = document.getElementById($(elem).attr("id") + "_viewer");
	var serialStr = $(elem).parents("form").eq(0).serialize();
	serialStr += "&" + encodeURIComponent($(elem).attr("id")) + "=" + encodeURIComponent($(elem).attr("id"));
	ifm.src = $(elem).parents("form").eq(0).attr("action") + "?" + serialStr;
}