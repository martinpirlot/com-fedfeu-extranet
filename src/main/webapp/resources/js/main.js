$(document).ready(
		function() {
			$.each($('#listMenu').find('li'), function() {
				$(this).toggleClass(
						'active',
						window.location.pathname.indexOf($(this).find('a')
								.attr('href')) > -1);
				console.log(window.location.pathname);
			});
			
			$('#datatable').dataTable();
		    $("[data-toggle=tooltip]").tooltip();
		});