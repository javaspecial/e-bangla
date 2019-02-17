function displayPageById(id) {
	var page = document.getElementById(id);
	var dashboard = document.getElementById('dashboard');
	var categories = document.getElementById('menu_categories');
	var groups = document.getElementById('menu_groups');

	if (page.id === 'dashboard') {
		hide(categories);
		hide(groups);
		show(page);
	} else if (page.id === 'menu_categories') {
		hide(dashboard);
		hide(groups);
		show(page);
	} else if (page.id === 'menu_groups') {
		hide(dashboard);
		hide(categories);
		show(groups);
	}
}
function show(page) {
	page.style.display = 'block';
};

function hide(page) {
	page.style.display = 'none';
};