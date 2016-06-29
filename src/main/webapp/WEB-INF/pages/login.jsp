<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login Form</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="/css/style.css" rel='stylesheet' type='text/css' />
    <script type="text/javascript" src="/js/jquery-1.9.1.min.js"></script>
    <script>
        $(document).ready(function() {
            $("#login").click(function () {
                var username = $("#username").val();
                var password = $("#password").val();
                var admin = {"username": username, "password":password};
                $.ajax({
                    url:"/admin/login",
                    type:"POST",
                    dataType:"json",
                    data:JSON.stringify(admin),
                    contentType:"application/json;charset=UTF-8",
                    success:function(data) {
                        console.log(data);
                        if(data.result == true) {
                            alert("登录成功");
                            location.href = "/admin/admin"
                        }else {
                            alert("登录失败，请重新输入用户名和密码");
                            location.href = "/admin";
                        }
                    },
                    error:function(data) {
                        alert("error");
                        console.log(data);
                        location.href = "/admin";
                    }
                });
            });
        });

    </script>
</head>
<body>
	<div class="main">
		<div class="login">
			<h1>管理系统</h1>
			<div class="inset">
				<!--start-main-->
				<form>
			         <div>
			         	<h2>管理登录</h2>
						<span><label>用户名</label></span>
						<span><input id="username" type="text" class="textbox" ></span>
					 </div>
					 <div>
						<span><label>密码</label></span>
					    <span><input id="password" type="password" class="password"></span>
					 </div>
					<div class="sign">
                        <input id="login" type="button" value="登录" class="submit" />
					</div>
					</form>
				</div>
			</div>
		<!--//end-main-->
		</div>

<div class="copy-right">
	<p>&copy; 2015 Ethos Login Form. All Rights Reserved</p>

</div>

</body>
</html>