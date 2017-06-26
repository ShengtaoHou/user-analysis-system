<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<!-- <!DOCTYPE html> -->
<html class="bg-black">
    <head>
        <meta charset="UTF-8">
        <title>Register</title>
        <meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
        <!-- bootstrap 3.0.2 -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
        <!-- font Awesome -->
        <link href="${pageContext.request.contextPath}/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
        <!-- Theme style -->
        <link href="${pageContext.request.contextPath}/css/AdminLTE.css" rel="stylesheet" type="text/css" />

        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
          <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
        <![endif]-->
    </head>
    <body class="bg-black">

        <div class="form-box" id="login-box">
            <div class="header">注册新账号</div>
            <form action="ServletUserRegister" method="post">
                <div class="body bg-gray">
                    <div class="form-group">
                        <input type="text" name="userName" class="form-control" placeholder="Username"/>
                    </div>
                    <div class="form-group">
                        <input type="text" name="userEmail" class="form-control" placeholder="E-mail"/>
                    </div>
                    <div class="form-group">
                        <input type="password" name="userPassword" class="form-control" placeholder="Password"/>
                    </div>
                    <div class="form-group">
                        <input type="password" name="userPassword2" class="form-control" placeholder="Retype password"/>
                    </div>
                    <div class="form-group">
                        <input type="radio" name="userSex" value="man" checked="checked" />男
                        <input type="radio" name="userSex" value="female" />女
                    </div>

                    <div class="form-group">
                                    

                                    <label>职业</label>
                                    <select name="userOccup" class="form-control">
                                    
                                        <option value="designer">设计师</option>
                                        <option value="programmer">程序员</option>
                                        <option value="pm">产品经理</option>
                                        <option value="manager">项目主管</option>
                                    </select>

                    </div>

                </div>
                <div class="footer">                    

                    <button type="submit" class="btn bg-olive btn-block">注册</button>

                    
                </div>
            </form>

            <div class="margin text-center">
                <span>用社交账号注册</span>
                <br/>
                <button class="btn bg-light-blue btn-circle"><i class="fa fa-facebook"></i></button>
                <button class="btn bg-aqua btn-circle"><i class="fa fa-twitter"></i></button>
                <button class="btn bg-red btn-circle"><i class="fa fa-google-plus"></i></button>

            </div>
        </div>



    </body>
</html>