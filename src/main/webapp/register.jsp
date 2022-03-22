<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>User Register Form</h2>
            <div class="col-md-6 col-md-offset-3">
                <div class="alert alert-success center" role="alert">
                    <p>${NOTIFICATION}</p>
                </div>
  				 <!-- <c:url var="addAction" value="/userRegistration/register" ></c:url> -->
              <form action="<%=request.getContextPath()%>/register" method="post">
                <form action="${addAction}" method="post"> 

                   <!--  <div class="form-group">
                        <label for="uname">User Role :</label> <input type="text" class="form-control" id="user_role" placeholder="User role" name="user_role" required>
                    </div> -->

                    <div class="form-group">
                        <label for="uname">First Name :</label> <input type="text" class="form-control" id="fname" placeholder="First name" name="fname" required>
                    </div>

                    <div class="form-group">
                        <label for="uname">Last Name :</label> <input type="text" class="form-control" id="lname" placeholder="User Name" name="lname" required>
                    </div>

                    <div class="form-group">
                        <label for="uname">Gender :</label> <input type="text" class="form-control" id="gender" placeholder="Password" name="gender" required>
                    </div>
                    
                    <div class="form-group">
                        <label for="uname">Age :</label> <input type="text" class="form-control" id="age" placeholder="First Name" name="age" required>
                    </div>

                    <div class="form-group">
                        <label for="uname">Address :</label> <input type="text" class="form-control" id="address" placeholder="last Name" name="address" required>
                    </div>

                    <div class="form-group">
                        <label for="uname">Email :</label> <input type="text" class="form-control" id="email" placeholder="User Name" name="email" required>
                    </div>

                    <div class="form-group">
                        <label for="uname">User name :</label> <input type="text" class="form-control" id="username" placeholder="Password" name="username" required>
                    </div>
                    
                    <div class="form-group">
                        <label for="uname">Password :</label> <input type="password" class="form-control" id="password" placeholder="Password" name="password" required>
                    </div>

                    <button type="submit" class="btn btn-primary">Submit</button>

                </form>
        </div>
</body>
</html> --%>