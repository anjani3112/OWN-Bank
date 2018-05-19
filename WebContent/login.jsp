<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="file:///W:/Project/login2.html">
    
    <title>OWN Bank</title>

    <!-- Bootstrap core CSS -->
    <link href="./login3_files/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="./login3_files/product.css" rel="stylesheet">
    <link href="./login3_files/floating-labels.css" rel="stylesheet">
    <style type="text/css">
    span{
    color:red;
    }
    </style>
</head>

<body>

<nav class="site-header sticky-top py-1">
    <div class="container d-flex flex-column flex-md-row justify-content-between">
        <a class="py-2" href="index.html">
            <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="d-block mx-auto"><circle cx="12" cy="12" r="10"></circle><line x1="14.31" y1="8" x2="20.05" y2="17.94"></line><line x1="9.69" y1="8" x2="21.17" y2="8"></line><line x1="7.38" y1="12" x2="13.12" y2="2.06"></line><line x1="9.69" y1="16" x2="3.95" y2="6.06"></line><line x1="14.31" y1="16" x2="2.83" y2="16"></line><line x1="16.62" y1="12" x2="10.88" y2="21.94"></line></svg>
        </a>
        <a class="py-2 d-none d-md-inline-block" href="signin">Create an Account</a>
    </div>
</nav>
         <div class="position-relative overflow-hidden p-3 p-md-5 bg-light">
      <div class="col-md-5 p-lg-5 mx-auto my-5">
       <form class="form-signin" action="login" method="post">
      <div class="text-center mb-4">
        <svg xmlns="http://www.w3.org/2000/svg" width="72" height="72" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="d-block mx-auto"><circle cx="12" cy="12" r="10"></circle><line x1="14.31" y1="8" x2="20.05" y2="17.94"></line><line x1="9.69" y1="8" x2="21.17" y2="8"></line><line x1="7.38" y1="12" x2="13.12" y2="2.06"></line><line x1="9.69" y1="16" x2="3.95" y2="6.06"></line><line x1="14.31" y1="16" x2="2.83" y2="16"></line><line x1="16.62" y1="12" x2="10.88" y2="21.94"></line></svg>
        <h1 class="h3 mb-3 font-weight-normal">Login</h1>
        <p>Enter your login details.</p>
      </div>

      <div class="form-label-group">
        <input type="email" id="inputEmail" name="Email" class="form-control" placeholder="Email address" required="" autofocus="">
        <label for="inputEmail">Email address</label>
        <span><%if(request.getAttribute("idm")!=null){%><%=request.getAttribute("idm")%><%}%></span>
      </div>

      <div class="form-label-group">
        <input type="password" id="inputPassword" name="Password" class="form-control" placeholder="Password" required="">
        <label for="inputPassword">Password</label>
        <span><%if(request.getAttribute("passm")!=null){ %><%=request.getAttribute("passm")%><%}%></span>
      </div>
      <span><%if(request.getAttribute("ms")!=null){ %><%=request.getAttribute("ms")%><%}%></span>
      <div class="checkbox mb-3">
        <label>
          <input type="checkbox" value="remember-me"> Remember me
        </label>
      </div>
      <button class="btn btn-lg btn-primary btn-block" type="submit">Log in</button>
         <div>Don't have an account? <a href="signin">Register Here</a><br><a href="setting.html">Forgot Password?</a></div>
      <p class="mt-5 mb-3 text-muted text-center"> Copyright © Own's Bank. All Rights Reserved|Contact Us: +91 90000 00000</p>
    </form>
      </div>
      <div class="product-device box-shadow d-none d-md-block"></div>
      <div class="product-device product-device-2 box-shadow d-none d-md-block"></div>
    </div>
<footer class="container py-5">
    <div class="row">
        <div class="col-12 col-md">
            <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="d-block mb-2"><circle cx="12" cy="12" r="10"></circle><line x1="14.31" y1="8" x2="20.05" y2="17.94"></line><line x1="9.69" y1="8" x2="21.17" y2="8"></line><line x1="7.38" y1="12" x2="13.12" y2="2.06"></line><line x1="9.69" y1="16" x2="3.95" y2="6.06"></line><line x1="14.31" y1="16" x2="2.83" y2="16"></line><line x1="16.62" y1="12" x2="10.88" y2="21.94"></line></svg>
            <small class="d-block mb-3 text-muted">© 2017-2018</small>
        </div>
        <div class="col-6 col-md">
            <h5>Features</h5>
            <ul class="list-unstyled text-small">
                <li><p class="text-muted" href="#">Cool stuff</p></li>
                <li><p class="text-muted" href="#">Random feature</p></li>
                <li><p class="text-muted" href="#">Team feature</p></li>
                <li><p class="text-muted" href="#">Stuff for developers</p></li>
                <li><p class="text-muted" href="#">Another one</p></li>
                <li><p class="text-muted" href="#">Last time</p></li>
            </ul>
        </div>
        <div class="col-6 col-md">
            <h5>Resources</h5>
            <ul class="list-unstyled text-small">
                <li><p class="text-muted" href="#">Resource</p></li>
                <li><p class="text-muted" href="#">Resource name</p></li>
                <li><p class="text-muted" href="#">Another resource</p></li>
                <li><p class="text-muted" href="#">Final resource</p></li>
            </ul>
        </div>
        <div class="col-6 col-md">
            <h5>Resources</h5>
            <ul class="list-unstyled text-small">
                <li><p class="text-muted" href="#">Business</p></li>
                <li><p class="text-muted" href="#">Education</p></li>
                <li><p class="text-muted" href="#">Government</p></li>
                <li><p class="text-muted" href="#">Gaming</p></li>
            </ul>
        </div>
        <div class="col-6 col-md">
            <h5>About</h5>
            <ul class="list-unstyled text-small">
                <li><p class="text-muted" href="#">Team</p></li>
                <li><p class="text-muted" href="#">Locations</p></li>
                <li><p class="text-muted" href="#">Privacy</p></li>
                <li><p class="text-muted" href="#">Terms</p></li>
            </ul>
        </div>
    </div>
</footer>


<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="./login3_files/jquery-3.2.1.slim.min.js.download" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script>window.jQuery || document.write('<script src="scripts/jquery-slim.min.js"><\/script>')</script>
<script src="./login3_files/popper.min.js.download"></script>
<script src="./login3_files/bootstrap.min.js.download"></script>
<script src="./login3_files/holder.min.js.download"></script>
<script>
    Holder.addTheme('thumb', {
        bg: '#55595c',
        fg: '#eceeef',
        text: 'Thumbnail'
    });
</script>

</body></html>