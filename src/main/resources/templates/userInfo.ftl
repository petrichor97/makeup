
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
    <h1 class="demos-title">个人信息</h1>
</header>

<div class="weui-cells">
    <div class="weui-cell">
        <div class="weui-cell__bd">
            <p>昵称</p>
        </div>
        <div class="weui-cell__ft">${txVipUser.name}</div>
    </div>
    <div class="weui-cell">
        <div class="weui-cell__bd">
            <p>出生日期</p>
        </div>
        <div class="weui-cell__ft">${birthdatSimple}</div>
    </div>
    <div class="weui-cell">
        <div class="weui-cell__bd">
            <p>性别</p>
        </div>
        <div class="weui-cell__ft">${txVipUser.sex}</div>
    </div>
    <div class="weui-cell">
        <div class="weui-cell__bd">
            <p>学校</p>
        </div>
        <div class="weui-cell__ft">${txVipUser.school}</div>
    </div>
    <div class="weui-cell">
        <div class="weui-cell__bd">
            <p>学院</p>
        </div>
        <div class="weui-cell__ft">${txVipUser.institute}</div>
    </div>
    <div class="weui-cell">
        <div class="weui-cell__bd">
            <p>年级</p>
        </div>
        <div class="weui-cell__ft">${txVipUser.grade}</div>
    </div>
    <div class="weui-cell">
        <div class="weui-cell__bd">
            <p>肤质</p>
        </div>
        <div class="weui-cell__ft">${txVipUser.skin}</div>
    </div>

    <#--<%--修改肤质--%>-->
        <#--<%--<a class="weui-cell weui-cell_access" href="javascript:;">--%>-->
            <#--<%--<div class="weui-cell__bd">--%>-->
                <#--<%--<p>肤质</p>--%>-->
            <#--<%--</div>--%>-->
            <#--<%--<div class="weui-cell__ft">我的肤质</div>--%>-->
        <#--<%--</a>--%>-->

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


<script src="${request.contextPath}/js/jquery-weui.min.js"></script>

</body>
</html>


