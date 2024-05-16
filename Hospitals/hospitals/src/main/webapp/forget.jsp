<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<style>

* {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
  font-family: "segoe ui", verdana, helvetica, arial, sans-serif;
  font-size: 16px;
  transition: all 500ms ease; }

body {
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-rendering: optimizeLegibility;
  -moz-font-feature-settings: "liga" on; 
  background-color: #E8E3E2}

.row {
  background-color: rgba(20, 120, 200, 0.6);
  color: #fff;
  box-shadow: 0 0 25px blue;
  text-align: center;
  padding: 2em 2em 0.5em;
  width: 50%;
  margin: 150px	auto;
  border-radius: 20px; }
  .row h1 {
    font-size: 2.5em;
    font-style: inherit;
    
  color: #fff;
  text-align: center;
  animation: glow 1s ease-in-out infinite alternate;
}

@-webkit-keyframes glow {
  from {
    text-shadow: 0 0 10px #fff, 0 0 20px #fff, 0 0 30px #e60073, 0 0 40px #e60073, 0 0 50px #e60073, 0 0 60px #e60073, 0 0 70px #e60073;
  }
  
  to {
    text-shadow: 0 0 20px #fff, 0 0 30px #ff4da6, 0 0 40px #ff4da6, 0 0 50px #ff4da6, 0 0 60px #ff4da6, 0 0 70px #ff4da6, 0 0 80px #ff4da6;
  }
} 
  .row .form-group {
    margin: 0.5em 0; }
    .row .form-group label {
      display: block;
      color: #E8E3E2;
      text-align: left;
      font-weight: 600; }
    .row .form-group input, .row .form-group button {
      display: block;
      padding: 0.5em 0;
      width: 100%;
      margin-top: 1em;
      margin-bottom: 0.5em;
      background-color: inherit;
      border: none;
      border-bottom: 1px solid #555;
      color: #eee; }
      .row .form-group input:focus, .row .form-group button:focus {
        background-color: lightgray;
        color: #000;
        border: none;
        padding: 1em 0.5em; animation: pulse 1s infinite ease;}
    .row .form-group button {
      border: 1px solid #fff;
      border-radius: 5px;
      outline: none;
      -moz-user-select: none;
      user-select: none;
      color: white;
      font-weight: 800;
      cursor: pointer;
      margin-top: 2em;
      padding: 1em; }
      .row .form-group button:hover, .row .form-group button:focus {
        background-color:#74B8E8; }
      .row .form-group button.is-loading::after {
        animation: spinner 500ms infinite linear;
        content: "";
        position: absolute;
        margin-left: 2em;
        border: 2px solid #000;
        border-radius: 100%;
        border-right-color: transparent;
        border-left-color: transparent;
        height: 1em;
        width: 4%; }
  .row .footer h5 {
    margin-top: 1em; }
  .row .footer p {
    margin-top: 2em; }
    .row .footer p .symbols {
      color: #444; }
  .row .footer a {
    color: inherit;
    text-decoration: none; }

.information-text {
  color: #ddd; }




</style>
<head>
	<title>Forgot</title>
</head>
<body>
    <form action="forget">
	<div class="row">
		<h1>Forgot Password</h1><br><br>
		<h6 class="information-text"><%if (null != request.getAttribute("error")){
			    	out.println(request.getAttribute("error"));
			    }
		
			    	%></h6>
		<div class="form-group">
			<input type="email" name="email" id="email" required="required">
			<p><label for="username">Email</label></p>
			<input type="password" name="password" id="password" required="required">
			<p><label for="password">Password</label></p>
			<button >Reset Password</button>
		</div>
		<div class="footer">
			<h5>New here? <a href="registration.jsp">Sign Up.</a></h5>
			<h5>Already have an account? <a href="login.jsp">Sign In.</a></h5>
		</div>
	</div>
	</form>
</body>
</html>