
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
    <h1 class="demos-title">我的会员</h1>
</header>


<div class="weui-cells">

    <a class="weui-cell weui-cell_access" href="${request.contextPath}/wechat/authorize?returnUrl=/myWallet">
        <div class="weui-cell__hd"><img src="${request.contextPath}/images/vipCardIcon/qianbao.png" alt="" style="width:20px;margin-right:5px;display:block"></div>
        <div class="weui-cell__bd">
            <p>我的钱包</p>
        </div>
        <div class="weui-cell__ft">￥${txVipUser.money}</div>
    </a>

    <a class="weui-cell">
        <div class="weui-cell__hd"><img src="${request.contextPath}/images/vipCardIcon/jifen.png" alt="" style="width:20px;margin-right:5px;display:block"></div>
        <div class="weui-cell__bd">
            <p>我的积分</p>
        </div>
        <div class="weui-cell__ft">${txVipUser.integral}</div>
    </a>

    <a class="weui-cell weui-cell_access" href="javascript:showMessage();">
        <div class="weui-cell__hd"><img src="${request.contextPath}/images/vipCardIcon/youhuiquan.png" alt="" style="width:20px;margin-right:5px;display:block"></div>
        <div class="weui-cell__bd">
            <p>我的优惠券</p>
        </div>
        <div class="weui-cell__ft">0张</div>
    </a>

</div>

<div class="weui-cells">
    <a class="weui-cell weui-cell_access" href="${request.contextPath}/birthdayPrivilegesJump">
        <div class="weui-cell__hd"><img src="${request.contextPath}/images/vipCardIcon/shengri.png" alt="" style="width:20px;margin-right:5px;display:block"></div>
        <div class="weui-cell__bd">
            <p>生日特权</p>
        </div>
        <div class="weui-cell__ft"></div>
    </a>
</div>

<div class="weui-cells">
    <a class="weui-cell weui-cell_access" href="${request.contextPath}/wechat/authorize?returnUrl=/getUserInfo">
        <div class="weui-cell__hd"><img src="${request.contextPath}/images/vipCardIcon/xinxi.png" alt="" style="width:20px;margin-right:5px;display:block"></div>
        <div class="weui-cell__bd">
            <p>个人信息</p>
        </div>
        <div class="weui-cell__ft"></div>
    </a>
    <#--<a class="weui-cell weui-cell_access" href="${request.contextPath}/billJump">-->
        <#--<div class="weui-cell__hd"><img src="${request.contextPath}/images/vipCardIcon/zhangdan.png" alt="" style="width:20px;margin-right:5px;display:block"></div>-->
        <#--<div class="weui-cell__bd">-->
            <#--<p>账单</p>-->
        <#--</div>-->
        <#--<div class="weui-cell__ft"></div>-->
    <#--</a>-->
</div>

<div class="weui-cells">
    <a class="weui-cell weui-cell_access" href="javascript:;">
        <div class="weui-cell__hd"><img src="${request.contextPath}/images/vipCardIcon/kefu.png" alt="" style="width:20px;margin-right:5px;display:block"></div>
        <div class="weui-cell__bd">
            <p>专属客服</p>
        </div>
        <div class="weui-cell__ft"></div>
    </a>
    <a class="weui-cell weui-cell_access" href="javascript:;">
        <div class="weui-cell__hd"><img src="${request.contextPath}/images/vipCardIcon/dizhi.png" alt="" style="width:20px;margin-right:5px;display:block"></div>
        <div class="weui-cell__bd">
            <p>店铺地址</p>
        </div>
        <div class="weui-cell__ft"></div>
    </a>

</div>

<script src="${request.contextPath}/js/jquery-2.1.4.js"></script>
<script src="${request.contextPath}/js/fastclick.js"></script>
<script src="${request.contextPath}/js/wxUserAgent.js"></script>
<script src="http://res.wx.qq.com/open/js/jweixin-1.2.0.js"></script>
<script>
    $(function () {
        FastClick.attach(document.body);
    });


</script>

<script>
    function showMessage() {
        $.toast("暂未开放","cancel");
        setTimeout(function () {
            $.hideLoading();
        }, 1000)
    }
</script>



<script src="${request.contextPath}/js/jquery-weui.min.js"></script>

</div>
</div>
</body>
</html>


