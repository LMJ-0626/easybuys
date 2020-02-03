<%@ page import="cn.demo.easybuys.entity.News" %><%--
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
    <%--<script type="text/javascript">--%>
        <%--function yanzheng() {--%>
            <%--var title = $("#txtATitle").val();--%>
            <%--var content = $("#txtAContent").val();--%>
            <%--var createTime = $("#txtACreateTime").val();--%>
            <%--if (title.length <= 0) {--%>
                <%--$("#txtALoginName").focus();--%>
                <%--layer.msg("请输入标题", { icon: 2, skin: 'layer-ext-moon' });--%>
                <%--return false;--%>
            <%--}--%>
            <%--if (content.length <= 0) {--%>
                <%--$("#txtAContent").focus();--%>
                <%--layer.msg("请输入内容", { icon: 2, skin: 'layer-ext-moon' });--%>
                <%--return false;--%>
            <%--}--%>
            <%--if (createTime.length <= 0) {--%>
                <%--$("#txtAContent").focus();--%>
                <%--layer.msg("请输入日期", { icon: 2, skin: 'layer-ext-moon' });--%>
                <%--return false;--%>
            <%--}--%>

          <%--return true;--%>
        <%--}--%>
    <%--</script>--%>
</head>
<body>
<section class="content-header">
    <h1>&nbsp</h1>
    <ol class="breadcrumb">
        <li><a href="right.aspx"><i class="fa fa-dashboard"></i>Home</a></li>
        <li><a href="#">新闻管理</a></li>
        <li class="active">添加新闻</li>
    </ol>
</section>
<section class="content">
    <div class="row">
        <div class="col-md-12">
            <div class="box box-info">
                <div class="box-header with-border">
                    <h3 class="box-title">添加新闻</h3>
                </div>

                <%
                    String action="../../NewsServlet?opt=add";
                    News model = (News)request.getAttribute("newsOne");
                    if (model != null){
                        action="../../NewsServlet?opt=up";
                    }
                %>
                <form  action="<%=action%>"  method="post" id="form1" class="form-horizontal" >
                    <div class="box-body">
                        <div class="form-group">
                            <label for="txtATitle" class="col-sm-2 control-label" >标题：</label>
                            <div class="col-sm-10">
                                <input type="text" id="txtATitle" name="txtATitle" class="form-control" value="<%=model==null?"":model.getTitle()%>" placeholder="请输入标题"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="txtAContent" class="col-sm-2 control-label" >内容： </label>
                            <div class="col-sm-10">
                                <input type="hidden"  name="id" class="form-control" value="<%=model==null?"":model.getId()%>" placeholder="请输入内容"/>
                                <input type="text" id="txtAContent" name="txtAContent" class="form-control" value="<%=model==null?"":model.getContent()%>" placeholder="请输入内容"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="txtACreateTime" class="col-sm-2 control-label">创建时间：</label>
                            <div class="col-sm-10">
                                <input type="text" id="txtACreateTime" name="txtACreateTime" class="form-control"  value="<%=model==null?"":model.getCreateTime()%>" placeholder="请输入创建时间"/>
                            </div>
                        </div>

                    </div>
                    <div class="box-footer">
                        <div class="col-sm-offset-2 col-sm-8">
                            <input type="submit" id="btnok" value="保 存" class="btn btn-block btn-info btn-lg"  />
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


