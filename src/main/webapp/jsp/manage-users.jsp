<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User management</title>
  
<jsp:include page="links.jsp"></jsp:include> 
</head>
<body>
<!-- ======= Mobile nav toggle button ======= -->
  <i class="bi bi-list mobile-nav-toggle d-xl-none"></i>
  <!-- ======= Header ======= -->
  <header id="header">
    <div class="d-flex flex-column">

      <div class="profile">
        <img src="../img/picture.png" alt="no image" class="img-fluid rounded-circle">
        <h1 class="text-light"><a href="index.html">Pet's care</a></h1>
        <div class="social-links mt-3 text-center">
          <a href="#" class="twitter"><i class="bx bxl-twitter"></i></a>
          <a href="#" class="facebook"><i class="bx bxl-facebook"></i></a>
          <a href="#" class="instagram"><i class="bx bxl-instagram"></i></a>
          <a href="#" class="google-plus"><i class="bx bxl-skype"></i></a>
          <a href="#" class="linkedin"><i class="bx bxl-linkedin"></i></a>
        </div>
      </div>

      <nav id="navbar" class="nav-menu navbar">
        <ul>
          <li><a href="#hero" class="nav-link scrollto active"><i class="bx bx-user"></i> <span>User</span></a></li>
          <li><a href="#about" class="nav-link scrollto"><i class="bx bx-user"></i> <span>About us</span></a></li>
          <li><a href="#portfolio" class="nav-link scrollto"><i class="bx bx-book-content"></i> <span>Mission and Vision</span></a></li>
          <li><a href="#services" class="nav-link scrollto"><i class="bx bx-server"></i> <span>Services</span></a></li>
          <li><a href="#contact" class="nav-link scrollto"><i class="bx bx-envelope"></i> <span>Contact</span></a></li>
          <li>
          <!-- <button type="button" class="btn btn-primary btn-bg" data-toggle="modal" data-target="#exampleModal">
  			log in
		</button> -->
			<a class="btn btn-pimary" id="loginBtn">Log out</a>
          </li>
        </ul>
      </nav><!-- .nav-menu -->
    </div>
  </header><!-- End Header -->

<i class="bi bi-list mobile-nav-toggle d-xl-none"></i>
  <!-- ======= Header ======= -->
  <header id="header">
    <div class="d-flex flex-column">

      <div class="profile">
        <img src="img/picture.png" alt="no image" class="img-fluid rounded-circle">
        <h1 class="text-light"><a href="index.html">Pet's care</a></h1>
        <div class="social-links mt-3 text-center">
          <a href="#" class="twitter"><i class="bx bxl-twitter"></i></a>
          <a href="#" class="facebook"><i class="bx bxl-facebook"></i></a>
          <a href="#" class="instagram"><i class="bx bxl-instagram"></i></a>
          <a href="#" class="google-plus"><i class="bx bxl-skype"></i></a>
          <a href="#" class="linkedin"><i class="bx bxl-linkedin"></i></a>
        </div>
      </div>

      <nav id="navbar" class="nav-menu navbar">
        <ul>
          <li><a href="#hero" class="nav-link scrollto active"><i class="bx bx-home"></i> <span>Home</span></a></li>
          <li><a href="#about" class="nav-link scrollto"><i class="bx bx-user"></i> <span>About us</span></a></li>
          <li><a href="#portfolio" class="nav-link scrollto"><i class="bx bx-book-content"></i> <span>Mission and Vision</span></a></li>
          <li><a href="#services" class="nav-link scrollto"><i class="bx bx-server"></i> <span>Services</span></a></li>
          <li><a href="#contact" class="nav-link scrollto"><i class="bx bx-envelope"></i> <span>Contact</span></a></li>
          <li>
          <!-- <button type="button" class="btn btn-primary btn-bg" data-toggle="modal" data-target="#exampleModal">
  			log in
		</button> -->
			<a class="btn btn-pimary" id="loginBtn">Log in</a>
          </li>
        </ul>
      </nav><!-- .nav-menu -->
    </div>
  </header><!-- End Header --><!-- ======= Hero Section ======= -->
  
  
 <main id="main">
 <br />
 <br />
  <!-- table -->
  <div class="container">
   <h3 class="text-center">User Management</h3>
   <hr>
   <div class="container text-left">

    <a href="<%=request.getContextPath()%>/new"
     class="btn btn-success">Add Employee</a>
   </div>
   <br>
   <table class="table table-bordered">
    <thead>
     <tr>
      <th>Title</th>
      <th>Date Hired</th>
      <th>Description</th>
      <th>Status</th>
      <th>Actions</th>
     </tr>
    </thead>
    <tbody>
     <!--   for (employee employee: employees) {  -->
     <c:forEach var="employee" items="${listemployee}">

      <tr>
       <td><c:out value="${employee.title}" /></td>
       <td><c:out value="${employee.targetdate}" /></td>
       <td><c:out value="${employee.desc}" /></td>
       <td><c:out value="${employee.status}" /></td>

       <td><a href="edit?id=<c:out value='${employee.id}' />">Edit</a>
        &nbsp;&nbsp;&nbsp;&nbsp; <a
        href="delete?id=<c:out value='${employee.id}' />">Delete</a></td>

       <!--  <td><button (click)="updateemployee(employee.id)" class="btn btn-success">Update</button>
                 <button (click)="deleteemployee(employee.id)" class="btn btn-warning">Delete</button></td> -->
      </tr>
     </c:forEach>
     <!-- } -->
    </tbody>

   </table>
  </div>
 </div>
 </main>
 
 
  
  
</body>
</html>