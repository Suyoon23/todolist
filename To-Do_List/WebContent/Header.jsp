<%-- 메뉴 추가 --%>
<%@page import="spms.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>       
<div style="background-color:lightyellow;height:40px;padding: 30px 30px 30px 30px;">
<div style="text-align:center">  <font size ="5"  weight="bold" color ="red"> 
<strong>TO-DO_LIST</strong> </font></div>
<div style ="text-align: right">
<a style="color:gray;" 
  href="<%=request.getContextPath()%>/project/list.do">프로젝트</a>
<a style="color:gray;" 
  href="<%=request.getContextPath()%>/member/list.do">회원</a>  
<c:if test="${empty sessionScope.member or 
              empty sessionScope.member.email}">
<a style="color:gray;" 
  href="<%=request.getContextPath()%>/auth/login.do">로그인</a></div>
</c:if>  
            
<c:if test="${!empty sessionScope.member and 
              !empty sessionScope.member.email}">
${sessionScope.member.name}
(<a style="color:gray;" 
  href="<%=request.getContextPath()%>/auth/logout.do">로그아웃</a>)
</c:if>

</div>