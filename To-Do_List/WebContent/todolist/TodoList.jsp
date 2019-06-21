<%@ page 
	language="java" 
	contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>      
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>listforTodo'</title>
</head>
<body>
<jsp:include page="/Header.jsp"/>
<h1> WHAT'S MY <strong>TO-DO</strong></h1>

<table border="1">
<tr>
  <th>No</th>
  <th>Title</th>
  <th>Start_Date</th>
  <th>End_Date</th>
  <th>Status</th>
  <th></th>
</tr>
<c:forEach var="todolist" items="${todolists}">
<tr> 
  <td>${todolist.no}</td>
  <td><a href='update.do?no=${todolist.no}'>${todolist.title}</a></td>
  <td>${todolist.startDate}</td>
  <td>${todolist.endDate}</td>
  <td>${todolist.state}</td>
  <td><a href='delete.do?no=${todlist.no}'>[REMOVE]</a></td>
</tr>
</c:forEach>
</table>
<p style="text-align:right"><a href='add.do'>ADD 'TO-DO' </a></p><br>
<jsp:include page="/Tail.jsp"/>
</body>


</html>
