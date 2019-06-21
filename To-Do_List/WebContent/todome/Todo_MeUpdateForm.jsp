<%@ page 
  language="java" 
  contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
  "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>InfoforRegis</title>
</head>
<body>
<h1>Welcome!</h1>
<form action='update.do' method='post'>
No: <input type='text' name='no' value='${todome.no}' readonly><br>
Nick: <input type='text' name='name' value='${todome.name}'><br>
Email: <input type='text' name='email' value='${todome.email}'><br>
Cre_Date: ${todome.createdDate}<br>
<input type='submit' value='Save'>
<input type='button' value='Delete' 
  onclick='location.href="delete.do?no=${todome.no}";'>
<input type='button' value='Back' onclick='location.href="list.do"'>
</form>
</body>
</html>