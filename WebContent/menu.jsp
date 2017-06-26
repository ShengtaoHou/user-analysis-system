<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="com.hst.user.vo.*,com.hst.user.dao.*,com.hst.login.vo.*,com.hst.login.dao.*,com.hst.user.servlet.*,java.util.ArrayList" %>
<%  
	
	UserVo curuser = (UserVo)(session.getAttribute("curuser")); 
	String userName=curuser.getUserName();
    LoginVo curlogin = (LoginVo)(session.getAttribute("curlogin")); 
%>
<html>

        <!-- header logo: style can be found in header.less -->
        <header class="header">
            <a href="#" class="logo">
                <!-- Add the class icon to your logo image or logo icon to add the margining -->
                用户行为分析
            </a>
            <!-- Header Navbar: style can be found in header.less -->
            <nav class="navbar navbar-static-top" role="navigation">
                <!-- Sidebar toggle button-->
                <a href="#" class="navbar-btn sidebar-toggle" data-toggle="offcanvas" role="button">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </a>
                <div class="navbar-right">
                    <ul class="nav navbar-nav">
                        
                        <!-- User Account: style can be found in dropdown.less -->
                        <li class="dropdown user user-menu">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                <i class="glyphicon glyphicon-user"></i>
                                <span><%=userName %><i class="caret"></i></span>
                            </a>
                            <ul class="dropdown-menu">
                                <!-- User image -->
                                <li class="user-header bg-light-blue">
                                    <img src="img/avatar5.png" class="img-circle" alt="User Image" />
                                    <p>
                                        <%=userName %> - <%=curuser.getUserOccup() %>
                                        <small>Mar 31th 2017</small>
                                    </p>
                                </li>
                                <!-- Menu Body -->
                                <li class="user-body">
                                    <div class="col-xs-4 text-center">
                                        <a href="#"><%=curlogin.getUserIP() %></a>
                                    </div>
                                    <div class="col-xs-4 text-center">
                                        <a href="#"><%=curlogin.getUserOS() %></a>
                                    </div>
                                    <div class="col-xs-4 text-center">
                                        <a href="#"><%=curlogin.getUserBrowser() %></a>
                                    </div>
                                </li>
                                <!-- Menu Footer-->
                                <li class="user-footer">
                                    <div class="pull-left">
                                        <a class="btn btn-default btn-flat" href="ServletToUserUpdate?userId=<%=curuser.getUserId() %>">修改个人资料</a>
                                    </div>
                                    <div class="pull-right">
                                        <a href="userlogin.jsp" class="btn btn-default btn-flat">登出</a>
                                    </div>
                                </li>
                            </ul>
                        </li>
                    </ul>
                </div>
            </nav>
        </header>
        <div class="wrapper row-offcanvas row-offcanvas-left">
            <!-- Left side column. contains the logo and sidebar -->
            <aside class="left-side sidebar-offcanvas">                
                <!-- sidebar: style can be found in sidebar.less -->
                <section class="sidebar">
                    <!-- Sidebar user panel -->
                    <div class="user-panel">
                        <div class="pull-left image">
                            <img src="img/avatar5.png" class="img-circle" alt="User Image" />
                        </div>
                        <div class="pull-left info">
                            <p><%=userName%></p>

                            <a href="#"><i class="fa fa-circle text-success"></i>online</a>
                        </div>
                    </div>
                    <!-- search form -->
                    <form action="#" method="get" class="sidebar-form">
                        <div class="input-group">
                            <input type="text" name="q" class="form-control" placeholder="Search..."/>
                            <span class="input-group-btn">
                                <button type='submit' name='seach' id='search-btn' class="btn btn-flat"><i class="fa fa-search"></i></button>
                            </span>
                        </div>
                    </form>
                    <!-- /.search form -->
                    <!-- sidebar menu: : style can be found in sidebar.less -->
                    <ul class="sidebar-menu">

                        <li class="treeview active">
                            <a href="#">
                                <i class="fa fa-bar-chart-o"></i>
                                <span>数据图表</span>
                                <i class="fa fa-angle-left pull-right"></i>
                            </a>
                            <ul class="treeview-menu">
                                <li><a href="basic.jsp"><i class="fa fa-angle-double-right"></i>用户行为基本信息</a></li>
                                <li><a href="correlation.jsp"><i class="fa fa-angle-double-right"></i>用户行为分析</a></li>
                                <li><a href="abnormal.jsp"><i class="fa fa-angle-double-right"></i>异常行为检测</a></li>
                            </ul>
                        </li>
<% 
String uname=curuser.getUserName();
if(uname.equals("admin")){

%>

                        <li class="treeview active">
                            <a href="#">
                                <i class="fa fa-table"></i><span>数据表</span>
                                <i class="fa fa-angle-left pull-right"></i>
                            </a>
                            <ul class="treeview-menu">
                            <li><a href="userlist.jsp"><i class="fa fa-angle-double-right"></i>用户表</a></li>
                            <li ><a href="loginlist.jsp"><i class="fa fa-angle-double-right"></i>登陆日志表</a></li>
                            </ul>
                        </li>
           <%
}
           %>
						<li class="treeview active">
                            <a href="#">
                                <i class="fa fa-table"></i><span>多媒体</span>
                                <i class="fa fa-angle-left pull-right"></i>
                            </a>
                            <ul class="treeview-menu">
                            <li><a href="image.jsp"><i class="fa fa-angle-double-right"></i>图片</a></li>
                            <li ><a href="audio.jsp"><i class="fa fa-angle-double-right"></i>音乐</a></li>
                            <li ><a href="video.jsp"><i class="fa fa-angle-double-right"></i>视频</a></li>
                            </ul>
                        </li>
						
                        
                    </ul>
                </section>
                <!-- /.sidebar -->
            </aside>

</html>