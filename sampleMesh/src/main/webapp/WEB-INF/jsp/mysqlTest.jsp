<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>sample</title>
<script type="text/javascript" src="//ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
</head>
<body>
<form id ='ff' enctype="multipart/form-data">
	<br>
	<input type="text" name="dawd" value="ㅁㅈㅈㅈㅈㅈㅈㅈㅈㅈㅈㅈㅈㅈㅈㅈㅈㅈㅈ"> 
	<br>
	<input type="text" name="dawd" value="ddddddddddddddddd"> 
	<input type="number" name="wwww" value="12344" > 
	<br>
	
	<input type="checkbox" name="food" value="01" checked="checked"> 한식
	<input type="checkbox" name="food" value="02" checked="checked"> 중식
	<input type="checkbox" name="food" value="02" checked="checked"> 중식
	<input type="checkbox" name="food" value="02" checked="checked"> 중식
	<input type="checkbox" name="food" value="02" checked="checked"> 중식
	<input type="checkbox" name="food" value="02" checked="checked"> 중식
	<input type="checkbox" name="food" value="02" checked="checked"> 중식
	<br>
	   <button type="submit" name="btn1">login</button>
	<br>
	<button id="button" name='btn2'>체크 값보내기</button>
	<br>
	<textarea rows="20" cols="20" name="text" >
		dawdwdw
	</textarea>
</form>
<h3>param : <span></span></h3>




<script>
	form();
	function form(){
			var formData = new FormData(document.getElementById('ff'));
			console.log( formData.keys());
			var key 	 = formData.keys();
			console.log(key.next());
			console.log(key.next());
			console.log(key.next());
			var entries 	 = formData.entries();
			console.log(entries.next());
			console.log(entries.next());
			console.log(entries.next());
			
			var jsonObject = {};
			
			for (var key  in formData.entries()) {
			    //jsonObject[key] = value;
			}
			console.log(jsonObject);
	};
	

	$('#button').click(function(e){
		e.preventDefault();
		var formdata = $('form').serializeArray();
		var obj  = {};    
        jQuery.each(formdata, function(k,v) {
        	 if (obj[this.name]) {
        		 console.log(obj[this.name], this.name);
                 if (!obj[this.name].push) {
                	 console.log(!obj[this.name].push, this.name);
                	 obj[this.name] = [obj[this.name]];
                 }
                 obj[this.name].push(this.value || '');
             } else {
            	 obj[this.name] = this.value || '';
            	
             }
        }); 
        console.log(obj);

		var form = $('form')[0];
		var formdata2 = new FormData(form);
		jQuery.ajax({
            url:'/mesh/test'
           ,type:'POST'
       	   ,dataType:'JSON'
           ,data : JSON.stringify({'request':obj} )
        //   ,processData: false
        //   ,contentType: false
           ,success : function(data) {
        	   console.log("success  : "  ,data);
        	   $('span').text(JSON.stringify(data.param));
        	   $('span').text(JSON.stringify(data.rows));
            },
            complete : function(data) {
                console.log(" : complete");
            },
            error : function(xhr, status, error) {
                //  console.log(url + " : error");
                  console.log(xhr, status, error);
                //  alert("오류 발생("+error+") , 오류코드 : \n"+xhr.responseText);
            }
      });
	});
	
	/*
		var elements = document.getElementById('ff').elements;
			console.log(document.getElementById('ff'));
			console.log(document.getElementById('ff').elements.length);
			var obj = {};
			for(var i = 0 ; i < elements.length ; i++){
		        var item = elements.item(i);
		        console.log(elements.item(i) , i );
		        if (obj[item.name]) {
	        		 console.log(obj[item.name], item.name);
	                 if (!obj[item.name].push) {
	                	 obj[item.name] = [obj[item.name]];
	                 }
	                 obj[item.name].push(item.value || '');
	             } else {
	            	 obj[item.name] = item.value || '';
	            	
	             }
		    }
			console.log(obj);
	
	
	*/
</script>
</body>
</html>