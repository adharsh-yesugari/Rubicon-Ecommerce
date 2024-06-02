<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="./CSS/style.css" />
    <title>E-Commerce</title>
</head>
<body>
    <jsp:include page="nav.jsp" />
    <jsp:include page="header.jsp" />
    <section class="banner">
        <h2>Sign Up / Sign In</h2>
        <ul class="banner-links">
            <li class="banner-link">Home</li>
            <li class="banner-link active">Sign Up or Sign In</li>
        </ul>
    </section>
    <main class="form-container">
        <div class="sign-up container">
            <h2>Sign Up</h2>
            <h3>Not Our Registered Customer Yet?</h3>
            <p>With registration with us new world of fashion, fantastic discounts and much more opens to you! The whole process will not take you more than a minute!</p>
            <p class="faq">If you have any questions , please feel free to contact us, our customer service center is working for you 24/7.</p>
            <form  name ="myForm" method="post" action="registration" onsubmit="return registerValidateForm()" autocomplete="on">
                <div class="form-group">
                    <label>First Name</label>
                    <input type="text" name="name" />
                    <label id="user_name" style="color: red; visibility: hidden;">Please enter first name</label>
                </div>
                <div class="form-group">
                    <label>Email</label>
                    <input  id ="email" type="email" name="email" />
                    <label id="user_email" style="color: red; visibility:hidden;">Enter valid email</label>
                </div>
                <div class="form-group">
                    <label>Password</label>
                    <input id = "password" type="password" name="password" placeholder="@Aa1bcd!" />

                    <label id="user_password" style="color: red; visibility: hidden;">enter valid password</label>
                </div>
                <div class="form-button">
                    <button type="submit">
						<i class="fas fa-user"></i>Register
					</button>
                    <%
					if (response.getStatus() == 201) {
					%>
                        <p class="valid">
                            <i class="fas fa-check-circle"></i> User Registered
                        </p>
                        <%
					} else if (response.getStatus() == 400) {
					%>
                            <p class="error">
                                <i class="fas fa-exclamation-circle"></i> Unsuccessfull Registration,Please Register Again
                            </p>
                            <%
					}
					%>
                </div>
            </form>
        </div>
        <div class="sign-in container">
            <h2>Sign In</h2>
            <p class="faq">If you have any questions , please feel free to contact us, our customer service center is working for you 24/7.</p>

            <form  name = "loginForm" method="post" action="login" onsubmit="return loginValidateForm()" autocomplete="off">
                <div class="form-group">
                    <label>Email</label>
                    <input  type="email" name="email" />
                    <label id="login_email" style="color: red; visibility: hidden;">enter valid email</label>
                </div>
                <div class="form-group">
                    <label>Password</label>
                    <input  type="password" name="password" />

                    <label id="login_password" style="color: red; visibility: hidden;">enter valid password</label>
                </div>
                <div class="form-button">
                    <button type="submit">
						<i class="fas fa-sign-in-alt"></i> Log In
					</button>
                    <div class="checkbox">
                        <input type="checkbox" name="stay" value="yes" /> <label>Stay
							Signed In</label>
                    </div>
                    <%
					if (response.getStatus() == 401) {
					%>
                        <p class="error">
                            <i class="fas fa-exclamation-circle"></i> Invalid Email
                        </p>
                        <%
					}
					%>
                </div>
            </form>
        </div>
    </main>
    <jsp:include page="footer.jsp" />
    <script src="https://kit.fontawesome.com/45359be96a.js" crossorigin="anonymous"></script>
    <script src="js/script.js"></script>
</body>

</html>