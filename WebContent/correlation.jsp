<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta charset="UTF-8">
        <title>correlation</title>
        <meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
        <!-- bootstrap 3.0.2 -->
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />
        <!-- font Awesome -->
        <link href="css/font-awesome.min.css" rel="stylesheet" type="text/css" />
        <!-- Ionicons -->
        <link href="css/ionicons.min.css" rel="stylesheet" type="text/css" />
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


int win10man=lgdao.getOSnumberSex("MAC","man");
int win98man=lgdao.getOSnumberSex("Windows","man");
int linuxman=lgdao.getOSnumberSex("Linux","man");
int chromeman=lgdao.getBrowserNumberSex("Chrome","man");
int ieman=lgdao.getBrowserNumberSex("IE","man");
int firefoxman=lgdao.getBrowserNumberSex("Firefox","man");

int win10woman=lgdao.getOSnumberSex("MAC","female");
int win98woman=lgdao.getOSnumberSex("Windows","female");
int linuxwoman=lgdao.getOSnumberSex("Linux","female");
int chromewoman=lgdao.getBrowserNumberSex("Chrome","female");
int iewoman=lgdao.getBrowserNumberSex("IE","female");
int firefoxwoman=lgdao.getBrowserNumberSex("Firefox","female");

int win10o1=lgdao.getOSnumberOccup("MAC","manager");
int win98o1=lgdao.getOSnumberOccup("Windows","manager");
int linuxo1=lgdao.getOSnumberOccup("Linux","manager");
int chromeo1=lgdao.getBrowserNumberOccup("Chrome","manager");
int ieo1=lgdao.getBrowserNumberOccup("IE","manager");
int firefoxo1=lgdao.getBrowserNumberOccup("Firefox","manager");

int win10o2=lgdao.getOSnumberOccup("MAC","pm");
int win98o2=lgdao.getOSnumberOccup("Windows","pm");
int linuxo2=lgdao.getOSnumberOccup("Linux","pm");
int chromeo2=lgdao.getBrowserNumberOccup("Chrome","pm");
int ieo2=lgdao.getBrowserNumberOccup("IE","pm");
int firefoxo2=lgdao.getBrowserNumberOccup("Firefox","pm");

int win10o3=lgdao.getOSnumberOccup("MAC","programmer");
int win98o3=lgdao.getOSnumberOccup("Windows","programmer");
int linuxo3=lgdao.getOSnumberOccup("Linux","programmer");
int chromeo3=lgdao.getBrowserNumberOccup("Chrome","programmer");
int ieo3=lgdao.getBrowserNumberOccup("IE","programmer");
int firefoxo3=lgdao.getBrowserNumberOccup("Firefox","programmer");

int win10o4=lgdao.getOSnumberOccup("MAC","designer");
int win98o4=lgdao.getOSnumberOccup("Windows","designer");
int linuxo4=lgdao.getOSnumberOccup("Linux","designer");
int chromeo4=lgdao.getBrowserNumberOccup("Chrome","designer");
int ieo4=lgdao.getBrowserNumberOccup("IE","designer");
int firefoxo4=lgdao.getBrowserNumberOccup("Firefox","designer");

