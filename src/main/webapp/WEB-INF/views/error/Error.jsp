<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" 
     uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>에러 발생</title>
</head>
<body>
<div style="text-align: center">
    <c:if test="${erMsg!=null or fn:length(erMsg) >0}">
         <c:out value="에러발생: ${erCd}: ${erMsg}"/>;
    </c:if>
    <h3>관리자에게 문의하세요 메롱${erMsg}</h3>
    <a href="/">이전 페이지로 </a>
 </div>
</body>
</html>


