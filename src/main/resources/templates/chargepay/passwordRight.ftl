
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">

    <meta name="description" content="Write an awesome description for your new site here. You can edit this line in _config.yml. It will appear in your document head meta (for Google search results) and in your feed.xml site description.
">

    <link rel="stylesheet" href="${request.contextPath}/css/weui.min.css">
    <link rel="stylesheet" href="${request.contextPath}/css/jquery-weui.min.css">
    <link rel="stylesheet" href="${request.contextPath}/css/demos.css">


</head>

<body ontouchstart>

<header class='demos-header'>
    <h1 class="demos-title">支付金额${money}</h1>
</header>

<form id="formDemo">
    <div class="weui-cells weui-cells_form">
        <div class="weui-cell">
            <div class="weui-cell__hd"><label class="weui-label">密码</label></div>
            <div class="weui-cell__bd">
                <input name="password" class="weui-input" type="password" placeholder="请输入密码">
            </div>
        </div>

    </div>

    <div class="weui-btn-area">
        <a class="weui-btn weui-btn_primary" id="show-toast-forbidden" href="javascript:passwordRight();"
           id="showTooltips">确定</a>
    </div>

</form>


<script src="${request.contextPath}/js/jquery-2.1.4.js"></script>
<script src="${request.contextPath}/js/fastclick.js"></script>
<script src="${request.contextPath}/js/wxUserAgent.js"></script>
<script src="http://res.wx.qq.com/open/js/jweixin-1.2.0.js"></script>


<script src="${request.contextPath}/js/jquery-weui.min.js"></script>


<script type="text/javascript">
    function passwordRight() {
       var data =$('#formDemo').serializeJSON();
       data.orderId="${orderId}";
        var dataJson = JSON.stringify(data);
        $.ajax({
            type: "POST",
            url: "${request.contextPath}/pay/chargepay",
            data: dataJson,
            dataType: "json",
            async: false,
            contentType: "application/json",
            success: function (data) {
                // console.log(data)
                // console.log(data["message"])
                if (data["message"] == "密码正确") {

                window.location.href = "${request.contextPath}/payMoneySuccessJump";
                } else {
                    $.toast(data["message"], "forbidden");
                    setTimeout(function () {
                        $.hideLoading();
                    }, 1000)


                }

            },
            error: function () {
                console.log(dataJson);
                $.toast("服务器异常", "forbidden");
                setTimeout(function () {
                    $.hideLoading();
                }, 1000)

            }
        });
    }


</script>

<script type="text/javascript" src="${request.contextPath}/js/jquery.serializejson.min.js"></script>

</div>
</div>
</body>
</html>


