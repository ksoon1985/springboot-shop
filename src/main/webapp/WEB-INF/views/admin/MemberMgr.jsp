<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Simple Shopping Mall Admin</title>
<link href="../resources/css/main.css" 
             rel="stylesheet" type="text/css">
<script src="../resources/js/jquery-1.10.2.min.js"></script>
<script src="../resources/js/mainScript.js" charset="utf-8" type="text/javascript"></script>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script src="../resources/js/zipCheck.js"></script>
</head>
<body>
<div class="tb_wrap">
  <div class ="tb_box">
	   <c:import url="Top.jsp"/>

	<table class="tb">
	<tr> 
	<td class="tbodystyle">

		<table class="tb" >
		<thead >
			<tr> 
				<th  class="theadstyle">회원이름</th>
				<th  class="theadstyle">회원아이디 </th>
				<th  class="theadstyle">패스워드 </th>
				<th  class="theadstyle">전화번호 </th> 
				<th  class="theadstyle">이메일 </th>
				<th  class="theadstyle">수정 </th>
			</tr>
		</thead>
		<tbody >
		<c:choose>
		  <c:when test="${memberList!=null}">
			<c:forEach var="mdto" items="${memberList}">
				<tr > 
				<td class="tbodystyle">${mdto.m_name}</td>
				<td class="tbodystyle">${mdto.mem_id}</td>
				<td class="tbodystyle">${mdto.m_phone}</td>
				<td class="tbodystyle">${mdto.m_email}</td>
				<td class="tbodystyle">${mdto.address}</td>
				<td class="tbodystyle"><a href="javascript:Update('${mdto.mem_id}')" >수정하기</a></td>
				</tr>
			</c:forEach>
		  </c:when>
		  <c:otherwise>
				    <tr >
					   <td class="tb2" colspan="6"> 등록된 회원이 없습니다.</td>
					</tr>
		  </c:otherwise>
		</c:choose>
		</tbody>
		</table>
	</td>
	</tr>
	</table>
     <c:import url="Bottom.jsp"/>
  </div>
  </div>
    <form name="update" method="post" action="/memberUpdate">
	  <input type=hidden name="mem_id">
	</form>

</body>
</html>
