
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
    <h1 class="demos-title">积分 ${integral}</h1>
</header>


<div class="weui-cells">
    <a class="weui-cell weui-cell_access" href="javascript:confirm('欧舒丹护手霜',100);">
        <div class="weui-cell__bd">
            <p>欧舒丹护手霜</p>
        </div>
        <div class="weui-cell__ft">
            100积分兑换
        </div>
    </a>
    <a class="weui-cell weui-cell_access" href="javascript:confirm('欧舒丹香皂',100);">
        <div class="weui-cell__bd">
            <p>欧舒丹香皂</p>
        </div>
        <div class="weui-cell__ft">
            100积分兑换
        </div>
    </a>
    <a class="weui-cell weui-cell_access" href="javascript:confirm('Mac口红',200);">
        <div class="weui-cell__bd">
            <p>Mac口红</p>
        </div>
        <div class="weui-cell__ft">
            200积分兑换
        </div>
    </a>
    <a class="weui-cell weui-cell_access" href="javascript:confirm('75ml神仙水',500);">
        <div class="weui-cell__bd">
            <p>75ml神仙水</p>
        </div>
        <div class="weui-cell__ft">
            500积分兑换
        </div>
    </a>

</div>

<script src="${request.contextPath}/js/jquery-2.1.4.js"></script>
<script src="${request.contextPath}/js/fastclick.js"></script>
<script src="http://res.wx.qq.com/open/js/jweixin-1.2.0.js"></script>
<script src="${request.contextPath}/js/wxUserAgent.js"></script>
<script>
    $(function () {
        FastClick.attach(document.body);
    });


</script>


<script>
    function confirm(goods,num) {
        $.confirm(goods, "确认兑换?", function() {

            window.location.href="${request.contextPath}/countDown?goods="+goods+"&num="+num+"&openid=${openid}";
        }, function() {
            //取消操作
        });
    }

</script>



<script src="${request.contextPath}/js/jquery-weui.min.js"></script>

</div>
</div>
</body>
</html>


