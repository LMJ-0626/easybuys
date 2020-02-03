<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2019/12/4
  Time: 10:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <title>易买网管理后台</title>
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport" />
    <meta name="apple-mobile-web-app-capable" content="yes" />
    <meta name="apple-mobile-web-app-status-bar-style" content="black" />
    <meta name="apple-touch-fullscreen" content="yes" />
    <link rel="stylesheet" href="../css/bootstrap.min.css"/>
    <!-- Font Awesome -->
    <link rel="stylesheet" href="../css/font-awesome.min.css" />
    <!-- Ionicons -->
    <link rel="stylesheet" href="../css/ionicons.min.css" />
    <!-- Theme style -->
    <link rel="stylesheet" href="dist/css/AdminLTE.min.css" />
    <script src="../js/jquery-2.2.3.min.js" type="text/javascript"></script>
    <script src="../js/layer/layer.js" type="text/javascript"></script>
    <style type="text/css">
        .copyright {
            color: #FFF;
            text-shadow: 0px 1px 2px #000;
        }

        .login-panel {
            border-radius: 8px;
            background: rgba(255,255,255,0.6);
            position: relative;
            -webkit-box-shadow: 0 2px 2px 2px rgba(5,5,5,0.2);
            box-shadow: 0 2px 2px 2px rgba(5,5,5,0.2);
        }

        .login-page {
            background: url(dist/img/loginbg.jpg) 0 0 no-repeat;
        }
    </style>
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
    <script type="text/javascript">
        function ig_onclick() {
            $("#ig").attr("src", "/ValidateImage.aspx?img=" + Math.random());
            //document.getElementById("ig").src = "/ValidateImage.aspx?img=" + Math.random();
        }
        function yanzheng() {
            var name = $("#txtUserName").val();
            var pwd = $("#txtPwd").val();
            var code = $("#txtCode").val();
            if (name.length <= 0) {
                $("#txtUserName").focus();
                layer.msg("请输入用户名", { icon: 2, skin: 'layer-ext-moon' });
                return false;
            }
            if (pwd.length <= 0) {
                $("#txtPwd").focus();
                layer.msg("请输入密码", { icon: 2, skin: 'layer-ext-moon' });
                return false;
            }
            if (code.length <= 0) {
                $("#txtCode").focus();
                layer.msg("请输入验证码", { icon: 2, skin: 'layer-ext-moon' });
                return false;
            }
            return true;
        }
    </script>
</head>
<body class="hold-transition login-page">
<div class="login-box">
    <div class="login-logo">
        <a href="index.html">易买网</a>
    </div>
    <!-- /.login-logo -->
    <div class="login-box-body login-panel">
        <p class="login-box-msg">欢迎您登录易买网管理后台</p>
        <form id="form1">
            <div class="form-group has-feedback">
                <input type="text" id="txtUserName" name="txtUserName" class="form-control" placeholder="请输入登录名" />
                <span class="glyphicon glyphicon-user form-control-feedback"></span>
            </div>
            <div class="form-group has-feedback">
                <input type="password" id="txtPwd" name="txtPwd" class="form-control" placeholder="请输入密码" />
                <span class="glyphicon glyphicon-lock form-control-feedback"></span>
            </div>
            <div class="form-group">
                <input type="text" id="txtCode" name="txtCode" class="form-control" placeholder="请输入验证码" />
                <img src="/" id="ig" class="img-responsive" style="cursor: pointer" onclick="ig_onclick()" height="60px" width="100px" />
            </div>
            <div class="row">
                <!-- /.col -->
                <div class="col-md-offset-8 col-md-4">
                    <input type="button" id="btnlogin" value="登录" class="btn btn-primary btn-block btn-flat" onclick="yanzheng()"/>
                </div>
                <!-- /.col -->
            </div>
        </form>
    </div>
    <!-- /.login-box-body -->
    <div class="copyright text-center">
        Copyright©2017-2060 易买网 版权所有<br />技术支持：清华ITJava1836
    </div>
</div>
<script src="../js/bootstrap.min.js" type="text/javascript"></script>
</body>
</html>
