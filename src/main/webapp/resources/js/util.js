
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

/**
 *
 * @param _url 路径
 * @param _data 数据
 * @param _type HTTP方法
 * @param _dataType 数据类型
 * @param _doSuccess 成功回调函数
 */
var sendRestFulAjax = function(_url ,_data,_type,_dataType,_doSuccess){
    var type =_type == "undefined" || $.trim(_type)==''?'POST':_type;
    var dataType =_type == "undefined" || $.trim(_dataType)==''?'json':_dataType;
    var sf =_doSuccess == "undefined" || $.trim(_doSuccess)==''?doSucess:_doSuccess;
    $.ajax({
        url: _url,
        data:_data ,
        type:type,
        //dataType: dataType,
        success: sf,
        error:doNotSucess
    });
}

/*bootbox.setLocale("zh_CN");*/
var doNotSucess = function(XMLHttpRequest, textStatus, errorThrown){
    console.error(XMLHttpRequest);
    bootbox.alert("本次操作失败.");
}


var doSucess = function(XMLHttpRequest, textStatus, errorThrown){
    //bootbox.alert(XMLHttpRequest);
}

/**
 * 将“&”连接的字符串转换成Json
 * @param str “&”连接的字符串
 * @returns {Object}  Json
 */
function strToJson(str){
    str = str.replace(/&/g,"','");
    str = str.replace(/=/g,"':'");
    str = "({'"+str +"'})";
    var obj = eval(str);
    return obj;
}