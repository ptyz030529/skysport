var sendAjax = function(url, data, doSuccess) {
	console.log("url:"+url);
	console.log("data:"+data);
	 $.ajax({
         url: url,
         data:data , 
         success: doSuccess
     });
}