<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.hst.user.vo.*,com.hst.user.servlet.*,java.util.ArrayList" %>

<% UserVo user = (UserVo)request.getAttribute("user");%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form name="myform" action = "ServletUserReturn" method="post">
    <table border = "1" align = "center" style="border-collapse:collapse;">
        <tr>
            <td colspan="2">用户查看</td>    
        </tr>
        <tr>
            <td>用户名</td>
            <td><%=user.getUserName() %></td>    
        </tr>
        <tr>
            <td>密 码</td>
            <td><%=user.getUserPassword() %></td>    
        </tr>
         <tr>
            <td>邮箱</td>
            <td><%=user.getUserEmail() %></td>    
        </tr>
         <tr>
            <td>性别</td>
            <td><%=user.getUserSex() %></td>    
        </tr>
        <tr>
            <td>职业</td>
            <td><%=user.getUserOccup() %></td>    
        </tr>
        <tr>
            <td colspan="2"><input type = "submit" value = "返回" /></td>
        </tr>
    </table>
    </form>
</body>
</html>