%>
 <!-- Right side column. Contains the navbar and content of the page -->
 <aside class="right-side">
     <!-- Content Header (Page header) -->
     <section class="content-header">
         <h1>
             用户特征与使用行为分析
             <small></small>
         </h1>
         <ol class="breadcrumb">
             <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
             <li class="active">Blank page</li>
         </ol>
     </section>

     <!-- Main content -->
     <section class="content">
         <div class="row">
             <div class="col-xs-12">
                    
                 <div class="box">
                     <div class="box-header">
                         <h3 class="box-title">用户性别与使用行为</h3>                                    
                     </div><!-- /.box-header -->
                     <div class="box-body table-responsive">
                         <table id="example1" class="table table-bordered table-striped">
                             <thead>
                                 <tr> 
                                     <th data-field="state" data-checkbox="true" ></th>
                                     
                                     <th data-field="id" data-sortable="true">IE</th>           
                                     <th data-field="tele"  data-sortable="true">Chrome</th>
                                     <th data-field="id" data-sortable="true">Firefox</th>           
                                     <th data-field="tele"  data-sortable="true">Linux</th> 
                                     <th data-field="tele"  data-sortable="true">MAC</th>
                                     <th data-field="tele"  data-sortable="true">Windows</th>              
                                 </tr>
                             </thead>
                             <tbody >
                                 <tr>
                                      <td>男</td>
                                      <td><%=ieman%></td>
                                      <td><%=chromeman %></td>
                                       <td><%=firefoxman%></td>
                                      <td><%=linuxman %></td>  
                                      <td><%=win10man%></td>
                                      <td><%=win98man %></td>                    
                                  </tr>
                                  
                                  <tr>
                                      <td>女</td>
                                      <td><%=iewoman%></td>
                                      <td><%=chromewoman %></td>
                                       <td><%=firefoxwoman%></td>
                                      <td><%=linuxwoman %></td>  
                                      <td><%=win10woman%></td>
                                      <td><%=win98woman %></td> 
                                                            
                                  </tr>      
                                                                          
                             </tbody> 
                         </table>
                     </div><!-- /.box-body -->
                 </div><!-- /.box -->
                 
                 <div class="box">
                     <div class="box-header">
                         <h3 class="box-title">用户职业与使用行为</h3>                                    
                     </div><!-- /.box-header -->
                     <div class="box-body table-responsive">
                         <table id="example1" class="table table-bordered table-striped">
                             <thead>
                                 <tr> 
                                     <th data-field="state" data-checkbox="true" ></th>
                                     
                                     <th data-field="id" data-sortable="true">IE</th>           
                                     <th data-field="tele"  data-sortable="true">Chrome</th>
                                     <th data-field="id" data-sortable="true">Firefox</th>           
                                     <th data-field="tele"  data-sortable="true">Linux</th> 
                                     <th data-field="tele"  data-sortable="true">MAC</th>
                                     <th data-field="tele"  data-sortable="true">Windows</th>              
                                 </tr>
                             </thead>
                             <tbody >
                                 <tr>
                                      <td>项目主管</td>
                                      <td><%=ieo1%></td>
                                      <td><%=chromeo1 %></td>
                                       <td><%=firefoxo1%></td>
                                      <td><%=linuxo1 %></td>  
                                      <td><%=win10o1%></td>
                                      <td><%=win98o1 %></td>                    
                                  </tr>
                                  
                                  <tr>
                                      <td>产品经理</td>
                                      <td><%=ieo2%></td>
                                      <td><%=chromeo2 %></td>
                                       <td><%=firefoxo2%></td>
                                      <td><%=linuxo2 %></td>  
                                      <td><%=win10o2%></td>
                                      <td><%=win98o2 %></td>                    
                                  </tr>
                                  
                                  <tr>
                                      <td>程序员</td>
                                      <td><%=ieo3%></td>
                                      <td><%=chromeo3 %></td>
                                       <td><%=firefoxo3%></td>
                                      <td><%=linuxo3 %></td>  
                                      <td><%=win10o3%></td>
                                      <td><%=win98o3 %></td>                    
                                  </tr>
                                  
                                  <tr>
                                      <td>设计师</td>
                                      <td><%=ieo4%></td>
                                      <td><%=chromeo4 %></td>
                                       <td><%=firefoxo4%></td>
                                      <td><%=linuxo4 %></td>  
                                      <td><%=win10o4%></td>
                                      <td><%=win98o4 %></td>                    
                                  </tr>    
                                                                          
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
 <script src="js/jquery.min.js"></script>
 <!-- Bootstrap -->
 <script src="js/bootstrap.min.js" type="text/javascript"></script>
 <!-- AdminLTE App -->
 <script src="js/AdminLTE/app.js" type="text/javascript"></script>

 <!-- FLOT CHARTS -->
 <script src="js/plugins/flot/jquery.flot.min.js" type="text/javascript"></script>
 <!-- FLOT RESIZE PLUGIN - allows the chart to redraw when the window is resized -->
 <script src="js/plugins/flot/jquery.flot.resize.min.js" type="text/javascript"></script>
 <!-- FLOT PIE PLUGIN - also used to draw donut charts -->
 <script src="js/plugins/flot/jquery.flot.pie.min.js" type="text/javascript"></script>
 <!-- FLOT CATEGORIES PLUGIN - Used to draw bar charts -->
 <script src="js/plugins/flot/jquery.flot.categories.min.js" type="text/javascript"></script>

 <!-- Page script -->
 <script type="text/javascript">

    
 </script>
    </body>
</html>