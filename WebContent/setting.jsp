<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>OWN Bank</title>

    <!-- Bootstrap core CSS -->
    <link href="../scripts/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="../scripts/floating-labels.css" rel="stylesheet">
    <style type="text/css">
    span{
    color:red;
    }
    </style>
  </head>

  <body>
    <form class="form-signin" action="setting" method="post">
      <div class="text-center mb-4">
        <svg xmlns="http://www.w3.org/2000/svg" width="72" height="72" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="d-block mx-auto"><circle cx="12" cy="12" r="10"></circle><line x1="14.31" y1="8" x2="20.05" y2="17.94"></line><line x1="9.69" y1="8" x2="21.17" y2="8"></line><line x1="7.38" y1="12" x2="13.12" y2="2.06"></line><line x1="9.69" y1="16" x2="3.95" y2="6.06"></line><line x1="14.31" y1="16" x2="2.83" y2="16"></line><line x1="16.62" y1="12" x2="10.88" y2="21.94"></line></svg>
        <h1 class="h3 mb-3 font-weight-normal">Change PIN</h1>
        <p>Enter Details Below</p>
      </div>
        
        <div class="form-label-group">
        <input type="password" id="inputOPin" name="OldPin" class="form-control" placeholder="Old PIN" required>
        <label for="inputOPin">Old PIN</label>
        <span><%if(request.getAttribute("opm")!=null){ %><%=request.getAttribute("opm")%><%}%></span>
      </div>
      
      <div class="form-label-group">
        <input type="password" id="inputNPin" name="NewPin" class="form-control" placeholder="New 4-Digit PIN" required>
        <label for="inputNPin">New PIN</label>
        <span><%if(request.getAttribute("pm")!=null){ %><%=request.getAttribute("pm")%><%}%></span>
      </div>

      <div class="form-label-group">
        <input type="password" id="inputRePin" name="RePin" class="form-control" placeholder="Re-enter 4-Digit PIN" required>
        <label for="inputRePin">Re-entert PIN</label>
        <span><%if(request.getAttribute("rpm")!=null){ %><%=request.getAttribute("rpm")%><%}%></span>
      </div>
      <button class="btn btn-lg btn-primary btn-block" type="submit">Deposit</button>
      <p class="mt-5 mb-3 text-muted text-center">&copy; 2017-2018</p>
    </form>
  </body>
</html>
