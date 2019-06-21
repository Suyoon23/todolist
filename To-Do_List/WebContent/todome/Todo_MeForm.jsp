<%@ page 
  language="java" 
  contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
  "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Register</title>
</head>
<body>
<jsp:include page="/Header.jsp"/>
<h1>Sign Up</h1>
<form action='add.do' method='post'>
Nick: <input type='text' name='name'><br>
Email: <input type='text' name='email'><br>
PWD: <input type='password' name='password'><br>
<input type='reset' value='취소'>
</form>
<jsp:include page="/Tail.jsp"/>
</body>
</html>
