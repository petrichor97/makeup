<html>
<head>
    <meta charset="utf-8">
    <title>成功提示</title>
    <link href="https://cdn.bootcss.com/bootstrap/3.0.1/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="alert alert-dismissable alert-success">
                <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
                <h4>
                    登录成功!
                </h4> <strong>${msg!""}</strong><a href="/sell/seller/order/list" class="alert-link">3s后自动跳转</a>
            </div>
        </div>
    </div>
</div>

</body>

<script>
    setTimeout('location.href="/sell/seller/order/list"', 3000);
</script>

</html>