<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>OWN Bank</title>

    <!-- Bootstrap core CSS -->
    <link href="./login3_files/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="./login3_files/product.css" rel="stylesheet">
</head>

<body>

<div class="position-relative overflow-hidden p-3 p-md-5 " height="600">
    <div class="col-md-5 p-lg-5 mx-auto my-5">
            <div class="text-center mb-4">
                <svg xmlns="http://www.w3.org/2000/svg" width="100" height="100" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="d-block mx-auto"><circle cx="12" cy="12" r="10"></circle><line x1="14.31" y1="8" x2="20.05" y2="17.94"></line><line x1="9.69" y1="8" x2="21.17" y2="8"></line><line x1="7.38" y1="12" x2="13.12" y2="2.06"></line><line x1="9.69" y1="16" x2="3.95" y2="6.06"></line><line x1="14.31" y1="16" x2="2.83" y2="16"></line><line x1="16.62" y1="12" x2="10.88" y2="21.94"></line></svg>
                <h1 class="h3 mb-3 font-weight-normal">WELCOME,<%=session.getAttribute("name") %></h1>
                <p>Your account number: <%=session.getAttribute("acc")%></p>
                <p>Your balance: <%=session.getAttribute("blnc")%></p>
            </div>
    </div>
    <div class="product-device box-shadow d-none d-md-block"></div><br><br><br><br>
    <div class="product-device product-device-2 box-shadow d-none d-md-block"></div>
</div>


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