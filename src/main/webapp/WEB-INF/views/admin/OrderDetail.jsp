<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn"  uri="http://java.sun.com/jsp/jstl/functions" %>

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
<div class="tb_wrap">
  <div class ="tb_box">		
	<c:import url="Top.jsp"/>
 
	<table class="tb">
	 <tr> 
	   <td  class="tb2">

	 <form method=post name="order" action="/adminOrderProc">
		<table>
		 <tr> 
		  <th class="theadstyle" colspan="2"><font color="#FFFFFF">주문 상세내역</font></th>
		 </tr>
		 <tr> 
			<th class="theadstyle" >고객아이디</th>
			<td class="tbodystyle">${odto.id}</td>
		 </tr>
		 <tr> 
			<th class="theadstyle" >주문번호</th>
			<td class="tbodystyle">${odto.no}</td>
		 </tr>
		 <tr> 
			<th class="theadstyle" >제품번호</th>
			<td class="tbodystyle" align="center">${odto.product_no}</td>
		 </tr>				
		 <tr> 
			<th class="theadstyle" >제품이름</th>
			<td class="tbodystyle" align="center">${odto.pname}</td>
		 </tr>
		 <tr> 
			<th class="theadstyle" >제품가격</th>
			<td class="tbodystyle" align="center">${odto.price}원</td>
		 </tr>
		 <tr> 
			<th class="theadstyle" >주문수량</th>
			<td class="tbodystyle"align="center">${odto.quantity}개</td>
		 </tr>
		 <tr> 
			<th class="theadstyle" >재고수량</th>
			<td class="tbodystyle" align="center">${odto.stock}개</td>
		 </tr>		
		 <tr> 
			<th class="theadstyle" >주문날짜</th>
			<td class="tbodystyle" align="center">${odto.or_date}</td>
		 </tr>
		 <tr> 
			<th class="theadstyle" >금액</th>
			<td class="tbodystyle" align="center">${odto.quantity*odto.price}원</td>
		 </tr>
		 <tr> 
			<td class="theadstyle" >주문상태</td>
			<td class="tbodystyle" align="center">
			 <select name="state" id='state'>
				<option value="1">접수중</option>
				<option value="2">접수</option>
				<option value="3">입금확인</option>
				<option value="4">배송준비</option>
				<option value="5">배송중</option>
				<option value="6">완료</option>
			  </select>
			<script>	   
			$(function(){
			   $("#state").val(${odto.state})
			});
	  </script>
			</td>
		</tr>
		<tr> 
		<td class="tbtnstyle" colspan="2" align="center">
		<input type="button"  value="수정" size="3" onclick="javascript:orderUpdate(this.form, 'U')"> / 
		<input type="button" value="삭제" size="3" onclick="javascript:orderUpdate(this.form, 'D')">
		</td>
		</tr>
		</table>
		<input type="hidden" name="no" value="${odto.no}">
		<input type="hidden" name="flag">
		</form>		
			
	   </td>
	  </tr>
	</table>
	 <c:import url="Bottom.jsp"/>
	 </div>
  </div>
</body>
</html>

