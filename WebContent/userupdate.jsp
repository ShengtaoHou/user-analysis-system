<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.hst.user.vo.*,com.hst.user.servlet.*,java.util.ArrayList" %>

<% UserVo user = (UserVo)request.getAttribute("user");%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">


function setValue(){
    if('<%= user.getUserSex() %>'=="男"){
        document.getElementById("man").checked="checked";
    }else{
        document.getElementById("woman").checked="checked";
    }
}

</script>
</head>
<body>

<form name="myform" action ="ServletToUserUpdate" method="post">
    <table border = "1" align = "center" style="border-collapse:collapse;">
        <tr>　　　　　　　　　　　　　
        <!-- 黄色部分代码是为了数据修改的时候使用 -->
            <td colspan="2">用户修改<input type="hidden" name="userId" value='<%=user.getUserId() %>'/></td>           
        </tr>
        <tr>
            <td>用户名</td>
            <td class="tdstyle2"><input type="text" name="userName" value='<%=user.getUserName() %>'/></td>    
        </tr>
        <tr>
            <td>密 码</td>
            <td><input type="text" name="userPassword" value='<%=user.getUserPassword() %>'/></td>            
        </tr>

        <tr>
            <td>性 别</td>
            <td>
                <input type="radio" id = "man" name="userSex" value="男" checked="checked" />男
                <input type="radio" id = "woman"name="userSex" value="女" />女
            </td>        
        </tr>
        
        <tr>
            <td>邮箱</td>
            <td class="tdstyle2"><input type="text" name="userEmail" value='<%=user.getUserEmail() %>'/></td>
        </tr>
        
        <tr>
            <td>职业</td>
            <td class="tdstyle2"><input type="text" name="userOccup" value='<%=user.getUserOccup() %>'/></td>
        </tr>
        
        <tr>
            <td colspan="2"><input type = "submit" value = "修改" /></td>          
        </tr>
    </table>
    </form>
</body>
</html>