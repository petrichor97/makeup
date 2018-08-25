
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
    <h1 class="demos-title">福利兑换</h1>
</header>

<div class="weui-cells">
<#if welfareNameList?? && (welfareNameList?size > 0)>
<#list welfareNameList as welfareName>
    <a class="weui-cell weui-cell_access" href="javascript:confirm(' ${welfareName.welfareName}',${welfareName.userWelfareId});">
        <div class="weui-cell__bd">
            <p> ${welfareName.welfareName}</p>
        </div>
        <div class="weui-cell__ft">
            兑换
        </div>
    </a>

</#list>

<#else>
<a class="weui-cell"">
    <div class="weui-cell__bd">
        <p> 尚未拥有可兑换福利</p>
    </div>

</a>

</#if>
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
function confirm(goods,userWelfareId) {
    $.confirm("需到店100秒内领取", "确认兑换?", function() {
        window.location.href="${request.contextPath}/welfareDelect?userWelfareId="+userWelfareId+"&goods="+goods;
        <#--window.location.href="${request.contextPath}/welfareDelect?openid=${openid}&goods="+goods;-->
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


