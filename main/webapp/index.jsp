<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="./CSS/style.css" />
<title>E-Commerce</title>
</head>


<body>
    <%
        session.setAttribute("COOKIESTATUS", "NOTFOUND");
        session.setAttribute("COOKIVALUE", null);
        Cookie[] cookieArray = request.getCookies();
        if (cookieArray != null) {
        	for (Cookie cookie : cookieArray) {
        		String cookieName = cookie.getName();
        		if (cookieName.equals("taEcommerce")) {
        		    String cookieValue = cookie.getValue();
        		    session.setAttribute("COOKIEVALUE", cookieValue);
        		    session.setAttribute("COOKIESTATUS", "FOUND");
        		    response.sendRedirect("login");
        		    break;
        		}
        	}
        }
    %>
    <jsp:include page="nav.jsp" />
    <jsp:include page="header.jsp" />
    <section class="coursel">
    		<div class="coursel-arrows">
    			<i class='bx bx-left-arrow-alt'></i> <i class='bx bx-right-arrow-alt' ></i>
    		</div>
    	</section>
	<section class="products-view">
		<div class="products-section">
			<div class="header">
				<h2>Deals of the Day</h2>
				<button>View All</button>
			</div>
			<div class="products-list">
				<div class="product">
					<div class="image-container">
						<img src="./images/DOD1.jpeg" alt="" />
					</div>
					<div class="product-details">
						<h3 class="title">Men's Footwear</h3>
						<p class="desc">Upto 60 + Extra 10% off</p>
						<button>View</button>
					</div>
				</div>
				<div class="product">
					<div class="image-container">
						<img src="./images/DOD2.jpeg" alt="" />
					</div>
					<div class="product-details">
						<h3 class="title">Addidas, Reebok &amp; Puma..</h3>
						<p class="desc">Upto 50 + Extra 5% off</p>
						<button>View</button>
					</div>
				</div>
				<div class="product">
					<div class="image-container">
						<img src="./images/DOD3.jpeg" alt="" />
					</div>
					<div class="product-details">
						<h3 class="title">Laptop Bags</h3>
						<p class="desc">Starting from <i class='bx bx-rupee'></i>249</p>
						<p></p>
						<p></p>
						<p></p>
						<p></p>
						<button>View</button>
					</div>
				</div>
				<div class="product">
					<div class="image-container">
						<img src="./images/DOD4.jpeg" alt="" />
					</div>
					<div class="product-details">
						<h3 class="title">Memory Cards, Hard Disks, SDD..</h3>
						<p class="desc">Extra 5% off</p>
						<p></p>
                        <p></p>
                        <p></p>
                        <p></p>
						<button>View</button>
					</div>
				</div>
				<div class="product">
					<div class="image-container">
						<img src="./images/DOD5.jpeg" alt="" />
					</div>
					<div class="product-details">
						<h3 class="title">Timex, Maxima &amp; Titan..</h3>
						<p class="desc">Under <i class='bx bx-rupee'></i>999 + Extra 7% off</p>
						<button>View</button>
					</div>
				</div>
				<div class="product">
					<div class="image-container">
						<img src="./images/DOD6.jpeg" alt="" />
					</div>
					<div class="product-details">
						<h3 class="title">Skybags, American Tourister..</h3>
						<p class="desc">Under <i class='bx bx-rupee bx-xm'></i>999 + Extra 5% off</p>
						<button>View</button>
					</div>
				</div>
			</div>
		</div>
		<div class="products-section">
			<div class="header">
				<h2>Featured Brands</h2>
				<button>View All</button>
			</div>
			<div class="banners-list">
				<div class="banner1">
					<div class="image-container">
						<img src="./images/b1.jpg" alt="" />
					</div>
				</div>
				<div class="banner1">
					<div class="image-container">
						<img src="./images/b2.jpg" alt="" />
					</div>
				</div>
				<div class="banner1">
					<div class="image-container">
						<img src="./images/b3.jpg" alt="" />
					</div>
				</div>
				<div class="banner1">
					<div class="image-container">
						<img src="./images/b4.jpg" alt="" />
					</div>
				</div>
			</div>
		</div>
		<div class="products-section">
			<div class="header">
				<h2>New Mobile Launches</h2>
				<button>View All</button>
			</div>
			<div class="products-list">
				<div class="product">
					<div class="image-container">
						<img src="./images/m1.jpeg" alt="" />
					</div>
					<div class="product-details">
						<h3 class="title">Redmi Note 6 Pro</h3>
						<p class="desc">12MP+5MP | 20MP+2MP</p>
						<button>View</button>
					</div>
				</div>
				<div class="product">
					<div class="image-container">
						<img src="./images/m2.jpeg" alt="" />
					</div>
					<div class="product-details">
						<h3 class="title">Realme 2</h3>
						<p class="desc">13MP+2MP | 8MP Camera</p>
						<button>View</button>
					</div>
				</div>
				<div class="product">
					<div class="image-container">
						<img src="./images/m3.jpeg" alt="" />
					</div>
					<div class="product-details">
						<h3 class="title">Realme C1</h3>
						<p class="desc">13MP+2MP | 5MP Camera</p>
						<button>View</button>
					</div>
				</div>
				<div class="product">
					<div class="image-container">
						<img src="./images/m4.jpeg" alt="" />
					</div>
					<div class="product-details">
						<h3 class="title">Nokia 6.1 Plus</h3>
						<p class="desc">16MP+5MP | 5MP Camera</p>
						<button>View</button>
					</div>
				</div>
				<div class="product">
					<div class="image-container">
						<img src="./images/m5.jpeg" alt="" />
					</div>
					<div class="product-details">
						<h3 class="title">Lenovo A5</h3>
						<p class="desc">16MP+8MP | 8MP Camera</p>
						<button>View</button>
					</div>
				</div>
				<div class="product">
					<div class="image-container">
						<img src="./images/m6.jpeg" alt="" />
					</div>
					<div class="product-details">
						<h3 class="title">Redmi Note 5 Pro</h3>
						<p class="desc">12MP+5MP | 8MP Camera</p>
						<button>View</button>
					</div>
				</div>
			</div>
		</div>
		<div class="products-section">
			<div class="header">
				<h2>Home Decor Range</h2>
				<button>View All</button>
			</div>
			<div class="products-list">
				<div class="product">
					<div class="image-container">
						<img src="./images/h1.jpeg" alt="" />
					</div>
					<div class="product-details">
						<h3 class="title">Decorative Bottles</h3>
						<p class="desc">From ₹199</p>
						<button>View</button>
					</div>
				</div>
				<div class="product">
					<div class="image-container">
						<img src="./images/h2.jpeg" alt="" />
					</div>
					<div class="product-details">
						<h3 class="title">Wall Clocks</h3>
						<p class="desc">Minimum 50% off</p>
						<button>View</button>
					</div>
				</div>
				<div class="product">
					<div class="image-container">
						<img src="./images/h3.jpeg" alt="" />
					</div>
					<div class="product-details">
						<h3 class="title">FengShui Showpieces</h3>
						<p class="desc">Under ₹999</p>
						<button>View</button>
					</div>
				</div>
				<div class="product">
					<div class="image-container">
						<img src="./images/h4.jpeg" alt="" />
					</div>
					<div class="product-details">
						<h3 class="title">Wall Shelves</h3>
						<p class="desc">Upto 80% off</p>
						<button>View</button>
					</div>
				</div>
				<div class="product">
					<div class="image-container">
						<img src="./images/h5.jpeg" alt="" />
					</div>
					<div class="product-details">
						<h3 class="title">Laser Lights</h3>
						<p class="desc">Upto 60% off</p>
						<button>View</button>
					</div>
				</div>
				<div class="product">
					<div class="image-container">
						<img src="./images/h6.jpeg" alt="" />
					</div>
					<div class="product-details">
						<h3 class="title">Hookahs &amp; Bongs..</h3>
						<p class="desc">Under ₹599</p>
						<button>View</button>
					</div>
				</div>
			</div>
		</div>
		<div class="products-section">
			<div class="header">
				<h2>Fashion Accesories</h2>
				<button>View All</button>
			</div>
			<div class="products-list">
				<div class="product">
					<div class="image-container">
						<img src="./images/a1.jpeg" alt="" />
					</div>
					<div class="product-details">
						<h3 class="title">Ray-Ban, Fastrack &amp; Gucci..</h3>
						<p class="desc">20-60% off</p>
						<button>View</button>
					</div>
				</div>
				<div class="product">
					<div class="image-container">
						<img src="./images/a2.jpeg" alt="" />
					</div>
					<div class="product-details">
						<h3 class="title">Cross, Woodland, Peter England</h3>
						<p class="desc">Top Rated</p>
						<button>View</button>
					</div>
				</div>
				<div class="product">
					<div class="image-container">
						<img src="./images/a3.jpeg" alt="" />
					</div>
					<div class="product-details">
						<h3 class="title">Casio, Maxima&amp; Fastrack..</h3>
						<p class="desc">Upto 50% off</p>
						<button>View</button>
					</div>
				</div>
				<div class="product">
					<div class="image-container">
						<img src="./images/a4.jpeg" alt="" />
					</div>
					<div class="product-details">
						<h3 class="title">Casio, Maxima, Fastrack</h3>
						<p class="desc">10-50% off</p>
						<button>View</button>
					</div>
				</div>
				<div class="product">
					<div class="image-container">
						<img src="./images/a5.jpeg" alt="" />
					</div>
					<div class="product-details">
						<h3 class="title">Titan, Fastrack</h3>
						<p class="desc">20-80% off</p>
						<button>View</button>
					</div>
				</div>
				<div class="product">
					<div class="image-container">
						<img src="./images/a6.jpeg" alt="" />
					</div>
					<div class="product-details">
						<h3 class="title">Fastrack</h3>
						<p class="desc">Under ₹999</p>
						<button>View</button>
					</div>
				</div>
			</div>
		</div>
	</section>
	<jsp:include page="footer.jsp" />
	<script src="https://kit.fontawesome.com/45359be96a.js"
		crossorigin="anonymous"></script>
</body>

</html>