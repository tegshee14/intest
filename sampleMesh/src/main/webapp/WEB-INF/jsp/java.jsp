<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<form enctype="multipart/form-data">
<input type="text" data-field="name" data-value="bobo">
<input type="checkbox" >
<input type="button" >
<input type="file" >
</form>
<ul data-record="1">
  <li data-field="name" data-value="hika">hika</li>
  <li data-field="gender" data-value="male">male</li>
  <li data-field="job" data-value="player">player</li>
</ul>
<ul data-record="2">
  <li data-field="name" data-value="bobo">bobo</li>
  <li data-field="gender" data-value="female">female</li>
  <li data-field="job" data-value="worker">worker</li>
</ul>

<script>
	document.onkeydown = function(e) {
		var dom = document.getElementsByTagName('li')[0];
		//우선 갖고 놀 dom객체 획득
		var dom = document.getElementsByTagName('li')[0];
		 
		//속성값 얻기
		console.log( dom.getAttribute( 'data-value' ) ); //hika
		 
		//속성값 쓰기
		dom.setAttribute('data-value', 'hika00' );
		 
		console.log( dom.outerHTML ); //변경된 결과를 보자!

	    console.log(e);
	    console.log(location);
	    if (e.keyCode == 116) {
	        return false;
	    }
	};
</script>
</body>
</html>