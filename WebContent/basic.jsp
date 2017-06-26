<%@ page import="java.util.Vector" %>
<%@ page import="com.hst.Sequence" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta charset="UTF-8">
        <title>basic</title>
        <meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
        <!-- bootstrap 3.0.2 -->
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />
        <!-- font Awesome -->
        <link href="css/font-awesome.min.css" rel="stylesheet" type="text/css" />
        <!-- Ionicons -->
        <link href="css/ionicons.min.css" rel="stylesheet" type="text/css" />
        <!-- Morris charts -->
        <link href="css/morris/morris.css" rel="stylesheet" type="text/css" />
        <!-- Theme style -->
        <link href="css/AdminLTE.css" rel="stylesheet" type="text/css" />

        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
          <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
        <![endif]-->
    </head>
    <body class="skin-blue">
       <%@include file="menu.jsp" %>
<% 
LoginDao lgdao=new LoginDao();
UserDao udao=new UserDao();

int linux=lgdao.getOSnumber("Linux");
int windows=lgdao.getOSnumber("Windows");
int macos=lgdao.getOSnumber("MAC");

int chrome=lgdao.getBrowserNumber("Chrome");
int firefox=lgdao.getBrowserNumber("Firefox");
int ie=lgdao.getBrowserNumber("IE");


int o1=udao.getOccupNumber("manager");
int o2=udao.getOccupNumber("pm");
int o3=udao.getOccupNumber("programmer");
int o4=udao.getOccupNumber("designer");

