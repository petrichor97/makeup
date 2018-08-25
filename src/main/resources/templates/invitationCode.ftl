
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



<body ontouchstart>
<#if invitationCode??>
<header class='demos-header'>
    <h1 class="demos-title">我的邀请码</h1>
    <h1 class="demos-title">${invitationCode}</h1>
</header>
<#else>
    <header class='demos-header'>
        <h1 class="demos-title">邀请有礼</h1>
    </header>
</#if>

<article class="weui-article">
    <h1>成功邀请新用户注册并充值送一次到店神仙水护肤体验一次。</h1>
                <img src="${request.contextPath}/images/QRcode.jpg" alt="">

</article>


<script src="http://res.wx.qq.com/open/js/jweixin-1.2.0.js"></script>
<script src="${request.contextPath}/js/wxUserAgent.js"></script>

</body>
</html>


