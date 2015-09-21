/**
 * 报价
 * Created by zhangjh on 2015/9/18.
 */

(function ($) {

    /**
     * 初始化报价信息
     * @param _data
     */
    var iniBomQuotedInfo = function (_data) {
        var natrualkey = $("#natrualkey").val();
        if (natrualkey != '' && natrualkey != 'null') {
            Object.keys(_data).map(function (key) {
                $('#offerDescDetail input').filter(function () {
                    return key == this.name;
                }).val(_data[key]);
                //$("#" + key).val(_data[key]);
            });
        }
    }



    $(function () {
        $("#offerDescTitle").click(function () {
            $("#offerDescDetail").toggle(300);
        });
    })


    $.extend({
        iniBomQuotedInfo: iniBomQuotedInfo
    })


}(jQuery));