int man=udao.getSexNumber("man");
int woman= udao.getSexNumber("female");
int[][]os_information = udao.getOS();
int[]flow=udao.flow();
int[][] browser_information = udao.getBrowser();
%>
            <!-- Right side column. Contains the navbar and content of the page -->
            <aside class="right-side">
                <!-- Content Header (Page header) -->
                <section class="content-header">
                    <h1>
                        Basic Charts
                        <small></small>
                    </h1>
                    <ol class="breadcrumb">
                        <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                        <li><a href="#">Charts</a></li>
                        <li class="active">Morris</li>
                    </ol>
                </section>

                <!-- Main content -->
                <section class="content">

                    <div class="row">
                        <div class="col-md-6">
                            

                            <!-- DONUT CHART -->
                            <div class="box box-danger">
                                <div class="box-header">
                                    <h3 class="box-title">操作系统市场占比</h3>
                                </div>
                                <div class="box-body chart-responsive">
                                    <div class="chart" id="os-pie-chart" style="height: 300px; position: relative;"></div>
                                </div><!-- /.box-body -->
                            </div><!-- /.box -->    

                            <!-- DONUT CHART -->
                            <div class="box box-danger">
                                <div class="box-header">
                                    <h3 class="box-title">浏览器市场占比</h3>
                                </div>
                                <div class="box-body chart-responsive">
                                    <div class="chart" id="browser-pie-chart" style="height: 300px; position: relative;"></div>
                                </div><!-- /.box-body -->
                            </div><!-- /.box -->   

                             
							<!-- AREA CHART -->
                            <div class="box box-primary">
                                <div class="box-header">
                                    <h3 class="box-title">操作系统市场折线图</h3>
                                </div>
                                <div class="box-body chart-responsive">
                                    <div class="chart" id="os-line-chart" style="height: 300px;"></div>
                                </div><!-- /.box-body -->
                            </div><!-- /.box -->

                            <!-- LINE CHART -->
                            <div class="box box-info">
                                <div class="box-header">
                                    <h3 class="box-title">浏览器市场折线图</h3>
                                </div>
                                <div class="box-body chart-responsive">
                                    <div class="chart" id="browser-line-chart" style="height: 300px;"></div>
                                </div><!-- /.box-body -->
                            </div><!-- /.box -->
                            
                            

                        </div><!-- /.col (LEFT) -->


                     
                        

                        <div class="col-md-6">
							<!-- DONUT CHART -->
                            <div class="box box-danger">
                                <div class="box-header">
                                    <h3 class="box-title">性别</h3>
                                </div>
                                <div class="box-body chart-responsive">
                                    <div class="chart" id="gender-pie-chart" style="height: 300px; position: relative;"></div>
                                </div><!-- /.box-body -->
                            </div><!-- /.box -->   
                            
                            <!-- DONUT CHART -->
                            <div class="box box-danger">
                                <div class="box-header">
                                    <h3 class="box-title">职业</h3>
                                </div>
                                <div class="box-body chart-responsive">
                                    <div class="chart" id="occupation-pie-chart" style="height: 300px; position: relative;"></div>
                                </div><!-- /.box-body -->
                            </div><!-- /.box --> 
                            
                            
                        	

                            <!-- LINE CHART -->
                            <div class="box box-info">
                                <div class="box-header">
                                    <h3 class="box-title">登录人数折线图</h3>
                                </div>
                                <div class="box-body chart-responsive">
                                    <div class="chart" id="login-line-chart" style="height: 300px;"></div>
                                    
                                </div><!-- /.box-body -->
                            </div><!-- /.box -->

                            <!-- DONUT CHART -->
                            <div class="box box-danger">
                                <div class="box-header">
                                    <h3 class="box-title">访问者地图</h3>
                                </div>
                                <div class="box-body chart-responsive">
                                    <div style="height: 300px; position: relative;">
                                    <script type="text/javascript" src="//rf.revolvermaps.com/0/0/8.js?i=53ossldkohu&amp;m=7&amp;c=ff0000&amp;cr1=ffffff&amp;f=arial&amp;l=33" async="async"></script>
                                    </div>
                                </div><!-- /.box-body -->
                            </div><!-- /.box --> 


                        </div><!-- /.col (RIGHT) -->

                    </div><!-- /.row -->

                </section><!-- /.content -->
            </aside><!-- /.right-side -->
        </div><!-- ./wrapper -->


        <!-- jQuery 2.0.2 -->
        <script src="js/jquery.min.js"></script>
        <!-- Bootstrap -->
        <script src="js/bootstrap.min.js" type="text/javascript"></script>

        <!-- Morris.js charts -->
        <script src="js/raphael-min.js"></script>
        <script src="js/plugins/morris/morris.min.js" type="text/javascript"></script>
		

        <!-- AdminLTE App -->
        <script src="js/AdminLTE/app.js" type="text/javascript"></script>

        <!-- page script -->
        <script type="text/javascript">
            $(function() {
                "use strict";
                // LINE CHART
                var current_month = new Date().getMonth();
                var data=[]
                <%
                for(int i = 0;i<11;i++){
                %>
                data.push({"y":(current_month+<%=i%>)%12,"windows":<%=os_information[0][i]%>,
                    "linux":<%=os_information[1][i]%>,"macos":<%=os_information[2][i]%>})
                   <%
                }
                %>


                var line1 = new Morris.Line({
                    element: 'os-line-chart',
                    resize: true,
                    data:data,
                    xkey: 'y',
                    ykeys: ['windows','linux',"macos"],
                    labels: ['windows','linux',"macos"],
                    lineColors: ['#3c8dbc','#a0d0e0','#a0d0e0'],
                    hideHover: 'auto'
                });

                // 浏览器信息
                var current_month = new Date().getMonth();
                var data=[]
                var element = {}
                <%
                for(int i = 0;i<11;i++){
                %>
                data.push({"y":(current_month+<%=i%>)%12,"chrome":<%=browser_information[0][i]%>,
                    "edge":<%=browser_information[1][i]%>,
                    'firefox':<%=browser_information[2][i]%> })
                <%
             }
             %>
                var line2 = new Morris.Line({
                    element: 'browser-line-chart',
                    resize: true,
                    data:data,
                    xkey: 'y',
                    ykeys: ['chrome','ie','firefox'],
                    labels: ['chrome','ie','firefox'],
                    lineColors: ['#3c8dbc','#a0d0e0'],
                    hideHover: 'auto'
                });
				
				// LINE CHART
                var current_month = new Date().getMonth();
                var data=[]
                <%
                for(int i = 0;i<11;i++){
                %>
                data.push({"y":(current_month+<%=i%>)%12,"flow":<%=flow[i]%>,
                    })
                <%
             }
             %>
                var line3 = new Morris.Line({
                    element: 'login-line-chart',
                    resize: true,
                    data: data,
                    xkey: 'y',
                    ykeys: ['flow'],
                    labels: ['flow'],
                    lineColors: ['#3c8dbc'],
                    hideHover: 'auto'
                });

                //os CHART
                var donut = new Morris.Donut({
                    element: 'os-pie-chart',
                    resize: true,
                    colors: ["#3c8dbc", "#f56954", "#00a65a"],
                    data: [
                        {label: "windows", value: <%=windows %>},
                        {label: "macos", value: <%=macos %>},
                        {label: "linux", value: <%=linux %>}
                    ],
                    hideHover: 'auto'
                });

                //browser CHART
                var donut2 = new Morris.Donut({
                    element: 'browser-pie-chart',
                    resize: true,
                    colors: ["#3c8dbc", "#f56954", "#00a65a"],
                    data: [
                        {label: "Chrome", value: <%=chrome %>},
                        {label: "IE", value: <%=ie %>},
                        {label: "Firefox", value: <%=firefox %>}
                    ],
                    hideHover: 'auto'
                });

                //gender CHART
                var donut3 = new Morris.Donut({
                    element: 'gender-pie-chart',
                    resize: true,
                    colors: ["#3c8dbc", "#f56954"],
                    data: [
                        {label: "man", value: <%=man %>},
                        {label: "woman", value: <%=woman %>}
                    ],
                    hideHover: 'auto'
                });

                //occupation CHART
                var donut4 = new Morris.Donut({
                    element: 'occupation-pie-chart',
                    resize: true,
                    colors: ["#3c8dbc", "#f56954",'#00a65a',"#f56954"],
                    data: [
                        {label: "项目主管", value: <%=o1 %>},
                        {label: "产品经理", value: <%=o2 %>},
                        {label: "程序员", value: <%=o3 %>},
                        {label: "设计师", value: <%=o4 %>}
                    ],
                    hideHover: 'auto'
                });


                //BAR CHART
                var bar = new Morris.Bar({
                    element: 'age-bar-chart',
                    resize: true,
                    data: [
                        {y: '2006', a: 100},
                        {y: '2007', a: 75},
                        {y: '2008', a: 50},
                        {y: '2009', a: 75},
                        {y: '2010', a: 50},
                        {y: '2011', a: 75},
                        {y: '2012', a: 100}
                    ],
                    barColors: ['#00a65a'],
                    xkey: 'y',
                    ykeys: ['a'],
                    labels: ['age'],
                    hideHover: 'auto'
                });
            });
        </script>

    </body>
</html>