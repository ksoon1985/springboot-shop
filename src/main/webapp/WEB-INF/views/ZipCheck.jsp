<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>
<title>우편번호검색</title>
<link href="/resources/css/main.css" rel="stylesheet" type="text/css">
<script  type="text/javascript"  src="./resources/js/addrScript.js" charset="utf-8"></></script>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
</head>
<body>
	<div>                   
	<input class="form-control" style="width: 40%; display: inline;" placeholder="우편번호" name="addr1" id="addr1" type="text" readonly="readonly" >
	    <button type="button" class="btn btn-default" onclick="execPostCode();"><i class="fa fa-search"></i> 우편번호 찾기</button>                               
	</div>
	<div >
	    <input class="form-control" style="top: 5px;" placeholder="도로명 주소" name="addr2" id="addr2" type="text" readonly="readonly" />
	</div>
	<div >
	    <input class="form-control" placeholder="상세주소" name="addr3" id="addr3" type="text"  />
	</div>

</body>
</html>