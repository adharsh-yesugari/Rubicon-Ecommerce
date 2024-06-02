<%@ page import="java.sql.*"%>
<%@ page import="main.com.tadigital.ecommerce.customer.entity.Customer"%>
<%
String name = null;
Customer customer = (Customer) session.getAttribute("CUSTOMERINFORMATION");

String  customerProfileData = (String) session.getAttribute("CUSTOMERPROFILEDATA");
String pic = null;
if(customer != null){
	 pic = customer.getProfilePicture();
}

if(customerProfileData !=null){
	 pic = customerProfileData;
}
String cookieStatus = (String) session.getAttribute("COOKIESTATUS");
if (cookieStatus != null) {
	if (cookieStatus.equals("NOTFOUND")) {
		name = (String) session.getAttribute("USERNAME");
	} else if (cookieStatus.equals("FOUND")) {
		name = (String) session.getAttribute("CUSTOMERNAME");
	}
}
%>
<nav>
	<div>
		<p class="contact-number">Contact Us on +91 40 66217777</p>
	</div>
	<ul>                      <%
	    if (name != null) {   %>
		    <li class="dropdown"><%=name%>
			    <div class="dropdown__content">
				    <a href="ProfileUpdation.jsp">Profile</a>
				    <a href="password">ChangePassword</a>
				    <a href="logout">Logout</a>
			    </div>
		    </li>    <%
		} else {     %>
		    <li class="nav-link">
		        <a href="SignInSignUpForm.jsp"><i class="fa fa-sign-in"></i>Sign Up</a>
		    </li>
		    <li class="nav-link">
		        <a href="SignInSignUpForm.jsp"><i class="fa fa-user"></i>Sign In</a>
		    </li>
		    <li class="nav-link">
		        <a href="#"><i class="fa fa-user"></i>Vendor Sign in</a>
		    </li>   <%
		}           %>
		<li class="nav-link">
		    <a href="#"><i class="fa fa-facebook"></i></a>
		</li>
		<li class="nav-link">
		    <a href="#"><i class="fa fa-google-plus"></i></a>
		</li>
		<li class="nav-link">
		    <a href="#"><i class="fa fa-twitter"></i></a>
		</li>
		<li class="nav-link">
		    <a href="#"><i class="fa fa-envelope"></i></a>
		</li>
		<li class="nav-link">
		    <a href="logout"><i class="fa fa-sign-out" aria-hidden="true"></i>Logout</a>
		</li>
	</ul>
</nav>