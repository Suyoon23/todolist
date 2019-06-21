<%@ page 
	language="java" 
	contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Info for Todolist</title>
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
<h1>Info for 'WHAT SHOULD I DO?'</h1>
<form action='update.do' method='post'>
<ul>
<li><label for="no">No</label> 
  <input id="no" 
  type='text' name='no' size="5" value="${todolist.no}"
  readonly></li>
<li><label for="title">Title</label> 
  <input id="title" 
  type='text' name='title' size="50" value="${todolist.title}"></li>
<li><label for="content">Description</label>
  <textarea id="content" 
  name='content' rows="5" cols="40">${todolist.content}</textarea></li>
<li><label for="sdate">Start_Date</label>
  <input id="sdate" 
  type='text' name='startDate' placeholder="ex)2019-01-01"
  value="${todolist.startDate}"></li>
<li><label for="edate">Deadline</label>
  <input id="edate" 
  type='text' name='endDate' placeholder="ex)2019-01-01"
  value="${todolist.endDate}"></li>
<li><label for="state">Status</label>
  <select id="state" name="state">
    <option value="0" ${todolist.state == 0 ? "selected" : ""}>ready</option>
    <option value="1" ${todolist.state == 1 ? "selected" : ""}>proceeding</option>
    <option value="2" ${todolist.state == 2 ? "selected" : ""}>complete</option>
    <option value="3" ${todolist.state == 3 ? "selected" : ""}>cancel</option>
  </select></li>
<li><label for="tags">More</label>
  <input id="tags" 
  type='text' name='tags' placeholder="ex) Tag1, Tag2, Tag3" size="50"
  value="${todolist.tags}"></li>
</ul>
<input type='submit' value='Save'>
<input type='button' value='Cancel' 
  onclick='location.href="delete.do?no=${todolist.no}";'>
<input type='button' value='Cancle' onclick='location.href="list.do"'>
</form>
<jsp:include page="/Tail.jsp"/>
</body>
</html>