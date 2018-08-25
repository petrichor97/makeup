
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
    <h1 class="demos-title">用户注册</h1>
</header>

<form id="formDemo">
    <div class="weui-cells weui-cells_form">
        <div class="weui-cell">
            <div class="weui-cell__hd"><label class="weui-label">昵称</label></div>
            <div class="weui-cell__bd">
                <input name="name" class="weui-input" type="text" placeholder="请输入昵称">
            </div>
        </div>
        <div class="weui-cells__title">请选择性别</div>
        <div class="weui-cells weui-cells_radio">
            <label class="weui-cell weui-check__label" for="x11">
                <div class="weui-cell__bd">
                    <p>男</p>
                </div>
                <div class="weui-cell__ft">
                    <input type="radio" class="weui-check" name="sex" id="x11" value="男">
                    <span class="weui-icon-checked"></span>
                </div>
            </label>
            <label class="weui-cell weui-check__label" for="x12">

                <div class="weui-cell__bd">
                    <p>女</p>
                </div>
                <div class="weui-cell__ft">
                    <input type="radio" name="sex" class="weui-check" id="x12" checked="checked" value="女">
                    <span class="weui-icon-checked"></span>
                </div>
            </label>

        </div>
        <div class="weui-cell">
            <div class="weui-cell__hd"><label class="weui-label">学校</label></div>
            <div class="weui-cell__bd">
                <input name="school" class="weui-input" type="text" placeholder="请输入学校">
            </div>
        </div>
        <div class="weui-cell">
            <div class="weui-cell__hd"><label class="weui-label">学院</label></div>
            <div class="weui-cell__bd">
                <input name="institute" class="weui-input" type="text" placeholder="请输入学院">
            </div>
        </div>
    </div>

    <div class="weui-cell weui-cell_select weui-cell_select-after">
        <div class="weui-cell__hd">
            <label class="weui-label">年级</label>
        </div>
        <div class="weui-cell__bd">
            <select class="weui-select" name="grade">
                <option value="大一">大一</option>
                <option value="大二">大二</option>
                <option value="大三">大三</option>
                <option value="大四">大四</option>
            </select>
        </div>
    </div>

    </div>

    <div class="weui-cell">
        <div class="weui-cell__hd"><label class="weui-label">出生日期</label></div>
        <div class="weui-cell__bd">
            <input name="birthday" class="weui-input" type="date" value="1996-04-04">
        </div>
    </div>

    <div class="weui-cell weui-cell_select weui-cell_select-after">
        <div class="weui-cell__hd">
            <label class="weui-label">肤质</label>
        </div>
        <div class="weui-cell__bd">
            <select class="weui-select" name="skin">
                <option value="干性">干性</option>
                <option value="中性">中性</option>
                <option value="油性">油性</option>
                <option value="混合性">混合性</option>
                <option value="敏感性">敏感性</option>
            </select>
        </div>
    </div>
    <div class="weui-cell">
        <div class="weui-cell__hd"><label class="weui-label">支付密码</label></div>
        <div class="weui-cell__bd">
            <input name="password" class="weui-input" type="text" placeholder="请输入6位数字密码">
        </div>
    </div>
    <div class="weui-cell">
        <div class="weui-cell__hd"><label class="weui-label">邀请码</label></div>
        <div class="weui-cell__bd">
            <input name="beInvitationCode" class="weui-input" type="text" placeholder="非必填">
        </div>
    </div>
    <div class="weui-btn-area">
        <a class="weui-btn weui-btn_primary" id="show-toast-forbidden" href="javascript:addUser('${openid}');"
           id="showTooltips">确定</a>
    </div>

</form>
<script src="${request.contextPath}/js/jquery-2.1.4.js"></script>
<script src="${request.contextPath}/js/fastclick.js"></script>
<script src="${request.contextPath}/js/wxUserAgent.js"></script>
<script src="http://res.wx.qq.com/open/js/jweixin-1.2.0.js"></script>

<script>
    $(function () {
        FastClick.attach(document.body);
    });


</script>
<script type="text/javascript">


    function getUser() {
// console.log(JSON.stringify($('#formDemo').serializeJSON()));
//        return JSON.stringify($('#formDemo').serializeJSON());
        return  $('#formDemo').serializeJSON();


    }
</script>


<script type="text/javascript">
    function addUser(openid) {
        var data = getUser();
        data.openid=openid;
       var dataJson=JSON.stringify(data);
         console.log(dataJson);
        $.ajax({
            type: "POST",
            url: "${request.contextPath}/userRegister",
            data: dataJson,
            dataType: "json",
            async: false,
            contentType: "application/json",
            success: function (data) {
                if (data["message"] == "注册成功") {
                    window.location.href = "${request.contextPath}/registerSuccessJump";
                } else {
                    $.toast(data["message"], "forbidden");
                    setTimeout(function () {
                        $.hideLoading();
                    }, 1000)
                }

            },
            error: function () {
                $.toast("服务器异常", "forbidden");
                setTimeout(function () {
                    $.hideLoading();
                }, 1000)

            }
        });
    }


</script>

<script src="${request.contextPath}/js/jquery-weui.min.js"></script>
<script type="text/javascript" src="${request.contextPath}/js/jquery.serializejson.min.js"></script>

</div>
</div>
</body>
</html>

