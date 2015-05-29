
var sendAjax = function(url, data, doSuccess) {
	console.log("url:"+url);
	console.log("data:"+data);
	 $.ajax({
         url: url,
         data:data , 
         success: doSuccess,
         error:doNotSucess
     });
}

/*bootbox.setLocale("zh_CN");*/
var doNotSucess = function(XMLHttpRequest, textStatus, errorThrown){
    bootbox.alert(XMLHttpRequest);
}