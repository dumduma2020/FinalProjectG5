<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Login Here</title>
		<!-- <link rel="stylesheet" href=""> -->
	</head>
	<body>
		<div class="container">
			<div class="card">
				<h2>Login</h2>
				<form action="<%=request.getContextPath()%>/LoginController" method="post">
					<div class="form-group">
						<div class="form-group">
							<input type="text" class="form-control" id="username" placeholder="User Name" name="username" required>
						</div><br>
						<div class="form-group">
							<input type="password" class="form-control" id="password" placeholder="Password" name="password" required>
						</div>
						<span style="color: red"><%=(request.getAttribute("errMessage") == null) ? "" : request.getAttribute("errMessage")%></span><br>
						<button type="submit" class="btn btn-primary">Login</button>
					</div>
				</form>
				<p>Not registered yet? <a href="<%= request.getContextPath()%>/register.jsp" class="nav-link">Sign up</a> </p>
			</div>
		</div>
	</body>
</html>