<%--
  Created by IntelliJ IDEA.
  User: 永不垂头
  Date: 2019/12/16
  Time: 20:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户属性</title>
</head>
<body>
<form action="insert" method="post">
    <table>
        <tr>
            <td>用户名</td>
            <td><input type="text" name="username"></td>
        </tr>
        <tr>
            <td>性别</td>
            <td>
                <input type="radio" name="sex" value="男">
                <input type="radio" name="sex" value="女">
            </td>
        </tr>
        <tr>
            <td>用户生日</td>
            <td><input type="date" name="birthday"></td>
        </tr>
        <tr>
            <td>用户住址</td>
            <td><input type="text" name="address"></td>
        </tr>
        <tr>
            <td><input type="submit" value="提交"></td>
        </tr>
    </table>
</form>
</body>
</html>
