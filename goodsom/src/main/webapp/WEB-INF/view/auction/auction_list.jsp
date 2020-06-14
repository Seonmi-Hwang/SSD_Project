<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
	

<!doctype html>
<html lang="ko">

<head>
<title>Goodsom &mdash; SSD Final Project</title>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link
	href="https://fonts.googleapis.com/css?family=Poppins:400,900|Source+Serif+Pro&display=swap"
	rel="stylesheet">

<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/fonts/icomoon/style.css">

<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/bootstrap.min.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/bootstrap-datepicker.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/jquery.fancybox.min.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/owl.carousel.min.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/owl.theme.default.min.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/fonts/flaticon/font/flaticon.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/aos.css">

<!-- MAIN CSS -->
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/style.css">

</head>

<body data-spy="scroll" data-target=".site-navbar-target"
	data-offset="300">


	<div class="site-wrap" id="home-section">

		<div class="site-mobile-menu site-navbar-target">
			<div class="site-mobile-menu-header">
				<div class="site-mobile-menu-close mt-3">
					<span class="icon-close2 js-menu-toggle"></span>
				</div>
			</div>
			<div class="site-mobile-menu-body"></div>
		</div>



		<header class="site-navbar site-navbar-target" role="banner">

			<div class="container">
				<div class="row align-items-center position-relative">

					<div class="col-3">
						<div class="site-logo">
							<a href="<%=request.getContextPath()%>/home.do" class="font-weight-bold">Goodsom</a>
						</div>
					</div>

					<div class="col-9  text-right">


						<span class="d-inline-block d-lg-none"><a href="#"
							class="text-primary site-menu-toggle js-menu-toggle py-5"><span
								class="icon-menu h3 text-primary"></span></a></span>



						<nav class="site-navigation text-right ml-auto d-none d-lg-block"
							role="navigation">
							<ul class="site-menu main-menu js-clone-nav ml-auto ">
								<li><a href="<%=request.getContextPath()%>/home.do" class="nav-link">Home</a></li>
								<li><a href="<%=request.getContextPath()%>/groupBuy/list.do" class="nav-link">GroupBuy</a></li>
								<li><a href="<%=request.getContextPath()%>/auction/list.do" class="nav-link"">Auction</a></li>
								<li><a href="#">Community</a></li>
								<li><a href="<%=request.getContextPath()%>/mypage/list.do"><img src="<%=request.getContextPath()%>/resources/images/mypage.jpg" alt="Image" 
								width="30px" height="20px" class="img-fluid"> ${userSession.user.nickname}</a></li>
							</ul>
						</nav>
					</div>


				</div>
			</div>

		</header>
		
		<div class="site-section-cover">
			<div class="container">
				<div
					class="row align-items-center text-center justify-content-center">
					<div class="col-lg-6">
						<h1 class="text-white mb-4">Auction</h1>
						<p class="lead">솜솜이들이 갖고 있던 학교 굿즈를 경매하는 공간</p>

					</div>
				</div>
			</div>
		</div>
		
		
		<div class="site-section">
			<div class="container">
			<a class="btn btn-primary py-3 px-5" href="<c:url value='/auction/form.do'></c:url>">경매 등록</a> <br/> <br/>
				<div class="row">
					<c:forEach var="auction" items="${auctionList}" varStatus="status">
						<div class="col-lg-4 col-md-6 mb-4">
							<div class="post-entry-1 h-100">
								<a href="<c:url value='/auction/detail.do'>
											<c:param name="auctionId" value="${auction.auctionId}"/>
										</c:url>">
										<img src="<%=request.getContextPath()%>/resources/images/img_1.jpg" alt="Image" class="img-fluid">
								</a>
								<div class="post-entry-1-contents">
	
									<h2>
										<a  href="<c:url value='/auction/detail.do'>
													<c:param name="auctionId" value="${auction.auctionId}"/>
												</c:url>">${auction.title}</a>
									</h2>
									<span class="meta d-inline-block mb-3">
										~ <fmt:formatDate value="${auction.endDate}" pattern="yyyy-MM-dd" />
									<span class="mx-2">현재 최고 금액</span> 
										<a href="#"><fmt:formatNumber value="${auction.maxPrice}" pattern="#,###원"/></a>
									</span>
									<p>${auction.content}</p>
								</div>
							</div>
						</div>
    				

					</c:forEach>
					<%-- <div class="col-lg-4 col-md-6 mb-4">
						<div class="post-entry-1 h-100">
							<a href="<c:url value='/auction/detail.do'>
										<c:param name="email" value="${member.email}"/>
									</c:url>">
									<img src="<%=request.getContextPath()%>/resources/images/img_1.jpg"
								alt="Image" class="img-fluid">
							</a>
							<div class="post-entry-1-contents">

								<h2>
									<a href="single.html">Lorem ipsum dolor sit amet</a>
								</h2>
								<span class="meta d-inline-block mb-3">July 17, 2019 <span
									class="mx-2">by</span> <a href="#">Admin</a></span>
								<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.
									Dolores eos soluta, dolore harum molestias consectetur.</p>
							</div>
						</div>
					</div>
					<div class="col-lg-4 col-md-6 mb-4">
						<div class="post-entry-1 h-100">
							<a href="single.html"> <img src="<%=request.getContextPath()%>/resources/images/img_2.jpg"
								alt="Image" class="img-fluid">
							</a>
							<div class="post-entry-1-contents">

								<h2>
									<a href="single.html">Lorem ipsum dolor sit amet</a>
								</h2>
								<span class="meta d-inline-block mb-3">July 17, 2019 <span
									class="mx-2">by</span> <a href="#">Admin</a></span>
								<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.
									Dolores eos soluta, dolore harum molestias consectetur.</p>
							</div>
						</div>
					</div>

					<div class="col-lg-4 col-md-6 mb-4">
						<div class="post-entry-1 h-100">
							<a href="single.html"> <img src="<%=request.getContextPath()%>/resources/images/img_3.jpg"
								alt="Image" class="img-fluid">
							</a>
							<div class="post-entry-1-contents">

								<h2>
									<a href="single.html">Lorem ipsum dolor sit amet</a>
								</h2>
								<span class="meta d-inline-block mb-3">July 17, 2019 <span
									class="mx-2">by</span> <a href="#">Admin</a></span>
								<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.
									Dolores eos soluta, dolore harum molestias consectetur.</p>
							</div>
						</div>
					</div>


					<div class="col-lg-4 col-md-6 mb-4">
						<div class="post-entry-1 h-100">
							<a href="single.html"> <img src="<%=request.getContextPath()%>/resources/images/img_1.jpg"
								alt="Image" class="img-fluid">
							</a>
							<div class="post-entry-1-contents">

								<h2>
									<a href="single.html">Lorem ipsum dolor sit amet</a>
								</h2>
								<span class="meta d-inline-block mb-3">July 17, 2019 <span
									class="mx-2">by</span> <a href="#">Admin</a></span>
								<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.
									Dolores eos soluta, dolore harum molestias consectetur.</p>
							</div>
						</div>
					</div>
					<div class="col-lg-4 col-md-6 mb-4">
						<div class="post-entry-1 h-100">
							<a href="single.html"> <img src="<%=request.getContextPath()%>/resources/images/img_2.jpg"
								alt="Image" class="img-fluid">
							</a>
							<div class="post-entry-1-contents">

								<h2>
									<a href="single.html">Lorem ipsum dolor sit amet</a>
								</h2>
								<span class="meta d-inline-block mb-3">July 17, 2019 <span
									class="mx-2">by</span> <a href="#">Admin</a></span>
								<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.
									Dolores eos soluta, dolore harum molestias consectetur.</p>
							</div>
						</div>
					</div>

					<div class="col-lg-4 col-md-6 mb-4">
						<div class="post-entry-1 h-100">
							<a href="single.html"> <img src="<%=request.getContextPath()%>/resources/images/img_3.jpg"
								alt="Image" class="img-fluid">
							</a>
							<div class="post-entry-1-contents">

								<h2>
									<a href="single.html">Lorem ipsum dolor sit amet</a>
								</h2>
								<span class="meta d-inline-block mb-3">July 17, 2019 <span
									class="mx-2">by</span> <a href="#">Admin</a></span>
								<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.
									Dolores eos soluta, dolore harum molestias consectetur.</p>
							</div>
						</div>
					</div>
 --%>

					<div class="col-12 mt-5 text-center">
						<span class="p-3">1</span> <a href="#" class="p-3">2</a> <a
							href="#" class="p-3">3</a> <a href="#" class="p-3">4</a>
					</div>

				</div>
			</div>
		</div>


		<div class="footer site-section bg-white">
			<div class="container">
				<div class="row">
					<div class="col-md-3">
						<div class="site-logo-footer">
							<a href="index.html">Approach</a>
						</div>
					</div>
					<div class="col-md-8 ml-auto">
						<div class="row">
							<div class="col-md-4 ml-auto">
								<ul class="list-unstyled links">
									<li><a href="#">Contact Us</a></li>
									<li><a href="#">hello@mydomain.com</a></li>
									<li><a href="#">+1 829 2293 382</a></li>
									<li><a href="#">Support</a></li>
								</ul>
							</div>
							<div class="col-md-4">
								<ul class="list-unstyled links">
									<li><a href="#">Home</a></li>
									<li><a href="#">Blog</a></li>
									<li><a href="#">Services</a></li>
									<li><a href="#">About Us</a></li>
								</ul>
							</div>
							<div class="col-md-4">
								<ul class="list-unstyled links">
									<li><a href="#">Home</a></li>
									<li><a href="#">Blog</a></li>
									<li><a href="#">Services</a></li>
									<li><a href="#">About Us</a></li>
								</ul>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

		<div class="site-section">
			<div class="container">
				<div class="row mb-4 text-center">
					<div class="col">
						<a href="#"><span class="m-2 icon-facebook"></span></a> <a
							href="#"><span class="m-2 icon-twitter"></span></a> <a href="#"><span
							class="m-2 icon-linkedin"></span></a> <a href="#"><span
							class="m-2 icon-instagram"></span></a> <a href="#"><span
							class="m-2 icon-skype"></span></a>
					</div>
				</div>
				<div class="row mt-5 justify-content-center">
					<div class="col-md-7 text-center">
						<p>
							<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
							Copyright &copy;
							<script>document.write(new Date().getFullYear());</script>
							All rights reserved | This template is made with <i
								class="icon-heart text-danger" aria-hidden="true"></i> by <a
								href="https://colorlib.com" target="_blank">Colorlib</a>
							<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
						</p>
					</div>
				</div>
			</div>
		</div>



	</div>

	<script src="js/jquery-3.3.1.min.js"></script>
	<script src="js/jquery-migrate-3.0.0.js"></script>
	<script src="js/popper.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/owl.carousel.min.js"></script>
	<script src="js/jquery.sticky.js"></script>
	<script src="js/jquery.waypoints.min.js"></script>
	<script src="js/jquery.animateNumber.min.js"></script>
	<script src="js/jquery.fancybox.min.js"></script>
	<script src="js/jquery.stellar.min.js"></script>
	<script src="js/jquery.easing.1.3.js"></script>
	<script src="js/bootstrap-datepicker.min.js"></script>
	<script src="js/isotope.pkgd.min.js"></script>
	<script src="js/aos.js"></script>


	<script src="js/typed.js"></script>
	<script>
            var typed = new Typed('.typed-words', {
            strings: ["Business"," Startups"," Organization", " Company"],
            typeSpeed: 80,
            backSpeed: 80,
            backDelay: 4000,
            startDelay: 1000,
            loop: true,
            showCursor: true
            });
            </script>


	<script src="js/main.js"></script>

</body>

</html>

