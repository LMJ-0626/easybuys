<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2019/12/4
  Time: 10:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>易买网管理后台-主页</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport" />
    <meta name="apple-mobile-web-app-capable" content="yes" />
    <meta name="apple-mobile-web-app-status-bar-style" content="black" />
    <meta name="apple-touch-fullscreen" content="yes" />
    <link rel="stylesheet" href="../css/bootstrap.min.css" />
    <!-- Font Awesome -->
    <link rel="stylesheet" href="../css/font-awesome.min.css" />
    <!-- Ionicons -->
    <link rel="stylesheet" href="../css/ionicons.min.css" />
    <!-- Theme style -->
    <link rel="stylesheet" href="dist/css/AdminLTE.min.css" />
    <link rel="stylesheet" href="dist/css/skins/_all-skins.min.css" />
    <script type="text/javascript" src="../js/jquery-2.2.3.min.js"></script>
    <script type="text/javascript" src="../js/layer/layer.js"></script>
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body class="hold-transition skin-blue sidebar-mini">
<form id="form1" runat="server">
    <div class="wrapper">
        <header class="main-header">
            <a href="index.aspx" class="logo">
                <span class="logo-mini"><img src="../img/logo-collapsed.png" width="40" /></span>
                <span class="logo-lg"><img src="../img/logo-collapsed.png" width="40" style="margin-top:-5px;" />易买网</span>
            </a>
            <nav class="navbar navbar-static-top">
                <a href="#" class="sidebar-toggle" data-toggle="offcanvas" role="button">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </a>
                <div class="navbar-custom-menu">
                    <ul class="nav navbar-nav">
                        <li class="dropdown user user-menu">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                <img src="../img/guanliyuan.jpg" class="user-image" alt="User Image" />
                                <label class="hidden-xs" id="lblname" name="lblname"></label>
                            </a>
                            <ul class="dropdown-menu">
                                <li class="user-header">
                                    <img src="../img/guanliyuan.jpg" class="img-circle" alt="User Image" />
                                    <p>
                                        欢迎管理员登录
                                        <small>易买网</small>
                                    </p>
                                </li>
                                <li class="user-body">
                                    <div class="row">
                                        <div class="col-xs-4 text-center">
                                            <a href="news/list.aspx" target="iframecon">资讯列表</a>
                                        </div>
                                        <div class="col-xs-4 text-center">
                                            <a href="product/list.aspx" target="iframecon">商品列表</a>
                                        </div>
                                        <div class="col-xs-4 text-center">
                                            <a href="admin/list.aspx" target="iframecon">管理员列表</a>
                                        </div>
                                    </div>
                                </li>
                                <li class="user-footer">
                                    <div class="pull-left">
                                        <a href="admin/adminpwd.aspx" target="iframecon"class="btn btn-default btn-flat">修改密码</a>
                                    </div>
                                    <div class="pull-right">
                                        <a href="#" class="btn btn-default btn-flat">退出</a>
                                    </div>
                                </li>
                            </ul>
                        </li>
                        <li>
                            <a href="#">退出</a>
                        </li>
                    </ul>
                </div>
            </nav>
        </header>
        <aside class="main-sidebar">
            <section class="sidebar">
                <div class="user-panel">
                    <div class="pull-left image">
                        <img src="../img/guanliyuan.jpg" class="img-circle" alt="User Image" />
                    </div>
                    <div class="pull-left info">
                        <p id="pname"></p>
                        <a href="#"><i class="fa fa-circle text-success"></i>Online</a>
                    </div>
                </div>
                <ul class="sidebar-menu">
                    <li class="header">系统菜单</li>
                    <li>
                        <a href="index.jsp">
                            <i class="fa fa-home"></i><span>Home</span>
                        </a>
                    </li>
                    <li class="treeview">
                        <a href="#">
                            <i class="fa fa-user"></i><span>管理员管理</span>
                            <span class="pull-right-container">
                                    <i class="fa fa-angle-left pull-right"></i>
                                </span>
                        </a>
                        <ul class="treeview-menu">
                            <li><a href="admin/info.jsp" target="iframecon"><i class="fa fa-circle-o"></i>添加管理员</a></li>
                            <li><a href="admin/list.jsp" target="iframecon"><i class="fa fa-circle-o"></i>管理管理员</a></li>
                            <li><a href="admin/adminpwd.jsp" target="iframecon"><i class="fa fa-circle-o"></i>修改密码</a></li>
                        </ul>
                    </li>
                    <li class="treeview">
                        <a href="#">
                            <i class="fa fa-newspaper-o"></i><span>新闻管理</span>
                            <span class="pull-right-container">
                                    <i class="fa fa-angle-left pull-right"></i>
                                </span>
                        </a>
                        <ul class="treeview-menu">
                            <li><a href="news/info.jsp" target="iframecon"><i class="fa fa-circle-o"></i>添加新闻</a></li>
                            <li><a href="../../NewsServlet?opt=list" target="iframecon"><i class="fa fa-circle-o"></i>新闻列表</a></li>
                        </ul>
                    </li>
                    <li class="treeview">
                        <a href="#">
                            <i class="fa fa-folder"></i><span>商品管理</span>
                            <span class="pull-right-container">
                                    <i class="fa fa-angle-left pull-right"></i>
                                </span>
                        </a>
                        <ul class="treeview-menu">
                            <li><a href="product/info.jsp" target="iframecon"><i class="fa fa-circle-o"></i>添加商品</a></li>
                            <li><a href="/ProductServlet" target="iframecon"><i class="fa fa-circle-o"></i>商品列表</a></li>
                        </ul>
                    </li>
                    <li class="treeview">
                        <a href="#">
                            <i class="fa fa-link"></i><span>分类管理</span>
                            <span class="pull-right-container">
                                    <i class="fa fa-angle-left pull-right"></i>
                                </span>
                        </a>
                        <ul class="treeview-menu">
                            <li><a href="category/list.jsp" target="iframecon"><i class="fa fa-circle-o"></i>分类列表</a></li>
                        </ul>
                    </li>
                </ul>
            </section>
        </aside>
        <div class="content-wrapper" style="background-color: #FFF;">
            <iframe class="embed-responsive-item" src="right.jsp" id="iframecon" style="min-height:724px;" name="iframecon" scrolling="no" onload="iFrameHeight()" width="100%" frameborder="0" border="0" allowfullscreen></iframe>
        </div>
        <footer class="main-footer">
            <strong>Copyright &copy; 2017-2060 <a href="/index.aspx" target="_blank">易买网</a>.</strong> All rights
            reserved.
        </footer>
    </div>
    <script src="../js/bootstrap.min.js"></script>
    <script src="plugins/slimScroll/jquery.slimscroll.min.js"></script>
    <script src="plugins/fastclick/fastclick.js"></script>
    <script src="dist/js/app.min.js"></script>
    <!--iframe自适应内容高度js-->
    <script type="text/javascript">
        function iFrameHeight() {
            var ifm = document.getElementById("iframecon");
            var subWeb = document.frames ? document.frames["iframecon"].document :
                ifm.contentDocument;
            if (ifm != null && subWeb != null) {
                ifm.height = subWeb.body.scrollHeight+100;
            }

            /*var iframeWin = ifm.contentWindow || ifm.contentDocument.parentWindow;
            if (iframeWin.document.body) {
                ifm.height = iframeWin.document.documentElement.scrollHeight || iframeWin.document.body.scrollHeight;
            }*/
        }
    </script>
</form>
</body>
</html>

