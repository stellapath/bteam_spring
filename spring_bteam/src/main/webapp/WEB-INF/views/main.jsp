<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Main</title>
<!-- css -->
<link rel="stylesheet" href="owlcarousel/owl.carousel.min.css">
<link rel="stylesheet" href="owlcarousel/owl.theme.default.min.css">

<!-- js -->
<script src="owlcarousel/owl.carousel.min.js"></script>
<script>
$(document).ready(function() {
	$(".owl-carousel").owlCarousel({
		items: 1,
		nav: true,
		dotsEach: true,
		loop: true,
		autoplay: true
	});
});
</script>
</head>
<body>
<hr />
<div class="owl-carousel">
	<div><img src="https://c4.wallpaperflare.com/wallpaper/246/739/689/digital-digital-art-artwork-illustration-abstract-hd-wallpaper-preview.jpg" /></div>
	<div><img src="https://p4.wallpaperbetter.com/wallpaper/828/579/667/artistic-neon-huawei-light-purple-hd-wallpaper-preview.jpg" /></div>
</div>
<hr />
</body>
</html>