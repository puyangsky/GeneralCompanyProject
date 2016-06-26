<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/6/23
  Time: 13:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script type="text/javascript" src="/js/jquery-1.9.1.min.js"></script>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>添加用户</title>
    <script type="text/javascript">
        $(document).ready(function(){
            $("#add").click(function(){
                var userName = $("#userName").val();
                var password =$("#password").val();
                console.log(userName + password);
                var user={"username":userName,"password":password};
                $.ajax({
                    url:"/user/addUser",
                    type:"POST",
                    contentType: "application/json;charse=UTF-8",
                    dataType:"json",
                    data:JSON.stringify(user),
                    success:function(data){
                        alert("user--->" + data);
                    }
                });
            });
            $("#get").click(function() {
                $.ajax({
                    url:"/user/getUsers",
                    type:"GET",
                    data:"",
                    success: function (data) {
                        alert("done");

                    }
                });
            });


        });
    </script>
</head>
<body>
<h1>添加用户</h1>
<br>
姓名：<input type="text" name="userName" id="userName"/>
密码：<input type="password" name="password" id="password"/>

<input type="button" value="添加" id="add">
<br><br>
<h1>获取用户列表</h1>
<br>
<button value="获取" id="get">获取</button>
</body>
</html>