<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <c:if test="${msg!=null}">
      <script type="text/javascript">
        var msg = '${msg}';
         alert("정상처리: "+msg);
      </script>
    </c:if>
    <script type="text/javascript">
        var url ='${url}'
        if(url.length==0 || url==null || url=='') url='/';
        document.location.href='${url}';
    </script>
</body>
</html>