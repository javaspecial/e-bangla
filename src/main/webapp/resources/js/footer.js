$(document).ready(function() {
	$(".dropdown").hover(function() {
		$('.dropdown-menu', this).stop(true, true).slideDown("fast");
		$(this).toggleClass('open');
	}, function() {
		$('.dropdown-menu', this).stop(true, true).slideUp("fast");
		$(this).toggleClass('open');
	});
});
// here stars scrolling icon
$(document).ready(function() {
	/*
	 * var defaults = { containerID: 'toTop', // fading element id
	 * containerHoverID: 'toTopHover', // fading element hover id scrollSpeed:
	 * 1200, easingType: 'linear' };
	 */

	$().UItoTop({
		easingType : 'easeOutQuart'
	});

});
// here ends scrolling icon
paypal.minicart.render();
paypal.minicart.cart
		.on(
				'checkout',
				function(evt) {
					var items = this.items(), len = items.length, total = 0, i;
					// Count the number of each item in the cart
					for (i = 0; i < len; i++) {
						total += items[i].get('quantity');
					}

					if (total < 3) {
						alert('The minimum order quantity is 3. Please add more to your shopping cart before checking out');
						evt.preventDefault();
					}
				});
