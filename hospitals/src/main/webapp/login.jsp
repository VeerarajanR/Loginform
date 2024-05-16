<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html>
<head>	
	<title>Hindu_hospitals_Login</title>
</head>
<style>
@import url('https://fonts.googleapis.com/css?family=Montserrat:400,800');
* {
	box-sizing: border-box;
}

body {
	background: #f3e0e2;
	display: flex;
	justify-content: center;
	align-items: center;
	flex-direction: column;
	font-family: 'Montserrat', sans-serif;
	height: 100vh;
	margin: -20px 0 50px;
}

h1 {
	font-weight: bold;
	margin: 0;
}

p {
	font-size: 14px;
	font-weight: 100;
	line-height: 20px;
	letter-spacing: 0.5px;
	margin: 20px 0 30px;
}


a {
	color: #333;
	font-size: 14px;
	text-decoration: none;
	margin: 15px 0;
}

a:hover{
color: green;

}

button {
	border-bottom-left-radius:10px;
	border-top-right-radius : 10px;
	border: 1px solid orange;
	background-color: #FF4B2B;
	color: #FFFFFF;
	font-size: 12px;
	font-weight: bold;
	padding: 12px 45px;
	letter-spacing: 1px;
	text-transform: uppercase;
	transition: transform 80ms ease-in;
}

form {
	background-color: #FFFFFF;
	display: flex;
	align-items: center;
	justify-content: center;
	flex-direction: column;
	padding: 0 50px;
	height: 100%;
	text-align: center;
	
	
}

input {
	background-color: #eee;
	border: none;
	padding: 12px 15px;
	margin: 8px 0;
	width: 100%;
	border-radius: 15px;
	
}

.container {
	background-color: #fff;
	border-radius: 10px;
  	box-shadow: 0 14px 28px rgba(0,0,0,0.25), 0 10px 10px rgba(0,0,0,0.22);
	position: relative;
	overflow: hidden;
	width: 768px;
	max-width: 100%;
	min-height: 480px;
}

.form-container {
	position: absolute;
	top: 0;
	height: 100%;
}

.log-in-container {
	left: 0;
	width: 50%;
	z-index: 2;
}


.overlay-container {
	position: absolute;
	top: 0;
	left: 50%;
	width: 50%;
	height: 100%;
}


.overlay {
	background: #FF416C;
	background: -webkit-linear-gradient(to right, #FF4B2B, #FF416C);
	background: linear-gradient(to right, #FF4B2B, #FF416C);
	background-repeat: no-repeat;
	background-size: cover;
	background-position: 0 0;
	color: #FFFFFF;
	position: relative;
	left: -100%;
	height: 100%;
	width: 200%;
}

.overlay-panel {
	position: absolute;
	display: flex;
	align-items: center;
	justify-content: center;
	flex-direction: column;
	padding: 0 40px;
	text-align: center;
	top: 0;
	height: 100%;
	width: 50%;
}

img{
background-size: 10px 50px;
}
.overlay-right {
	right: 0;
}





</style>
<body>

	<div class="container" id="container">
		<div class="form-container log-in-container">
			<form action="check">
			<div class = "logo">
			<img src=""> </div>
			    <h1 style="position: absolute; margin-top: -200px;">Login</h1>
			    <h6 style="position: absolute; margin-top: -100px;color: #DE3342;"><%if (null != request.getAttribute("error")){
			    	out.println(request.getAttribute("error"));
			    }
			    	%> </h6>
				
				
				<input type="text" placeholder="Email" name="email"/>
				<input type="password" placeholder="Password" name= "password"/>
				<a style="position: absolute; margin-top: 170px; margin-left: 100px;" href="forget.jsp">Forgot your password?</a>
				<button style="position: absolute; margin-top: 250px; ">Log In</button>
				<p style="position: absolute; margin-top: 390px; margin-left: 10px;">Don't have an account? <a href="registration.jsp">Sign up</a>.</p>
			</form>
		</div>
		<div class="overlay-container">
			<div class="overlay">
				<div class="overlay-panel overlay-right">
				    <p style="position: absolute; margin-top: -120px;">"Your life is in safe hands"</p><br>
					<h1>Hindu Hospitals</h1>
					<p>"The best doctors on the planet"</p>
				</div>
			</div>
		</div>
	</div>
</body>
</html>