<html>
<head>
    <meta charset="utf-8">
    <title>登录界面</title>
    <link href="https://cdn.bootcss.com/bootstrap/3.0.1/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-4 column">
        </div>
        <div class="col-md-4 column">
            <h3 class="text-center text-info">
                天暄商品及订单管理
            </h3>
            <form role="form" action="/sell/seller/login" method="post">
                <div class="form-group">
                    <label for="exampleInputEmail1">管理账号</label><input type="text" class="form-control" id="sellerId" name="sellerId" />
                </div>
                <div class="form-group">
                    <label for="exampleInputPassword1">密码</label><input type="password" class="form-control" id="password" name="password"/>
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