<%@ page 
	language="java" 
	contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add TodoList</title>
<style>
ul { padding: 0; }
li { list-style:none; }

label {
  float: left;
  text-align: right;
  width: 60px;
}
</style>
</head>
<body>
<jsp:include page="/Header.jsp"/>
<h1>Add My TodoList</h1>
<form action='add.do' method='post'>
<ul>
<li><label for="title">Title</label> 
  <input id="title" 
  type='text' name='title' size="50"></li>
<li><label for="content">Description</label>
  <textarea id="content" 
  name='content' rows="5" cols="40"></textarea></li>
<li><label for="sdate">Start-Date</label>
  <input id="sdate" 
  type='text' name='startDate' placeholder=" ex)2019-01-01"></li>
<li><label for="edate">DeadLine</label>
  <input id="edate" 
  type='text' name='endDate' placeholder="ex)2019-01-01"></li>
<li><label for="tags">More</label>
  <input id="tags" 
  type='text' name='tags' placeholder="ex)tag1, tag2, tag3" size="50"></li>
</ul>
<input type='submit' value='Add'>
<input type='reset' value='Cancel'>
</form>
<jsp:include page="/Tail.jsp"/>
</body>
</html>
