
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
    <h1 class="demos-title">请先注册</h1>
</header>

<script type="text/javascript">
    function jump(){
        window.location.href="${request.contextPath}/wechat/authorize?returnUrl=/userRegisterJump";
    }
    setTimeout(jump,1000)
</script>

<script src="http://res.wx.qq.com/open/js/jweixin-1.2.0.js"></script>






<script src="${request.contextPath}/js/jquery-weui.min.js"></script>
<script type="text/javascript" src="${request.contextPath}/js/jquery.serializejson.min.js"></script>

</div>
</div>
</body>
</html>

