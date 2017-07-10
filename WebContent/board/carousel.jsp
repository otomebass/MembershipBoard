<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1" />
<title>Welcome Neverland</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/bootstrap.min.css" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/custom.css" />
</head>

<body>
	<div class="container">

		<div id="myCarousel" class="carousel slide">
			<!-- Indicators -->
			<ol class="carousel-indicators">
				<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
				<li data-target="#myCarousel" data-slide-to="1"></li>
				<li data-target="#myCarousel" data-slide-to="2"></li>
				<li data-target="#myCarousel" data-slide-to="3"></li>
			</ol>
			<!-- Carousel items -->
			<div class="carousel-inner">
				<div class="item active">
					<img src="./images/neverland1.jpg" alt="First slide">
				</div>
				<div class="item">
					<img src="./images/neverland2.jpg" alt="Second slide">
				</div>
				<div class="item">
					<img src="./images/neverland3.jpg" alt="Third slide">
				</div>
				<div class="item">
					<img src="./images/neverland4.jpg" alt="Fourth slide">
				</div>
			</div>
			<!-- Controls -->
			<a class="left carousel-control" href="#myCarousel" data-slide="prev"> <span class="glyphicon glyphicon-chevron-left"></span>
			</a> <a class="right carousel-control" href="#myCarousel" data-slide="next"> <span class="glyphicon glyphicon-chevron-right "></span>
			</a>
		</div>
	</div>

	<script src="<%=request.getContextPath()%>/js/jquery-3.2.1.min.js" type="text/javascript"></script>
	<script src="<%=request.getContextPath()%>/js/bootstrap.min.js" type="text/javascript"></script>
	<script>
		$('.carousel').carousel({
			interval : 2000
		});
	</script>
</body>
</html>