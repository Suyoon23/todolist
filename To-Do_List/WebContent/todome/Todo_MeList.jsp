<%@ page 
  language="java" 
  contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>      
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
  "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>가입내역</title>
</head>
<body>
<jsp:include page="/Header.jsp"/>
<h3>WHO I AM</h3>
<c:forEach var="member" items="${members}"> 
${member.no},
<a href='update.do?no=${member.no}'>${member.name}</a>,
${member.email},
${member.createdDate}
<a href='delete.do?no=${member.no}'>[삭제]</a><br>
</c:forEach>
<jsp:include page="/Tail.jsp"/>
</body>
</html>