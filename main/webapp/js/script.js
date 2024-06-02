function registerValidateForm() {
    let username = document.forms["myForm"]["name"].value;
    let userEmail = document.form["myForm"]["email"].value;
    let password = document.form["myForm"]["password"].value;
    if(username == null || username == "") {
        document.getElementById('user_name').style.visibility = "visible";
        return false;
    }
    if(userEmail == null || userEmail == "") {
        document.getElementById("user_mail").style.visibility = "visible";
        return false;
    }
    if(password == null || password == "") {
        document.getElementById("user_password").style.visibility = "visible";
        return false;
    } else {
        return true;
    }
}

function loginValidateForm() {
    let loginMail = document.forms["loginForm"]["email"].value;
    let loginPassword = document.forms["loginForm"]["password"].value;
    if (loginMail == null || loginMail == "") {
        document.getElementById('login_email').style.visibility = "visible";
        return false;
    }
    if (loginPassword == null || loginPassword == "") {
        document.getElementById('login_password').style.visibility = "visible";
        return false;
    }
    else {
        return true;
    }
}
function passwordValidateForm() {
	let pass = document.forms["passwordForm"]["existingPassword"].value;
	let upass = document.forms["passwordForm"]["updatedPassword"].value;
	let cpass = document.forms["passwordForm"]["upadatedPasswordRetyped"].value;

	if (pass == null || pass == "") {
		document.getElementById('user_password').style.visibility = "visible";
		return false;
	}

	if (upass == null || upass == "") {
		document.getElementById('updated_password').style.visibility = "visible";
		return false;
	}

	if (cpass == null || cpass == "") {
		document.getElementById('confirm_password').style.visibility = "visible";
		return false;
	}
	else {
		return true;
	}
}

function contactValidateForm() {
	let contact = document.forms["contactForm"]["mobile"].value;

	if (contact == null || contact == "") {
		document.getElementById('contact').style.visibility = "visible";
		return false;
	}
	else {
		return true;
	}
}


function addressValidateForm() {
	let address1 = document.forms["addressForm"]["line1"].value;
	let address2 = document.forms["addressForm"]["line2"].value;
	let address3 = document.forms["addressForm"]["line3"].value;
	let city = document.forms["addressForm"]["city"].value;
	let state = document.forms["addressForm"]["state"].value;
	let pincode = document.forms["addressForm"]["pin"].value;

	if (address1 == null || address1 == "") {
		document.getElementById('add1').style.visibility = "visible";
		return false;
	}

	if (address2 == null || address2 == "") {
		document.getElementById('add2').style.visibility = "visible";
		return false;
	}

	if (address3 == null || address3 == "") {
		document.getElementById('add3').style.visibility = "visible";
		return false;
	}

	if (city == null || city == "") {
		document.getElementById('city').style.visibility = "visible";
		return false;
	}

	if (state == null || state == "") {
		document.getElementById('state').style.visibility = "visible";
		return false;
	}

	if (pincode == null || pincode == "") {
		document.getElementById('pincode').style.visibility = "visible";
		return false;
	}

	else {
		return true;
	}
}