<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
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
	<div class="password-change-container">
		<form action="password" onsubmit="return passwordValidateForm()" method="post">
			<div class="form-group">
				<label>Current Password</label> <input type="password"
					name="existingPassword" />
			</div>
			<div class="form-group">
				<label>New Password</label> <input type="password" name="updatedPassword" />
			</div>
			<div class="form-group">
				<label>Confirm Password</label> <input type="password"
					name="upadatedPasswordRetyped" />
			</div>
			<div class="form-button">
				<button type="submit">Change Password</button>
				<%
					if (response.getStatus() == 201) {
					%>
					<p class="valid">
						<i class="fas fa-check-circle"></i>Password Updated Please Login Again
					</p>
					<%
					} else if (response.getStatus() == 400) {
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

	<jsp:include page="footer.jsp" />
	<script src="https://kit.fontawesome.com/45359be96a.js"
		crossorigin="anonymous"></script>
		<script src="js/script.js"></script>
</body>
</html>













