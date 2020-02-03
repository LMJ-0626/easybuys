<%@ page import="cn.demo.easybuys.entity.Product" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2019/12/4
  Time: 10:47
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
    <link rel="stylesheet" href="../../css/dataTables.bootstrap.min.css" />
    <script type="text/javascript" src="../../js/jquery-2.2.3.min.js"></script>
    <script type="text/javascript" src="../../js/layer/layer.js"></script>
</head>
<body>
<form id="form1" runat="server">
    <section class="content-header">
        <h1>&nbsp;</h1>
        <ol class="breadcrumb">
            <li><a href="right.html"><i class="fa fa-dashboard"></i>Home</a></li>
            <li><a href="#">商品管理</a></li>
            <li class="active">商品列表</li>
        </ol>
    </section>
    <section class="content">
        <div class="row">
            <div class="col-md-12">
                <div class="box">
                    <div class="box-header">
                        <h3 class="box-title">商品列表</h3>
                    </div>
                    <div class="box-body table-responsive no-padding">
                        <table>
                            <tr>
                                <td colspan="4">关键词:<input type="text"/><input type="button" value="搜索" /></td>
                            </tr>
                        </table>
                        <table id="grid" class="table table-striped table-bordered table-hover" cellspacing="0" width="100%">

                            <thead>
                            <tr>
                                <th>编号</th>
                                <th>名称</th>
                                <th>描述</th>
                                <th>价格</th>
                                <th>库存</th>
                                <th>分类</th>
                                <th>操作</th>
                            </tr>
                            </thead>
                            <tbody>
                            <%
                               List<Product> list = (List<Product>)request.getAttribute("productList");
                               if (list != null && list.size()>0){
                                   for (Product model:list ) {%>
                                       <tr>
                                            <td><%= model.getId()%></td>
                                            <td><%=model.getName()%></td>
                                            <td><%=model.getDescription()%></td>
                                            <td><%=model.getPrice()%></td>
                                            <td><%=model.getStock()%></td>
                                            <td><%=model.getCategoryLevel1Id()%></td>
                                           <td><button id='editrow' class='btn btn-success btn-sm' type='button'>编辑</button>&nbsp<button id='delrow' class='btn btn-danger btn-sm' type='button'>删除</button></td>
                                       </tr>
                                  <% }

                               }
                            %>


                            </tbody>
                            <tr>
                                <td colspan="4" align="right">
                                    <ul class="pager">
                                        <li><a href="../../ProductServlet?opt=list&page=<%=request.getAttribute("firstPage")%>">首页</a></li>
                                        <li><a href="../../ProductServlet?opt=list&page=<%=request.getAttribute("prePage")%>">上一页</a></li>
                                        <li><a href="../../ProductServlet?opt=list&page=<%=request.getAttribute("nextPage")%>">下一页</a></li>
                                        <li><a href="../../ProductServlet?opt=list&page=<%=request.getAttribute("lastPage")%>">尾页</a></li>
                                        <li><span>共<%=request.getAttribute("currPage")%>/<%=request.getAttribute("totalPage")%>页</span></li>
                                    </ul>
                                </td>
                            </tr>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <script type="text/javascript" src="../../js/bootstrap.min.js"></script>
    <script type="text/javascript" src="../plugins/slimScroll/jquery.slimscroll.min.js"></script>
    <script type="text/javascript" src="../plugins/fastclick/fastclick.js"></script>
    <script type="text/javascript" src="../dist/js/app.min.js"></script>
</form>
</body>
</html>

