<html>
<head>
    <meta charset="utf-8">
    <title>支付界面</title>
    <link href="https://cdn.bootcss.com/bootstrap/3.0.1/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-4 column">
        </div>
        <div class="col-md-4 column">
            <h3 class="text-center text-info">
                钱包支付
            </h3>
            <form role="form" action="/sell/pay/chargepay" method="post">
                <div class="form-group">
                    <label for="exampleInputPassword1">密码</label><input type="password" class="form-control" id="password" name="password"/>
                    <input type="hidden" name="orderId" value="${orderId}">
                </div>
                <input type="submit" value="确认">
            </form>
        </div>
        <div class="col-md-4 column">
        </div>
    </div>
</div>
</body>
</html>