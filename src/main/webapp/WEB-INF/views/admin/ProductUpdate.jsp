<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Simple Shopping Mall Admin</title>
<link href="../resources/css/main.css" rel="stylesheet" type="text/css">
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
		<form method="post" action="productMgrProc?flag=update" enctype="multipart/form-data">
		     <table class="tableclass3">
				<thead >
					<tr > 
					<th colspan="2" class="theadstyle" ><font color="#FFFFFF">상품 등록</font></th>
					</tr>
				</thead>
				<tbody style="height: 90%;">
					<tr> 
						<td class="tbodystyle" width="20%" >상품이름</td>
						<td class="tbodystyle"><input type="text" name="name" size="20" value="${pdto.name}"></td>
					</tr>
					<tr> 
						<td class="tbodystyle">상품가격</td>
						<td class="tbodystyle"><input type="text" name="price" size="20"  value="${pdto.price}">원</td>
					</tr>
					<tr> 
						<td class="tbodystyle">상품설명</td>
						<td class="tbodystyle"><textarea rows="10" cols="80" name="detail" >${pdto.detail}</textarea></td>
					</tr>
					<tr> 
						<td class="tbodystyle">상품수량</td>
						<td class="tbodystyle"><input type="text" name="stock" size="10" value="${pdto.stock}">개</td>
					</tr>
					<tr> 
						<td class="tbodystyle">상품이미지</td>
						<td class="tbodystyle"><img src="./upload/${pdto.image}" height="150" width="150"><input type="file" name="image2"  SIZE ="30" style="height: 25PX"></td>
					</tr>
					<tr > 
						<th colspan="2" class="tbtnystyle"> 
						<!-- chk title기입 -->
						<button type="submit" id ="inputCheck">수정하기</button> 
							&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; 
						<button type="reset">다시쓰기 </button>
						</th>
					</tr>
				</tbody>
			</table>
			<input type="hidden" name="no" value="${pdto.no}"/>
		</form>
	
     	</td>
	  </tr>
	</table>

     <c:import url="Bottom.jsp"/>
   </div>
  </div>
</body>
</html>

