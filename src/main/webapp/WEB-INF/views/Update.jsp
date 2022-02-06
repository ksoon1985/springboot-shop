<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>Simple Shopping Mall</title>
<link href="./resources/css/main.css" 
             rel="stylesheet" type="text/css">
<script src="./resources/js/jquery-1.10.2.min.js"></script>
<script src="./resources/js/mainScript.js" charset="utf-8" 
          type="text/javascript"></script>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script src="./resources/js/zipCheck.js"></script>
</head>

<body>
    <c:choose>
      <c:when test='${adminDto!=null}'>
        <c:import url="./admin/Top.jsp"/>
      </c:when>
      <c:otherwise>
        <c:import url="Top.jsp"/>
      </c:otherwise>
    </c:choose>
	<form name="regForm" method="post" action="memberUpdateProc?flag=U">
	<table class="tableclass2">
	<thead>
	     <tr> <th colspan=3  class="theadstyle"> 회원가입 </th></tr>
	   </thead>
	<tbody >
		<tr> 
			<td  class="tbodystyle" >아이디</td>
			<td style="width: 60%"  class="tbodystyle">
			<input type="text" name="mem_id" size="30" class="chk" title="아이디"  readonly="readonly" 
			   value="${mdto.mem_id}"> 
			</td>
		</tr>
		<tr> 
			<td  class="tbodystyle">패스워드</td>
			<td  class="tbodystyle">
			 <input type="password"  id= "passwd" name="m_passwd" size="30" class="chk" title="패스워드" placeholder="패스워드를 입력하시오.">
			  <font id="check" size="2" color="red"></font> 
			</td>
		</tr>
		<tr> 
			<td class="tbodystyle">패스워드 확인</td>
			<td class="tbodystyle">
			<input type="password" id= "passwd2" name="m_repasswd" size="30" class="chk" title="패스워드 확인" placeholder="패스워드를  확인하시오."> </td>
		</tr>
		<tr> 
			<td class="tbodystyle">이름</td>
			<td class="tbodystyle"><input type="text" name="m_name" size="30" class="chk" title="이름" value="${mdto.m_name }" readonly="readonly"> </td>
		</tr>
		<tr> 
		<td class="tbodystyle">이메일</td>
			<td class="tbodystyle">
			<input type="text" name="m_email" size="50" class="chk" title="이메일" value="${mdto.m_email}"> </td>
		</tr>
		<tr>  
			<td class="tbodystyle">전화번호</td>
			<td class="tbodystyle">
			<input type="text" name="m_phone" size="40" class="chk" title="전화번호" value="${mdto.m_phone}"> </td>
		</tr>
		
		 <tr>
                <td class="tbodystyle">우편번호</td>
                <td class="tbodystyle">
                <input type="text" name="zipcode" id="sample6_postcode" readonly="readonly" value="${mdto.zipcode}"> 
                <input type="button" onclick="zipCheck()" class="chk" title="우편번호" value="우편번호 찾기">
                </td>
            </tr>
 
            <tr>
                <td class="tbodystyle">주소</td>
                <td class="tbodystyle">
                <input type="text" size="100" name="address" id="sample6_address" 
                      class="chk" title="주소" readonly="readonly" value="${mdto.address}"></td>
            </tr>
            <tr>
                <td class="tbodystyle">주소상세</td>
                <td class="tbodystyle">
                <input type="text" size="100" name="address2" id="sample6_address2" 
                   class="chk" title="상세주소"  value="${mdto.address2}"></td>
            </tr>
		<tr>  
			<td class="tbodystyle">직업</td>
			<td class="tbodystyle">
				<select name="m_job">
					<option value="0" <c:if test="${mdto.m_job==null}">selected</c:if>>선택하세요.</option>
					<option value="회사원" <c:if test='${mdto.m_job=="회사원"}'>selected</c:if>>회사원 </option>
					<option value="연구전문직" <c:if test='${mdto.m_job=="연구전문직"}'>selected</c:if>>연구전문직</option>
					<option value="교수학생" <c:if test='${mdto.m_job=="교수학생"}'>selected</c:if>>교수학생</option>
					<option value="일반자영업" <c:if test='${mdto.m_job=="일반자영업"}'>selected</c:if>>일반자영업</option>
					<option value="공무원" <c:if test='${mdto.m_job=="공무원"}'>selected</c:if>>공무원</option>
					<option value="의료인" <c:if test='${mdto.m_job=="의료인"}'>selected</c:if>>의료인</option>
					<option value="법조인" <c:if test='${mdto.m_job=="법조인"}'>selected</c:if>>법조인</option>
					<option value="종교,언론,에술인" <c:if test='${mdto.m_job=="종교,언론,에술인"}'>selected</c:if>> 종교.언론/예술인</option>
					<option value="농,축,수산,광업인" <c:if test='${mdto.m_job=="농,축,수산,광업인"}'>selected</c:if>>농/축/수산/광업인</option>
					<option value="주부" <c:if test='${mdto.m_job=="주부"}'>selected</c:if>>주부</option>
					<option value="무직" <c:if test='${mdto.m_job=="무직"}'>selected</c:if>>무직</option>
					<option value="기타" <c:if test='${mdto.m_job=="기타"}'>selected</c:if>>기타</option>
				</select>
			</td>
		</tr>
		<tr> 
			<td colspan="3"  class="theadstyle"> 
			<button type="button" id ="inputCheck">정보수정</button> 
			&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; 
			<button type="button" id ="deleteChk">회원탈퇴</button> 
			&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; 
			<button type="reset" onclick="javascript:location.href='/'"> 취소 </button>
			</td>
		</tr>
	</tbody>
	</table>
	</form>
	 <form name ="postF" action="" method="post">
	   <c:choose>
	    <c:when test="${adminDto!=null }">
   	       <input type="hidden" name="mem_id" value="${mdto.mem_id}"/>
   	       <c:set var= "adminDto" value="${adminDto}"/>
	    </c:when>
	    <c:when test="${adminDto==null}">
           <input type="hidden" name="mem_id" 
                     value="${mdto.mem_id}"/>
	    </c:when>
	   </c:choose>
	</form>
	<form name ="postForm" >
	  <input type="hidden" name="cpass">
	  <c:choose>
	    <c:when test="${adminDto!=null }">
        <input type="hidden" name="passwd" 
                   value="${adminDto.m_passwd}">
	    </c:when>
	    <c:when test="${adminDto==null}">
          <input type="hidden" name="passwd" 
                       value="${mdto.m_passwd}">
	    </c:when>
	   </c:choose>
	</form>
    <c:choose>
      <c:when test='${adminDto!=null}'>
        <c:import url="./admin/Bottom.jsp"/>
      </c:when>
      <c:otherwise>
        <c:import url="Bottom.jsp"/>
      </c:otherwise>
    </c:choose>
   
</body>
</html> 

