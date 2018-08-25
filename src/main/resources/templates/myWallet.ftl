
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
    <h1 class="demos-title">我的钱包</h1>
</header>

<div class="weui-form-preview">
    <div class="weui-form-preview__hd">
        <div class="weui-form-preview__item">
            <label class="weui-form-preview__label">我的余额</label>
            <em class="weui-form-preview__value">¥${money}</em>
        </div>
    </div>
</div>

<div class="bd">
    <div class="page__bd">

        <div class="weui-panel">
            <div class="weui-panel__hd">充值有优惠哦</div>
            <div class="weui-panel__bd">
                <div class="weui-media-box weui-media-box_small-appmsg">
                    <div class="weui-cells">
                        <a class="weui-cell weui-cell_access" href="${request.contextPath}/pay/createMoneyOrder?openid=${openid}&money=0.01">
                            <div class="weui-cell__hd"><img src="${request.contextPath}/images/wallet/chognzhi1.png" alt="" style="width:20px;margin-right:5px;display:block"></div>
                            <div class="weui-cell__bd weui-cell_primary">
                                <p>充值100元，送可爱少女化妆镜</p>
                            </div>
                            <span class="weui-cell__ft"></span>
                        </a>
                        <a class="weui-cell weui-cell_access" href="${request.contextPath}/pay/createMoneyOrder?openid=${openid}&money=0.02">
                            <div class="weui-cell__hd"><img src="${request.contextPath}/images/wallet/chognzhi1.png" alt="" style="width:20px;margin-right:5px;display:block"></div>
                            <div class="weui-cell__bd weui-cell_primary">
                                <p>充值200元，送20元及40ml碧柔防晒乳</p>
                            </div>
                            <span class="weui-cell__ft"></span>
                        </a>
                        <a class="weui-cell weui-cell_access" href="${request.contextPath}/pay/createMoneyOrder?openid=${openid}&money=0.03">
                            <div class="weui-cell__hd"><img src="${request.contextPath}/images/wallet/chognzhi1.png" alt="" style="width:20px;margin-right:5px;display:block"></div>
                            <div class="weui-cell__bd weui-cell_primary">
                                <p>充值300元，送40元及mini版大牌香水</p>
                            </div>
                            <span class="weui-cell__ft"></span>
                        </a>
                        <a class="weui-cell weui-cell_access" href="${request.contextPath}/pay/createMoneyOrder?openid=${openid}&money=0.04">
                            <div class="weui-cell__hd"><img src="${request.contextPath}/images/wallet/chognzhi1.png" alt="" style="width:20px;margin-right:5px;display:block"></div>
                            <div class="weui-cell__bd weui-cell_primary">
                                <p>充值500元，送70元</p>
                            </div>
                            <span class="weui-cell__ft"></span>
                        </a>
                        <a class="weui-cell weui-cell_access" href="${request.contextPath}/pay/createMoneyOrder?openid=${openid}&money=0.05">
                            <div class="weui-cell__hd"><img src="${request.contextPath}/images/wallet/chognzhi1.png" alt="" style="width:20px;margin-right:5px;display:block"></div>
                            <div class="weui-cell__bd weui-cell_primary">
                                <p>充值600元，送60ml安耐防晒喷雾</p>
                            </div>
                            <span class="weui-cell__ft"></span>
                        </a>
                        <a class="weui-cell weui-cell_access" href="${request.contextPath}/pay/createMoneyOrder?openid=${openid}&money=0.06">
                            <div class="weui-cell__hd"><img src="${request.contextPath}/images/wallet/chognzhi2.png" alt="" style="width:20px;margin-right:5px;display:block"></div>
                            <div class="weui-cell__bd weui-cell_primary">
                                <p>充值1000元，送150元</p>
                            </div>
                            <span class="weui-cell__ft"></span>
                        </a>
                    </div>
                </div>
            </div>
        </div>
    </div>



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
    function chargeMoney(money) {

    }
</script>


<script src="${request.contextPath}/js/jquery-weui.min.js"></script>

</body>
</html>


