<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2019/12/4
  Time: 10:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title></title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport" />
    <meta name="apple-mobile-web-app-capable" content="yes" />
    <meta name="apple-mobile-web-app-status-bar-style" content="black" />
    <meta name="apple-touch-fullscreen" content="yes" />
    <link rel="stylesheet" href="../../css/bootstrap.min.css" />
    <!-- Font Awesome -->
    <link rel="stylesheet" href="../../css/font-awesome.min.css" />
    <!-- Ionicons -->
    <link rel="stylesheet" href="../../css/ionicons.min.css" />
    <!-- Theme style -->
    <link rel="stylesheet" href="../dist/css/AdminLTE.min.css" />
    <link rel="stylesheet" href="../dist/css/skins/_all-skins.min.css" />
    <script type="text/javascript" src="../../js/jquery-2.2.3.min.js"></script>
    <script type="text/javascript" src="../../js/layer/layer.js"></script>
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
    <script type="text/javascript">
        function yanzheng() {
            var username = $("#txtALoginName").val();
            var userpwd = $("#txtAPassWord").val();
            var repwd = $("#txtreAPassWord").val();
            if (username.length <= 0) {
                $("#txtALoginName").focus();
                layer.msg("请输入用户名", { icon: 2, skin: 'layer-ext-moon' });
                return false;
            }
            if (userpwd.length <= 0) {
                $("#txtAPassWord").focus();
                layer.msg("请输入密码", { icon: 2, skin: 'layer-ext-moon' });
                return false;
            }
            if (userpwd.length < 6) {
                $("#txtAPassWord").focus();
                layer.msg("密码至少六位", { icon: 2, skin: 'layer-ext-moon' });
                return false;
            }
            if (userpwd != repwd) {
                $("#txtreAPassWord").focus();
                layer.msg("两次密码不一直", { icon: 2, skin: 'layer-ext-moon' });
                return false;
            }
            return true;
        }
    </script>
</head>
<body>
<section class="content-header">
    <h1>&nbsp</h1>
    <ol class="breadcrumb">
        <li><a href="right.aspx"><i class="fa fa-dashboard"></i>Home</a></li>
        <li><a href="#">管理员管理</a></li>
        <li class="active">添加管理员</li>
    </ol>
</section>
<section class="content">
    <div class="row">
        <div class="col-md-12">
            <div class="box box-info">
                <div class="box-header with-border">
                    <h3 class="box-title">添加管理员</h3>
                </div>
                <form id="form1" class="form-horizontal">
                    <div class="box-body">
                        <div class="form-group">
                            <label for="txtALoginName" class="col-sm-2 control-label">用户名：</label>
                            <div class="col-sm-10">
                                <input type="text" id="txtALoginName" name="txtALoginName" class="form-control" placeholder="请输入用户名"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="txtAPassWord" class="col-sm-2 control-label">密码：</label>
                            <div class="col-sm-10">
                                <input type="password" id="txtAPassWord" name="txtAPassWord" class="form-control" placeholder="请输入密码"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="txtreAPassWord" class="col-sm-2 control-label">重复密码：</label>
                            <div class="col-sm-10">
                                <input type="password" id="txtreAPassWord" name="txtreAPassWord" class="form-control" placeholder="请输入重复密码"/>
                            </div>
                        </div>
                    </div>
                    <div class="box-footer">
                        <div class="col-sm-offset-2 col-sm-8">
                            <input type="button" id="btnok" value="保 存" class="btn btn-block btn-info btn-lg" onclick="yanzheng()" />
                        </div>
                        <div class="col-sm-2">&nbsp;</div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</section>
<script src="../../js/bootstrap.min.js" type="text/javascript"></script>
<script src="../plugins/slimScroll/jquery.slimscroll.min.js" type="text/javascript"></script>
<script src="../plugins/fastclick/fastclick.js" type="text/javascript"></script>
<script src="../dist/js/app.min.js" type="text/javascript"></script>
</body>
</html>

