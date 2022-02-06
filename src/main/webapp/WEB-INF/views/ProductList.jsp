<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" 
     uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
<title>Simple Shopping Mall Admin</title>
<link href="./resources/css/main.css" 
             rel="stylesheet" type="text/css">
<script src="./resources/js/jquery-1.10.2.min.js"></script>
<script src="./resources/js/mainScript.js" charset="utf-8" type="text/javascript"></script>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script src="./resources/js/zipCheck.js"></script>
</head>
 <!-- 
  조건에 따라서 idKey가 없으면 로그인 페이지로
  있으면 나오게
  -->
<body>
<div class="tb_wrap">
  <div class ="tb_box">
	 <c:import url="Top.jsp"/>
	<table class="tb">
		<tr> 
			<td  class="tb2">
			  <table>
			   <thead>
				<tr> 
					<th  class="theadstyle"><font color="#FFFFFF">이름</font></th>
					<th  class="theadstyle"><font color="#FFFFFF">가격</font></th>
					<th  class="theadstyle"><font color="#FFFFFF">날짜</font></th>
					<th  class="theadstyle"><font color="#FFFFFF">재고</font></th>
					<th  class="theadstyle">&nbsp;</th>
				</tr>
				</thead>
                 <tbody >
						<c:choose> 
						  <c:when test="${fn:length(pdtoList) >0}">
							<c:forEach var="pdto" items="${pdtoList}">
								<tr > 
									<td class="tbodystyle">${pdto.name}</td>
									<td class="tbodystyle">${pdto.price}</td>
									<td class="tbodystyle">${pdto.pr_date}</td>
									<td class="tbodystyle">${pdto.stock}</td>
									<td class="tbodystyle"><a href="javascript:shopMgrDetail('${pdto.no}')">상세보기</a></td>
								</tr>
							</c:forEach>
						  </c:when>
						  <c:otherwise>
								    <tr >
									   <td class="tb2" colspan="5"> 등록된 상품이 없습니다.</td>
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
	<form name="detail" method="post" action="productDetail?custom=YES" >
	  <input type="hidden" name="no">
	</form>
</body>
</html>
   