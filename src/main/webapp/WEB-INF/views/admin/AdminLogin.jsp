<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>Simple Shopping Mall</title>
<link href="../resources/css/main.css" 
             rel="stylesheet" type="text/css">
<script src="../resources/js/jquery-1.10.2.min.js"></script>
<script src="../resources/js/mainScript.js" charset="utf-8" type="text/javascript"></script>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script src="../resources/js/zipCheck.js"></script>
</head>

<body>
   <%--  <c:import url="AdminTop.jsp"/> --%>
	<form name="loginForm" method="post" action="/adloginProc">
	<table  class="tableclass1">
	  <tr>
	    <td style="background-color: #F1F8E0;">
	           <!-- inner -->
	           <table >
	               <thead>
					   <tr><th class="theadstyle">로그인</th></tr>
					 </thead>
				   	 <tbody>
				   	 <tr>
				   	  <td>
				   	    <table>
				 			<tbody>
				 			<tr>
						      <td class="tbodystyle">ID</td>
							   <td class="tbodystyle"><input type="text" name="admin_id" size=30></td>
							</tr>
							<tr> 
							<td class="tbodystyle"> Password</td>
							<td class="tbodystyle"><input type="password" name="admin_passwd" size=30></td>
							</tr>
							<tr class="theadstyle"> 
							  <td class="tbtnstyle" colspan="2"><button type="submit" id='login'>로그인</button> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
							      <button type="button" onclick="javascript:location.ref='/'"> 취소 </button>
							</td>
							</tr>
				 			</tbody>
						 </table>
				   	  </td>
				   	 </tr>
					  </tbody>
	           </table>
	    </td>
	  </tr>
	</table>
	</form>
	
	
	
 <%--   <c:import url="AdminBottom.jsp"/> --%>
	
</body>
</html>