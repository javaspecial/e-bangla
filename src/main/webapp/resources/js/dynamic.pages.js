function displayPageById(id) {
	var page = document.getElementById(id);
	var dashboard = document.getElementById('dashboard');
	var menu_categories = document.getElementById('menu_categories');
	var menu_groups = document.getElementById('menu_groups');

	if (page.id === 'dashboard') {
		hide(menu_categories);
		hide(menu_groups);
		show(page);
	} else if (page.id === 'menu_categories') {
		hide(dashboard);
		hide(menu_groups);
		show(page);
	} else if (page.id === 'menu_groups') {
		hide(dashboard);
		hide(menu_categories);
		show(page);
	}
}
function show(page) {
	page.style.display = 'block';
};

function hide(page) {
	page.style.display = 'none';
};