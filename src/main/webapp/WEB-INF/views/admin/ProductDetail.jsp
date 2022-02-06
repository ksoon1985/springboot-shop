<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" 
     uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
<head>
<title>Simple Shopping Mall Admin</title>
<link href="../resources/css/main.css"  rel="stylesheet" type="text/css">
<script src="../resources/js/jquery-1.10.2.min.js"></script>
<script src="../resources/js/mainScript.js" charset="utf-8" type="text/javascript"></script>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script src="../resources/js/zipCheck.js"></script>
</head>

<body>
<c:choose>
  <c:when test="${adminDto==null}">
     <c:redirect url="/login"></c:redirect>
  </c:when>
  <c:when test="${adminDto!=null}">
	 <div class="tb_wrap">
	  <div class ="tb_box">
		<c:import url="Top.jsp"/>
		<table class="tb">
		<tr> 
		 <td class="tb2">
	
			<table>
			<tr> 
			<th class="theadstyle" colspan="3"><font color="#FFFFFF">${pdto.name}</font></th>
			</tr>
			<tr> 
			<td class="tbodystyle" width="20%">
		
			<a href="./upload/${pdto.image}"><img src="./upload/${pdto.image}" height="150" width="150"></a>
			  </td>
			  <td class="tbodystyle" width="30%" >
	
				<table>
				<tr>
				<th class="tbodystyle" ><b>상품이름 : </b>${pdto.name}</th>
				</tr>			
				<tr>
				<td class="tbodystyle" ><b>가    격 : </b>${pdto.price}></td>
				</tr>
				<tr>
				<td class="tbodystyle" ><b>입고날짜 : </b>${pdto.pr_date}</td>
				</tr>
				<tr>
				<td class="tbodystyle" ><b>재    고 : </b>${pdto.stock}</td>
				</tr>
				</table>
			
			</td>
			<td class="tbodystyle" width="50%" valign="top"><b>상세설명</b><br><pre>${pdto.detail}</pre></td>
			</tr>
			<tr> 
			<td class="tbtnstyle" colspan="3" align="center">
			<a href="javascript:productUpdate('${pdto.no}','U')">수정하기</a>&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="javascript:productUpdate('${pdto.no}','D')">삭제하기</a>&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="/productMgr">목록으로</a>
			</td>
			</tr>
			</table>
		 </td>
		</tr>
		</table>
	      <c:import url="Bottom.jsp"/>
		</div>
	    </div>
	
	<form name="update" method="post" action="/productUpdate">
	<input type=hidden name=no>
	</form>
  </c:when>
  </c:choose>
</body>
</html>


		