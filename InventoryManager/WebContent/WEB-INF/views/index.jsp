
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Inventory Manager</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
body 
{
font-family: Arial, Helvetica, sans-serif;
/* background-image: linear-gradient(to right, rgba(255,1,1,1), rgba(255,153,1,1)); */
}
form {border: 3px solid #f1f1f1;}

input[type=text], input[type=password] {
  width: 50%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  box-sizing: border-box;
}

button {
  background-image: linear-gradient(to right, rgba(255,0,0,0), rgba(255,153,1,1));
  color: white;
  padding: 12px 20px;
  margin: 8px 0;
  border: none;
  cursor: pointer;
  width: 50%;
  position:relative; left:40px; 
}

button:hover {
  opacity: 0.8;
}

.cancelbtn {
  width: 50%;
  padding: 10px 18px;
  background-color: #f44336;
}

.imgcontainer {
  text-align: center;
  margin: 24px 0 12px 0;
}

img.avatar {
  width: 50%;
  border-radius: 50%;
}

.container {
  padding: 16px;
}

span.psw {
  float: right;
  padding-top: 16px;
}

/* Change styles for span and cancel button on extra small screens */
@media screen and (max-width: 300px) {
  span.psw {
     display: block;
     float: none;
  }
  .cancelbtn {
     width: 100%;
  }
}
</style>
</head>

<body>
<form action="login" method="post">
<center><h2><em><strong>Inventory Manager Login</strong></em></h2></center>
  <div class="imgcontainer">
   <img src="<c:url value="/resources/images/login1.png"/>">
  </div>

  <div class="container">
  <center>
    <label for="uname"><b>Username</b></label>
    <input type="text" placeholder="Enter Username" name="uname" required>

    <label for="psw"><b><br>Password</b></label>
    <input type="password" placeholder="Enter Password" name="psw" required>
        
    <button type="submit">Login</button>
   </center>
  </div>

  
  
  
  </form> 
</body>
</html>
