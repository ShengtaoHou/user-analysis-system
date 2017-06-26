<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.hst.user.vo.*,com.hst.user.dao.*,com.hst.user.servlet.*,java.util.ArrayList" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%  UserDao userDao = new UserDao();
	ArrayList<UserVo> list = userDao.selectNotDeleteList();
%>

<html>
    <head>
        <meta charset="UTF-8">
        <title>用户数据分析</title>
        <meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
        <!-- bootstrap 3.0.2 -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
        <!-- font Awesome -->
        <link href="${pageContext.request.contextPath}/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
        <!-- Ionicons -->
        <link href="${pageContext.request.contextPath}/css/ionicons.min.css" rel="stylesheet" type="text/css" />
        <!-- DATA TABLES -->
        <link href="${pageContext.request.contextPath}/css/datatables/dataTables.bootstrap.css" rel="stylesheet" type="text/css" />
        <!-- Theme style -->
        <link href="${pageContext.request.contextPath}/css/AdminLTE.css" rel="stylesheet" type="text/css" />

        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
          <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
        <![endif]-->

    </head>
    <body class="skin-blue">
        	<%@include file="menu.jsp" %>
            <!-- Right side column. Contains the navbar and content of the page -->
            <aside class="right-side">                
                <!-- Content Header (Page header) -->
                <section class="content-header">
                    <h1>
                        数据表
                        
                    </h1>
                    <ol class="breadcrumb">
                        <li><a href="#"><i class="fa fa-dashboard"></i>主页</a></li>
                        <li><a href="#">数据表</a></li>
                        <li class="active">用户表</li>
                    </ol>
                </section>
                
                <!-- Main content -->
                <section class="content">
                    <div class="row">
                        <div class="col-xs-12">

                            
                            <div class="box">
                                <div class="box-header">
                                    <h3 class="box-title">用户表</h3>                                    
                                </div><!-- /.box-header -->
                                <div class="box-body table-responsive">
                                    <table id="example1" class="table table-bordered table-striped">
                                        <thead>
                                            <tr>

                                                <th data-field="id" data-checkbox="true" ></th>
                                                <th data-field="username" data-sortable="true" >用户名</th>
                                                <th data-field="pwd" data-sortable="true">密码</th>
                                                <th data-field="sex" data-sortable="true">性别</th>           
                                                <th data-field="email"  data-sortable="true">邮箱</th>
                                                <th data-field="delete" data-sortable="true">职业</th>
                                                <th data-field="edit" data-sortable="true"></th>
                                                <th data-field="edit" data-sortable="true"></th>
                                            </tr>
                                        </thead>

                                        <tbody >
                                                <%for(int i = 0 ; i<list.size();i++) {
            
                                                    UserVo user = list.get(i);%>

                                                    <tr align="center" >
                                                    <td><input type = "checkbox"  value ='<%=user.getUserId() %>' name="num"/></td>
                                                    <td><a href="ServletViewUser?userId=<%=user.getUserId() %>"><%=user.getUserName()%></a></td>
                                                    <td><%=user.getUserPassword() %></td>
                                                    <td><%=user.getUserSex() %></td>
                                                    <td><%=user.getUserEmail() %></td>
                                                    <td><%=user.getUserOccup() %></td>
                                                    <td><a href="ServletUserDelete?userId=<%=user.getUserId() %>">删除</a></td>
                                                    <td><a href="ServletToUserUpdate?userId=<%=user.getUserId() %>">修改</a></td>
                                                    </tr>
                                                <% 
                                                }
                                                %>
                                        </tbody> 
                                    </table>
                                </div><!-- /.box-body -->
                            </div><!-- /.box -->


                        </div>
                    </div>

                </section><!-- /.content -->
            </aside><!-- /.right-side -->
        </div><!-- ./wrapper -->


        <!-- jQuery 2.0.2 -->
        <script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
        <!-- Bootstrap -->
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js" type="text/javascript"></script>
        <!-- DATA TABES SCRIPT -->
        <script src="${pageContext.request.contextPath}/js/plugins/datatables/jquery.dataTables.js" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/js/plugins/datatables/dataTables.bootstrap.js" type="text/javascript"></script>
        <!-- AdminLTE App -->
        <script src="${pageContext.request.contextPath}/js/AdminLTE/app.js" type="text/javascript"></script>

        <!-- page script -->
        <script type="text/javascript">
            $(function() {
                $("#example1").dataTable({
                    "bPaginate": true,
                    "bLengthChange": false,
                    "bFilter": false,
                    "bSort": true,
                    "bInfo": true,
                    "bAutoWidth": false
                });
                $('#example2').dataTable({
                    "bPaginate": true,
                    "bLengthChange": false,
                    "bFilter": false,
                    "bSort": true,
                    "bInfo": true,
                    "bAutoWidth": false
                });
            });
        </script>

    </body>
</html>