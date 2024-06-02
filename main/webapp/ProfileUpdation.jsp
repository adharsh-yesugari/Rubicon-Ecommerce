<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="main.com.tadigital.ecommerce.customer.entity.Customer" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ecommerce</title>
<link rel="stylesheet" href="./CSS/style.css" />
</head>
<body>
    <jsp:include page="nav.jsp" />
	<jsp:include page="header.jsp" />
	<%
	Customer  customer = (Customer) session.getAttribute("CUSTOMERINFORMATION");
	String  customerProfileData = (String) session.getAttribute("CUSTOMERPROFILEDATA");
	String pic = null;
	if(customer != null){
		 pic = customer.getProfilePicture();
	}
	if(customerProfileData !=null){
		 pic = customerProfileData;
	}
	String fname = "";
    String lname = "";
    String email = "";
    if(customer != null){
        fname = customer.getFirstName();
        lname = customer.getLastName();
        email = customer.getEmail();
    }
	%>
	<main class="form-container">
		<div class="sign-up container-profile v">
			<h2 class="bottom">Sign Up</h2>
			<form method="post" action="personal" enctype="multipart/form-data"  autocomplete="off">
				<div class="form-group">
				<%
				if (pic == null) {
				%>
				 <img src="./images/default-user.png" alt="profile"
					height="130" width="100%" /> <%
 				} else {
 					 String  profilePicture = "images/"+pic;
 						%> <img src="<%=profilePicture %>"
						alt="porfile" height="130" width="100%" /> <%
					 }
	 %>
				</div>
				<div class="form-group">
            		<label>Profile Picture</label>
                    <input type="file" name="profilePicture" size="50"/>
                </div>
				<div class="form-group">
					<label>firstName</label> <input type="text" name="fname" value="<%=fname %>" required />
				</div>
				<div class="form-group">
					<label>lastName</label> <input type="text" name="lname" value="<%=lname %>" required />
				</div>
				<div class="form-group">
					<label>Gender</label>
					<div class="gender-input">
						<input type="radio" name="gender" value="male"  />&nbsp;Male&nbsp;
						<input type="radio" name="gender" value="female"  />&nbsp;Female&nbsp;
						<input type="radio" name="gender" value="others"  />&nbsp;Others&nbsp;
					</div>
				</div>
				<div class="form-group">
					<label>Date of Birth</label>
					 <input type="date" id="date-of-birth"
						name="date"/>
				</div>
				<div class="form-button">
					<button type="submit">
						<i class="fas fa-user"></i>Update Details
					</button>
				</div>
				 <%
                 if (request.getAttribute("status") != null) {
                    int status = (int) request.getAttribute("status");
                    if (status == 201) {     %>
                        <p class="valid">
                            <i class="fas fa-check-circle"></i> Successfully Updated
                        </p>     <%
                    } else if (status == 400) {  %>
                        <p class="error">
                            <i class="fas fa-exclamation-circle"></i> Updation Failed
                        </p><%
                    }
                 } %>
			</form>
		</div>
		<div class="sign-in container-profile v">
			<h2 class="bottom">Contact Details</h2>
			<form method="post" action="contact" onsubmit="return contactValidateForm()" autocomplete="off">
				<div class="form-group">
					<label>Email</label> <input type="email" name="email"  value="<%=email %>"required/>
				</div>
				<div class="form-group">
					<label>Mobile Number</label> <input type="text" name="mobile"
						required />
				</div>
				<div class="form-button">
					<button type="submit">
						<i class="fas fa-sign-in-alt"></i> Update Contact Details
					</button>
					<%
					if (response.getStatus() == 202) {
					%>
					<p class="valid">
						<i class="fas fa-check-circle"></i> Successfully Updated
					</p>
					<%
					} else if (response.getStatus() == 402) {
					%>
					<p class="error">
						<i class="fas fa-exclamation-circle"></i>  Updation Failed
					</p>
					<%
					}
					%>
				</div>
			</form>
		</div>
		<div class="sign-in container-profile v">
			<h2 class="bottom">Address details</h2>
			<form method="post" action="address" onsubmit="return addressValidateForm()" autocomplete="off">
				<div class="form-group">
					<label>Address Line1 </label> <input type="text" name="line1" required />
				</div>
				<div class="form-group">
					<label>Address Line2</label> <input type="text" name="line2" required />
				</div>
				<div class="form-group">
					<label>Address Line3</label> <input type="text" name="line3" required />
				</div>
				<div class="form-group">
					<label>City</label> <input type="text" name="city" required />
				</div>
				<div class="form-group">
					<label>State</label> <input type="text" name="state" required />
				</div>
				<div class="form-group">
					<label>Postal Code</label> <input type="text" name="pin"
						required />
				</div>
				<div class="form-button">
					<button type="submit">
						<i class="fas fa-sign-in-alt"></i> Update Address
					</button>
					<%
					if (response.getStatus() == 203) {
					%>
					<p class="valid">
						<i class="fas fa-check-circle"></i> Successfully Updated
					</p>
					<%
					} else if (response.getStatus() == 403) {
					%>
					<p class="error">
						<i class="fas fa-exclamation-circle"></i> Updation Failed
					</p>
					<%
					}
					%>
				</div>
			</form>
		</div>
	</main>
	<jsp:include page="footer.jsp" />
	<script src="https://kit.fontawesome.com/45359be96a.js"
		crossorigin="anonymous"></script>
		<script src="js/script.js"></script>
</body>
</html>